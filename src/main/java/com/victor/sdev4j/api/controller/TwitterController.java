package com.victor.sdev4j.api.controller;

import com.victor.sdev4j.api.service.TwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TwitterController {

	@Autowired
	TwitterService twitterService;

	@ResponseBody
	@RequestMapping("/api/search")
	public List<String> getTweetCriteria(@RequestParam("criteria") String criteria) {

		return twitterService.getTweetCriteria(criteria);
	}

	@ResponseBody
	@RequestMapping("/api/timeline")
	public List<String> getTwitterTimeline() {

		return twitterService.getTwitterTimeline();
	}
}
