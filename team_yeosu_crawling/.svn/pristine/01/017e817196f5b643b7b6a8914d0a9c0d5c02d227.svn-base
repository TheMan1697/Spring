package app;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Type;
import java.net.URL;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import utils.DBConn;

public class HTMLParser4 {
	public static void main(String[] args) throws Exception{
		Connection conn=Jsoup.connect("https://www.goodchoice.kr/product/search/3/3108?sel_date=2022-06-20&sel_date2=2022-06-21");
		Document doc = conn.get();
        Elements elements = doc.select(".list_2");
        for(int i = 0; i < elements.size() ; i++) {
			Element el = elements.get(i);
			String no = el.getElementsByTag("a").attr("data-ano");
			String originLink = el.getElementsByTag("a").attr("href");
			String headLink = originLink.replaceAll("detail", "get_review_non");
//			System.out.println(headLink);
			Document doc2 = Jsoup.connect(headLink).get();
			System.out.println(doc2);
			String jsonStr = doc2.getElementsByTag("body").get(0).text();
			Gson gson = new Gson();
			TestVO myMap = gson.fromJson(jsonStr, TestVO.class);
			System.out.println(myMap);
			boolean b = true;
			if(b)
			return;
//			System.out.println(doc2);
//			Connection conn=Jsoup.connect("https://www.goodchoice.kr/product/get_review_non?ano=55875");
//			System.out.println(doc2.getElementsByTag("body").get(0).text());
			Type type = new TypeToken<Map<String, Object>>(){}.getType();
			//Map<String, Object> myMap = gson.fromJson(jsonStr, type);
//			System.out.println(myMap);

//			myMap.forEach((k, v) -> {
//				System.out.println(k + ":" + v);
//		});
			
//			String count= String.valueOf(((Map)myMap.get("result")).get("count"));
//			if (count=="0") {
//				continue;
//			}
//			else {
				
				System.out.println("번호 : " + no);
	//			System.out.println("댓글 개수 : "+count);
				String totalPageCnt =  "0";// String.valueOf(((Map)myMap.get("result")).get("total_page_cnt"));
				for (int j = 1; j <= Float.parseFloat(totalPageCnt); j++) {
					Document doc3 =Jsoup.connect(headLink+"&page="+j).get();
					String jsonStr2= doc3.getElementsByTag("body").get(0).text();
					Gson gson2= new Gson();
					TestVO vo =gson2.fromJson(jsonStr2, TestVO.class);
//					List<Object> items =  (List<Object>) ((Map)myMap2.get("result")) .get("items");
					System.out.print(headLink+"&page="+j);
					System.out.println(vo);
	//			System.out.println(total_page_cnt);
//					for(Object item : items) {
//						System.out.println();
//						System.out.println("댓글 제목 : "+((Map)item).get("epilrate_textinfo"));
//						System.out.println("===================");	
//						System.out.println("댓글 내용 : "+((Map)item).get("aepcont"));
//						System.out.println("===================");
//						System.out.println("별점 : "+((Map)item).get("epilrate"));
//						System.out.println("===================");
//						System.out.println("이미지링크 : "+(((List)((Map)item).get("aepimg"))).get(0));
//					}
				}
			}
		}
//	}
	static void saveFile(String no, Long r_id, String imgSrc, int ORD) throws Exception {
    	int idxDot = imgSrc.lastIndexOf(".");
		String ext = "";
		if(idxDot != -1) {
			ext= imgSrc.substring(idxDot);
			System.out.println(ext);
		}
		
		String name = "";
		String path = "";
		UUID uuid = UUID.randomUUID();
		if(!ext.equals(".jpg")) {
			name = "dump_" + uuid + ".jpg";

		} else {
			name = uuid +ext; //uuid
		
	
	  URL url = new URL(imgSrc);
      BufferedInputStream bis = new BufferedInputStream(url.openStream());
      path= "main\\" + no+ "\\"+ r_id+"";
      File file = new File("D:\\"+path);
      if(!file.exists()) {
    	  file.mkdirs();
      }
		
		
      file =new File(file,name);
      BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
      
      

      int b = 0;
      while((b = bis.read()) != -1) {
          bos.write(b);
      }
      bos.close();
		}
		System.out.println(name);
      
    java.sql.Connection conn = DBConn.getConnection();
    PreparedStatement pstmt = conn.prepareStatement(
  			"INSERT INTO TBL_PENSION_ATTACH VALUES(?,?,?,1,?,?)");
  	pstmt.setString(1,name);
  	pstmt.setString(2,name);
  	pstmt.setString(3, path);
  	pstmt.setInt(4, ORD);
  	pstmt.setLong(5, r_id);
  	pstmt.executeUpdate();
  	pstmt.close();
	}
}
