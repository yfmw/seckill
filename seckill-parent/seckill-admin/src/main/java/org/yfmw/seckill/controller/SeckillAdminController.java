package org.yfmw.seckill.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.yfmw.seckill.model.SeckillAdmin;
import org.yfmw.seckill.service.IAdminService;

import java.util.List;

/**
 * @ClassName SeckillAdminController
 * @Description TODO
 * @Author 影之
 * @Date 12/8/2022 下午4:00
 * @Version 1.0
 */
@Slf4j
@Controller
@RequestMapping(value = "/admin")
public class SeckillAdminController {

    @Autowired
    private IAdminService adminService;
    @RequestMapping("/listAdminPage")
    public String listAdminPage(Model model) {
        List<SeckillAdmin> list = adminService.listAdmin();
        model.addAttribute("list", list);
        log.info("==={}",list.toString());
        return "admin/listAdminPage";
    }

}
