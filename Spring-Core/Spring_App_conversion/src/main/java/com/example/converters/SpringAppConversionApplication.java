package com.example.converters;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.format.support.FormattingConversionService;

import com.example.formatter.*;
import com.example.formatter.StoryParser;
import com.example.formatter.StoryPrinter;

public class SpringAppConversionApplication {

	public static void main(String[] args) {

//		Testing Converters
		ConverterTests tests = new ConverterTests();
		tests.main();
		
//		Testing Formatters
	
		FormatterTests test = new FormatterTests();
		test.main();
		
	}
	

	

}
