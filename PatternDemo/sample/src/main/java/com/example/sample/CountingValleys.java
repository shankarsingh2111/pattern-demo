package com.example.sample;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class CountingValleys {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		int steps = Integer.parseInt(bufferedReader.readLine().trim());

		String path = bufferedReader.readLine();

		int result = countingValleys(steps, path);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}



	public static int countingValleys(int steps, String path) {
		// Write your code here
		char[] csteps = path.toCharArray();

		int count = 0;

		int altitude = 0;
		boolean valleyStart = false;
		for(int i=0; i<csteps.length; i++){
			char c = csteps[i];

			if(altitude == 0 && c == 'D'){
				valleyStart = true;
			}
			else if(valleyStart && altitude == -1 && c == 'U'){
				valleyStart = false;
				count++;
			}

			if(c == 'U'){
				altitude++;
			} else if(c == 'D'){
				altitude--;
			}

		}

		return count;
	}

}
