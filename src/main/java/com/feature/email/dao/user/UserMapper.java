package com.feature.email.dao.user;

import com.feature.email.entity.user.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    final String resultMap = " id,user_name,user_password,salt,user_email," +
            "user_type,cust_name,create_time,update_time,is_deleted ";
    final String resultParamMap = " (#{id},#{userName},#{userPassword},#{salt},#{userEmail}," +
            "#{userType},#{custName},#{createTime},#{updateTime},#{isDeleted})  ";
    final String updateResultMap = " id = #{id},user_name=#{userName},user_password=#{userPassword}," +
            "salt = #{salt},user_email=#{userEmail},user_type = #{userType},cust_name =#{custName}," +
            "create_time=#{createTime},update_time=#{updateTime},is_deleted=#{isDeleted} ";

    final String updateUserMap = " user_name=#{userName},user_email=#{userEmail},update_time=#{updateTime} ";


    @Insert("insert into fe_user (" + resultMap + ") values " + resultParamMap)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Integer saveUser(User user);

    @Select("select " + resultMap + " from fe_user where is_deleted = '0' and user_name = #{userName}")
    User queryByUserName(@Param("userName") String userName);

    @Select("select" + resultMap + "from fe_user where is_deleted = '0' and id = #{userId}")
    User queryByUserId(@Param("userId") Long userId);

    @Select("select" + resultMap + "from fe_user where is_deleted = '0' and user_email = #{userEmail}")
    User queryByUserEmail(@Param("userEmail") String userEmail);

    @Update("update fe_user set " + updateUserMap + " where id = #{id}")
    Integer updateUser(User user);

    @Update("update fe_user set user_password = #{userPwd} where id = #{id}")
    Integer updateUserPwd(@Param("userPwd") String userPwd, @Param("id") Long id);
}
