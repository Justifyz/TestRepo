package selfdivisor;

public class SelfDivisor {
	
	public static boolean isSelfDivisor(int number) {
		int n = number;
		while(n > 0) {
			int rightNumber = n%10;
			if(rightNumber == 0 || number%rightNumber != 0) {
				return false;
			}
			n /= 10;
		}
		return true;
	}
	
	public static int[] firstNumSelfDivisors(int start, int num) {
		int count = 0;
		int startNum = start;
		int[] firstNumDivisors = new int[num];
		while(count < num) {
			if(isSelfDivisor(startNum)) {
				firstNumDivisors[count] = startNum;
				count++;
			}
			startNum++;
		}
		return firstNumDivisors;
	}
	
}
