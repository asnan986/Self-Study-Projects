package xmlToExcel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader bufRead = new BufferedReader(
				new FileReader(new File("C:\\L2_learning\\L2Document\\practice.txt")));
		StringBuilder sb = new StringBuilder();
		String input = bufRead.readLine();
		while (input != null) {

			sb.append(input);
			input = bufRead.readLine();
		}
		String xml2String = sb.toString();
		// System.out.println(xml2String);
		bufRead.close();
		String[] demo = xml2String.split("</Data>");
		int count = 0;
		int index = 1;
		String output;
		List<String> listHead = new ArrayList();
		for (String s : demo) {
			if (!demo.equals(" ")) {
				int lastIndex = s.lastIndexOf(">") + 1;
				if (s.contains("dept_name")) {
					output = "| " + s.substring(lastIndex, s.length()) + "                                     ";
					listHead.add(output);
				} else {
					output = "| " + s.substring(lastIndex, s.length()) + " ";
					listHead.add(output);
				}
				count += output.length();
				index++;
				System.out.print(output);
			}
		}
		System.out.println();
		int decorCount = count;
		while (decorCount > 0) {
			System.out.print("-");
			decorCount--;
		}
		System.out.println();
		BufferedReader bufRead1 = new BufferedReader(
				new FileReader(new File("C:\\L2_learning\\L2Document\\values.txt")));
		StringBuilder sb1 = new StringBuilder();
		String input1 = bufRead1.readLine();
		while (input1 != null) {

			sb1.append(input1);
			input1 = bufRead1.readLine();
		}

		String xml2String1 = sb1.toString();
		bufRead1.close();
		String[] demo1 = xml2String1.split("</Data>");
		int count1 = 0;
		int index1 = 0;

		String output1;
		
		
		//		for (String s : demo1) {
//			index1++;
//			if(index1%55==0) {
//				System.out.println();				
//			}
//			if (!demo1.equals(" ")) {
//				int lastIndex = s.lastIndexOf(">") + 1;
//				output1 = "| " + s.substring(lastIndex, s.length()) + " ";
//				count1 += output1.length();				
//				System.out.print(output1);
//			}
//			
//		}
//		
//		Pattern p = Pattern.compile(">(.*?)</Data");
//		Matcher m = p.matcher(xml2String);
//		while (m.find()) {
//			if (!m.group(1).isEmpty())
//				System.out.println(m.group(1)); // is your string. do what you want
//		}

	}

	private static String fun1(String s) {
		int lastIndex = s.lastIndexOf(">") + 1;
        return "| " + s.substring(lastIndex, s.length()) + " ";
	}
	
	public static void whenAppendStringUsingBufferedWritter_thenOldContentShouldExistToo(String str) 
			  throws IOException {
			    //String str = "World";
			    BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\\\L2_learning\\\\L2Document\\\\dept.txt", true));
			    writer.append(str);
			    writer.newLine();
			    
			    writer.close();
			}
}
