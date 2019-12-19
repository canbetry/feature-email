package com.feature.email.dao.email;

import com.feature.email.entity.email.TotalEmail;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TotalEmailMapper {

    final String resultMap = " id,user_id,email_title,email_content,send_user_real_name,recive_user_real_name," +
            "recive_user_real_addr,recive_user_real_email,is_visible,create_email_time,update_email_time," +
            "is_send,is_deleted ";

    final String resultParamMap = " #{id},#{userId},#{emailTitle},#{#{emailContent}," +
            "#{sendUserRealName},#{reciveUseRealName},#{reciveUserRealAddr}," +
            "#{reciveUserRealEmail},#{isVisible},#{createEmailTime},#{updateEmailTime},#{isSend},#{isDeleted} ";

    final String updateResultMap = " id=#{id},user_id=#{userId},email_title=#{emailTitle}," +
            "email_content=#{emailContent},send_user_real_name=#{sendUserRealName}," +
            "recive_user_real_name=#{reciveUseRealName},recive_user_real_addr=#{reciveUserRealAddr}," +
            "recive_user_real_email=#{reciveUserRealEmail},is_visible=#{isVisible},create_email_time=#{createEmailTime}," +
            "update_email_time=#{updateEmailTime},is_send=#{isSend},is_deleted=#{isDeleted} ";

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
