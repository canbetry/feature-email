package com.feature.email.dao;

import com.feature.email.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Component;

@Mapper
public interface UserMapper {

    @Insert("insert into email_user (user_name,user_password,user_email,user_type,cust_name) " +
            "values (#{userName},#{userPassword},#{userEmail},#{userType},#{custName})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    public Integer saveUser(User user);
}
