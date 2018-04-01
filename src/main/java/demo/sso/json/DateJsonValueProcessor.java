package demo.sso.json;


import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
import org.apache.commons.lang.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateJsonValueProcessor implements JsonValueProcessor {
    private String dataFormateStr = "yyyy-MM-dd HH:mm:ss";

    public DateJsonValueProcessor() {

    }

    public DateJsonValueProcessor(String dataFormateStr) {
        if (StringUtils.isNotEmpty(dataFormateStr)) {
            this.dataFormateStr = dataFormateStr;
        }
    }

    public Object processArrayValue(Object value, JsonConfig jsonConfig) {
        if (value == null) {
            return value;
        }
        String[] obj = {};
        if (value instanceof Date[]) {
            SimpleDateFormat sf = new SimpleDateFormat(dataFormateStr);
            Date[] dates = (Date[]) value;
            obj = new String[dates.length];
            for (int i = 0; i < dates.length; i++) {
                obj[i] = sf.format(dates[i]);
            }
        }
        return obj;
    }

    public Object processObjectValue(String key, Object value,
                                     JsonConfig jsonConfig) {
        if (value == null) {
            return value;
        }
        if (value instanceof Date) {
            String str = new SimpleDateFormat(dataFormateStr)
                    .format((Date) value);
            return str;
        }
        return value.toString();
    }

}