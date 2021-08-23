package com.sgcc.bd.overallview.businessapi.environmententer;

import com.sgcc.bd.overallview.businessapi.ApiResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @description: TODO
 * @author： hfl
 * @date：2021/8/20 16:45
 * @File: FaultRecordResponse
 */
@Data
public class FaultRecordResponse extends ApiResponse {

    @ApiModelProperty(value = "响应数据")
    private FaultRecordData result;

    @Data
    public  static class  FaultRecordData{

        Integer current;

        List orders;

        Integer pages;

        List<FaultVo> records;

        Boolean searchCount;

        Integer size;

        Integer total;

    }

    @Data
    public  static class  FaultVo{

        String objId;
        String sgyjqxdId;
        String bdzid;
        String bdzmc;
        String ssdsid;
        String ssdsmc;
        String gzxlid;
        String gzxmc;
        String gzsb;
        String gzsbmc;
        String jsyy;
        String zryy;
        String djbmid;
        String djbmmc;
        String dzzbzid;
        String dzzbz;
        String cljg;
        Date gzfssj;
        String qxryid;
        String qxrymc;
        String gzdczjg;
        String gzxz;
        String gzjt;
        String gzlx;
        String gzqk;
        Integer sftz;
        Date gztzsj;
        String zdzzdzqk;
        String gzxb;
        String gzsdtq;
        String gzssfh;
        String gzdwxxms;
        String gzdwxxxzb;
        String gzdwxxyzb;
        String ydcs;
        String chzdzqk;
        Date gzdczsj;
        Date hfsdsj;
        String gzsbyxbz;
        Double sfzjl;
        String glzjlid;
        String bz;
        String cbssjb;
        String hjssjb;
        String rsssjb;
        String dwssjb;
        Date sbsj;
        String jjbzj;
        Double sfzngz;
        String djrid;
        String djrmc;
        String gzlb;
        String gzjb;
        Double gzsfyj;
        String gztyfw;
        String dydj;
        String gzssqk;
        String gztyfwid;
        String gztyfwmc;
        String ssdwid;
        String ssdwmc;
        String clrid;
        String clrmc;
        Date clsj;
        String gzfxbg;
        String sblxbm;
        String sblx;
        String tzyy1;
        String tzyy2;
        String gzlbt;
        String gzdwlbjl;
        String clwc;
        String gzfxbglcid;
        String gzfxbglchj;
        String gzfxbgscsj;
        String tp;
        Integer sfbs;
        String jbsdzqk;
        Integer sfty;
        String zyfl;
        Date djsj;
        String lbcj;
        Integer gzdl;
        String sjlyxx;
        String gzcssj;
        Integer lcslid;
        String gzzt;
        String sfscjzb;
        String tysbsblxbm;
        String sfslgk;
    }

}
