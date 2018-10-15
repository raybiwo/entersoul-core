package core;

import java.util.ArrayList;
import java.util.List;

public class GenerateJson {

	static String[] contains = { "private", "String", "BigDecimal", "Date" };
	static List<String> listString = new ArrayList<>();
	static List<String> mirrorList = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		run(args);
	}

	// 1 line command
	public static void run(String[] args) {
		listGen(args);
		remover();
		printRes();
	}

	// add array args to list
	public static void listGen(String[] args) {
		for (String arg : args) {
			listString.add(arg);
			mirrorList.add(arg);
		}
	}

	// remove elements in list, checked by array contains
	public static void remover() {
		for (String ls : listString) {
			for (String contain : contains) {
				if (ls.equals(contain)) {
					mirrorList.remove(ls);
				}
			}
		}
	}

	// check list
	public static void print(List<String> mirrorList) {
		for (String ml : mirrorList) {
			System.out.println(ml);
		}
	}

	// generate result
	public static void printRes() {
		for (String ml : mirrorList) {
			System.out.println("var " + ml + " = myJSONObject.contents[count]."
					+ ml + ";");
		}
		System.out.println();
		for (String ml : mirrorList) {
			System.out.println("row[\"" + ml + "\"] = " + ml + ";");
		}
	}
}
