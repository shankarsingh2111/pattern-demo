package com.example.sample;

import java.util.Scanner;

class Sum {

	public static void main (String[] args) {

		Scanner scanner = new Scanner(System.in);
		int testCount = scanner.nextInt();

		for(int i=0; i<testCount; i++){
			int n = scanner.nextInt();

			int[] array = new int[n];
			int sum = 0;
			for(int j=0; j<n; j++){
				array[j] = scanner.nextInt();
				sum += array[j];
			}

			System.out.println(sum);

		}

	}

}
