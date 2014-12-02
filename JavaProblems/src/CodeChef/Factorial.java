package CodeChef;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> zeros = new ArrayList<Integer>();
		int t = s.nextInt();
		int count;
		for(int i = 0; i < t; i++) {
			list.add(s.nextInt());
		}
		for(Integer n : list) {
			count = 0;
			for(int i = 1; i <= n; i++) {
				if(i%5 == 0) {
					count++;
				}
				if(i%25 == 0) {
					count++;
				}
			}
			zeros.add(count);
		}
		for(Integer n : zeros) {
			System.out.println(n);
		}
		

	}

}
