package com.example.itextpdf.utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.draw.LineSeparator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;


public class PdfReportUtil {

    private static Font textfont;


    static {
        try {
            // 这里时itextpdf自带的，出来的字体效果不是我想要的
            //BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
            // 这里我是用windows的字体去定义我想要的字体风格（第一个参数的字体位置你电脑应该也是一样的，自己看到合适的字体拿路径过来就行；后面两个参数是啥暂时不太了解）
            BaseFont bfChinese = BaseFont.createFont("C:\\Windows\\Fonts\\AdobeSongStd-Light.otf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            // 设置字体大小、字体形状（粗体、斜体什么的）
            textfont = new com.itextpdf.text.Font(bfChinese, 12, Font.NORMAL);
        } catch (Exception e) {
            System.out.println("创建字体出错........................");
            e.printStackTrace();
        }
    }

    public static File getPdfFile(String qrCodeContent, Map<String, String> tableDataMap){
        // 1.新建document对象
        Document document = new Document(PageSize.A4);
        File file = null;

        try {
            // 2.建立一个书写器(Writer)与document对象关联
            file = new File("D:\\PDFDemo.pdf");
            file.createNewFile();
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));

            // 3.打开文档
            document.open();

            // 4.向文档中添加内容
            // 直线
            Paragraph lineP = new Paragraph();
            lineP.add(new Chunk(new LineSeparator()));
            // 段落
            Paragraph paragraph = new Paragraph("Welcome!", textfont);
            paragraph.setAlignment(0); //设置文字居中 0靠左   1，居中     2，靠右
            // 生成qrcCode
            BarcodeQRCode barcodeQRCode = new BarcodeQRCode(qrCodeContent, 180, 180, null);
            Image image = barcodeQRCode.getImage();
            image.scalePercent(80f); //依照比例缩放
            // 生成表格
            PdfPTable table = createTable(new float[] { 100f, 250f});
            for(String key: tableDataMap.keySet()){
                table.addCell(createCell(key));
                table.addCell(createCell(tableDataMap.get(key)));
            }
            document.add(lineP);
            document.add(paragraph);
            document.add(image);
            document.add(table);

            // 5.关闭文档
            document.close();
        } catch (IOException e) {
            System.out.println("创建文件出错........................");
            e.printStackTrace();
        } catch (DocumentException e) {
            System.out.println("创建书写器(Writer)........................");
            e.printStackTrace();
        }
        return file;
    }

    /**
     * 创建指定列宽、列数的表格
     * @param widths
     *          数组里面的每个值代表第几列的宽度，数组长度代表多少列
     * @return
     */
    public static PdfPTable createTable(float[] widths) {
        PdfPTable table = new PdfPTable(widths);
        try {
            table.setTotalWidth(350f); // 最大宽度
            table.setLockedWidth(true);
            table.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.getDefaultCell().setBorder(0);  // 表格无边框，这样设置没用，还得去cell那里设置
            table.setSpacingBefore(10f);// 表格与上个元素的距离
        } catch (Exception e) {
            e.printStackTrace();
        }
        return table;
    }

    /**
     * 创建单元格
     * @param value
     *              单元格内容
     * @return
     */
    public static PdfPCell createCell(String value) {
        PdfPCell cell = new PdfPCell();
        cell.setVerticalAlignment(Element.ALIGN_TOP);   // 垂直居中
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);   // 水平向左
        cell.setPhrase(new Phrase(value, textfont));     // 设置单元但内容一级字体样式
        cell.setBorder(0);      // table设置border0，但是还是有边框，只能在单元格设置了
        cell.setMinimumHeight(20f);   //设置最低高度
        return cell;
    }

}
