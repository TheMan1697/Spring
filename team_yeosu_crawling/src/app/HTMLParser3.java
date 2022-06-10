package app;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HTMLParser3 {
	public static void main(String[] args) throws Exception{
		Connection conn = Jsoup.connect("https://www.goodchoice.kr/product/search/3");
		Document doc = conn.get();
		Elements elements = doc.select(".list_2");
		for(int i = 0; i < 20 ; i++) {
			Element el = elements.get(i);
//			System.out.println(el);
			String no = el.getElementsByTag("a").attr("data-ano");
			System.out.println("번호 : " + no);
			
			Element el2 = el.select(".name").get(0);
				
			String title = el2.selectFirst("strong").text();
			System.out.println("펜션이름 : " + title);
			
			String around = el2.select("p").get(1).text();
			System.out.println("주변지역 : " + around);
			
			String price1= el.select(".map_html").select("em").html();
			System.out.println("이전 가격 : " +price1+"원");
			String price= el.select(".map_html").select("b").html();
			System.out.println("가격 : " +price);
			
			String link = el.getElementsByTag("a").attr("href");
			System.out.println(link);
			
//			Element pic=el.selectFirst(".pic img");
//			System.out.println(pic);
			Document doc2 = Jsoup.connect(link).get();
//			Elements el3 = doc2.select(".swiper-slide");
//			for (int j = 0; j < 10; j++) {
//				Element eximg= el3.select(".swiper-lazy").get(j);
//				String img = eximg.attr("data-src");
//				System.out.println(img);
//			}
			String address = doc2.select(".address").text();
			System.out.println("주소 : " +address);
//			
//			String comment = doc2.select(".comment div").text();
//			System.out.println("사장님 한 마디" +comment);
//			
			Elements price2 = doc2.select(".room");
			for (int j = 0; j < price2.size(); j++) {
				String el5= price2.get(j).select(".price p b").text();
				System.out.println(el5);
			}
//			System.out.println(price2);
			
			
			// 객실 내부 사진
			Elements el4= doc2.select(".owl-item");
			System.out.println(el4);
			for (int j = 0; j < el4.size(); j++) {
				Element eximg2 = el4.get(j);
				String test = eximg2.select(".owl-lazy").attr("data-src");
				System.out.println("비비빅"+test);
			}
			Elements title2 = doc2.select("#review");
//			System.out.println(title2);
			
//			Elements el5=doc2.select(".service");
//			String pickup=	el5.select(".theme_62").text();
//			System.out.println("픽업 가능 여부 : "+pickup);
//			String cooking=	el5.select(".theme_237").text();
//			System.out.println("취사 가능 여부 : "+cooking);
//			String BREAKFAST=	el5.select(".theme_208").text();
//			System.out.println("조식 포함 여부 : "+BREAKFAST);
//			String FREE_PARKING=	el5.select(".theme_147").text();
//			System.out.println("주차 가능 여부 : "+FREE_PARKING);
//			String CAMPFIRE=	el5.select(".theme_330").text();
//			System.out.println("캠프파이어 가능 여부 : "+CAMPFIRE);
//			for (int j = 0; j < el5.size(); j++) {
//				Element test2=el5.get(j);
//				String test3=test2.outerHtml();
//				System.out.println(test3);
//			}
			
			// 댓글명 실패
//			for (int j = 0; j < 10; j++) {
//				Element exTitle =reply.get(j);
//				String replyTitle= exTitle.select("strong").text();
//				System.out.println(replyTitle);
//			}
//			Connection conn2=Jsoup.connect("https://www.goodchoice.kr/product/get_review_non?ano=55875");
//			Document doc3 = conn2.get();
//			System.out.println(doc3);
//			String replyTitles = doc3.outerHtml();
//			System.out.println(replyTitles);
//			for (int j = 0; j < 15; j++) {
//				Element replyTitle = replyTitles.get(j);
//				System.out.println(replyTitle);
//			}
//			System.out.println(reply);
//			for (int j = 0; j < 10; j++) {
//				Element el4=reply.get(j);
//				String replyTitle = el4.selectFirst("strong").text();
//				System.out.println(replyTitle);
//			}
//			for (int j = 0; j < 10; j++) {
//				Element score = reply.select(score_)
//				System.out.println(score);
//			}
//			String price
			
			
//				String around = el2.getEle;
//				System.out.println(around);
			
				
//			String info = el.selectFirst(".list_info").text();
//			String price = el.selectFirst(".price").text();
//			String link = el.selectFirst(".list_info a").attr("href");
//			Element img = el.selectFirst(".list_img img");

//			Map<String, String> map = new HashMap<>();
//			map.put("no", no);
//			map.put("title", title);
//			map.put("info", info);
//			map.put("price", price);
//			map.put("link", link);
////			System.out.println(no);
////			System.out.println(title);
////			System.out.println(info);
////			System.out.println(price);
////			System.out.println(link);
//			
////			System.out.println(img.attr("data-original"));
//			
////			saveDB(map);
//			saveFile(no, img.attr("data-original"));
			
			System.out.println(no + "번 작업 완료");
			System.out.println();
		}
	}
	
	static void saveFile(String no, String imgSrc) throws Exception {
		URL url = new URL(imgSrc);

		BufferedInputStream bis = new BufferedInputStream(url.openStream());
		File file = new File("C:\\mu", no);
		if(!file.exists()) {
			file.mkdirs();
		}
		
		file = new File(file, "thumb.jpg");
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
		
		int b = 0;
		while((b = bis.read()) != -1) {
			bos.write(b);
		}
		
		bos.close();
	}
	
//	static void saveDB(Map<String, String> map) throws Exception {
//		PreparedStatement pstmt = DBConn.getConnection().prepareStatement(
//				"INSERT INTO TBL_MUSINSA_SAMPLE VALUES(?, ?, ?, ?, ?)");
//		pstmt.setString(1, map.get("no"));
//		pstmt.setString(2, map.get("title"));
//		pstmt.setString(3, map.get("info"));
//		pstmt.setString(4, map.get("price"));
//		pstmt.setString(5, map.get("link"));
//		pstmt.executeUpdate();
//		pstmt.close();
//	}
//	
//	static void doOldParsing() throws Exception {
//		String urlStr = "https://www.musinsa.com/category/014001";
//		URL url = new URL(urlStr);
//
//		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
//		BufferedWriter bw = new BufferedWriter(new FileWriter("무신사.html"));
//		
//		String s = null;
//		while((s = br.readLine()) != null) {
//			System.out.println(s);
//			bw.write(s);
//			bw.newLine();
//		}
//		
//		bw.close();
//	}
}
