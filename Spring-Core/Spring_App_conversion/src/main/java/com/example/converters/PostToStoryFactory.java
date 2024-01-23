package com.example.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

public class PostToStoryFactory implements ConverterFactory<FeedPost, Story> {

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Story> Converter<FeedPost, T> getConverter(Class<T> Story) {	
		return (Converter<FeedPost, T>) new PostToStory();
	}

}
