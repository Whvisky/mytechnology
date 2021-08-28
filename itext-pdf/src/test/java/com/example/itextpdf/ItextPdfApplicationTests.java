package com.example.itextpdf;

import com.example.itextpdf.utils.PdfReportUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@SpringBootTest
class ItextPdfApplicationTests {

    @Test
    void contextLoads() {
        Map<String,String> tableDataMap = new LinkedHashMap<>();
        tableDataMap.put("Test Name", "tdsadgshd");
        tableDataMap.put("phone", "13566788909");
        tableDataMap.put("content", "我们今天使用了ItextPdf工具包生成了一个pdf文件，文件包括对齐的文字以及一张二维码，二维码也是用ItextPdf生成的哦，确实强大。");
        tableDataMap.put("地址", "shanghai China.");
        tableDataMap.put("date", "2021-10-09");
        File pdfFile = PdfReportUtil.getPdfFile("reverseId", tableDataMap);

    }

}
