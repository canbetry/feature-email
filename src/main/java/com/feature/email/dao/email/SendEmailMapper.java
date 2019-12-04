package com.feature.email.dao.email;


import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SendEmailMapper {
    final String resultMap = " id,send_user_id,send_user_real_name,send_user_real_email," +
            "recive_user_real_name,recive_user_real_addr,recive_user_real_email," +
            "send_email_time,revice_email_time,total_email_idemail_status,is_deleted ";
    final String resultParamMap = " #{id},#{sendUserId},#{sendUserRealName},#{sendUserRealEmail}," +
            "#{reciveUserRealName},#{#{reciveUserRealEmail},#{sendEmailTime},#{reviceEmailTime}," +
            "#{totalEmailId},#{emailStatus},#{isDeleted} ";

    final String updateResultMap = " id = #{id},send_user_id = #{sendUserId}," +
            "send_user_real_name = #{sendUserRealName},send_user_real_email = #{sendUserRealEmail}," +
            "recive_user_real_name = #{reciveUserRealName},recive_user_real_addr = #{reciveUserRealAddr}," +
            "recive_user_real_email = #{reciveUserRealEmail},send_email_time = #{sendEmailTime}," +
            "revice_email_time = #{reciveEmailTime},total_email_id = #{totalEmailId},email_status = #{emailStatus}," +
            "is_deleted = #{isDeleted} ";




}
