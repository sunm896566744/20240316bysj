package com.byh.biyesheji.controller;

import com.byh.biyesheji.entity.ApplicationDocuments;
import com.byh.biyesheji.pojo.Customer;
import com.byh.biyesheji.service.CustomerService;
import com.byh.biyesheji.util.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 用户模块controller
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/list")
    public String list(Model model, Page page){
        PageHelper.offsetPage(page.getStart(),page.getCount());//分页查询
        List<Customer> list= customerService.list();
        int total = (int) new PageInfo<Customer>(list).getTotal();//总条数
        page.setTotal(total);

        model.addAttribute("list",list);
        model.addAttribute("totals",total);
        return "cstpage/cst-list";
    }

    /**
     * 设置会员
     * @param id
     * @return
     */
    @RequestMapping("/shezhihuiyuan")
    @ResponseBody
    public String shezhihuiyuan(int id){
        customerService.shezhihuiyuan(id);
        return "success";
    }

    @RequestMapping("/del")
    public String del(int id){
        customerService.del(id);
        return "redirect:list";
    }

    /**
     * 设置配送人员
     * @return
     */
    @RequestMapping("/updateDeliveryById")
    @ResponseBody
    public String updateDeliveryById(int id, int status){
        customerService.updateDeliveryById(id,status);
        return "success";
    }



    /**
     * 查询培训员申请单
     * @return
     */
    @RequestMapping("/getApplicationDocumentsList")
    public String getApplicationDocumentsList(Model model, Page page,ApplicationDocuments applicationDocuments){
        PageHelper.offsetPage(page.getStart(),page.getCount());//分页查询
        List<ApplicationDocuments> list= customerService.getApplicationDocumentsList(applicationDocuments);
        int total = (int) new PageInfo<ApplicationDocuments>(list).getTotal();//总条数
        page.setTotal(total);

        model.addAttribute("list",list);
        model.addAttribute("totals",total);
        return "courierpage/apply-courier-list";
    }


    /**
     * 审批通过
     * @return
     */
    @RequestMapping("/aApproved")
    @ResponseBody
    public String aApproved(int id, int status){
        return customerService.aApproved(id,status);
    }

}
