package com.example.converters;

import org.springframework.core.convert.converter.Converter;

public class StoryToPost implements Converter<Story, FeedPost> {

	@Override
	public FeedPost convert(Story source) {
		
		FeedPost post = new FeedPost();
		post.setData(source.getData());
		post.setCaption("No Caption Needed");
		post.setComments(source.getReply());
		post.setLikes(source.getLikes());
		return post;
	}

}
