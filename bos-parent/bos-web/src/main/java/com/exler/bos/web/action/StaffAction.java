package com.exler.bos.web.action;

import com.exler.bos.domain.Staff;
import com.exler.bos.service.StaffService;
import com.exler.bos.web.action.base.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * @Auther: Exler
 * @Date: 2018/5/19 14:14
 * @Description:
 */
@Controller
@Scope("prototype")
public class StaffAction extends BaseAction<Staff> {
    @Autowired
    private StaffService staffService;

    /**
     * 添加取派员
     * @return
     * @throws Exception
     */
    public String add() throws Exception {
        staffService.save(model);
        return "list";
    }
}
