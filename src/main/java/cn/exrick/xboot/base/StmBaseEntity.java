package cn.exrick.xboot.base;

import cn.exrick.xboot.common.utils.SnowFlakeUtil;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Exrickx
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public abstract class StmBaseEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "唯一标识")
    private String id ;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill= FieldFill.INSERT)
    private Date createTime;


}
