package com.ssm.shoestoreproject.domin;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfo implements Serializable {
    private Integer userId;
    private String userName;
    private String userPasswd;
    private String userContact;
    private Double userSave;
    private String userAdd;

    public UserInfo() {
    }

    public UserInfo(Integer userId, String userName, String userPasswd, String userContact, Double userSave, String userAdd) {
        this.userId = userId;
        this.userName = userName;
        this.userPasswd = userPasswd;
        this.userContact = userContact;
        this.userSave = userSave;
        this.userAdd = userAdd;
    }

    //无id和金额的构造函数
    public UserInfo(String userName, String userPasswd, String userContact, String userAdd) {
        this.userName = userName;
        this.userPasswd = userPasswd;
        this.userContact = userContact;
        this.userAdd = userAdd;
    }

//    public Integer getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Integer userId) {
//        this.userId = userId;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getUserPasswd() {
//        return userPasswd;
//    }
//
//    public void setUserPasswd(String userPasswd) {
//        this.userPasswd = userPasswd;
//    }
//
//    public String getUserContact() {
//        return userContact;
//    }
//
//    public void setUserContact(String userContact) {
//        this.userContact = userContact;
//    }
//
//    public Double getUserSave() {
//        return userSave;
//    }
//
//    public void setUserSave(Double userSave) {
//        this.userSave = userSave;
//    }
//
//    public String getUserAdd() {
//        return userAdd;
//    }
//
//    public void setUserAdd(String userAdd) {
//        this.userAdd = userAdd;
//    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPasswd='" + userPasswd + '\'' +
                ", userContact='" + userContact + '\'' +
                ", userSave=" + userSave +
                ", userAdd='" + userAdd + '\'' +
                '}';
    }
}
