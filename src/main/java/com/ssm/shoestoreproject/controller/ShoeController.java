package com.ssm.shoestoreproject.controller;

import com.ssm.shoestoreproject.domin.*;
import com.ssm.shoestoreproject.service.OrderService;
import com.ssm.shoestoreproject.service.ShoeService;
import com.ssm.shoestoreproject.service.UserOrdersService;
import com.ssm.shoestoreproject.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/buy")
public class ShoeController {
    @Autowired
    private ShoeService shoeService;
    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private UserOrdersService userOrdersService;

    //单个鞋查看详情，选择码数以及男女款
    @GetMapping("/showoneshoe")
    public String showOneShoe(@Param("shoeId") Integer shoeId,@Param("shoeName") String shoeName, Model model){
        List<ShoeInfo> shoeInfos = shoeService.ShowOneShoe(shoeName);
        ShoeInfo shoeInfo = shoeService.ShowOneShoeById(shoeId);
        for(int i = 0; i < shoeInfos.size(); i++){
            shoeInfos.get(i).setShoePicture("../image/" + shoeInfos.get(i).getShoePicture());
        }
        shoeInfo.setShoePicture("../image/" + shoeInfo.getShoePicture());
        model.addAttribute("shoeInfos", shoeInfos);
        model.addAttribute("shoeInfo", shoeInfo);
        return "/shoeIntro";
    }

        //单个鞋选择是否购买，或者加入购物车
    @GetMapping("/ChageOneShoe")
    public String chageOneShoe(@Param("shoeId") Integer shoeId,Model model){
        ShoeInfo shoeInfo = shoeService.ShowOneShoeById(shoeId);
        shoeInfo.setShoePicture("../image/" + shoeInfo.getShoePicture());
        model.addAttribute("shoeInfo", shoeInfo);
        return "/chageOneShoe";
    }


    //单个鞋加入购物车
    @GetMapping("/oneAddshoppingcar")
    public String oneAddshoppingcar(@Param("shoeId") Integer shoeId,Model model){
        HttpSession session = httpServletRequest.getSession();
        UserInfo userInfo = (UserInfo)session.getAttribute("customer");
        int userId = userInfo.getUserId();
        ShoppingCar shoppingCar = shoeService.findCarByuIdandsId(userInfo.getUserId(),shoeId);
//        System.out.println(shoppingCar.getQuantity());
        if(shoppingCar != null){
            int k = shoeService.updateCarByuIdandsId(userId,shoeId);
            if(k==1){
                return "redirect:/shoppingcar/showshoppingcar";
            }
            else{
                return "/chageOneShoe";
            }
        }
        else{
        ShoppingCar shoppingCar1 = new ShoppingCar(userId, shoeId, 1);
          shoeService.OneaddShoppingCar(shoppingCar1);
          return "redirect:/shoppingcar/showshoppingcar";
    }
    }

    //单个鞋购买
    @RequestMapping("/buyoneshoe")
    public String buyoneshoe(@Param("shoeId") String shoeId,@Param("price") double price,Model model) {
        HttpSession session = httpServletRequest.getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute("customer");
        int userId = userInfo.getUserId();
        //添加一个订单
        Orders order = new Orders(userId,price,shoeId,"正在选择");
        orderService.insertOrder(order);
        Integer orderId = orderService.getOrderId("正在选择");
        ShoeInfo shoeInfo = shoeService.findById(shoeId);
        shoeInfo.setShoePicture("../image/"+shoeInfo.getShoePicture());
        model.addAttribute("shoeInfo", shoeInfo);
        return "/onepaysure";

    }

    @GetMapping("/buyoneshoesure")
    public String buyoneshoesure(@Param("price") double price,@Param("shoeId") Integer shoeId) {
        HttpSession session = httpServletRequest.getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute("customer");
        int userId = userInfo.getUserId();
        double userSave = userService.getUserSave(userId);

        Integer orderId = orderService.getOrderId("正在选择");
        //判断用户余额是否足够
        if(userSave >= price) {
            OrderItem orderItem = new OrderItem(shoeId,orderId,1);
            orderService.insertOrderItem(orderItem);
            shoeService.updatesoldnumber(1,shoeId);

            userSave = userSave - price;
            userService.updateUserSave(userSave,userId);

            orderService.updateStatus_o(orderId);
            orderService.updateStatus_s(orderId);
            return "/buysuccess";
        }
        else{
            System.out.println("余额不足");
            userOrdersService.deletenosaveorder(orderId);
            return "/buyfail";
        }
    }

    @GetMapping("/buysuccess")
    public String buysuccess(){
        return "/buysuccess";
    }

    @GetMapping("/buyfail")
    public String buybuyfail(){
        return "/buyfail";
    }
    //搜索框模糊查询
    @PostMapping("/selectshoeBylikeName")
    public String selectshoeBylikeName(@RequestParam("shoeName") String shoeName,Model model){
        String name = "%" + shoeName + "%";
        List<ShoeInfo> shoeInfos = shoeService.SelectShoeByName(name);
        for(int i = 0; i < shoeInfos.size(); i++){
            shoeInfos.get(i).setShoePicture("../image/" + shoeInfos.get(i).getShoePicture());
        }
        model.addAttribute("shoeInfos",shoeInfos);
        return "/findByshoeName";
    }

}
