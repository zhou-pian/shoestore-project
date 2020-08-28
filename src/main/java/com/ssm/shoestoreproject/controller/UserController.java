package com.ssm.shoestoreproject.controller;

import com.ssm.shoestoreproject.domin.OrderItemPlus;
import com.ssm.shoestoreproject.domin.OrdersPlus;
import com.ssm.shoestoreproject.domin.UserInfo;
import com.ssm.shoestoreproject.service.UserOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserOrdersService userOrdersService;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @RequestMapping("/showAllOrders")
    public String showAllOrders(Model model){
        HttpSession session = httpServletRequest.getSession();
        UserInfo userInfo =(UserInfo)session.getAttribute("customer");
        List<OrdersPlus> orders = userOrdersService.findAllOrders(userInfo.getUserId());
        model.addAttribute("orders",orders);
        return "/userallorders";
    }

    @RequestMapping("/showOrderItem")
    public String showOrderItem(@RequestParam("orderId") Integer orderId, Model model){
        List<OrderItemPlus> orderItem = userOrdersService.findOrderItem(orderId);
        for(int i = 0; i < orderItem.size(); i++){
            orderItem.get(i).setShoePicture("/image/" + orderItem.get(i).getShoePicture());
        }
        model.addAttribute("orderItem",orderItem);
        return "/usershoworderitem";
    }

    //发起退货
    @GetMapping("/returnshoe")
    public String returnShoe(@RequestParam("orderItemId") Integer orderItemId,@RequestParam("orderId") Integer orderId){
       userOrdersService.UserupdateStatus1(orderItemId);
       return "redirect:/user/showOrderItem?orderId="+orderId;
    }
}
