-- create or replace view AIMS.INTO_APPLIANCE_VIEW as
-- select a.ID,a.ARCHIVES_TIME,a.CATEGORY_ID,a.CODE,CREATE_BY,a.CREATE_TIME,a.FIRST_INSPECT_BY,a.FIRST_INSPECT_DATE,a.LAST_EXP_TIME,
--        a.MANUFACTURER_ID,a.NEXT_EXP_TIME,a.PRODUCE_DATE,a.SERIAL_NUM,a.SPEC_ID,a.STATION_ID,a.STATUS,a.PURCHASE_ORDER,a.PAIR_COUNT,a.CHECK_DATE,
--        a.IS_NORMAL,a.INSTALLATION,a.DISMANTLE,a.IS_PRINT,a.RECIPIENTS,a.LAST_UPDATE_TIME,a.NEW_STATUS,
--        b."NAME" STATION_NAME,b.GROUP_ID,b.EXP_CENTER_ID,
--        c.NAME MANUFACTURER_NAME,
--        d."SPEC" SPEC_NAME,d.EXP_PARAMS EXP_PARAMS,d.VOLTAGE,
--        e."NAME" CATEGORY_NAME,e."CATEGORY_PATH" CATEGORY_PATH,e.EXP_PERIOD EXP_PERIOD,e.IS_PERIOD IS_PERIOD,e.SHELF_LIFE SHELF_LIFE,e.EXPPARAM_TYPE EXPPARAM_TYPE,
--        f.path org_path,f.NAME org_name,f.BMXZNAME org_BMXZNAME,f.com_bmjc org_com_bmjc,f.PARENTID
-- from AIMS.INTO_APPLIANCE a
--          left join AIMS.INTO_STATION b on a.STATION_ID=b."ID"
--          left join AIMS.INTO_MANUFACTURER c on a.MANUFACTURER_ID=c.ID
--          left join AIMS.INTO_APPLIANCE_SPEC d on a.SPEC_ID=d.ID
--          left join AIMS.INTO_APPLIANCE_CATEGORY e on a.CATEGORY_ID=e.id
--          left join AIMS.COM_BASEORGNAIZE f on b.GROUP_ID=f.OBJ_ID
-- /

