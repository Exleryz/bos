package com.exler.bos.service;

import com.exler.bos.domain.Staff;
import com.exler.bos.utils.PageBean;

/**
 * @Auther: Exler
 * @Date: 2018/5/19 14:15
 * @Description:
 */
public interface StaffService {
    void save(Staff model);

    void pageQuery(PageBean pageBean);

    void deleteBatch(String ids);
}
