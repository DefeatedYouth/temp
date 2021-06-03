package cn.exrick.xboot.base;

import cn.exrick.xboot.common.utils.HLStringUtil;
import cn.exrick.xboot.common.utils.SnowFlakeUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Exrickx
 */
@Data
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public abstract class StmBaseEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "唯一标识")
    private String id ;

    public void initId(String idPrefix){
        if (HLStringUtil.isNotEmptyWithBlank(idPrefix)){
//            if (this instanceof ExperimentMain){
//                id = idPrefix + MyDateUtil.getTimeId();
//            } else if (this instanceof InspectionMain){
//                id = idPrefix + MyDateUtil.getTimeId();
//            } else if( this instanceof ScrapMain){
//                id = idPrefix + MyDateUtil.getTimeId();
//            } else if (this instanceof CollectNumberMain){
//                id = idPrefix + MyDateUtil.getTimeId();
//            }
//            else {
                id = String.valueOf(SnowFlakeUtil.getFlowIdInstance().nextId());
//            }
        } else {
            id =  String.valueOf(SnowFlakeUtil.getFlowIdInstance().nextId());
        }
    };
    public void initId(){
        id = String.valueOf(SnowFlakeUtil.getFlowIdInstance().nextId());
    };


}
