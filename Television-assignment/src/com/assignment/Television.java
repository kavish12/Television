package com.assignment;
import java.util.Collections;
import java.util.Map;

public class Television {

	
	private int currentChannelNumber = 0;
	private Map<String,String> channelNumberToNameMap;
	
	/**
	*Constructor
	*
	*@param channelNumberToNameMap A map of every channel number and its corresponding channel name
	*
	*NOTE:It is safe to assume that the channelNumberToNameMap's keys will all be numeric and positive
	*and the values will be non null/whitespace.Inaddition,channelNumberToName Map will not be empty.
	*Do not make anyo therassumptions about channelNumberToNameMap or the data itcontains.
	*/
	public Television(Map<String, String> channelNumberToNameMap){
		this.channelNumberToNameMap = channelNumberToNameMap;
		currentChannelNumber = getMinChannel();
	}
	
	/**
	*Changes the Television to the desired channel.
	*
	*@paramchannelNumberThedesiredchannelnumber
	*@return
	Thenameofthedesiredchannel
	 * @return 
	*/
	public String goToChannel(String channelNumber) {
		String channel = channelNumberToNameMap.get(channelNumber);
		return channel !=null ? channel : "CHANNEL_NOT_FOUND";
	}
	
	/**
	*Changes the Television channel once in an ascending direction.
	*
	*@return
	The name of the next channel
	*/
	public String channelUp() {
		
		currentChannelNumber++;
		
		if(currentChannelNumber > getMaxChannel()){
			currentChannelNumber = getMinChannel();
		}
		
		return channelNumberToNameMap.get(Integer.toString(currentChannelNumber));
	}
	
	/**
	*Changes the Television channel once in a descending direction.
	*
	*@return
	The name of the previous channel
	*/
	public String channelDown() {
		
		currentChannelNumber--;
		
		if(currentChannelNumber < getMinChannel()){
			currentChannelNumber = getMaxChannel();
		}
		
		return channelNumberToNameMap.get(Integer.toString(currentChannelNumber));
	}

	private int getMaxChannel() {
		return Integer.parseInt(Collections.max(channelNumberToNameMap.entrySet(), (entry1, entry2) -> Integer.parseInt(entry1.getKey()) - Integer.parseInt(entry2.getKey())).getKey());
	}

	private int getMinChannel() {
		return Integer.parseInt(Collections.min(channelNumberToNameMap.entrySet(), (entry1, entry2) -> Integer.parseInt(entry1.getKey()) - Integer.parseInt(entry2.getKey())).getKey());
	}	
}
