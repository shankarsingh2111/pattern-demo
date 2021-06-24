package com.example.sample;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

	/*
	 * Complete the 'stringAnagram' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY.
	 * The function accepts following parameters:
	 *  1. STRING_ARRAY dictionary
	 *  2. STRING_ARRAY query
	 */

	public static List<Integer> stringAnagram(List<String> dictionary, List<String> query) {
		// Write your code here
		List<Integer> counts = new ArrayList<>();

		for(int i=0; i<query.size(); i++){
			int count = 0;
			char[] charSet = query.get(i).toCharArray();

			for(int j=0; j<dictionary.size(); j++) {
				char[] charSetD = dictionary.get(j).toCharArray();
				if (charSet.length != charSetD.length) {
					continue;
				}
				int sum = 0;

				for (int k = 0; k < charSet.length; k++){
					sum = sum + charSet[k];
				}
				for (int k = 0; k < charSet.length; k++){
					sum = sum - charSetD[k];
				}
				if(sum == 0){
					count++;
				}
			}
			counts.add(count);
		}

		return counts;
	}

}

public class Anagram {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		int dictionaryCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<String> dictionary = IntStream.range(0, dictionaryCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		})
				.collect(toList());

		int queryCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<String> query = IntStream.range(0, queryCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		})
				.collect(toList());

		List<Integer> result = Result.stringAnagram(dictionary, query);

		bufferedWriter.write(
				result.stream()
						.map(Object::toString)
						.collect(joining("\n"))
						+ "\n"
		);

		bufferedReader.close();
		bufferedWriter.close();
	}
}