package cn.exrick.xboot.modules.stm.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "用户")
public class SrmUser {

    @ApiModelProperty(value = "用户ID")
    private String userId;

    @ApiModelProperty(value = "账号")
    private String account;

    @ApiModelProperty(value = "姓名")
    private String realName;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "部门Id")
    private String departmentId;

    @ApiModelProperty(value = "公司ID")
    private String companyId;

    @ApiModelProperty(value = "班组ID")
    private String groupid;

    @ApiModelProperty(value = "角色类型：1班组成员，2=试验中心成员，3=安监成员，4=维护管理员，999=超级管理员")
    private String type;

}
