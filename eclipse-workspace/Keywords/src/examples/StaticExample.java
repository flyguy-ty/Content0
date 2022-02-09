package examples;

class StaticDemo {
	static int counter = 0;
	int number = 0;
	
	public StaticDemo() {
		counter++;
		number++;
	}
}

public class StaticExample {
	
	public static void main(String[] args) {
		
		StaticDemo instanceA = new StaticDemo();
		System.out.println("instanceA counter: " + instanceA.counter);
		System.out.println("instanceA number: " + instanceA.number);
		
		StaticDemo instanceB = new StaticDemo();
		System.out.println("instanceB counter: " + instanceB.counter);
		System.out.println("instanceB number: " + instanceB.number);
	}
}
