package com.fresco;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int numberOfMatches = Integer.parseInt(s.nextLine());
        String squads = s.nextLine();
        int sqs = Integer.parseInt(s.nextLine());
        int sqd = Integer.parseInt(s.nextLine());
        // Hashset b = new Hashset();
        String e = Hashset.getOut(numberOfMatches, squads, sqs, sqd);

        System.out.println(e);
        s.close();
    }
}