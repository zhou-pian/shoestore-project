package com.ssm.shoestoreproject.service;

import com.ssm.shoestoreproject.domin.ShoeInfo;
import com.ssm.shoestoreproject.domin.ShoePlus;
import com.ssm.shoestoreproject.domin.ShoppingCar;
import com.ssm.shoestoreproject.mapper.ShoeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ShoeService {

    @Autowired
    public ShoeMapper shoeMapper;

    public List<ShoePlus> findAll(){
        return shoeMapper.findAll();
    }

    public ShoeInfo findById(String shoeId){
        return shoeMapper.findById(shoeId);
    }

    public int insertShoe(MultipartFile multipartFile,ShoeInfo shoeInfo) throws IOException {
        String filePath = "C:\\Users\\周翩\\Desktop\\shoestore-project\\src\\main\\resources\\static\\image";
        String fileName = multipartFile.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String newFileName = UUID.randomUUID().toString() + suffixName;
        File targetFile = new File(filePath,newFileName);
        multipartFile.transferTo(targetFile);
        shoeInfo.setShoePicture(newFileName);

//        Date date = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd");
//        shoeInfo.setTime(simpleDateFormat.format(date));
        return shoeMapper.insertShoe(shoeInfo);
    }

    public int updateShoe(ShoeInfo shoeInfo){
        return shoeMapper.updateShoe(shoeInfo);
    }

    public int deleteShoe(Integer shoeId){
        return shoeMapper.deleteShoe(shoeId);
    }

    public int deliverShoe(Integer shoeId){
        return shoeMapper.deliverShoe(shoeId);
    }

    public Double getPrice(Integer shoeId){
        return shoeMapper.getPrice(shoeId);
    }

    public void updatesoldnumber(Integer quantity,Integer shoeId){
        shoeMapper.updatesoldnumber(quantity,shoeId);
    }

    public void updatesoldnumber1(Integer quantity,Integer shoeId){
        shoeMapper.updatesoldnumber1(quantity,shoeId);
    }

    //显示全部的鞋
    public List<ShoeInfo> ShowAllShoes(){
        List<ShoeInfo> shoeInfos = shoeMapper.ShowAllShoes();
        return shoeInfos;
    }

    //显示单个鞋的具体信息
    public List<ShoeInfo> ShowOneShoe(String shoeName){
        List<ShoeInfo> shoeInfos = shoeMapper.ShowOneShoe(shoeName);
        return shoeInfos;
    }
    public ShoeInfo ShowOneShoeById(int shoeId){
        ShoeInfo shoeInfo = shoeMapper.ShowOneShoeById(shoeId);
        return shoeInfo;
    }

    //单个鞋添加购物车
    public int OneaddShoppingCar(ShoppingCar shoppingCar){
        return shoeMapper.OneaddShoppingCar(shoppingCar);
    }
    public ShoppingCar findCarByuIdandsId(int userId,int shoeId){
        ShoppingCar shoppingCar = shoeMapper.findCarByuIdandsId(userId,shoeId);
        return shoppingCar;
    }
    public int updateCarByuIdandsId(int userId,int shoeId){
        return shoeMapper.updateCarByuIdandsId(userId,shoeId);
    }

    //根据鞋名模糊查询鞋
    public List<ShoeInfo> SelectShoeByName(String shoeName){
        List<ShoeInfo> shoeInfos = shoeMapper.SelectShoeByName(shoeName);
        return shoeInfos;
    }
}
