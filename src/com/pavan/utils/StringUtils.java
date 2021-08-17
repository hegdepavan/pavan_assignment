package com.pavan.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.testng.Assert;

public class StringUtils {
	/**
	 * <h1>Method to get number of occurrence of key in a given string
	 * 
	 * @param text, key
	 * @author pavanhegde
	 */
	public static int getNumOfOccurceOfStringInText(String input, String key) {
		if (input.isEmpty() || key.isEmpty()) {
			return 0;
		}
		int index = 0, count = 0;
		while (true) {
			index = input.indexOf(key, index);
			if (index != -1) {
				count++;
				index += key.length();
			} else {
				break;
			}
		}

		return count;

	}

	/**
	 * <h1>Method to read file and then get file data
	 * 
	 * @param filePathe
	 * @author pavanhegde
	 */
	public static String getFileData(String filePath) {
		String data = "";
		try {

			File reader = new File(filePath);
			Scanner sc = new Scanner(reader);
			while (sc.hasNextLine()) {
				data += sc.nextLine();
			}
			sc.close();
			return data;
		} catch (FileNotFoundException e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
		return data;
	}

}
