package com.feature.email.common.commonEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


/**
 * @description: CommonEntity <br>
 * @date: 2020/1/7 11:41 <br>
 * @author: luoyl <br>
 * @version: 1.0 <br>
 */
@Data
@ApiModel("通用实体")
public class CommonEntity implements Serializable {
    @ApiModelProperty("自增主键表示")
    private Long id;
    @ApiModelProperty("逻辑删除标志:0.正常，1.删除")
    private String isDeleted = "0";
}
