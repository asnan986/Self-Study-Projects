package com.fresco;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Student {
	private int creditPoint;
	private double gradePointSum;

	public abstract String result(String s);

	public void subjectMarkCalc(String[] subjects, Student student) {

		for (String subjectTemp : subjects) {
			String[] indvidual = subjectTemp.split(" ");
			int i = 0;
			for (String indvidualTemp : indvidual) {
				if (i % 2 == 0 && i < indvidual.length) {
					student.creditPoint += 5;
					student.gradePointSum += student.getGradePoint(Integer.parseInt(indvidualTemp))
							* Integer.parseInt(indvidual[i + 1]);

				}
				i++;
			}
		}
	}

	public void nccMarkCalc(String[] nccMark, Student student) {
		if (nccMark[0].equals("1")) {
			student.gradePointSum += student.getGradePoint(Integer.parseInt(nccMark[1])) * Integer.parseInt(nccMark[2]);
			student.creditPoint += 5;

		}

	}

	public void sportsMarkCalc(String[] sportsMark, Student student) {
		if (sportsMark[0].equals("1")) {
			student.gradePointSum += student.getGradePoint(Integer.parseInt(sportsMark[1]))
					* Integer.parseInt(sportsMark[2]);
			student.creditPoint += 5;

		}

	}

	public String cgpaCalc(Student student) {

		return new BigDecimal((student.getGradePointSum()) / (student.getCreditPoint()))
				.setScale(2, RoundingMode.HALF_DOWN).toString();
	}

	public double getGradePoint(int marks) {
		double gradePoint;
		if (marks >= 75 && marks <= 100)
			gradePoint = 9.0 + ((marks - 75.0) * ((10.0 - 9.0) / (100 - 75.0)));

		else if (marks >= 60 && marks <= 74)
			gradePoint = 8.0 + ((marks - 60.0) * ((8.9 - 8.0) / (74.0 - 60.0)));

		else if (marks >= 50 && marks <= 59)
			gradePoint = 7.0 + ((marks - 50.0) * ((7.9 - 7.0) / (59.0 - 50.0)));

		else if (marks >= 40 && marks <= 49)
			gradePoint = 6.0 + ((marks - 40.0) * ((6.9 - 6.0) / (49.0 - 40.0)));

		else
			gradePoint = 0;

		return new BigDecimal(gradePoint).setScale(1, RoundingMode.HALF_DOWN).doubleValue();
	}

	public int getCreditPoint() {
		return creditPoint;
	}

	public double getGradePointSum() {
		return gradePointSum;
	}

}
