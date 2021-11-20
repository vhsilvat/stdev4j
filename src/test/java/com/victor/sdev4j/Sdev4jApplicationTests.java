package com.victor.sdev4j;

import com.victor.sdev4j.api.service.TwitterService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import twitter4j.TwitterException;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class Sdev4jApplicationTests {

	@Autowired
	private TwitterService twitterService;

	@Test
	public void testGetTweets() throws TwitterException {
		List<String> tweets = twitterService.getTwitterTimeline();
		for (String tweet : tweets) {
			System.err.println(tweet);
		}
	}

}
