package com.exler.bos.dao;

import com.exler.bos.dao.base.BaseDao;
import com.exler.bos.domain.Region;

import java.util.List;

/**
 * @Auther: Exler
 * @Date: 2018/5/20 21:30
 * @Description:
 */
public interface RegionDao extends BaseDao<Region> {
    List<Region> findListByQ(String q);
}
