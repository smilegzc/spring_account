package com.smilegzc.spring_account.controller;

import com.smilegzc.spring_account.service.ExportService;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * 日期:2020/3/30
 * 时间:下午4:49
 */
@Controller
public class ExportController {
    
    final ExportService exportService;
    public ExportController(ExportService exportService) {
        this.exportService = exportService;
    }
    
    @RequestMapping("/export")
    public void exportFile(HttpServletResponse response) {
        XSSFWorkbook data = exportService.getData();
        String fileName = "营业信息.xlsx";
        OutputStream outputStream = null;
        try{
            fileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8);
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName);
            outputStream = response.getOutputStream();
            data.write(outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
