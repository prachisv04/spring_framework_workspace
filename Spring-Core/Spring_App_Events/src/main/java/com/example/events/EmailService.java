package com.example.events;

import java.util.List;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class EmailService implements ApplicationEventPublisherAware{

	private List<String> blockedList;
	private ApplicationEventPublisher applicationEventPublisher;
	
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		
		this.applicationEventPublisher = applicationEventPublisher;
		
	}

	public List<String> getBlockedList() {
		return blockedList;
	}

	public void setBlockedList(List<String> blockedList) {
		this.blockedList = blockedList;
	}
	
	public void sendEmail(String address , String content) {
		if(blockedList.contains(address)) {
			applicationEventPublisher.publishEvent( new BlockedListEvent(this,address,content) );
		}
		
	}

}
