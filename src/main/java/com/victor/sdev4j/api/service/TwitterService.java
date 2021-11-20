package com.victor.sdev4j.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twitter4j.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class TwitterService {

	@Autowired
	private Twitter twitter;

	public List<String> getTweetCriteria(String criteria) {

		List<String> responseList = new ArrayList<>();

		try {
			Query q = new Query(criteria);
			QueryResult criteriaSearch = twitter.search(q);
			for (Status status : criteriaSearch.getTweets()) {
				responseList.add(status.getText());
			}
		} catch (TwitterException e) {
			throw new RuntimeException(e);
		}

		return responseList;
	}

	public List<String> getTwitterTimeline () {

		List<String> tweets = new ArrayList<>();

		try {
			ResponseList<Status> homeTimeline = twitter.getHomeTimeline();
			for (Status status : homeTimeline) {
				tweets.add(status.getText());
			}
		} catch (TwitterException e) {
			throw new RuntimeException(e);
		}

		return tweets;
	}
}
