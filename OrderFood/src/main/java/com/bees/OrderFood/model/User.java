package com.bees.OrderFood.model;

import javax.persistence.*;

@Entity
@Table(name = "tbl_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long UserId;
    @Column(name = "user_name")
    private String UserName;
    @Column(name = "user_account")
    private String UserAccount;
    @Column(name = "user_password")
    private String UserPassword;
    @Column(name = "user_email")
    private String UserEmail;
    @Column(name = "user_address")
    private  String UserAddress;
    @Column(name = "user_active")
    private int Active;

    public User(Long userId, String userName, String userAccount, String userPassword, String userEmail, String userAddress, int active) {
        UserId = userId;
        UserName = userName;
        UserAccount = userAccount;
        UserPassword = userPassword;
        UserEmail = userEmail;
        UserAddress = userAddress;
        Active = active;
    }

    public User() {
    }

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long userId) {
        UserId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserAccount() {
        return UserAccount;
    }

    public void setUserAccount(String userAccount) {
        UserAccount = userAccount;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String userPassword) {
        UserPassword = userPassword;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserEmail(String userEmail) {
        UserEmail = userEmail;
    }

    public String getUserAddress() {
        return UserAddress;
    }

    public void setUserAddress(String userAddress) {
        UserAddress = userAddress;
    }

    public int isActive() {
        return Active;
    }

    public void setActive(int active) {
        Active = active;
    }
}
