package CodeChef;
import java.util.*;

public class AndOperation {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int max = 0;
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		for(int i = 1; i < n; i++) {
			int bit = arr[i] & arr[i-1];
			if (bit > max) {
				max = bit;
			}
		}
		System.out.println(max);
	}
	
}
