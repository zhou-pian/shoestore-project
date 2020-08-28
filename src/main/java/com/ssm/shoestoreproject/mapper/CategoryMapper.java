package com.ssm.shoestoreproject.mapper;

import com.ssm.shoestoreproject.domin.Category;
import com.ssm.shoestoreproject.domin.ShoeInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    public Category findById(String categoryId);

    //显示全部种类
    public List<Category> showAllCategories();

    //根据种类名显示出所有鞋
    public List<ShoeInfo> SelectShoesBycategoryId(int categoryId);
}
