package numbers;

public class ArithmeticNumberStream implements IncreasingNumberStream {

	private int startingValue, incrementValue;
	private int total;
	
	public ArithmeticNumberStream(int sv, int iv) {
		this.startingValue = sv;
		this.incrementValue = iv;
		this.total = 0;
	}
	
	@Override
	public int nextTerm() {
		if(total == 0) {
			total += startingValue;
		}
		else {
			total += incrementValue;
		}
		return total;
	}

	@Override
	public void restart() {
		total = 0;
	}
	
	public static void main (String[] args) {
		ArithmeticNumberStream stream = new ArithmeticNumberStream(12, 5);
		System.out.print(stream.nextTerm() + " ");
		System.out.print(stream.nextTerm() + " ");
		System.out.print(stream.nextTerm() + " ");
		stream.restart();
		System.out.print(stream.nextTerm() + " ");
		System.out.print(stream.nextTerm());
	}

}
