package com.sgcc.bd.overallview.modules.stm.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenfeixiang6@163.com
 * @date 2021/4/9
 * @desc
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileUploadVo {
    @ApiModelProperty(value = "可以预览的路径")
    private String httpPath;
    @ApiModelProperty(value = "保存的时候 传入此路径")
    private String path;
}
