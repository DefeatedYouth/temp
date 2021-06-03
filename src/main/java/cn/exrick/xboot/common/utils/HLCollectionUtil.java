package cn.exrick.xboot.common.utils;

import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.lang.Nullable;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenfeixiang6@163.com
 * @date 2021/1/19
 * @desc
 */
public class HLCollectionUtil extends CollectionUtils {

    /**
     * 判断 Collection 是否为空
     * Collection 为【null】或者 元素个数为0 返回 true
     * @param collection
     * @return
     */
    public static boolean isEmpty(@Nullable Collection<?> collection) {
        return (collection == null || collection.isEmpty());
    }

    /**
     * 判断 Collection 是否为空
     * Collection 不为【null】并且 元素个数不为0 返回 true
     * @param collection
     * @return
     */
    public static boolean isNotEmpty(@Nullable Collection<?> collection) {
        return (collection != null && !collection.isEmpty());
    }
    /**
     * 判断 map 是否为空
     * map 为【null】或者 元素个数为0 返回 true
     * @param map
     * @return
     */
    public static boolean isEmpty(@Nullable Map<?, ?> map) {
        return (map == null || map.isEmpty());
    }

    /**
     * 判断 map 是否为空
     * map 不为【null】并且 元素个数不为0 返回 true
     * @param map
     * @return
     */
    public static boolean isNotEmpty(@Nullable Map<?, ?> map) {
        return (map != null && !map.isEmpty());
    }

    public static <T,V>  List<V> copyProperties(List<T> sourceList,Class<V> clazz){
        List<V> result = Lists.newArrayList();
        sourceList.forEach(source->{
            V v = null;
            try {
                v = clazz.newInstance();
            } catch (Exception e) {
            }
            if (source != null){
                BeanUtils.copyProperties(source, v);
                result.add(v);
            }
        });
        return result;
    }

    public static <T>  T[] toArray(List<T> list){
        return (T[]) list.toArray(new String[list.size()]);
    }

    //Object转Map
    public static Map<String, Object> getObjectToMap(Object obj){
        Map<String, Object> map = null;
        try {
            map = new LinkedHashMap<String, Object>();
            Class<?> clazz = obj.getClass();
            while (clazz != null) {//当父类为null的时候说明到达了最上层的父类(Object类).
                for (Field field : clazz.getDeclaredFields()) {
                    field.setAccessible(true);
                    String fieldName = field.getName();
                    Object value = field.get(obj);
                    if (value == null){
                        value = "";
                    }
                    map.put(fieldName, value);
                }
                clazz = clazz.getSuperclass(); //得到父类,然后赋给自己

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    //Map转Object
    public static Object mapToObject(Map<Object, Object> map, Class<?> beanClass) {
        Object obj = null;
        try {
            if (map == null){
                return null;
            }
            beanClass.newInstance();
            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field : fields) {
                int mod = field.getModifiers();
                if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                    continue;
                }
                field.setAccessible(true);
                if (map.containsKey(field.getName())) {
                    field.set(obj, map.get(field.getName()));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}

