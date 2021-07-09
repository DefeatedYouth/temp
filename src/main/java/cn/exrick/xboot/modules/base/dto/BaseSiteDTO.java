package cn.exrick.xboot.modules.base.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/7/5 10:37
 * @File: BaseSiteDTO
 */
@Data
public class BaseSiteDTO {
    @ApiModelProperty(value = "")
    private String id;

    @ApiModelProperty(value = "名称")
    private String name;
}
