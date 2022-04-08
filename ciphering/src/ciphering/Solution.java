package ciphering;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

	public static void main(String[] args) {
		Scanner readInput = new Scanner(System.in);
		String normal = readInput.nextLine();
		String ciphered = readInput.nextLine();

		CipherDecipher cipherOrDecipher = new CipherDecipher();
		System.out.println(cipherOrDecipher.ciphering(normal));
		System.out.println(cipherOrDecipher.deciphering(ciphered));

	}

}

class CipherDecipher {
	/**
	 * This method is used to cipher the message (normal) by following steps. Swap
	 * the cases of String - UpperCase letters to LowerCase letters and viceversa.
	 * Reverse the String Replace the spaces of string with a star character("*")
	 * Replace the characters in the even positions of the string Append any integer
	 * at the last in that String
	 * 
	 * @param normal
	 * @return the ciphered message
	 */
	public String ciphering(String normal) {
		// Write your code here
		char iner, lower, upper;
		String NewNormal = normal;
		for(int i=0;i<normal.length();i++){

	        if (normal.charAt(i) >= (char) '0' && normal.charAt(i) <= (char) '9') {
	            return normal;
	        }
	    }
		for (int i = 0; i < normal.length(); i++) {
			iner = ' ';
			iner = normal.charAt(i);
			if (Character.isUpperCase(iner) == true) {
				lower = Character.toLowerCase(iner);
				NewNormal = NewNormal.replace(normal.charAt(i), lower);
			} else if (Character.isLowerCase(iner) == true) {
				upper = Character.toUpperCase(iner);
				NewNormal = NewNormal.replace(normal.charAt(i), upper);
			}
		}
		StringBuilder Fin = new StringBuilder();
		StringBuilder Fi = new StringBuilder(NewNormal);
		Fi.reverse();
		// String Any = Fi.toString();
		/// Any = Any.replaceAll(" ","*");
		// System.out.println(Any);
		StringBuilder fFi = new StringBuilder(Fi);
		for (int i = 0; i < fFi.length(); i++) {
			if (fFi.charAt(i) == ' ') {
				fFi.setCharAt(i, '*');

			}

		}
		for (int i = 0; i < normal.length(); i++) {
			if (i == 0) {
				Fin.append(fFi.charAt(i));
			} else if (i % 2 != 0) {
				int a = fFi.charAt(i);
				Fin.append(a);
			} else {
				Fin.append(fFi.charAt(i));
			}
		}
		Fin.append(3);
		String Final = Fin.toString();
		return Final;
	}

	/**
	 * This method is used to get the normal text by the reverse process of
	 * ciphering.
	 * 
	 * @param ciphered
	 * @return the deciphered message
	 */
	public String deciphering(String ciphered) {
		// Write your code here
		StringBuilder newf = new StringBuilder(ciphered);
		newf.deleteCharAt(ciphered.length() - 1);
		 //System.out.println(newf);
		StringBuilder Fin = new StringBuilder();
		String asciiNumber=" ";
		for (int i = 0; i <newf.length(); i++) {
			if (i == 0) {
				Fin.append(newf.charAt(i));
			} 
			
			
			else if(newf.charAt(i)>=(char)'0'&&newf.charAt(i)<=(char)'9') {
				asciiNumber=asciiNumber.concat(Character.toString(newf.charAt(i)));
				
				if((newf.length()-1)==i) {
					System.out.println("hai");
					int ab = Integer.parseInt(asciiNumber.trim());
					String asd = Character.toString((char) ab);
					Fin.append(asd);
				}
					
				
			}
			else{
				//char temp = newf.charAt(i);
				//char temp2 = newf.charAt(i + 1);
				//StringBuffer fina = new StringBuffer();
				//fina.append(temp);
				//fina.append(temp2);
				//String fif = fina.toString();
				int ab = Integer.parseInt(asciiNumber.trim());
				String asd = Character.toString((char) ab);
				// String asd = Character.toString((char)fif);
				// System.out.println("fif =" + asd);
				// System.out.println(newf.charAt(i + 1));
				// int a = newf.charAt(i) * 10 + newf.charAt(i + 1);
				// int a = ciphered.charAt(i);
				// System.out.println(asd);
				Fin.append(asd).append(newf.charAt(i));
				asciiNumber=" ";
				//newf.deleteCharAt(i + 1);
			} 
			
			/*
			 * else { Fin.append(newf.charAt(i)); }
			 */
		}
       
		for (int i = 0; i < Fin.length(); i++) {
			if (Fin.charAt(i) == '*') {
				Fin.setCharAt(i, ' ');

			}
		}
		Fin.reverse();
		char inera, lowera, upper;
		String NewNormal1 = Fin.toString();
		for (int i = 0; i < Fin.length(); i++) {
			inera = ' ';
			inera = Fin.charAt(i);
			if (Character.isUpperCase(inera) == true) {
				lowera = Character.toLowerCase(inera);
				NewNormal1 = NewNormal1.replace(Fin.charAt(i), lowera);
			} else if (Character.isLowerCase(inera) == true) {
				upper = Character.toUpperCase(inera);
				NewNormal1 = NewNormal1.replace(Fin.charAt(i), upper);
			}
		}
		// System.out.println(NewNormal1);

		return NewNormal1;
	}
}
