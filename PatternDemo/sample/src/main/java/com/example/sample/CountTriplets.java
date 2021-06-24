package com.example.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class CountTriplets {

	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(read.readLine());
		while(t-- > 0){
			int n = Integer.parseInt(read.readLine());
			String input[] = read.readLine().split(" ");

			int arr[] = new int[n];
			for(int i=0; i<n; i++){
				arr[i] = Integer.parseInt(input[i]);
			}

			System.out.println(countTriplet(arr, n));
		}


	}


	private static int countTriplet(int arr[], int n) {
		// code here

		HashMap<Integer, String> map = new HashMap<Integer, String>();
		for(int i=0; i<arr.length; i++){
			map.put(arr[i], null);
		}

		int triplets = 0;
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr.length; j++){
				if(i != j){
					int key = arr[i]+arr[j];
					if(map.keySet().contains(key)
							&& (map.get(key) == null
							|| (!map.get(key).contains(""+arr[i]) && !map.get(key).contains(""+arr[j]))
							)
					){
						triplets++;
						map.put(key, ""+arr[i]+"+"+arr[j]);
					}

//					for(int k=0; k<arr.length; k++){
//						if(k != i && k != j && arr[k]==arr[i]+arr[j]){
//							System.out.println(arr[k]+" = "+arr[i]+" + "+arr[j]);
//							triplets++;
//						}
//					}
				}
			}
		}
		System.out.println("map = "+map);

		return triplets;

	}
}