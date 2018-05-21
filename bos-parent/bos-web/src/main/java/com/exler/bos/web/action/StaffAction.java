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
     *
     * @return
     * @throws Exception
     */
    public String add() throws Exception {
        staffService.save(model);
        return "list";
    }

    // 属性驱动 接收页面提交的分页参数

    /**
     * 分页查询
     *
     * @return
     * @throws Exception
     */
    public String pageQuery() throws Exception {
        staffService.pageQuery(pb);
        // 将pb对象转为json 通过输出流写回页面中
        java2Json(pb, new String[]{"currentPage", "dc", "pageSize"});
        return null;
    }

    // 属性驱动，接收页面提交的ids参数
    private String ids;

    /**
     * 取派员批量删除
     *
     * @return
     * @throws Exception
     */
    public String deleteBatch() throws Exception {
        staffService.deleteBatch(ids);
        return "list";
    }

    /**
     * 修改取派员信息
     * 直接用model只注入了  5个属性
     * 先查询数据库，根据id查询原始数据
     * 然后挨个覆盖
     *
     * @return
     * @throws Exception
     */
    public String edit() throws Exception {
        Staff staff = staffService.findById(model.getId());
        // 覆盖
        staff.setName(model.getName());
        staff.setTelephone(model.getTelephone());
        staff.setHaspda(model.getHaspda());
        staff.setStandard(model.getStandard());
        staff.setStation(model.getStation());

        staffService.update(staff);
        return "list";
    }


    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }
}
