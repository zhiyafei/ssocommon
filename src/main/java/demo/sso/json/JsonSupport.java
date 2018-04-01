package demo.sso.json;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class JsonSupport{

    /**
     * 输出普通文本到页面
     * @param content
     * @throws Exception
     */
    protected void printWriterToPage(String content, HttpServletResponse response) throws Exception {
        this.printWriterToPage(content, null, response);
    }

    /**
     * 输出json内容到页面
     *
     * @param response
     * @throws Exception
     */
    public static void printWriterJsonToPage(String content, HttpServletResponse response) throws Exception {
        printWriterToPage(content, "acontenttion/json", response);
    }

    /**
     * 输出xml内容到页面
     *
     * @param content
     * @throws Exception
     */
    public static void printWriterXMLToPage(String content, HttpServletResponse response) throws Exception {
        printWriterToPage(content, "text/xml", response);
    }

    public static void printWriterToPage(String content, String contentType, HttpServletResponse response)
            throws Exception {
        try {
            // "application/json"
            // ".txt"="text/plain"
            // "text/xml"
            if (contentType != null && !"".equals(contentType)) {
                response.setContentType(contentType);
            } else {
                response.setContentType("text/plain");
            }
            //response.reset();
            response.setCharacterEncoding("UTF-8");
            response.setHeader("pragma", "no-cache");
            response.setHeader("cache-control", "no-cache");
            response.setDateHeader("expires", 0);
            PrintWriter pw = response.getWriter();
            pw.print(content);
            pw.flush();
            pw.close();
        } catch (Exception e) {
        }
    }

    protected void downloadFile(String fileFullName, String content, HttpServletResponse response)
            throws Exception {
        // 设置输出的格式
        response.reset();
        response.setContentType("application/x-msdownload");
        response.setContentType("text/html; charset=UTF-8");
        response.addHeader("Content-Disposition", "attachment; filename="
                + new String(fileFullName.getBytes("gbk"), "iso-8859-1"));
        response.getOutputStream().write(content.getBytes());
        response.getOutputStream().flush();
    }
}
