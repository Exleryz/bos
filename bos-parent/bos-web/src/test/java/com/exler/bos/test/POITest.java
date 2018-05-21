package com.exler.bos.test;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Auther: Exler
 * @Date: 2018/5/20 20:42
 * @Description:
 */
public class POITest {

    /**
     * 使用POI解析Excel文件
     *
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {
        String filePath = "I:\\javaweb\\bos\\区域导入测试数据.xls";
        // 包装一个excel文件对象
        HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(new File(filePath)));
        // 读取文件中第一个Sheet标签页
        HSSFSheet sheet0 = workbook.getSheetAt(0);
        // 遍历标签页中所有的行
        for (Row row : sheet0) {
            // 获得行号
            int rowNum = row.getRowNum();
            if (rowNum == 0) {
                continue;
            }
            for (Cell cell : row) {
                // 获取单元格文本值
                String value = cell.getStringCellValue();
                System.out.print(value + "\t");
            }
            System.out.println();
        }

    }


}
