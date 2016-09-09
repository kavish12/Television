package com.assignment;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TelevisionTest {

	Map<String, String> channelNumberToNameMap = new HashMap<String,String>();
	Television television;
	
	@Before
	public void setUp(){
		
		channelNumberToNameMap.put("1", "ABC");
		channelNumberToNameMap.put("2", "CNC");
		channelNumberToNameMap.put("3", "CBS");
		channelNumberToNameMap.put("4", "TBS");
		channelNumberToNameMap.put("5", "NBC");
		channelNumberToNameMap.put("6", "HBO");
		channelNumberToNameMap.put("7", "CNBC");
		channelNumberToNameMap.put("8", "UNO");
		
		television  = new Television(channelNumberToNameMap);
	}
	

	@Test
	public void goToChannel() {
		String expectedChannel = "ABC";
		
		String actualChannel = television.goToChannel("1");
		assertEquals(expectedChannel, actualChannel);
		
		expectedChannel = "CBS";
		actualChannel = television.goToChannel("3");
		assertEquals(expectedChannel, actualChannel);
	
		expectedChannel = "CHANNEL_NOT_FOUND";
		actualChannel = television.goToChannel("11");
		assertEquals(expectedChannel, actualChannel);
		
		expectedChannel = "UNO";
		actualChannel = television.goToChannel("8");
		assertEquals(expectedChannel, actualChannel);
		
	}
	
	@Test
	public void channelUp() {
		String [] expectedChannelSequence = {"CNC","CBS","TBS","NBC","HBO","CNBC","UNO","ABC"};
		String [] actualChannelSequence = new String[expectedChannelSequence.length];
		for(int i = 0 ; i < expectedChannelSequence.length;i++){
			actualChannelSequence[i] = television.channelUp();
		}
		Assert.assertArrayEquals(expectedChannelSequence, actualChannelSequence);
	}
	
	@Test
	public void channelDown() {
		
		String [] expectedChannelSequence = {"UNO","CNBC","HBO","NBC","TBS","CBS","CNC","ABC"};
		String [] actualChannelSequence = new String[expectedChannelSequence.length];
		for(int i = 0 ; i < expectedChannelSequence.length;i++){
			actualChannelSequence[i] = television.channelDown();
		}
		Assert.assertArrayEquals(expectedChannelSequence, actualChannelSequence);
	}
	
	@Test
	public void channelUpDown() {
		
		String expectedChannelOne = "CBS";
		String expectedChannelTwo = "HBO";
		String expectedChannelThree = "CBS";
		
		television.channelUp();
		String actualChannelOne = television.channelUp();
		television.channelUp();
		television.channelUp();
		String actualChannelTwo = television.channelUp();
		
		television.channelDown();
		television.channelDown();
		
		String actualChannelThree = television.channelDown();
		
		assertEquals(expectedChannelOne, actualChannelOne);
		assertEquals(expectedChannelTwo, actualChannelTwo);
		assertEquals(expectedChannelThree, actualChannelThree);
		
	}
}
