package demo.sso.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CatchImage {
	
	public static List<String> getImgStr(String htmlStr){     
	     String img="";     
	     Pattern p_image;     
	     Matcher m_image;     
	     List<String> pics = new ArrayList<String>();  
	  
	     String regEx_img = "<img.*src=(.*?)[^>]*?>"; //图片链接地址     
	     p_image = Pattern.compile   
	             (regEx_img,Pattern.CASE_INSENSITIVE);     
	     m_image = p_image.matcher(htmlStr);   
	     while(m_image.find()){     
	         img = img + "," + m_image.group();     
	         Matcher m  = Pattern.compile("src=\"?(.*?)(\"|>|\\s+)").matcher(img); //匹配src  
	         while(m.find()){  
	            pics.add(m.group(1));  
	         }  
	     }     
	     return pics;     
	 }
	
	public static void main(String[] args) {
		String string = "<p>sdfasdf</p><p>asd</p><p>fad</p><p>" +
				"<br/></p><p>src <br/></p><p>href <br/></p><p>text <br/>" +
				"</p><p>" +
				"<img src=\"/ueditor/jsp/upload/image/20150519/1432001264616055927.png\" title=\"1432001264616055927.png\" alt=\"add.png\"/><br/>" +
						"</p><p><br/></p><p>img 123 456</p><p>" +
						"<img src=\"/ueditor/jsp/upload/image/20150519/1432001291258038565.png\" title=\"1432001291258038565.png\" alt=\"update.png\"/></p>" +
						"<img src=\"http://img.baidu.com/hi/jx2/j_0002.gif\"/>";
		List<String> list = getImgStr(string);
		for (String item : list) {
			System.out.println(item);
		}
	}
}
