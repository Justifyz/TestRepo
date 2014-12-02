package treepriority;

public interface PriorityQueue {
	public boolean isEmpty();
	public void add(Object obj);
	public Object removeMin();
	public Object peekMin();
}
