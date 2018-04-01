package demo.sso.utils;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Properties;


public class PropertiesUtils {

    public static final String CONFIG_PROPERTIES = "config.properties";


    private static HashMap<String, Properties> propertiesMap = new HashMap<String, Properties>();

    private PropertiesUtils(){}

    /**
     * 根据filename 获取Properties对象
     * @param filename
     * @return
     */
    public static Properties getProperties(String filename){
        Properties props = propertiesMap.get(filename);
        if(null == props) {
            props = new Properties();
            InputStreamReader in = null;
            try{
                in = new InputStreamReader(PropertiesUtils.class.getResourceAsStream("/" + filename), "utf-8");
                props.load(in);
                propertiesMap.put(filename, props);
                return props;

            } catch (Exception e) {
            }finally{
                if (in != null){
                    try {
                        in.close();
                    } catch (IOException e) {
                    }
                }
            }
        }
        return props;
    }


    public static String getPropertyValueByKey(String filePath,String key){

        String fileKeyValues = "";
        try{
            InputStream inputStream = PropertiesUtils.class.getResourceAsStream(filePath);
            Properties properties = new Properties();
            properties.load(inputStream);
            fileKeyValues = (String)properties.get(key);

        }catch(Exception e){
            e.printStackTrace();
        }
        return fileKeyValues;
    }

    /**
     * 根据配置文件名与key名读取相关配置
     * @author panpanxu  2016年7月11日
     * @param fileName - 配置文件名字
     * @param key - 配置文件里的key的名字
     * @return
     */
    public static String getProperty(String fileName, String key) {
        Properties props = getProperties(fileName);
        return props == null ? null : props.getProperty(key);
    }

}

