package com.ssm.shoestoreproject.service;

import com.ssm.shoestoreproject.domin.Category;
import com.ssm.shoestoreproject.domin.ShoeInfo;
import com.ssm.shoestoreproject.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    public Category findById(String categoryId){
        return categoryMapper.findById(categoryId);
    }

    //显示全部种类
    public List<Category> showAllCategories(){
        List<Category> categories = categoryMapper.showAllCategories();
        return categories;
    }

    //根据种类名显示出所有鞋
    public List<ShoeInfo> SelectShoesBycategoryId(int categoryId){
        List<ShoeInfo> shoeInfos = categoryMapper.SelectShoesBycategoryId(categoryId);
        return shoeInfos;
    }
}
