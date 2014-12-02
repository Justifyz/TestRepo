package ProjectEuler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Problem22 {

	public static void main(String[] args) {
		String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		BufferedReader br = null;
		String[] str = null;
		try{
			String line;
			br = new BufferedReader(new FileReader("C://Users/O609755/Desktop/p022_names.txt"));
			line = br.readLine();
			str = line.replaceAll("\"", "").split(",");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(br != null) {
					br.close();
				}
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		Arrays.sort(str);
		long total = 0;
		int nameScore;
		for(int i = 0; i < str.length; i++) {
			String word = str[i];
			nameScore = 0;
			for(char c : word.toCharArray()) {
				nameScore = nameScore + abc.indexOf(c)+1;
			}
			nameScore *= (i+1);
			total += nameScore;
		}
		System.out.println(total);
		
	}
	
}
