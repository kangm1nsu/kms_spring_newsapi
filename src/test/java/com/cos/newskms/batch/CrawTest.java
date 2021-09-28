

package com.cos.newskms.batch;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

//https://news.naver.com/main/read.naver?mode=LSD&mid=shm&sid1=100&oid=003&aid=0000000001
public class CrawTest {
	int aidNum = 1;
	@Test
	public void test1() throws IOException {
		//httpUrlConnection(자바기본),okHttp(라이브러리),RestTemplate,Retrofit2
		//파이썬 requests
		RestTemplate rt = new RestTemplate();
		
		
		String url="https://news.naver.com/main/read.naver?mode=LSD&mid=shm&sid1=102&oid=022&aid=0000000001";
		String html = rt.getForObject(url, String.class);
		
		Document doc = Jsoup.parse(html);
		
//		Element companyElement = doc.selectFirst(".press_logo a img");
//		String company = companyElement.attr("alt");
//		System.out.print(company);
		
//		Element titleElement = doc.selectFirst("#articleTitle");
//		String title = titleElement.text();
//		System.out.print(title);
		
		Element createAtElement = doc.selectFirst(".t11");
		String createAt = createAtElement.text();
		System.out.println(createAt);
		
	}
	

	
	
}

