package com.exler.bos.service.impl;

import com.exler.bos.dao.StaffDao;
import com.exler.bos.domain.Staff;
import com.exler.bos.service.StaffService;
import com.exler.bos.utils.PageBean;
import org.apache.commons.lang.StringUtils;
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

    /**
     * 取派员批量删除
     * 逻辑删除 只修改staff表中的标志字段
     *
     * @param ids
     */
    @Override
    public void deleteBatch(String ids) {
        if (StringUtils.isNotBlank(ids)) {
            String[] staffIds = ids.split(",");
            for (String id :
                    staffIds) {
                staffDao.executeUpdate("staff.delete", id);
            }
        }
    }

    /**
     * 根据id查询取派员
     *
     * @param id
     * @return
     */
    @Override
    public Staff findById(String id) {
        return staffDao.findById(id);
    }

    /**
     * 根据id修改取派员
     *
     * @param staff
     */
    @Override
    public void update(Staff staff) {
        staffDao.update(staff);
    }
}
