package com.exler.bos.web.action.base;

import com.exler.bos.domain.Region;
import com.exler.bos.service.RegionService;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Exler
 * @Date: 2018/5/20 19:06
 * @Description: 区域管理
 */
@Controller
@Scope("prototype")
public class RegionAction extends BaseAction<Region> {

    @Autowired
    private RegionService regionService;

    // 属性驱动接收上传文件
    private File regionFile;

    /**
     * 区域导入
     *
     * @return
     * @throws Exception
     */
    public String importXls() throws Exception {
        List<Region> regionList = new ArrayList<Region>();
        // 使用POI解析Excel文件
        HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(regionFile));
        // 根据标签页的名字 获取指定标签页对象
        HSSFSheet sheet0 = workbook.getSheet("Sheet1");
        for (Row row : sheet0) {
            int rowNum = row.getRowNum();
            if (rowNum == 0) {
                continue;
            }
            // 获取指定位置的单元格
            String id = row.getCell(0).getStringCellValue();
            String province = row.getCell(1).getStringCellValue();
            String city = row.getCell(2).getStringCellValue();
            String district = row.getCell(3).getStringCellValue();
            String postcode = row.getCell(4).getStringCellValue();
            // 包装一个区域对象
            Region region = new Region(id, province, city, district, province, null, null, null);
            regionList.add(region);
        }
        regionService.saveBatch(regionList);
        System.out.println(regionFile);
        return null;
    }

    public String pageQuery() throws Exception {
        return "";
    }

    public void setRegionFile(File regionFile) {
        this.regionFile = regionFile;
    }
}
