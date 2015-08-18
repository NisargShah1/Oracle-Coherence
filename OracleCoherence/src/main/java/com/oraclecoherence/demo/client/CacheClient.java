package com.oraclecoherence.demo.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CacheClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		 
        CoherenceCacheRunner cacheUpdater = (CoherenceCacheRunner) context.getBean("CoherenceCacheRunner");
        cacheUpdater.run();
	}

}
