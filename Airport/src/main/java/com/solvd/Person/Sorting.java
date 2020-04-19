package com.solvd.Person;

import java.util.ArrayList;

public class Sorting{

	public static void main(String[] args) {
	
		ArrayList<Integer> unsorted = new ArrayList<Integer>();		
		unsorted.add(1);
		unsorted.add(32);
		unsorted.add(67);
		unsorted.add(2);
		selectionSort(unsorted);
		System.out.println(unsorted);
	}

	public static void selectionSort(ArrayList<Integer> unsorted) {

		int size = unsorted.size();
		for (int i = 0; i < size; i++) {
			int min = i;
			for (int j = i; j < size; j++) {
				if (unsorted.get(j) < unsorted.get(min)) {
					min = j;
				}
			}
			int temp = unsorted.get(min);
			unsorted.set(min, unsorted.get(i));
			unsorted.set(i, temp);
		}
	}

}
