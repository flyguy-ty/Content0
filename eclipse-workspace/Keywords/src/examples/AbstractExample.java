package examples;

abstract class Animal {
	public void eat() {
		System.out.println("The animal eats");
	}
	abstract void move();
	
}

class Dog extends Animal {
	public void move() {
		System.out.println("the dog walks");
	}
	
	public void beg() {
		System.out.println("Dog wants food");
	}
}

public class AbstractExample {
	public static void main(String[] args) {
		Dog myDog = new Dog();
		myDog.eat();
		myDog.move();
		myDog.beg();
	}
}
