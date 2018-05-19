package com.exler.bos.web.interceptor;

import com.exler.bos.domain.User;
import com.exler.bos.utils.BOSUtils;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;

/**
 * 自定义拦截器，实现用户未登录自动跳转到登录页面
 */
public class BOSLoginInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        // 输出拦截请求的地址
        ActionProxy proxy = actionInvocation.getProxy();
        String actionName = proxy.getActionName();
        String namespace = proxy.getNamespace();
        System.out.println(namespace + actionName);

        User loginUser = BOSUtils.getLoginUser();
        if (loginUser == null) {
            return "login";
        }
        return actionInvocation.invoke();
    }
}
