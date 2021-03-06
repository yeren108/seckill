package com.yeren.execute;

import java.io.IOException;

import com.yeren.constant.JedisStandalAloneConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yeren.execute.thread.SaveUserToRedisThead;
import com.yeren.service.UserService;

import redis.clients.jedis.Jedis;


/**
 * 存放登陆用户，模拟用户已经登陆了，信息被记录到redis中了
 * @author ThinkPad
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context-test.xml")
public class SaveUserToRedisExecute {
	
	@Autowired
	UserService userService;
	
	@Test
	public void saveUser() throws IOException{
		Jedis jedis1=new Jedis(JedisStandalAloneConfig.STANDAL_ALONE_HOST, JedisStandalAloneConfig.STANDAL_ALONE_PORT);
		jedis1.auth(JedisStandalAloneConfig.STANDAL_ALONE_AUTH);
		
		Jedis jedis2=new Jedis(JedisStandalAloneConfig.STANDAL_ALONE_HOST, JedisStandalAloneConfig.STANDAL_ALONE_PORT);
		jedis2.auth(JedisStandalAloneConfig.STANDAL_ALONE_AUTH);
		
		Jedis jedis3=new Jedis(JedisStandalAloneConfig.STANDAL_ALONE_HOST, JedisStandalAloneConfig.STANDAL_ALONE_PORT);
		jedis3.auth(JedisStandalAloneConfig.STANDAL_ALONE_AUTH);
		
		Jedis jedis4=new Jedis(JedisStandalAloneConfig.STANDAL_ALONE_HOST, JedisStandalAloneConfig.STANDAL_ALONE_PORT);
		jedis4.auth(JedisStandalAloneConfig.STANDAL_ALONE_AUTH);
		
		Jedis jedis5=new Jedis(JedisStandalAloneConfig.STANDAL_ALONE_HOST, JedisStandalAloneConfig.STANDAL_ALONE_PORT);
		jedis5.auth(JedisStandalAloneConfig.STANDAL_ALONE_AUTH);
		
		Jedis jedis6=new Jedis(JedisStandalAloneConfig.STANDAL_ALONE_HOST, JedisStandalAloneConfig.STANDAL_ALONE_PORT);
		jedis6.auth(JedisStandalAloneConfig.STANDAL_ALONE_AUTH);
		
		Jedis jedis7=new Jedis(JedisStandalAloneConfig.STANDAL_ALONE_HOST, JedisStandalAloneConfig.STANDAL_ALONE_PORT);
		jedis7.auth(JedisStandalAloneConfig.STANDAL_ALONE_AUTH);
		
		Jedis jedis=new Jedis(JedisStandalAloneConfig.STANDAL_ALONE_HOST, JedisStandalAloneConfig.STANDAL_ALONE_PORT);
		jedis.auth(JedisStandalAloneConfig.STANDAL_ALONE_AUTH);
		Runnable r1=new SaveUserToRedisThead(jedis1,userService,0,2000);
		Runnable r2=new SaveUserToRedisThead(jedis2,userService,2000,4000);
		Runnable r3=new SaveUserToRedisThead(jedis3,userService,4000,6000);
		Runnable r4=new SaveUserToRedisThead(jedis4,userService,6000,8000);
		Runnable r5=new SaveUserToRedisThead(jedis5,userService,8000,10000);
		Runnable r6=new SaveUserToRedisThead(jedis6,userService,10000,12000);
		Runnable r7=new SaveUserToRedisThead(jedis7,userService,12000,13000);
		Thread t1=new Thread(r1);
		Thread t2=new Thread(r2);
		Thread t3=new Thread(r3);
		Thread t4=new Thread(r4);
		Thread t5=new Thread(r5);
		Thread t6=new Thread(r6);
		Thread t7=new Thread(r7);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		System.in.read();
	}
}
