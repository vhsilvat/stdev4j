package com.victor.sdev4j.core.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
@Configuration
@ConditionalOnClass ({ TwitterFactory.class, Twitter.class })
public class Twitter4jConfiguration {

	static final String CONSUMER_KEY = "3PvWZxZFis64noI1DlDPTh1Fp";
	static final String CONSUMER_SECRET = "0xibWPmzreKogegyXJu9yBUlRQ9VVrxx0CufXWB5CUZsA6GlSc";
	static final String ACCESS_TOKEN = "1461074085769887749-KESPZ4kvvaTcWdNwUbpUSNAMhUnRBf";
	static final String ACCESS_TOKEN_SECRET = "u0MrofRrBlsBFHI2XMbDjmVWRSmEs0dwsKc1QMCrR5k05";

	@Bean
	@ConditionalOnMissingBean
	public TwitterFactory twitterFactory() {

		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
				.setOAuthConsumerKey(CONSUMER_KEY)
				.setOAuthConsumerSecret(CONSUMER_SECRET)
				.setOAuthAccessToken(ACCESS_TOKEN)
				.setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);

		return new TwitterFactory(cb.build());
	}

	@Bean
	@ConditionalOnMissingBean
	public Twitter twitter(TwitterFactory twitterFactory){
		return twitterFactory.getInstance();
	}
}
