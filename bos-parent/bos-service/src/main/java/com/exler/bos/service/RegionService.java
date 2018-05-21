package com.exler.bos.service;

import com.exler.bos.domain.Region;

import java.util.List;

/**
 * @Auther: Exler
 * @Date: 2018/5/20 21:27
 * @Description:
 */
public interface RegionService {
    void saveBatch(List<Region> regionList);
}
