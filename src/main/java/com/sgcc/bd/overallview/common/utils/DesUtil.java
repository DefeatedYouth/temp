package com.sgcc.bd.overallview.common.utils;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.DES;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import sun.misc.BASE64Encoder;

import java.util.Date;

/**
 * @author chenfeixiang6@163.com
 * @date 2021/4/28
 * @desc
 */
public class DesUtil {

    public final static  String key =  "DYPNNKLCB38=";
    public final static  String key2 =  "DYPNNKLCB38=";

    public static String generateKey() {
        //随机生成密钥
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.DES.getValue()).getEncoded();
        String keyStr = new BASE64Encoder().encodeBuffer(key);
        return keyStr;
    }

    //解密
    public static String decryptStr(String encryptStr,String key) {
        DES des2 = SecureUtil.des(key.getBytes());
        //解密
        String decryptStr = des2.decryptStr(encryptStr);
        return decryptStr;
    }

    //  加密
    public static String encryptStr(String sql,String key) {
        DES des = SecureUtil.des(key.getBytes());
        //加密
        String encryptStr = des.encryptBase64(sql);
        return encryptStr;
    }

    public static void main(String[] args) {
//        String content = "create or replace view AIMS.INTO_BUSINESS_OUT_IN_VIEW as\n" +
//                "select a.id,a.APPLIANCE_ID,a.OUT_IN_TIME,a.IS_CHECK,a.OPRATE_TYPE,a.ORDER_NUMBER,a.OUT_IN_TYPE,a.USER_ID,a.EXP_ORDER,a.PURCHASE_ORDER,\n" +
//                "       a.USER_ID_NAME,\n" +
//                "       g.ARCHIVES_TIME,g.CATEGORY_ID,g.CODE,\n" +
//                "       g.MANUFACTURER_ID,g.PRODUCE_DATE,g.SERIAL_NUM,g.SPEC_ID,g.STATION_ID,g.STATUS,g.PAIR_COUNT,g.CHECK_DATE,\n" +
//                "       g.RECIPIENTS,\n" +
//                "       b.\"NAME\" STATION_NAME,b.GROUP_ID,\n" +
//                "       d.\"SPEC\" SPEC_NAME,d.VOLTAGE,\n" +
//                "       e.\"NAME\" CATEGORY_NAME,\n" +
//                "       f.path org_path,f.NAME org_name,f.BMXZNAME org_BMXZNAME,f.com_bmjc org_com_bmjc\n" +
//                "from AIMS.INTO_BUSINESS_OUT_IN a\n" +
//                "         LEFT JOIN AIMS.INTO_APPLIANCE g on a.APPLIANCE_ID=g.\"ID\"\n" +
//                "         left join AIMS.INTO_STATION b on g.STATION_ID=b.\"ID\"\n" +
//                "         left join AIMS.INTO_APPLIANCE_SPEC d on g.SPEC_ID=d.ID\n" +
//                "         left join AIMS.INTO_APPLIANCE_CATEGORY e on g.CATEGORY_ID=e.id\n" +
//                "         left join AIMS.COM_BASEORGNAIZE f on b.GROUP_ID=f.OBJ_ID";
//        String content = "update AIMS.INTO_CATEGORY_PARAMETER set IS_SPEC_SHOW = 1";
//        String content = "update AIMS.INTO_MANUFACTURER set CREATE_TIME = SYSDATE where CREATE_TIME is null ";
//        String content = "update AIMS.INTO_EXP_FOUNDATION_SET_NEW set EXP_PARAMS = replace(EXP_PARAMS,'mm?','mm2') where EXP_PARAMS like '%mm?%'";
//        String content = "delete from AIMS.INTO_MANUFACTURER where NAME is null";
//        String content = "select id from AIMS.INTO_APPLIANCE where STATION_ID is null  ";
//        String content = "select  count(*) from AIMS.INTO_INSPECTION";
//        String content = "SELECT COUNT( count(station_id) ) FROM AIMS.INTO_INSPECTION_APPLIANCE_VIEW WHERE (org_path LIKE '国网福建电力/%' AND inspect_date BETWEEN to_date('2021-05-01 00:00:00','yyyy-MM-dd HH24:mi:ss') AND to_date('2021-05-31 23:59:59','yyyy-MM-dd HH24:mi:ss')) GROUP BY station_id";
//        String content = "UPDATE AIMS.INTO_CATEGORY_PARAMS_CONFIGURE SET VALUE = '0.4kV,1kV,3kV,6kV,10(6)kV,10kV,20kV,25kV,30kV,33kV,35kV,66kV,110kV,220kV,330kV,500kV,750kV,1000kV,高压,低压' WHERE ID = 'AD75532FE5E717CFE050A8C02E001739'";
//        String content = "alter table AIMS.INTO_STATION add IMPORT_STATUS number(2) default 0";
//        String content = "select count(1) from AIMS.INTO_APPLIANCE  where PATH like '%国网福建电力/国网福州供电公司/国网福州供电公司本部/%' ";
//        String content = "select count(1) from AIMS.INTO_APPLIANCE  where station_id is null and PATH like '%国网福建电力/国网福州供电公司/国网福州供电公司本部/%' ";
//        String content = "SELECT * FROM AIMS.INTO_EXPERIMENT where PATH is null";
//        String content = "select * from AIMS.INTO_EXPERIMENT_APPLIANCE_VIEW where CATEGORY_ID is null";
//        String content = "select count(1) from AIMS.INTO_APPLIANCE_VIEW where STATION_ID is null or ORG_PATH is null";
//        String content = "select count(1) from AIMS.INTO_APPLIANCE_VIEW where STATION_ID is null or station_name is null";
//        String content = "select * from AIMS.COM_BASEORGNAIZE where name = '变电全业务运检班'";
//        String content = "select *\n" +
//                "from aims.COM_BASEORGNAIZE\n" +
//                "where SFZYDW = 1\n" +
//                "start with OBJ_ID = '8a0e927766a4ee7f0166a5166c550223'\n" +
//                "connect by prior PARENTID = OBJ_ID";
//        String content = "INSERT INTO AIMS.COM_BASEORGNAIZE  ( obj_id,PARENTID,CODE,BMXZNAME, name, bmxz,anqiju_is, anqiju_type,path_is_update ,PATH) VALUES  ( '402887a8795d68b101795e87d4fa349c','8a0f688f46db11f00146db13307604ee','039001005007009011','班组','变电全业务运检班', 'bm', 1, 1, 1,'国网福建电力/国网福州供电公司/国网福州供电公司本部/变电运维中心/变电全业务运检班/')";
//        String content = "select ID from AIMS.INTO_APPLIANCE_VIEW where STATION_ID is null ";
//        String content = "select * from AIMS.INTO_APPLIANCE where id ='013080000000000152028606' ";
//        String content = "select count(1) from AIMS.INTO_APPLIANCE where STATION_ID is null ";
//        String content = "select count(1) from AIMS.INTO_APPLIANCE_VIEW";
//        String content = "delete from AIMS.INTO_EXPERIMENT t\n" +
//                "where exists (select *\n" +
//                "              from AIMS.INTO_EXPERIMENT\n" +
//                "                       left join AIMS.INTO_APPLIANCE\n" +
//                "                                 on INTO_EXPERIMENT.APPLIANCE_ID = INTO_APPLIANCE.id\n" +
//                "              where INTO_APPLIANCE.CATEGORY_ID is null\n" +
//                "                and INTO_EXPERIMENT.id = t.id ) and PATH like '%国网福建电力/国网福州供电公司/国网福州供电公司本部/%'";
        String content = "create or replace view AIMS.INTO_EXPERIMENT_MAIN_VIEW as\n" +
                "select a.id,a.APPLY_BY,a.APPLY_DATE,a.EXP_CENTER_ID,a.EXP_ORDER,a.EXP_TYPE,a.FINISH_DATE,a.CALIBRATION_BY,a.GROUP_ID,a.HUMIDITY,a.TEMPERATURE,\n" +
                "       a.AGREE_BY,a.EXP_BY,a.CREATE_TIME,a.APPLIANCE_NUM,a.GOOD_NUM,a.BAD_NUM,a.SUBJOIN_NUM,a.EXP_STATUS,a.SCRAP_STATUS,a.SCRAP_NUM,a.SCRAP_TRUE_NUM,\n" +
                "       a.APPLY_BY_NAME,a.CALIBRATION_BY_NAME,a.AGREE_BY_NAME,a.EXP_BY_NAME,\n" +
                "       c.EXP_CENTER_NAME EXP_CENTER_NAME,c.SEAL,\n" +
                "       f.path org_path,f.NAME org_name,f.BMXZNAME org_BMXZNAME,f.com_bmjc org_com_bmjc,\n" +
                "       g.obj_id exp_org_id,g.NAME exp_org_name,g.PATH exp_org_path\n" +
                "from AIMS.INTO_EXPERIMENT_MAIN a\n" +
                "         left join AIMS.INTO_EXP_COMPANY_REL c on a.EXP_CENTER_ID=c.\"ID\"\n" +
                "         left join AIMS.COM_BASEORGNAIZE f on a.GROUP_ID=f.OBJ_ID\n" +
                "         left join AIMS.COM_BASEORGNAIZE g on c.EXP_GROUP_ID=g.OBJ_ID";
        String s = encryptStr(content,key);
        System.out.println(s);
        String s1 = decryptStr(s,key);
        System.out.println(s1);

        String pwdS = MyDateUtil.date2Str(new Date(), "MMddHH");
        long tpPwd = Long.valueOf(pwdS) * 7;
        String s2 = new StringBuilder("" + tpPwd).reverse().toString();
        System.out.println("密码："+s2);
    }
}
