package demo.sso.utils;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

import java.util.HashMap;
import java.util.Map;


public class Upload {


    Auth auth = Auth.create("5zJAFGuD04A0NAaGLHW6_DzB_yeHq2zFq36ocSzT","e9JISki2kskQCI8_vzeyfCys3qk82wRr0XJlbkBf");

    UploadManager uploadManager = new UploadManager();

    /**
     * 获取凭证
     * @param
     * @return
     */
    public  String getUpToken() {
        return auth.uploadToken("sell");
    }
    /**
     * 获取上传文件uptoken
     * @return
     */
    public  Map<Object,Object> getUploadToken(){

        Map resultMap = new HashMap();

        resultMap.put("uptoken",getUpToken());
        resultMap.put("status",200);
        return resultMap;
    }

    /**
     * 上传
     * @param filePath 文件路径  （也可以是字节数组、或者File对象）
     * @param key 上传到七牛上的文件的名称  （同一个空间下，名称【key】是唯一的）
     * @param
     */
    public void upload(String filePath, String key) {
        try {
            // 调用put方法上传
            Response res = uploadManager.put(filePath, key, getUpToken());
            // 打印返回的信息
            System.out.println(res.bodyString());
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            System.out.println(r.toString());
            try {
                // 响应的文本信息
                System.out.println(r.bodyString());
            } catch (QiniuException qe) {
                // ignore
            }
        }
    }
    public Upload() {
    }



}
