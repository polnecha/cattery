package ru.cat.cattery.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.cat.cattery.entity.Osmotr;
import ru.cat.cattery.service.OsmotrService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Controller
public class HomeController {

    private final OsmotrService osmotrService;

    public HomeController(OsmotrService osmotrService) {
        this.osmotrService = osmotrService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @PostMapping("/report/osmotry")
    public void generateOsmotryReport(
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate,
            HttpServletResponse response) throws IOException {

        List<Osmotr> osmotry = osmotrService.findByDateBetween(startDate, endDate);

        // Создаём Excel
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Осмотры");

        // Заголовки
        Row headerRow = sheet.createRow(0);
        String[] headers = {
                "ID", "Животное", "Дата", "Ветеринар", "Причина", "Диагноз",
                "Вес (кг)", "Температура", "Глаза", "Уши", "Зубы/дёсны",
                "Кожа/шерсть", "Лимфоузлы", "Живот", "Назначения",
                "Следующий визит", "Комментарии", "Описание"
        };

        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(createHeaderStyle(workbook));
        }

        // Данные
        int rowNum = 1;
        for (Osmotr o : osmotry) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(o.getIdOsmotr());
            row.createCell(1).setCellValue(o.getPet().getName());
            row.createCell(2).setCellValue(o.getDataOsmotra().toString());
            row.createCell(3).setCellValue(o.getVeterinarniyVrach());
            row.createCell(4).setCellValue(o.getPrichinaVizita());
            row.createCell(5).setCellValue(o.getPredvaritelnyDiagnoz());
            row.createCell(6).setCellValue(o.getVes());
            row.createCell(7).setCellValue(o.getTemperatura());
            row.createCell(8).setCellValue(o.getGlaza());
            row.createCell(9).setCellValue(o.getUshi());
            row.createCell(10).setCellValue(o.getZubyDesny());
            row.createCell(11).setCellValue(o.getKozhaSherst());
            row.createCell(12).setCellValue(o.getLimfouzly());
            row.createCell(13).setCellValue(o.getZhivot());
            row.createCell(14).setCellValue(o.getNaznacheniya());
            row.createCell(15).setCellValue(o.getDataSleduyuschegoVizita() != null ? o.getDataSleduyuschegoVizita().toString() : "");
            row.createCell(16).setCellValue(o.getKommentarii());
            row.createCell(17).setCellValue(o.getObsheeSostoyanie());
        }

        // Автоподбор ширины
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Отправка файла
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=osmotry_" + startDate + "_to_" + endDate + ".xlsx");

        workbook.write(response.getOutputStream());
        workbook.close();
    }

    private CellStyle createHeaderStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        style.setFont(font);
        style.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        return style;
    }
}