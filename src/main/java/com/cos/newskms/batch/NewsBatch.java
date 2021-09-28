package com.cos.newskms.batch;

import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cos.newskms.domain.News;
import com.cos.newskms.domain.NewsRepository;
import com.cos.newskms.util.NaverCraw;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class NewsBatch {
	private final NewsRepository newsRepository;
	private final NaverCraw naverCraw;
	
	@Scheduled(fixedDelay = 1000*60*1)
	public void newsCrawAndSave() { 
		List<News> newsList = naverCraw.collect5();
		newsRepository.saveAll(newsList);
	}
}
