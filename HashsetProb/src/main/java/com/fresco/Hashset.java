package com.fresco;

import java.util.ArrayList;


import java.util.HashSet;
import java.util.Iterator;

public class Hashset {

	public static String getOut(int numberOfMatches, String squads, int squad1, int squad2) {
		// write your code here
		// HashSet<Sqd> set = new HashSet<>();
		ArrayList<Sqd> set = new ArrayList<Sqd>();
		HashSet<String> set1 = new HashSet<String>();
		HashSet<String> All = new HashSet<String>();
		String[] ss, pl;
		String s;
		int i = 0;
		ss = squads.split("#");
		// System.out.println("Started");
		while (i < numberOfMatches) {
			// ss = squads.split("#");
			pl = ss[i].split(" ");
			for (String string : pl) {
				set1.add(string);
				All.add(string);
			}

			// System.out.println(set1);
			set.add(new Sqd(set1));

			i++;
			set1 = new HashSet<String>();
		}
		// System.out.println(All);
		// StringBuffer ssss = new StringBuffer();
		ArrayList<HashSet> nee = new ArrayList<HashSet>();
		for (Sqd a : set) {
			// System.out.println(a.sb.toString());
			nee.add(a.sb);
			// ssss.append(a.sb.toString());
			// ssss.append("+");
			// System.out.println(ssss.toString());
		}
		HashSet<String> chk = new HashSet<String>();
		HashSet<String> cck = new HashSet<String>();
		int temp = 0;
		/*
		 * for (int k = 0; i < nee.size(); k++) { for (String Al : All) {
		 * if(nee.get(k).contains(Al)); { temp++;
		 * 
		 * } }
		 * 
		 * }
		 */
		// StringBuffer sbb = new StringBuffer();
		int tem = 0;
		for (String Al : All) {
			tem = 0;
			// System.out.println(Al);
			for (int k = 0; k < nee.size(); k++) {
				// chk = nee.get(k);
				// boolean asdf = chk.contains("abc");
				// System.out.println(asdf);
				if (nee.get(k).contains(Al)) {
					// System.out.println(nee.get(k).toString());
					tem++;
				} else {
					tem = 0;
					continue;
				}
				if (tem == nee.size()) {
					// System.out.println(Al);
					chk.add(Al);
				}
			}

		}
		// System.out.println(chk.toString());

		StringBuffer sss = new StringBuffer();
		int ssd = squad1 - 1;
		int ssds = squad2 - 1;
		// System.out.println(sss);
		// System.out.println(ssd);
		// System.out.println(ssds);
		for (String Alp : All) {
			// System.out.println(Alp);
			if (nee.get(ssds).contains(Alp) && !(nee.get(ssd).contains(Alp))) {
				// if()
				cck.add(Alp);
				// System.out.println(Alp);
			} else {
				// System.out.println(Alp);
			}

		}
		Iterator itr = chk.iterator();

		// check element is present or not. if not loop will
		// break.
		while (itr.hasNext()) {
			sss.append((itr.next()));
			sss.append(" ");
		}
		// String cchk = cck.toString();
		sss.append(" ,");
		itr = cck.iterator();

		// check element is present or not. if not loop will
		// break.
		while (itr.hasNext()) {
			sss.append((itr.next()));
			
			sss.append(" ");
		}
		// sss.append(cck.toString());
		String finale = sss.toString();// cchk.concat(",").concat(cck.toString());
		// System.out.println(finale);

		return finale;
	}
}

class Sqd {
	public HashSet<String> sb = new HashSet<String>();

	public Sqd(HashSet<String> nee) {
		this.sb = nee;
	}
}
