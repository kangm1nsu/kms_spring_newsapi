package com.cos.newskms.util;


import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.cos.newskms.domain.News;

@Component
public class NaverCraw {
	
	int aidNum = 1;
	
	public List<News> collect5() {
		RestTemplate rt = new RestTemplate();
		List<News> newsList = new ArrayList<>();
		try {
			for (int i = 1; i<6; i++) {
				
				String num = String.format("%010d", aidNum);
				
				String url="https://news.naver.com/main/read.naver?mode=LSD&mid=shm&sid1=102&oid=022&aid=" + num;
				String html = rt.getForObject(url, String.class);
				
				Document doc = Jsoup.parse(html);
				
				Element titleElement = doc.selectFirst("#articleTitle");
				String title = titleElement.text();
				
				Element companyElement = doc.selectFirst(".press_logo a img");
				String company = companyElement.attr("alt");
				
				
				Element createAtElement = doc.selectFirst(".t11");
				String createAt = createAtElement.text();
			
				
							
				
				News news = News.builder()
						.company(company)
						.title(title)
						.createdAt(createAt)
						.build();
				
				newsList.add(news);
				
				aidNum ++;
			}
		} catch (RestClientException e) {
			e.printStackTrace();
		}
		return newsList;
	}

	
}	
