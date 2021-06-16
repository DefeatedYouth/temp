package cn.exrick.xboot.modules.shebei.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/6/15 17:02
 * @File: SbDefectDTO
 */
@Data
public class SbDefectDTO {

    @ApiModelProperty(value = "一般缺陷（隐患）数量")
    private Integer commonNum;
    @ApiModelProperty(value = "严重缺陷（隐患）数量")
    private Integer severityNum;
    @ApiModelProperty(value = "危机缺陷（隐患）数量")
    private Integer criticalNum;
    @ApiModelProperty(value = "未处理缺陷（隐患）数量")
    private Integer notdefectNum;

}
