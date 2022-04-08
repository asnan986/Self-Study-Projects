package com.fresco;

import java.util.regex.Pattern;

public class Aided extends Student {

	

	@Override
	public String result(String s) {

		String[] splitted = s.split(Pattern.quote("|"));

		String[] subjectMark = splitted[0].split(",");
		String[] nccMark = splitted[1].split(",");
		String[] sportsMark = splitted[2].split(",");
		Student student= new Aided();
		
		student.subjectMarkCalc(subjectMark,student);
		student.nccMarkCalc(nccMark,student);
		student.sportsMarkCalc(sportsMark,student);
		
		
		
         return student.cgpaCalc(student);
	}

	

	

}
