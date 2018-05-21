package com.exler.bos.service.impl;

import com.exler.bos.dao.SubareaDao;
import com.exler.bos.domain.Subarea;
import com.exler.bos.service.SubareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Auther: Exler
 * @Date: 2018/5/21 20:23
 * @Description:
 */
@Service
@Transactional
public class SubareaServiceImpl implements SubareaService {

    @Autowired
    private SubareaDao subareaDao;

    /**
     *
     * @param model
     */
    @Override
    public void save(Subarea model) {
        subareaDao.save(model);
    }
}
