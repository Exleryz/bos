package com.exler.bos.dao.base;

import com.exler.bos.utils.PageBean;

import java.io.Serializable;
import java.util.List;

/**
 * 持久层通用接口
 *
 * @param <T>
 */
public interface BaseDao<T> {

    public void save(T entity);

    public void delete(T entity);

    public void update(T entity);

    public void saveOrUpdate(T entity);

    public T findById(Serializable id);

    public List<T> findAll();

    public void executeUpdate(String queryName, Object...objects);

    public void pageQuery(PageBean pageBean);
}
