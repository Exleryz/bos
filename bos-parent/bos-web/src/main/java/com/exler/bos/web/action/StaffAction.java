package com.exler.bos.web.action;

import com.exler.bos.domain.Staff;
import com.exler.bos.service.StaffService;
import com.exler.bos.utils.PageBean;
import com.exler.bos.web.action.base.BaseAction;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
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
    private int page;
    private int rows;

    /**
     * 分页查询
     *
     * @return
     * @throws Exception
     */
    public String pageQuery() throws Exception {
        PageBean pageBean = new PageBean();
        pageBean.setCurrentPage(page);
        pageBean.setPageSize(rows);
        // 创建离线条件查询对象
        DetachedCriteria dc = DetachedCriteria.forClass(Staff.class);
        pageBean.setDc(dc);

        staffService.pageQuery(pageBean);

        // 将pb对象转为json 通过输出流写回页面中
        JsonConfig config = new JsonConfig();
        config.setExcludes(new String[]{"currentPage", "dc", "pageSize"});
        String json = JSONObject.fromObject(pageBean, config).toString();
        ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
        ServletActionContext.getResponse().getWriter().print(json);
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

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }
}
