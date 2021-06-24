package com.example.sample;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PasswordDecryption {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String s = bufferedReader.readLine();

		String result = decryptPassword(s);

		bufferedWriter.write(result);
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}

	public static String decryptPassword(String s) {
		// Write your code here
		String digits = "123456789";
		String lowercase = "abcdefghijklmnopqrstuvwxyz";
		String uppercase = "abcdefghijklmnopqrstuvwxyz".toUpperCase();
		ArrayList<Character> characters = new ArrayList<>();
		for(int i=0; i<s.length(); i++){
			characters.add(s.charAt(i));
		}

		int i = 0;
		while(i < s.length()){
			if(digits.contains(String.valueOf(characters.get(i)))){
				int last0 = characters.lastIndexOf('0');
				characters.add(last0, characters.remove(i));
				characters.remove(last0+1);
				i++;
			} else if('*' == characters.get(i)){
				char temp = characters.get(i-2);
				char temp1 = characters.get(i-1);
				characters.set(i-2, temp1);
				characters.set(i-1, temp);
				characters.remove(i);
			}
		}
		StringBuilder pass = new StringBuilder();
		for(Character ch : characters){
			pass.append(ch);
		}
		return pass.toString();

	}
}