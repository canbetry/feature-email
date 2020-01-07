package com.feature.email.dao.email;

import com.feature.email.entity.email.TotalEmail;
import org.apache.ibatis.annotations.*;

import java.util.List;


/**
 * @description: TotalEmailMapper <br>
 * @date: 2020/1/7 11:00 <br>
 * @author: luoyl <br>
 * @version: 1.0 <br>
 */
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


    /**
     * 保存邮件
     *
     * @param totalEmail {@link TotalEmail}
     * @return
     */
    @Insert("insert into fe_total_email (" + resultMap + ") VALUES " + resultParamMap)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Integer saveTotalEmail(TotalEmail totalEmail);

    /**
     * 查询邮件列表
     *
     * @param totalEmail {@link TotalEmail}
     * @return
     */
    @Select("select " + resultMap + " from fe_total_email where " + updateResultMap)
    List<TotalEmail> queryTotalEmailList(TotalEmail totalEmail);

    /**
     * 根据id查询邮件
     *
     * @param id
     * @return
     */
    @Select("select " + resultMap + " from fe_total_email where id = #{id}")
    TotalEmail queryTotalEmailById(@Param("id") Long id);


    /**
     * 更新邮件
     *
     * @param totalEmail
     * @return
     */
    @Update("update fe_total_email set " + updateResultMap)
    Integer updateTotalEmail(TotalEmail totalEmail);

    /**
     * 删除邮件
     *
     * @param id
     * @return
     */
    @Update("update fe_total_email set is_deleted = '1' where id = #{id}")
    Integer removeTotalEmail(Long id);
}
