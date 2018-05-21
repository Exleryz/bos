package com.exler.bos.web.action.base;

import com.exler.bos.utils.PageBean;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 表现层通用实现
 *
 * @param <T>
 */
public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {
    // 声明模型对象
    protected T model;

    // 在构造方法中动态获取实体类型 通过反射创建model对象
    public BaseAction() {
        ParameterizedType superclass = (ParameterizedType) this.getClass().getGenericSuperclass();
        // 获得baseAction上声明的数组
        Type[] actualTypeArguments = superclass.getActualTypeArguments();
        Class<T> entityClass = (Class<T>) actualTypeArguments[0];

        dc = DetachedCriteria.forClass(entityClass);
        pb.setDc(dc);

        try {
            model = entityClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 分页查询代码抽取
     */
    protected PageBean pb = new PageBean();
    DetachedCriteria dc = null;

    public void setPage(int page) {
        pb.setCurrentPage(page);
    }

    public void setRows(int rows) {
        pb.setPageSize(rows);
    }
    // end

    /**
     * 将指定Java对象转为json
     * @param o
     * @param exclueds
     */
    public void java2Json(Object o, String[] exclueds) {
        JsonConfig config = new JsonConfig();
        config.setExcludes(exclueds);
        String json = JSONObject.fromObject(o, config).toString();
        ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
        try {
            ServletActionContext.getResponse().getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public T getModel() {
        return model;
    }
}
