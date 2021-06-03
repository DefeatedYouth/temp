package cn.exrick.xboot.modules.stm.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author chenfeixiang6@163.com
 * @date 2021/3/18
 * @desc
 */
@Data
public class CategoryParamsQuery {

    /**参数名称*/
    @ApiModelProperty(value = "参数字段名称")
    private String name;
    /**器具类型id*/
    @ApiModelProperty(value = "器具类型id")
    private String categoryId;
}
