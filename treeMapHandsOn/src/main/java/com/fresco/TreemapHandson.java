package com.fresco;

import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Pattern;

public class TreemapHandson {

    public TreeMap<Integer, String> createPlayerPositionMap(String cricketDataset) {
        int i = 0;
        TreeMap<Integer, String> asd = new TreeMap<Integer, String>();
        ArrayList<TreeMap> abc = new ArrayList<TreeMap>();

        String[] Players;
        String[] temp;
        Players = cricketDataset.split(Pattern.quote("|"));
        while (i < Players.length) {
            temp = Players[i].split(",");
            for (int j = 0; j < temp.length; j++) {
                asd.put(Integer.parseInt(temp[0]), temp[1]);
            }
            i++;
        }
        return asd;

    }

    public TreeMap<String, Integer> createPlayerScoreMap(String cricketDataset) {
        int i = 0;
        TreeMap<String, Integer> asd = new TreeMap<String, Integer>();
        ArrayList<TreeMap> abc = new ArrayList<TreeMap>();

        String[] Players;
        String[] temp;
        Players = cricketDataset.split(Pattern.quote("|"));

        while (i < Players.length) {
            temp = Players[i].split(",");
            for (int j = 0; j < temp.length; j++) {
                asd.put(temp[1], Integer.parseInt(temp[2]));
            }
            i++;
        }
        return asd;

    }

    public TreeMap<?, ?> createMatchesMap(String cricketDataset) {

        String[] a = cricketDataset.split("[\\r\\n]+");
        String[] s, u;
        int value = 0;
        TreeMap<String, Integer> net = new TreeMap<String, Integer>();
        int i = 0;
        while (i < a.length) {
            int temp = 1;
            s = a[i].toString().split(Pattern.quote("|"));
            
            for (int j = 0; j < s.length; j++) {
                u = s[j].toString().split(",");
                if (u[0].equals("1")) {
                    if (net.get(u[1]) != null) {
                        temp++;
                        value = (net.get(u[1]) + Integer.parseInt(u[2])) / temp;
                        net.replace(u[1], value);
                    } else {
                    	//System.out.println(u[2]+u[1]);
                        net.put(u[1], Integer.parseInt(u[2].trim()));
                    }

                }
            }

            i++;
        }

        return net;
    }

    public String getQuery(String cricketDataset, String query) {
        String data = cricketDataset;
        String[] pl = cricketDataset.split(Pattern.quote("|"));
        TreeMap<String, Integer> ne = new TreeMap<String, Integer>();
        TreeMap<Integer, String> ne1 = new TreeMap<Integer, String>();
        String[] a = query.split(" ");
        StringBuffer ads = new StringBuffer();
        int start, end;

        if (a[0].equals("1")) {
            start = Integer.parseInt(a[1]);
            end = Integer.parseInt(a[2]);
            ne1 = createPlayerPositionMap(data);
            for (int j = start; j <= end; j++) {
                ads.append(j + " " + ne1.get(j) + "\n");
            }
        } else if (a[0].equals("2")) {
            ads = new StringBuffer();
            ne = createPlayerScoreMap(data);
            ne1 = createPlayerPositionMap(data);
            for (Map.Entry<Integer, String> entry : ne1.entrySet()) {
                for (Map.Entry<String, Integer> entry1 : ne.entrySet()) {
                    if (entry1.getValue() > Integer.parseInt(a[1])) {
                        if (entry1.getKey().equals(entry.getValue())) {
                            ads.append(entry.getKey() + " " + entry.getValue() + "\n");
                        }
                    }
                }
            }

        } else if (a[0].equals("3")) {
            ads = new StringBuffer();
            TreeMap<?, ?> nes = new TreeMap();
            nes = createMatchesMap(data);
            int comp = 0;
            for (Entry<?, ?> integer : nes.entrySet()) {
                if (Integer.parseInt(integer.getValue().toString()) >= comp) {
                    comp = Integer.parseInt(integer.getValue().toString());
                }
            }
            for (Map.Entry<?, ?> integer : nes.entrySet()) {
                if (Integer.parseInt(integer.getValue().toString()) == comp) {
                    ads.append("The Efficient Opener is ");
                    ads.append(integer.getKey());
                    // ads.append(" ");
                }
            }
        }
        return ads.toString();
    }

}