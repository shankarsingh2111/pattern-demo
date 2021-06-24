package com.example.sample;

import java.util.Scanner;

class GFG {
	public static void main (String[] args) {
		//code

		Scanner scanner = new Scanner(System.in);
		int testCount = scanner.nextInt();

		for(int i=0; i<testCount; i++){
			int n = scanner.nextInt();
			int s = scanner.nextInt();

			int[] array = new int[n];
			for(int j=0; j<n; j++){
				array[j] = scanner.nextInt();
			}

			int start = 0;
			int end = -1;
			int sumlocal = array[start];

			for(int j=1; j<n; j++){
				sumlocal = sumlocal + array[j];
//				System.out.println("sumlocal = "+sumlocal+", start = "+start+", j ="+j);
				if(sumlocal > s){
					while(sumlocal > s){
						sumlocal = sumlocal - array[start];
						start = start+1;
//						System.out.println("sumlocal = "+sumlocal+", start = "+start);
					}
				}
				if(sumlocal == s){
					end = j;
//					System.out.println("matched start = "+start+", end = "+end);
					break;
				}
			}

			if(sumlocal == s && end != -1){
				System.out.println(""+(start+1)+" "+(end+1));
			} else {
				System.out.println("-1");
			}

		}

	}
}