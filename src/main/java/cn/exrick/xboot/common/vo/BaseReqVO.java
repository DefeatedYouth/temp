package cn.exrick.xboot.common.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author chenfeixiang6@163.com
 * @date 2021/6/7
 * @desc
 */
@Data
public class BaseReqVO {
    @ApiModelProperty(value = "唯一标识")
    private String id ;
    @ApiModelProperty(value = "唯一标识")
    private List<String> ids ;

    @ApiModelProperty(value = "层级 1 地市公司 2 工区 3 班组")
    private Integer level;

    @ApiModelProperty(value = "父级id")
    private Long parentId;

    @ApiModelProperty(value = "设备类型id")
    private Integer type;

    @ApiModelProperty(value = "变电站id")
    private Long siteId;

}
