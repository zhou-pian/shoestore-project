package com.ssm.shoestoreproject.controller;

import com.ssm.shoestoreproject.domin.OrderItem;
import com.ssm.shoestoreproject.domin.Orders;
import com.ssm.shoestoreproject.domin.ShoppingCarPlus;
import com.ssm.shoestoreproject.domin.UserInfo;
import com.ssm.shoestoreproject.mapper.ShoppingCarMapper;
import com.ssm.shoestoreproject.service.OrderService;
import com.ssm.shoestoreproject.service.ShoeService;
import com.ssm.shoestoreproject.service.ShoppingCarService;
import com.ssm.shoestoreproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/shoppingcar")
public class ShoppingCarController {

    @Autowired
    private ShoppingCarService shoppingCarService;

    @Autowired
    private OrderService orderService;

    @Autowired
    public ShoeService shoeService;

    @Autowired
    public UserService userService;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @RequestMapping("/showshoppingcar")
    public String showshoppingcar(Model model){
        HttpSession session = httpServletRequest.getSession();
        UserInfo userInfo = (UserInfo)session.getAttribute("customer");
        List<ShoppingCarPlus> shoppingCars = shoppingCarService.findShoppingCarByUser(userInfo.getUserId());
        for(int i = 0; i < shoppingCars.size(); i++){
            shoppingCars.get(i).setShoePicture("../image/" + shoppingCars.get(i).getShoePicture());
        }
        model.addAttribute("shoppingCars",shoppingCars);
        return "/showShoppingCar";
    }

    @ResponseBody
    @RequestMapping("/buy")
    public String buy(@RequestParam("ids") String ids){
        HttpSession session = httpServletRequest.getSession();
        UserInfo userInfo = (UserInfo)session.getAttribute("customer");
        Integer userId = userInfo.getUserId();
        List<Integer> list_ids = new ArrayList<>();
        String[] str_ids = ids.split("-");
        //组装id的集合
        for (String string : str_ids) {
            list_ids.add(Integer.parseInt(string));
        }
        System.out.println(list_ids);
        Double amount = 0.0;
        for(int i = 0; i  <list_ids.size(); i++){
            int id = list_ids.get(i);
            Integer shoeId = shoppingCarService.getShoeId(id);
            Integer quantity = shoppingCarService.getQuantity(id);
            Double price = shoeService.getPrice(shoeId);
            amount += price*quantity;
        }
        ids = userId + "-" +ids;
        System.out.println(ids);
        Orders order = new Orders(userId,amount,ids,"正在选择");
        orderService.insertOrder(order);
        return "{\"msg\":\"true\"}";
    }

    @ResponseBody
    @RequestMapping("/setQuantity1")
    public String setQuantity1(Integer id){
        int result = shoppingCarService.setQuantity1(id);
        if(result == 1){
            return "{\"msg\":\"true\"}";
        }
        else{
            return "{\"msg\":\"false\"}";
        }
    }

    @ResponseBody
    @RequestMapping("/setQuantity2")
    public String setQuantity2(Integer id){
        int result = shoppingCarService.setQuantity2(id);
        if(result == 1){
            return "{\"msg\":\"true\"}";
        }
        else{
            return "{\"msg\":\"false\"}";
        }
    }

    @RequestMapping("/pay")
    public String pay(Model model){
        Integer orderId = orderService.getOrderId("正在选择");
        String status_o = orderService.getStatus_o(orderId);
        Double amount = orderService.getAmount(orderId);
        String[] str_ids = status_o.split("-");
        List<ShoppingCarPlus> shoppingCars = new ArrayList<>();
        for(int i = 1;i < str_ids.length;i++)
        {
            int id = Integer.parseInt(str_ids[i]);
            ShoppingCarPlus shoppingCarPlus = shoppingCarService.findShoppingCarById(id);
            shoppingCars.add(shoppingCarPlus);
        }

        for(int i = 0; i < shoppingCars.size(); i++){
            shoppingCars.get(i).setShoePicture("../image/" + shoppingCars.get(i).getShoePicture());
        }
        model.addAttribute("shoppingCars",shoppingCars);
        model.addAttribute("amount",amount);
//        for(int i = 0; i  <list_ids.size(); i++){
//            int id = list_ids.get(i);
//            Integer shoeId = shoppingCarService.getShoeId(id);
//            Integer quantity = shoppingCarService.getQuantity(id);
//            OrderItem orderItem = new OrderItem(shoeId,orderId,quantity);
//            orderService.insertOrderItem(orderItem);
//        }
        return "/pay";
    }

    @ResponseBody
    @RequestMapping("/buyshoesure")
    public String buyshoesure(){
        //得到用户信息
        HttpSession session = httpServletRequest.getSession();
        UserInfo userInfo = (UserInfo)session.getAttribute("customer");
        Integer userId = userInfo.getUserId();
        double userSave = userService.getUserSave(userId);

        Integer orderId = orderService.getOrderId("正在选择");
        String status_o = orderService.getStatus_o(orderId);
        Double amount = orderService.getAmount(orderId);
        if(userSave >= amount){
            userSave = userSave - amount;
            userService.updateUserSave(userSave,userId);

            String[] str_ids = status_o.split("-");
            for(int i = 1;i < str_ids.length;i++){
                int id = Integer.parseInt(str_ids[i]);
                Integer shoeId = shoppingCarService.getShoeId(id);
                Integer quantity = shoppingCarService.getQuantity(id);
                OrderItem orderItem = new OrderItem(shoeId,orderId,quantity);
                orderService.insertOrderItem(orderItem);
                shoeService.updatesoldnumber(quantity,shoeId);
            }
            orderService.updateStatus_o(orderId);
            orderService.updateStatus_s(orderId);
            return "{\"msg\":\"true\"}";
        }
        else{
            orderService.deleteorder(orderId);
            return "{\"msg\":\"false\"}";
        }
    }

    @RequestMapping("/deleteOnecar")
    public String deleteOnecar(@RequestParam("shoppingcarId") Integer shoppingcarId){
        shoppingCarService.deleteshoppingcar(shoppingcarId);
        return "redirect:/shoppingcar/showshoppingcar";
    }
}
