package com.exler.bos.web.action;

import com.exler.bos.domain.User;
import com.exler.bos.service.UserService;
import com.exler.bos.web.action.base.BaseAction;
import com.opensymphony.xwork2.ActionContext;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")    // 多例程序启动时不会创建对象 需要使用到时访问
public class UserAction extends BaseAction<User> {

    // 属性驱动 接收页面输入的验证码
    private String checkcode;

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     *
     * @return
     * @throws Exception
     */
    public String login() throws Exception {
        // 检验验证码是否正确
        // 从session中获取验证码
        String key = (String) ServletActionContext.getRequest().getSession().getAttribute("key");
        if (StringUtils.isNotBlank(checkcode) && checkcode.equals(key)) {
            // 输入验证码正确
            User user = userService.login(model);
            if (user != null) {
                // 登录成功
                ActionContext.getContext().getSession().put("loginUser", user);
                return "home";
            } else {
                this.addActionError("用户名或者密码错误");
                return "login";
            }
        } else {
            // 设置提示信息 跳转到登录页面
            this.addActionError("输入验证码错误!");
            return "login";
        }
    }

    /**
     * 用户注销
     *
     * @return
     * @throws Exception
     */
    public String logout() throws Exception {
        ServletActionContext.getRequest().getSession().invalidate();
        return "login";
    }

    public void setCheckcode(String checkcode) {
        this.checkcode = checkcode;
    }
}
