package com.ssm.shoestoreproject.controller;

import com.ssm.shoestoreproject.domin.*;
import com.ssm.shoestoreproject.service.CategoryService;
import com.ssm.shoestoreproject.service.OrderService;
import com.ssm.shoestoreproject.service.ShoeService;
import com.ssm.shoestoreproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    public CategoryService categoryService;

    @Autowired
    public ShoeService shoeService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @RequestMapping("showAll")
    public String showAll(Model model){
        List<ShoePlus> shoes = shoeService.findAll();
        for(int i = 0; i < shoes.size(); i++){
            shoes.get(i).setShoePicture("/image/" + shoes.get(i).getShoePicture());
        }
        model.addAttribute("shoes",shoes);
        return "adminIndex";
    }

    // 显示补货页面
    @RequestMapping("/insertShoe")
    public String insertShoe(Model model) {
        List<Category> categories = categoryService.showAllCategories();
        model.addAttribute("categories",categories);
        return "/insertShoe";
    }

    @RequestMapping("/uploadShoe")
    public String uploadShoe(MultipartFile file, @RequestParam("shoeName") String shoeName,@RequestParam("price") Double price,@RequestParam("inventory") Integer inventory,
           @RequestParam("shoeSize") Integer shoeSize,@RequestParam("shoeStyle") String  shoeStyle,@RequestParam("cId") Integer cId) throws IOException {
        System.out.println(file);
       ShoeInfo shoeInfo = new ShoeInfo(shoeName,"c",price,inventory,cId,shoeSize,shoeStyle);
       System.out.println(shoeInfo);
        int key = 0;
        key = shoeService.insertShoe(file,shoeInfo);
        if(key == 0){
            System.out.println("failed");
        }
        else
        {
            System.out.println("success");
        }
        return "redirect:/admin/showAll";
    }

    // 显示修改页面
    @RequestMapping("/modifyShoe")
    public String modifyShoe(@RequestParam("shoeId") String shoeId,Model model){
        ShoeInfo shoeInfo = shoeService.findById(shoeId);
        model.addAttribute("shoeInfo",shoeInfo);
        List<Category> categories = categoryService.showAllCategories();
        model.addAttribute("categories",categories);
        return "updateShoe";
    }

    @RequestMapping("/updateShoe")
    public String updateShoe(ShoeInfo shoeInfo){
        System.out.println(shoeInfo);
        int result = shoeService.updateShoe(shoeInfo);
        if(result == 1){
            System.out.println("修改成功");
        }
        else{
            System.out.println("修改失败");
        }
        return "redirect:/admin/showAll";
    }

    @RequestMapping("/deleteShoe")
    public String deleteShoe(@RequestParam("shoeId") Integer shoeId){
        int result = shoeService.deleteShoe(shoeId);
        if(result == 1){
            System.out.println("删除成功");
        }
        else{
            System.out.println("删除失败");
        }
        return "redirect:/admin/showAll";
    }

    @RequestMapping("/showAllOrders")
    public String showAllOrders(Model model){
        List<OrdersPlus> orders = orderService.findAllOrders();
        model.addAttribute("orders",orders);
        return "/allOrders";
    }

    @RequestMapping("/showOrderItem")
    public String showOrderItem(@RequestParam("orderId") Integer orderId, Model model){
        List<OrderItemPlus> orderItem = orderService.findOrderItem(orderId);
        for(int i = 0; i < orderItem.size(); i++){
            orderItem.get(i).setShoePicture("../image/" + orderItem.get(i).getShoePicture());
        }
        model.addAttribute("orderItem",orderItem);
        return "/showOrderItem";
    }

    @RequestMapping("/showShoeOrder")
    public String showShoeOrder(@RequestParam("shoeId") Integer shoeId,Model model){
        List<OrderItemPlus> shoeOrders = orderService.findOrderByShoe(shoeId);
        String shoePicture = "../image/" + shoeOrders.get(0).getShoePicture();
        model.addAttribute("shoePicture",shoePicture);
        model.addAttribute("shoeOrders",shoeOrders);
        return "/showShoeOrder";
    }

    @RequestMapping("/deliverShoe")
    public String deliverShoe(@RequestParam("orderItemId") Integer orderItemId,@RequestParam("orderId") Integer orderId){
        Integer shoeId = orderService.getShoeId(orderItemId);
        orderService.updateStatus1(orderItemId);
        int result = shoeService.deliverShoe(shoeId);
        if(result == 1){
            System.out.println("发货成功");
        }
        else{
            System.out.println("发货失败");
        }
        return "redirect:/admin/showOrderItem?orderId="+orderId;
    }

    @RequestMapping("/returnShoe")
    public String returnShoe(@RequestParam("orderItemId") Integer orderItemId,@RequestParam("orderId") Integer orderId){
        Integer shoeId = orderService.getShoeId(orderItemId);
        Double price = shoeService.getPrice(shoeId);
        Integer quantity = orderService.getquantity(orderItemId);
        Integer userId = orderService.getUserId(orderId);
        UserInfo userInfo = userService.findUserById(userId);
        Double userSave = userInfo.getUserSave();
        userSave = userSave + price*quantity;
        userService.updateUserSave(userSave,userId);
        //状态改为已退货
        orderService.updateStatus2(orderItemId);
        //更新鞋的销量
        shoeService.updatesoldnumber1(quantity,shoeId);
        return "redirect:/admin/showOrderItem?orderId="+orderId;
    }
}