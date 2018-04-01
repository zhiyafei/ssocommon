package demo.sso.json;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;
import org.apache.commons.lang.StringUtils;

import java.util.Date;
import java.util.Map;

public class JSONUtils {

    public static String formatToJson(Object obj){
        return formatToJson(obj, null, null, null);
    }

    /**
     *
     * @param obj
     * @param removeBracket
     *            去掉外围的括号[]
     * @return
     */
    public static String formatToJson(Object obj, boolean removeBracket) {
        return formatToJson(obj, null, null, null, removeBracket);
    }

    /**
     *
     * @param obj
     * @param dataFormateStr
     *            时间格式
     * @return
     */
    public static String formatToJson(Object obj, String dataFormateStr) {
        return formatToJson(obj, null, dataFormateStr, null);
    }

    /**
     *
     * @param obj
     * @param dataFormateStr
     *            时间格式
     * @param removeBracket
     *            去掉外围的括号[]
     * @return
     */
    public static String formatToJson(Object obj, String dataFormateStr,
                                      boolean removeBracket) {
        return formatToJson(obj, null, dataFormateStr, null, removeBracket);
    }

    /**
     *
     * @param obj
     * @param excludeProperties
     *            在结果中排除的字段
     * @return
     */
    public static String formatToJson(Object obj, String[] excludeProperties) {
        return formatToJson(obj, null, null, excludeProperties);
    }

    /**
     *
     * @param obj
     * @param excludeProperties
     *            在结果中排除的字段
     * @param removeBracket
     *            去掉外围的括号[]
     * @return
     */
    public static String formatToJson(Object obj, String[] excludeProperties,
                                      boolean removeBracket) {
        return formatToJson(obj, null, null, excludeProperties, removeBracket);
    }

    /**
     *
     * @param obj
     * @param addObject
     *            追加的内容
     * @return
     */
    public static String formatToJson(Object obj, Object addObject) {
        return formatToJson(obj, addObject, null, null);
    }

    /**
     *
     * @param obj
     * @param addObject
     *            追加的内容
     * @param excludeProperties
     *            在结果中排除的字段
     * @return
     */
    public static String formatToJson(Object obj, Object addObject,
                                      String[] excludeProperties) {
        return formatToJson(obj, addObject, null, excludeProperties);
    }

    /**
     *
     * @param obj
     * @param addObject
     *            追加的内容
     * @param dataFormateStr
     *            时间格式
     * @param excludeProperties
     *            在结果中排除的字段
     * @return
     */
    public static String formatToJson(Object obj, Object addObject,
                                      String dataFormateStr, String[] excludeProperties) {
        return formatToJson(obj, addObject, dataFormateStr, excludeProperties,
                false);
    }

    public static String formatToJson(Object obj, String dataFormateStr,
                                      String[] excludeProperties, boolean removeBracket) {
        return formatToJson(obj, null, dataFormateStr, excludeProperties,
                removeBracket);
    }

    /**
     *
     * @param obj
     * @param addObject
     *            追加的内容
     * @param dataFormateStr
     *            时间格式
     * @param excludeProperties
     *            在结果中排除的字段
     * @param removeBracket
     *            去掉外围的括号[]
     * @return
     */
    public static String formatToJson(Object obj, Object addObject,
                                      String dataFormateStr, String[] excludeProperties,
                                      boolean removeBracket) {
        try {
            JsonConfig jsonConfig = new JsonConfig();

            // 当输出时间格式时，采用和JS兼容的格式输出
            jsonConfig.registerJsonValueProcessor(Date.class,
                    new DateJsonValueProcessor(dataFormateStr));

            jsonConfig.setJsonPropertyFilter(new JsonPropertyFilter() {
                public boolean apply(Object obj, String name, Object value) {
                    if (name.equals("hibernateLazyInitializer")
                            || name.equals("handler")) {
                        return true;
                    }
                    return false;
                }
            });
            // 防止自包含
            jsonConfig
                    .setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);

            if (excludeProperties != null) {
                // 排除需要序列化成json的属性
                jsonConfig.setExcludes(excludeProperties);
            }

            JSONArray jsonArray = JSONArray.fromObject(obj, jsonConfig);
            if (addObject != null) {
                jsonArray.add(addObject);
            }
            String result = jsonArray.toString();
            if (removeBracket && StringUtils.isNotEmpty(result)) {
                if (result.startsWith("[")) {
                    result = result.substring(1, result.length());
                }
                if (result.endsWith("]")) {
                    result = result.substring(0, result.length() - 1);
                }
            }
            //System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("JSON转换出错!");
            return "";
        }
    }

    public static String formatMapToJson(Map<Object, Object> map) {
        return formatMapToJson(map, null, null);
    }

    /**
     *
     * @param map
     * @param dataFormateStr
     *            时间格式
     * @return
     */
    public static String formatMapToJson(Map<Object, Object> map,
                                         String dataFormateStr) {
        return formatMapToJson(map, dataFormateStr, null);
    }

    /**
     *
     * @param map
     * @param excludeProperties
     *            在结果中排除的字段
     * @return
     */
    public static String formatMapToJson(Map<Object, Object> map,
                                         String[] excludeProperties) {
        return formatMapToJson(map, null, excludeProperties);
    }

    /**
     *
     * @param map
     * @param dataFormateStr 时间格式
     * @param excludeProperties
     *            在结果中排除的字段
     * @return
     */
    public static String formatMapToJson(Map<Object, Object> map,
                                         String dataFormateStr, String[] excludeProperties) {
        try {
            JsonConfig jsonConfig = new JsonConfig();

            // 当输出时间格式时，采用和JS兼容的格式输出
            jsonConfig.registerJsonValueProcessor(Date.class,
                    new DateJsonValueProcessor(dataFormateStr));
            if (excludeProperties != null) {
                // 排除需要序列化成json的属性
                jsonConfig.setExcludes(excludeProperties);
            }

            JSONObject jsonObject = new JSONObject();
            jsonObject.putAll(map);
            String result = jsonObject.toString();
            //System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("JSON转换出错!");
            return "";
        }

    }
}