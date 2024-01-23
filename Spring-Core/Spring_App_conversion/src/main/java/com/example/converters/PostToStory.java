package com.example.converters;

import org.springframework.core.convert.converter.Converter;

public class PostToStory implements Converter<FeedPost, Story> {

	@Override
	public Story convert(FeedPost source) {	
		Story s = new Story();
		s.setData(source.getData()+" - "+source.getCaption());
		s.setLikes(source.getLikes());
		s.setReply(source.getComments());
		return s;	
	}

}
