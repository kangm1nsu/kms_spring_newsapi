package com.cos.newskms.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.newskms.domain.News;
import com.cos.newskms.domain.NewsRepository;
import com.cos.newskms.web.dto.CMRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class NewsController {

	private final NewsRepository newsRepository;
	
	@GetMapping("/news")
	public CMRespDto<List<News>> findAll(){
		return new CMRespDto<>(1, "성공", newsRepository.findAll());
	}
}