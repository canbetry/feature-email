package com.feature.email.dao.user;

import com.feature.email.entity.user.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    final String resultMap = "id,user_name,user_password,salt,user_email,user_type,cust_name,is_deleted";
    final String resultParamMap = "(#{id},#{userName},#{userPassword},#{salt},#{userEmail},#{userType},#{custName},#{isDeleted})";

    @Insert("insert into email_user (" + resultMap + ") values " + resultParamMap)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Integer saveUser(User user);

    @Select("select " + resultMap + " from email_user where is_deleted = '0' and user_name = #{userName}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "user_name", property = "userName"),
            @Result(column = "user_password", property = "userPassword"),
            @Result(column = "salt", property = "salt"),
            @Result(column = "user_email", property = "userEmail"),
            @Result(column = "user_type", property = "userType"),
            @Result(column = "cust_name", property = "custName"),
            @Result(column = "is_deleted", property = "isDeleted")
    })
    User queryByUserName(@Param("userName") String userName);
}
