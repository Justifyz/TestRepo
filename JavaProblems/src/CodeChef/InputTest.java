package CodeChef;

import java.util.Scanner;

public class InputTest {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k = s.nextInt();
		int count = 0, num;
		for(int i = 0; i < n; i++) {
			num = s.nextInt();
			if(num%k == 0) {
				count++;
			}
		}
		System.out.println(count);
	}
}
