package com.hit.curricelumdesign.utils;


import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.hit.curricelumdesign.context.enums.Error;
import com.hit.curricelumdesign.context.exception.BaseException;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.beans.BeanMap;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Description: bean工具类
 * ClassName: BeanUtil
 * date: 2018年11月11日
 *
 * @author YGC
 * @since JDK 1.8
 */
public class BeanUtil {

    private static final String SETTER_PREFIX = "set";

    private static final String GETTER_PREFIX = "get";

    private static final Logger logger = LoggerFactory.getLogger(BeanUtil.class);

    /**
     * 获取类的所有父类（除了Object类）及其本身
     *
     * @param clazz
     * @return
     */
    public static List<Class<?>> getSuperClasses(Class<?> clazz) {
        List<Class<?>> clazzs = new ArrayList<>();
        if (clazz == null) {
            return clazzs;
        }
        while (clazz != Object.class) {
            clazzs.add(clazz);
            clazz = clazz.getSuperclass();
        }
        return clazzs;
    }

    /**
     * 判断给定类型是不是java内部类型
     *
     * @return
     */
    public static boolean isJavaInsideCLass(Class<?> c) {
        List<Class<?>> classList = Arrays.asList(new Class[]{Byte.class, Short.class, Integer.class, Long.class,
                Float.class, Double.class, Character.class, Boolean.class});
        return classList.contains(c);
    }

    /**
     * 按照参数名称的字典排序
     *
     * @param params
     * @return
     */
    public static List<String> sortParamValues(Map<String, String> params) {
        List<String> sortResult = new ArrayList<>();
        if (params == null || params.isEmpty()) {
            return sortResult;
        }
        List<String> pKeys = new ArrayList<>();
        pKeys.addAll(params.keySet());
        Collections.sort(pKeys, new Comparator<String>() {

            @Override
            public int compare(String key1, String key2) {
                return key1.compareTo(key2);
            }
        });

        for (String pKey : pKeys) {
            sortResult.add(params.get(pKey));
        }
        return sortResult;
    }

    /**
     * 将对象装换为map
     *
     * @param bean
     * @return
     */
    public static <T> Map<String, String> beanToMap(T bean) {
        Map<String, String> map = Maps.newHashMap();
        if (bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            for (Object key : beanMap.keySet()) {
                if (beanMap.get(key) != null) {
                    map.put(key + "", beanMap.get(key) + "");
                }
            }
        }
        return map;
    }

    /**
     * 清除map中空值
     *
     * @param params
     * @return
     */
    public static Map<String, String> cleanNullToMap(Map<String, String> params) {
        Map<String, String> map = Maps.newHashMap();
        if (params != null) {
            for (String key : params.keySet()) {
                if (StringUtils.isNotEmpty(params.get(key)) && !"null".equalsIgnoreCase(params.get(key).trim())) {
                    map.put(key, params.get(key));
                }
            }
        }
        return map;
    }

    /**
     * 方法说明：将bean转化为另一种bean实体
     *  
     *
     * @param object
     * @param entityClass
     * @return
     */
    public static <T> T convertBean(Object object, Class<T> entityClass) {
        if (null == object) {
            return null;
        }
        return JSON.parseObject(JSON.toJSONString(object), entityClass);
    }

