package CodeChef;

import java.util.Scanner;

public class ATM {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(true) {
			int amount = s.nextInt();
			double balance = s.nextDouble();
			double charge = 0.5;
			if(amount%5 == 0 && amount + charge <= balance) {
				System.out.println(balance-amount-0.5);
			}
			else {
				System.out.println(balance);
			}
		}
	}
	
}
