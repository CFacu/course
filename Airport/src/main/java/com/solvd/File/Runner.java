package com.solvd.File;

public class Runner {
	
	public static void main(String[] args) {
		
		FileReader reader = new FileReader("src\\main\\resources\\text.txt");
		reader.calculateOcurrences();
	}
}