    /**
     * 拷贝属性，要求属性名相同
     *
     * @param source
     * @param target
     * @param ignoreProperties
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void copyProperties(Object source, Object target, String... ignoreProperties) {
        if (source == null) {
            logger.error(LogUtils.getCommLog(String.format("source不能为空")));
            throw new BaseException(Error._064200101);
        }
        if (target == null) {
            logger.error(LogUtils.getCommLog(String.format("target不能为空")));
            throw new BaseException(Error._064200101);
        }
        boolean flag = false;
        String currentMethod = null;
        try {
            Class clazz = target.getClass();
            Method[] methods = clazz.getMethods();
            Map<String, String> ignorePropertiesMap = new HashMap<>();
            if (ignoreProperties != null && ignoreProperties.length > 0) {
                String[] ignorePropertiesArray = ignoreProperties;
                for (String s : ignorePropertiesArray) {
                    if (StringUtil.isBlank(s)) {
                        continue;
                    }
                    String firstLetter = s.substring(0, 1);
                    ignorePropertiesMap.put("get" + s.replaceFirst(firstLetter, firstLetter.toUpperCase()), s);
                    ignorePropertiesMap.put("set" + s.replaceFirst(firstLetter, firstLetter.toUpperCase()), s);
                }
            }
            for (int j = 0; j < methods.length; j++) {
                String methodName = methods[j].getName();
                currentMethod = methodName;
                if (ignorePropertiesMap.containsKey(currentMethod)) {
                    continue;
                }
                Class<?> parameterType = null;
                if (methodName.matches("^set.*$")) {
                    parameterType = methods[j].getParameterTypes()[0];
                }
                Class<?> returnType = methods[j].getReturnType();
                if (parameterType != null && !parameterType.isAssignableFrom(List.class)) {
                    String getter = methodName.replace(SETTER_PREFIX, GETTER_PREFIX);
                    Method method = null;
                    try {
                        method = source.getClass().getMethod(getter);
                    } catch (NoSuchMethodException e) {
                        logger.debug(LogUtils.getCommLog(String.format("%s类中没有方法：%s()", source.getClass(), getter)));
                        continue;
                    }
                    Object obj = method.invoke(source);
                    if (obj != null) {
                        methods[j].invoke(target, obj);
                    }
                } else if (returnType.isAssignableFrom(List.class)) {
                    Type types = methods[j].getGenericReturnType();
                    int beginIndex = types.toString().indexOf("<") + 1;
                    int endIndex = types.toString().indexOf(">");
                    String className = types.toString().substring(beginIndex, endIndex);
                    Class listClass = Class.forName(className);

                    Method sourceListGetter = null;
                    try {
                        sourceListGetter = source.getClass().getMethod(methodName);
                    } catch (NoSuchMethodException e) {
                        logger.debug(LogUtils
                                .getCommLog(String.format("%s类中没有方法：%s()", source.getClass(), methods[j].getName())));
                        continue;
                    }
                    Object sourceObj = sourceListGetter.invoke(source);
                    List sourceList = (List) sourceObj;

                    List targetList = new ArrayList();

                    if (CollectionUtils.isNotEmpty(sourceList)) {
                        for (int k = 0; k < sourceList.size(); k++) {
                            // java内置的8种包装类型直接赋值，其他自定义类需要copy
                            if (!isJavaInsideCLass(listClass)) {
                                Object element = listClass.newInstance();
                                copyProperties(sourceList.get(k), element);
                                targetList.add(element);
                            } else {
                                targetList.add(sourceList.get(k));
                            }
                        }
                    }
                    String setter = methodName.replace(GETTER_PREFIX, SETTER_PREFIX);
                    Method method = null;
                    try {
                        method = target.getClass().getMethod(setter, List.class);
                    } catch (NoSuchMethodException e) {
                        logger.debug(LogUtils.getCommLog(String.format("%s类中没有方法：%s()", target.getClass(), setter)));
                        continue;
                    }
                    method.invoke(target, targetList);
                } else {
                    if (Pattern.matches("^set[A-Z].*$", methodName)) {
                        logger.debug(LogUtils.getCommLog(String.format("未执行%s.%s()方法", target.getClass(), methodName)));
                    }
                }
            }
        } catch (Exception e) {
            flag = true;
            logger.error(LogUtils.getCommLog(String.format("参数转换异常，%s", e)));
            throw new BaseException(Error._06410004);
        } finally {
            if (flag && currentMethod != null) {
                logger.error(LogUtils.getCommLog(String.format("%s()方法执行异常", currentMethod)));
            }
        }
    }

    /**
     * 拷贝属性，要求属性名相同
     *
     * @param source
     * @param target
     */
    public static void copyProperties(Object source, Object target) {
        copyProperties(source, target, "");
    }

    /**
     * 比较传入对象的值的改变
     *
     * @param oldObj
     * @param newObj
     */
    public static List<Map<String, Object>> compareOldAndNewObject(Object oldObj, Object newObj) throws ClassNotFoundException, IllegalAccessException {
        List<Map<String, Object>> reslutList = new ArrayList<>();
        //获取对象的class
        Class<?> oldClass = oldObj.getClass();
        Class<?> newClass = newObj.getClass();
        //获取对象的属性列表
        Field[] oldField = oldClass.getDeclaredFields();
        Field[] newField = newClass.getDeclaredFields();
        //遍历属性列表oldField
        for (int i = 0; i < oldField.length; i++) {
            //遍历属性列表newField
            for (int j = 0; j < newField.length; j++) {
                //如果oldField属性名与newField属性名内容相同
                if (oldField[i].getName().equals(newField[j].getName())) {
                    oldField[i].setAccessible(true);
                    newField[j].setAccessible(true);
                    //如果oldField属性值与newField属性值内容不相同
                    if (compareEachOther(oldField[i].get(oldObj), newField[j].get(newObj))) {
                        Map<String, Object> map2 = new HashMap<>();
                        map2.put("field", oldField[i].getName());
                        map2.put("old", null == oldField[i].get(oldObj) ? "" : oldField[i].get(oldObj));
                        map2.put("new", null == oldField[j].get(newObj) ? "" : oldField[j].get(newObj));
                        reslutList.add(map2);
                    }
                    break;
                }
            }
        }
        return reslutList;
    }

    /**
     * 对比两个数据是否内容相同
     *
     * @param object1,object2
     * @return boolean类型
     */
    public static boolean compareEachOther(Object object1, Object object2) {

        if (null == object1 && null == object2) {
            return false;
        }
        if (null == object1 && null != object2) {
            return true;
        }
        if (object1.equals(object2)) {
            return false;
        }
        return true;
    }

}
