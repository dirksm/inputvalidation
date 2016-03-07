package com.leewardassociates.test.main;

public class PrimeNumbers {

    public static void main(String[] args) {
	if (args.length == 0) {
	    System.out.println("Error: Input count of numbers needed to print.");
	    System.exit(0);
	}
	int num = 0;
	try {
	    num = Integer.parseInt(args[0]);
	} catch (NumberFormatException nfe) {
	    System.out.println("First argument must be a number!");
	}
	int count = 0;
	for (int i = 1; i < num; i++) {
	    count = 0;
	    for (int j = 2; j < i/2; j++) {
		if (i%j == 0) {
		    count++;
		    break;
		}
	    }
	    if (count == 0) {
		System.out.println(i);
	    }
	}
	
    }
}
