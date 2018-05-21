package com.exler.bos.web.action;

import com.exler.bos.domain.Subarea;
import com.exler.bos.service.SubareaService;
import com.exler.bos.web.action.base.BaseAction;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.jws.WebParam;

/**
 * @Auther: Exler
 * @Date: 2018/5/21 20:12
 * @Description:
 */
@Controller
@Scope("prototype")
public class SubareaAction extends BaseAction<Subarea> {

    @Resource
    private SubareaService subareaService;

    /**
     * 添加分区
     *
     * @return
     * @throws Exception
     */
    public String add() throws Exception{
        subareaService.save(model);
        return "list";
    }
}
