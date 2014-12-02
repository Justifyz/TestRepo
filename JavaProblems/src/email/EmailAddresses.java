package email;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class EmailAddresses {

	private Map<String, Set<String>> addressBook;
	
	public EmailAddresses() {
		addressBook = new HashMap<String, Set<String>>();
	}
	
	public void appendSetToQueue(Set<String> items, Queue<String> q) {
		Iterator<String> it = items.iterator();
		while(it.hasNext()) {
			q.add(it.next());
		}
	}
	
	public Set<String> expandAlias(String alias) {
		Set<String> result = new HashSet<String>();
		Queue<String> q = new PriorityQueue<String>();
		q.add(alias);
		
		while(!q.isEmpty()) {
			String token = q.poll();
			Set<String> items = addressBook.get(token);
			if(items == null) {
				result.add(token);
			}
			else {
				appendSetToQueue(items, q);
			}
		}
		return result;
	}
	
}
