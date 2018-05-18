package com.exler.bos.web.action.base;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 表现层通用实现
 *
 * @param <T>
 */
public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {
    // 声明模型对象
    private T model;

    // 在构造方法中动态获取实体类型 通过反射创建model对象
    public BaseAction() {
        ParameterizedType superclass = (ParameterizedType) this.getClass().getGenericSuperclass();
        // 获得baseAction上声明的数组
        Type[] actualTypeArguments = superclass.getActualTypeArguments();
        Class<T> entityClass = (Class<T>) actualTypeArguments[0];
        try {
            model = entityClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }

    @Override
    public T getModel() {
        return model;
    }
}
