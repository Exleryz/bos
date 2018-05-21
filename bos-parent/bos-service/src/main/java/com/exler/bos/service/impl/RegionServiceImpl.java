package com.exler.bos.service.impl;

import com.exler.bos.dao.RegionDao;
import com.exler.bos.domain.Region;
import com.exler.bos.service.RegionService;
import com.exler.bos.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: Exler
 * @Date: 2018/5/20 21:28
 * @Description:
 */
@Service
@Transactional
public class RegionServiceImpl implements RegionService {

    @Autowired
    private RegionDao regionDao;
    /**
     * 区域数据批量保存
     * @param regionList
     */
    @Override
    public void saveBatch(List<Region> regionList) {
        for (Region region : regionList) {
            regionDao.saveOrUpdate(region);
//            System.out.println(region);
        }
    }

    /**
     * 区域分页查询
     * @param pb
     */
    @Override
    public void pageQuery(PageBean pb) {
        regionDao.pageQuery(pb);
    }
}
