package com.exler.bos.dao.impl;

import com.exler.bos.dao.RegionDao;
import com.exler.bos.dao.base.impl.BaseDaoImpl;
import com.exler.bos.domain.Region;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: Exler
 * @Date: 2018/5/20 21:30
 * @Description:
 */
@Repository
public class RegionDaoImpl extends BaseDaoImpl<Region> implements RegionDao {

    /**
     * 根据q参数进行模糊查询
     * @param q
     * @return
     */
    @Override
    public List<Region> findListByQ(String q) {
        String hql = "FROM Region r WHERE r.shortcode LIKE ? "
                + "	OR r.citycode LIKE ? OR r.province LIKE ? "
                + "OR r.city LIKE ? OR r.district LIKE ?";
        List<Region> list = (List<Region>) getHibernateTemplate().find(hql, "%" + q + "%", "%" + q + "%", "%" + q + "%", "%" + q + "%", "%" + q + "%");
        return list;
    }
}
