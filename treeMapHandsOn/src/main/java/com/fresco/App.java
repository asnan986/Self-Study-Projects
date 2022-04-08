package com.fresco;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        // int numberOfMatches = Integer.parseInt(s.nextLine());
        String squads = s.nextLine();
        String ss = s.nextLine();
        TreemapHandson a = new TreemapHandson();
        System.out.println(a.getQuery(squads, ss));
        s.close();
    }
}