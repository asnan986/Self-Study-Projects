package com.fresco;

import java.util.regex.Pattern;

public class SelfFinance extends Student {
	@Override
	public String result(String s) {

		String[] splitted = s.split(Pattern.quote("|"));

		String[] subjectMark = splitted[0].split(",");

		String[] sportsMark = splitted[1].split(",");

         Student student= new SelfFinance();
		
         student.subjectMarkCalc(subjectMark,student);
         student.sportsMarkCalc(sportsMark,student);
		
         return student.cgpaCalc(student);
         
	}
	}
