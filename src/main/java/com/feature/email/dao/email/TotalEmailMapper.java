package com.feature.email.dao.email;

import com.feature.email.entity.email.TotalEmail;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TotalEmailMapper {

    final String resultMap = " id,user_name,user_password,salt,user_email,user_type,cust_name," +
            "create_time,update_time,is_deleted ";

    final String resultParamMap = " #{id},#{user_id},#{#{email_content},#{send_user_real_name}," +
            "#{send_user_real_email},#{recive_user_real_name},#{recive_user_real_addr}," +
            "#{recive_user_real_email},#{create_email_time},#{update_email_time},#{is_send},#{is_deleted} ";

    final String updateResultMap = " id=#{id},user_id=#{user_id},email_title=#{email_title}," +
            "email_content=#{email_content},send_user_real_name=#{send_user_real_name}," +
            "recive_user_real_name=#{recive_user_real_name},recive_user_real_addr=#{recive_user_real_addr}," +
            "recive_user_real_email=#{recive_user_real_email},create_email_time=#{create_email_time}," +
            "update_email_time=#{update_email_time},is_send=#{is_send},is_deleted=#{is_deleted} ";

    @Insert("insert into fe_total_email (" + resultMap + ") VALUES " + resultParamMap)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Integer saveTotalEmail(TotalEmail totalEmail);

    @Select("select " + resultMap + " from fe_total_email where " + updateResultMap)
    List<TotalEmail> queryTotalEmailList(TotalEmail totalEmail);

    @Select("select " + resultMap + " from fe_total_email where id = #{id}")
    TotalEmail queryTotalEmailById(@Param("id") Long id);

    @Update("update fe_total_email set " + updateResultMap)
    Integer updateTotalEmail(TotalEmail totalEmail);

}
