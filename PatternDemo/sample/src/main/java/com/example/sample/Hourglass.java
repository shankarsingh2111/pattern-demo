package com.example.sample;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Hourglass {

	// Complete the hourglassSum function below.
	static int hourglassSum(int[][] a) {

		int n = a.length;
		int max = Integer.MIN_VALUE;

		for(int i=0; i<n-2; i++){

			for(int j=0; j<n-2; j++){

				int sum = a[i][j] + a[i][j+1] + a[i][j+2]
						+ a[i+1][j+1]
						+ a[i+2][j] + a[i+2][j+1] + a[i+2][j+2];
				if(sum > max){
					max = sum;
				}
			}

		}

		return max;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int[][] arr = new int[6][6];

		for (int i = 0; i < 6; i++) {
			String[] arrRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < 6; j++) {
				int arrItem = Integer.parseInt(arrRowItems[j]);
				arr[i][j] = arrItem;
			}
		}

		int result = hourglassSum(arr);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
