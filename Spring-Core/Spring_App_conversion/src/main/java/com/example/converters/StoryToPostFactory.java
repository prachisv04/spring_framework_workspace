package com.example.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

public class StoryToPostFactory implements ConverterFactory<Story, FeedPost> {

	@SuppressWarnings("unchecked")
	@Override
	public <T extends FeedPost> Converter<Story, T> getConverter(Class<T> FeedPost) {
		return (Converter<Story, T>) new StoryToPost();
	}

}
