package com.feature.email.dao;

import com.feature.email.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Component;

@Mapper
public interface UserMapper {

    @Insert("insert into email_user (id,user_name,user_password,salt,user_email,user_type,cust_name) " +
            "values (#{id},#{userName},#{userPassword},#{salt},#{userEmail},#{userType},#{custName})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    public Integer saveUser(User user);
}
