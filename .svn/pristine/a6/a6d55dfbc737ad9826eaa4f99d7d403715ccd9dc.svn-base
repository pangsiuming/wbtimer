package com.eshore.wbtimer.executor.mapper.bean;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author wyf
 * @since 2018-05-17
 */
public class Myusers implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "USERID", type = IdType.AUTO)
    private Integer userid;
    private String username;
    private String password;


    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Myusers{" +
        "userid=" + userid +
        ", username=" + username +
        ", password=" + password +
        "}";
    }
}
