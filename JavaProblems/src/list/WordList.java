package list;

import java.util.ArrayList;
import java.util.List;

public class WordList {

	private List<String> myList;
	
	public WordList(ArrayList<String> list) {
		this.myList = list;
	}
	
	public int numWordOfLength(int len) {
		int count = 0;
		for(String word : myList) {
			if(word.length() == len) {
				count++;
			}
		}
		return count;
	}
	
	public void removeWordsOfLength(int len) {
		for(String word : myList) {
			if(word.length() == len) {
				myList.remove(word);
			}
		}
	}
	
}
