package com.exler.bos.web.action;

import com.exler.bos.domain.User;
import com.exler.bos.web.action.base.BaseAction;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")    // 多例程序启动时不会创建对象 需要使用到时访问
public class UserAction extends BaseAction<User> {

}
