package examples;

public class VariablesExample {
	public static void main(String[] args) {
		boolean myBoolean = false;
		
		byte myByte = 2;
		
		short myShort = 3;
		
		char myChar = 'T';
		
		int myInt = '5';
		
		float myFloat = 0.25f;
		
		long myLong = 999999999L;
		
		double myDouble = 5.999d;
		
		String myString = new String("This is a String Object, created with a constructor!");
		
		System.out.println("2 + 3 = " + myByte + myShort);
		myBoolean = myInt < 6;
		System.out.println("Is myInt < 6? " + myBoolean);
		System.out.println("Here's some floating point division (myDouble/myFloat): ");
		System.out.println(myDouble/myFloat);
		System.out.println("But what happens when we divide integers? 5 / 2 = ");
		System.out.println(myInt/myByte);
		System.out.println("There's no decimal and no remainder");
		
		
	}
}
