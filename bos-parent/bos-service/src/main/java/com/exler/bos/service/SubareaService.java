package com.exler.bos.service;

import com.exler.bos.domain.Subarea;
import com.exler.bos.utils.PageBean;

/**
 * @Auther: Exler
 * @Date: 2018/5/21 20:19
 * @Description:
 */
public interface SubareaService {
    void save(Subarea model);

    void pageQuery(PageBean pb);
}
