package com.ssm.shoestoreproject.controller;

import com.ssm.shoestoreproject.domin.Category;
import com.ssm.shoestoreproject.domin.ShoeInfo;
import com.ssm.shoestoreproject.service.CategoryService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private HttpServletRequest httpServletRequest;

    //显示所有鞋的类别
    @GetMapping("/allcategories")
    public String showAllCategories(Model model){
        List<Category> categories = categoryService.showAllCategories();
        for(int i = 0; i < categories.size(); i++){
            categories.get(i).setCategoryImg("../image/index/" + categories.get(i).getCategoryImg());
        }
        model.addAttribute("categories",categories);
        return "/category";
    }

    //根据类别Id显示出所有的鞋
    @GetMapping("/showallShoesBycId")
    public String showallShoesBycId(@Param("categoryId") int categoryId,Model model){
        List<ShoeInfo> shoeInfos = categoryService.SelectShoesBycategoryId(categoryId);
        for(int i = 0; i < shoeInfos.size(); i++){
            shoeInfos.get(i).setShoePicture("../image/" + shoeInfos.get(i).getShoePicture());
        }
        model.addAttribute("shoeInfos",shoeInfos);
        return "/showShoeBycId";
    }


}
