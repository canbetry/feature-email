package com.feature.email.dao.user;

import com.feature.email.entity.user.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    final String resultMap = "id,user_name,user_password,salt,user_email," +
            "user_type,cust_name,create_time,update_time,is_deleted";
    final String resultParamMap = "(#{id},#{userName},#{userPassword},#{salt},#{userEmail}," +
            "#{userType},#{custName},#{createTime},#{updateTime},#{isDeleted})";
    final String updateResultMap = "id = #{id},user_name=#{userName},user_password=#{userPassword}," +
            "salt = #{salt},user_email=#{userEmail},user_type = #{userType},cust_name =#{custName}," +
            "create_time=#{createTime},update_time=#{updateTime},is_deleted=#{isDeleted}";


    @Insert("insert into fe_user (" + resultMap + ") values " + resultParamMap)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Integer saveUser(User user);


    //    @Results({
//            @Result(id = true, column = "id", property = "id"),
//            @Result(column = "user_name", property = "userName"),
//            @Result(column = "user_password", property = "userPassword"),
//            @Result(column = "salt", property = "salt"),
//            @Result(column = "user_email", property = "userEmail"),
//            @Result(column = "user_type", property = "userType"),
//            @Result(column = "cust_name", property = "custName"),
//            @Result(column = "is_deleted", property = "isDeleted")
//    })
    @Select("select " + resultMap + " from fe_user where is_deleted = '0' and user_name = #{userName}")
    User queryByUserName(@Param("userName") String userName);

    @Select("select" + resultMap + "from fe_user where is_deleted = '0' and id = #{userId}")
    User queryByUserId(@Param("userId") Long userId);

    @Select("select" + resultMap + "from fe_user where is_deleted = '0' and user_email = #{userEmail}")
    User queryByUserEmail(@Param("userEmail") String userEmail);

    @Update("update fe_user set " + updateResultMap)
    Integer updateUser(User user);
}
