package com.example.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.format.Parser;
import org.springframework.format.Printer;

public class StoryFormatter implements Formatter<Story>{

		private Parser<Story> parser;
	
	    private Printer<Story> printer;

	    StoryFormatter( Parser<Story> p , Printer<Story> pt ){
	    	parser=p;
	    	printer=pt;
	    }

	
	@Override
	public String print(Story story, Locale locale) {
		
		return printer.print(story, locale);
	
	}

	@Override
	public Story parse(String text, Locale locale) throws ParseException {
		
		return parser.parse(text, locale);
	}

}
