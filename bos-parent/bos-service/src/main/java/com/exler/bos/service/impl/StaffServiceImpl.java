package com.exler.bos.service.impl;

import com.exler.bos.dao.StaffDao;
import com.exler.bos.domain.Staff;
import com.exler.bos.service.StaffService;
import com.exler.bos.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Auther: Exler
 * @Date: 2018/5/19 14:16
 * @Description:
 */
@Service
@Transactional
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffDao staffDao;

    /**
     *
     * @param model
     */
    @Override
    public void save(Staff model) {
        staffDao.save(model);
    }

    @Override
    public void pageQuery(PageBean pageBean) {
        staffDao.pageQuery(pageBean);
    }
}
