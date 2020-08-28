package com.ssm.shoestoreproject.controller;

import com.ssm.shoestoreproject.domin.AdminInfo;
import com.ssm.shoestoreproject.domin.ShoeInfo;
import com.ssm.shoestoreproject.domin.ShoePlus;
import com.ssm.shoestoreproject.domin.UserInfo;
import com.ssm.shoestoreproject.service.AdminService;
import com.ssm.shoestoreproject.service.ShoeService;
import com.ssm.shoestoreproject.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/shoe")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private ShoeService shoeService;

    @Autowired
    private HttpServletRequest request;

    // 选择登录页面
    @GetMapping("/chagelogin")
    public String ShowChageLogin() {return "/chagelogin";}

    // 显示用户登录页面
    @GetMapping("/login")
    public String ShowLogin() {return "/login";}

    // 显示管理员登录页面
    @GetMapping("/adminlogin")
    public String ShowAdminLogin() {return "/adminlogin";}

    // 登录时显示主页面
    // 显示主页面
    @PostMapping("/user/index")
    public String ShowIndex(@RequestParam("name") String name, @RequestParam("passwd") String passwd, Model model) {
        HttpSession session = request.getSession(); // 得到公共session会话记录用户信息
        UserInfo customer = userService.findByName(name);
        session.setAttribute("customer", customer);
        List<ShoeInfo> shoeInfos = shoeService.ShowAllShoes();
        for(int i = 0; i < shoeInfos.size(); i++){
            shoeInfos.get(i).setShoePicture("/image/" + shoeInfos.get(i).getShoePicture());
        }
        model.addAttribute("shoeInfos", shoeInfos);
        return "/index";
    }

    //导航栏显示
    // 显示主页面
    @RequestMapping("/user/index1")
    public String ShowIndex1(Model model) {
        List<ShoeInfo> shoeInfos = shoeService.ShowAllShoes();
        for(int i = 0; i < shoeInfos.size(); i++){
            shoeInfos.get(i).setShoePicture("/image/" + shoeInfos.get(i).getShoePicture());
        }
        model.addAttribute("shoeInfos", shoeInfos);
        return "/index";
    }

    @RequestMapping("/check")
    @ResponseBody
     public String check(@Param("name") String name, @Param("passwd") String passwd){
        // 根据用户名和密码查询是否存在该用户

            UserInfo userInfo = userService.findByNameandPasswd(name,passwd);
            System.out.println(name);
            if (userInfo != null) {
                return "{\"msg\":\"true\"}";
            }
            return "{\"msg\":\"false\"}";

    }

    @RequestMapping("/admincheck")
    @ResponseBody
    public String admincheck(@Param("name") String name,@Param("passwd") String passwd){
        // 根据用户名和密码查询是否存在该用户

       AdminInfo adminInfo = adminService.findByNameandPasswd(name,passwd);
        if (adminInfo != null) {
            return "{\"msg\":\"true\"}";
        }
        return "{\"msg\":\"false\"}";

    }

    // 显示注册页面
    @GetMapping("/register")
    public String ShowRegiser() {
        return "/register";
    }

    // 注册信息保存到数据库
    @PostMapping("/insert")
    public String Register(@RequestParam("name") String name, @RequestParam("passwd") String passwd,
                           @RequestParam("contact") String contact, @RequestParam("add") String add,
                           HttpServletRequest request) {
        UserInfo customer = userService.findByName(name);
        // 数据库中该用户名没有被注册
        if (customer == null) {
            UserInfo userInfo = new UserInfo(name,passwd,contact,add);
            userService.addUser(userInfo);
        }
        return "/registerSuccess";

    }
    // 注册时根据c_name检测用户名是否被注册, 返回json信息
    @PostMapping("/checkName")
    @ResponseBody // 返回给register.html字符串格式
    public String checkName(String name) {
        // 根据用户名查询是否存在该用户
        UserInfo customer = userService.findByName(name);
        // 当对象不为空, 说明用户名存在
        if (customer != null) {
            return "{\"msg\":\"false\"}";
        }
        return "{\"msg\":\"true\"}";
    }

    //充值
    @GetMapping("/money")
    public String ShowMoney(Model model){
        HttpSession session = request.getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute("customer");
        UserInfo uinfo = userService.findUserById(userInfo.getUserId());
        model.addAttribute("uinfo",uinfo);
        return "/money";
    }

    @PostMapping("/moneysave")
    public String savemoney(@RequestParam("userSave") Double userSave){
        HttpSession session = request.getSession();
        UserInfo userInfo = (UserInfo)session.getAttribute("customer");
        System.out.println(userInfo.getUserSave());
//        double allmoney = userInfo.getUserSave() + userSave;
        int i = userService.updateUserSave1(userSave,userInfo.getUserId());
        if(i==1) {
            return "/savesuccess";
        }
        else{
            return "/money";
        }
    }

    @PostMapping("/useradd")
    public String updateAdd(@RequestParam("userAdd") String userAdd){
        HttpSession session = request.getSession();
        UserInfo userInfo = (UserInfo)session.getAttribute("customer");
//        double allmoney = userInfo.getUserSave() + userSave;
        int i = userService.updateUserAdd(userInfo.getUserId(),userAdd);
        if(i==1) {
            return "addsuccess";
        }
        else{
            return "/updateadd";
        }
    }


    @GetMapping("/my")
    public String ShowMy(Model model){
        HttpSession session = request.getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute("customer");
        model.addAttribute("name",userInfo.getUserName());
        return "/my";
    }

    @GetMapping("showadd")
    public String ShowAddresss(){return "/updateadd";}

    @GetMapping("/address")
    public String ShowAddress(Model model){
        HttpSession session = request.getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute("customer");
        UserInfo uinfo = userService.findUserById(userInfo.getUserId());
        model.addAttribute("uinfo",uinfo);
        return "/address";
    }

    @GetMapping("showsave")
    public  String ShowSave(){return "/updatemoney";}
}
