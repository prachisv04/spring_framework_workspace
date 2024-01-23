package com.example.formatter;

import java.text.ParseException;

import java.util.Arrays;
import java.util.Locale;

import org.springframework.format.Parser;

public class StoryParser implements Parser{

	@Override
	public Story parse(String text, Locale locale) throws ParseException {
	
			String[] vals = text.split(",");
			Story story = new Story();
			story.setData(vals[0]);
			story.setLikes(Integer.parseInt(vals[1]));
			story.setReply(Arrays.copyOfRange(vals, 2, vals.length));
		
		return story;
	}

}
