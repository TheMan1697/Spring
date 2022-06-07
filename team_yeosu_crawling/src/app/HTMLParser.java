package app;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import utils.DBConn;

public class HTMLParser {
    public static void main(String[] args) throws Exception {
//        Connection conn = Jsoup.connect("https://www.goodchoice.kr/product/search/3/3108?sel_date=2022-06-20&sel_date2=2022-06-21");
        Connection conn = Jsoup.connect("https://www.goodchoice.kr/product/search/3/3108?sort=HIT&sel_date=2022-06-20&sel_date2=2022-06-21&grade%5B%5D=POOLVILLA&persons=&min_price=&max_price=");
        Document doc = conn.get();
        Elements elements = doc.select(".list_2");
        for(int i = 0; i < elements.size() ; i++) {
			Element el = elements.get(i);
//			System.out.println(el);
			String no = el.getElementsByTag("a").attr("data-ano");
			System.out.println("번호 : " + no);
			
			Element el2 = el.select(".name").get(0);
				
			String title = el2.selectFirst("strong").text();
			System.out.println("펜션이름 : " + title);
			
//			String around = el2.select("p").get(1).text();
//			System.out.println("주변지역 : " + around);
			
			String price= el.select(".map_html").select("b").html();
			System.out.println("가격 : " +price);
//			
			String link = el.getElementsByTag("a").attr("href");
			System.out.println(link);
			
//			Element pic=el.selectFirst(".pic img");
//			System.out.println(pic);
			Document doc2 = Jsoup.connect(link).get();
			
			String address = doc2.select(".address").text();
			System.out.println("주소 : " +address);
			
			String comment = doc2.select(".comment div").text();
			System.out.println("사장님 한 마디 : " +comment);
			
			Map<String, String> map = new HashMap<>();
			Map<String, Integer> map2 = new HashMap<>();
			map.put("PENSION_ID",no);
			map.put("ROOM_NAME", title);
			map.put("address", address);
			map.put("comment", comment);
			Elements el3 = doc2.select(".swiper-slide");
//			System.out.println(el3);
			List<String> imgs = new ArrayList<>();
			long folderName = saveDB(map, map2);
			boolean check = true;
			for (int j = 0; j < el3.size()-1; j++) {
				Element eximg= el3.select(".swiper-lazy").get(j);
//				System.out.println(eximg);
				String img ="https:"+ eximg.attr("data-src");
//				System.out.println(imgs);
				
				if(imgs.size() == 0) {
					imgs.add(img);
				}
				else {
				
					for(String s : imgs) {
						if(!img.equals(s)) {
							imgs.add(img);
							break;
						}
						else {
							check = false;
						}
					}
				}
				if(!check) {
					break;
				}
//				System.out.println(img);
//				map2.put("PRICE",el7);
				saveFile(no, folderName, img,j);
			}
			for (int j = 0; j < imgs.size(); j++) {
				
				System.out.println(imgs.get(j));
			}
			System.out.println(imgs.size());
//			
			
//			Elements price2 = doc2.select(".room");
//			System.out.println(price2.size());
//			for (int j = 0; j < price2.size(); j++) {
//					Element el6= price2.get(j);
//					int el7 = Integer.parseInt(el6.select(".price p b").text().equals("") ? "0" : el6.select(".price p b").text().replace(",", "").replace("원", ""));
//					Element roomEl= price2.select(".title").get(j);
//					String roomName= roomEl.text();
//					System.out.println(roomName);
//					System.out.println(el7);
//					Map<String, String> map = new HashMap<>();
//					map.put("PENSION_ID",no);
//					map.put("ROOM_NAME", roomName);
////					
//					Map<String, Integer> map2 = new HashMap<>();
//					map2.put("PRICE",el7);
//					long folderName = saveDB(map, map2);
//					Elements el4= el6.select(".item");
//					System.out.println(el4.size());
//					for (int k = 0; k < el4.size(); k++) {
//						Element eximg2 = el4.get(k);
////						System.out.println(eximg2);
//						String img = "https:"+ eximg2.select("img").attr("data-src");
//						System.out.println(img);
//						System.out.println(test);
//					String img= "https:"+el6.select(".lazy").attr("data-original");
//					System.out.println(img);
//					saveFile(no, folderName, img,k);
//					}
					
//					String img3 = price2.select(".item on").outerHtml();
//					System.out.println(img3);
//					for (int k = 0; k < 5; k++) {
//						Element img4= img3.select(".owl_lazy").get(k);
//						String img5= img4.attr("data-src");
//						System.out.println(img5);
//					}
//			}
			
//			Elements el5=doc2.select(".service");
//			String FOOT_VOLLEYBALL_COURT=	el5.select(".theme_57").text().equals("") ? "" : "1";
//			System.out.println("WIFI : "+FOOT_VOLLEYBALL_COURT);
//			String KARAOKE=	el5.select(".theme_59").text().equals("") ? "" : "1";
//			System.out.println("TV : "+KARAOKE);
//			String CONVENIENCE_STORE=	el5.select(".theme_215").text().equals("") ? "" : "1";
//			System.out.println("AIR : "+CONVENIENCE_STORE);
//			String PARKING_LOT=	el5.select(".theme_221").text().equals("") ? "" : "1";
//			System.out.println("BAR : "+PARKING_LOT);
//			String SEMINAR_ROOM=	el5.select(".theme_58").text().equals("") ? "" : "1";
//			System.out.println("BATH : "+SEMINAR_ROOM);
//			String BBQ=	el5.select(".theme_148").text().equals("") ? "" : "1";
//			System.out.println("REF : "+BBQ);
//			String RESTAURANT=	el5.select(".theme_216").text().equals("") ? "" : "1";
//			System.out.println("REF : "+RESTAURANT);
//			
			
//        for(int i = 0; i < elements.size(); i++) {
//            Element el = elements.get(i);
////            System.out.println(el);
//            String no = el.attr("data-no");
////            System.out.println(no);
//            String info = el.selectFirst(".list_info").text();
//            String title = el.selectFirst(".item_title").text();
////            System.out.println(title);
//            String price = el.selectFirst(".price").text();
//            String link = el.selectFirst(".list_info a").attr("href");
//            Element img = el.selectFirst(".list_img img");
            
				
           
//            System.out.println(map);
//            saveFile(no, img.attr("data-original"));
            System.out.println(no + "번 작업 완료");
        }
    }
    
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
//    static void saveDB(Map<String, String> map) throws Exception{
//    	java.sql.Connection conn = DBConn.getConnection();
//    	PreparedStatement pstmt = conn.prepareStatement(
//    			"INSERT INTO TBL_PENSION VALUES(?,?,?,?,?,?,?)");
//    	pstmt.setString(1, map.get("FOOT_VOLLEYBALL_COURT"));
//    	pstmt.setString(1, map.get("KARAOKE"));
//    	pstmt.setString(2, map.get("CONVENIENCE_STORE"));
//    	pstmt.setString(3, map.get("PARKING_LOT"));
//    	pstmt.setString(4, map.get("SEMINAR_ROOM"));
//    	pstmt.setString(5, map.get("BBQ"));
//    	pstmt.setString(6, map.get("RESTAURANT"));
//    	pstmt.setString(7, map.get("PENSION_ID"));
//    	pstmt.executeUpdate();
//    	pstmt.close();
//    }
    static long saveDB(Map<String, String> map, Map<String, Integer> map2) throws Exception{
    	Long s = 0L;
    	java.sql.Connection conn = DBConn.getConnection();
    	String sql = "SELECT SEQ_ROOM.NEXTVAL FROM DUAL";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		s = rs.getLong(1);
    	
		conn = DBConn.getConnection();
    	pstmt = conn.prepareStatement(
    			"INSERT INTO TBL_PENSION VALUES(?,?,NULL,2,1,?,?)");
    	pstmt.setString(1, map.get("PENSION_ID"));
    	pstmt.setString(2, map.get("ROOM_NAME"));
    	pstmt.setString(3, map.get("address"));
    	pstmt.setString(4, map.get("comment"));
//    	pstmt.setLong(2, s);
//    	pstmt.setInt(3, map2.get("PRICE"));
    	pstmt.executeUpdate();
    	pstmt.close();
    	
    	return s;
    }
}