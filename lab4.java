import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;


public class lab4 
{
	/**
	 * Run the exercises to ensure we got the right answers
	 */
	public void runExercises() 
	{
		System.out.println("Running exercise 1 solution...");
		exercise1();
		System.out.println("Running exercise 2 solution...");
		exercise2();
		System.out.println("Running exercise 3 solution...");
		exercise3();
		System.out.println("Running exercise 4 solution...");
		exercise4();
		
	}

	/**
	 * All exercises should be completed using Lambda expressions and the new
	 * methods added to JDK 8 where appropriate. There is no need to use an
	 * explicit loop in any of the code. Use method references rather than full
	 * lambda expressions wherever possible.
	 */
	/**
	 * Exercise 1
	 *
	 * Create a string that consists of the first letter of each word in the
	 * list of Strings provided.
	 */
	interface func1
	{
		String printString (List a);
		
		
	}
	interface func2 
	{
		String manipulatedStrings (List<String> a);
	}
	private String printedString (List a, func1 fobj)
	{
		return fobj.printString(a);
	} 
	
	private  String manipulatedString (List a, func2 fobj)
	{
		return fobj.manipulatedStrings(a);
	}
	
	interface func3 
	{
		List <String> evenLengths(List <String> a);
	}
	
	private List<String> listedEvenLengths (List a, func3 fobj)
	{
		return fobj.evenLengths(a);
	}
	
	private void exercise1() 
	{
		
		List<String> list = Arrays.asList("alpha", "bravo", "charlie", "delta", "echo", "foxtrot");
		//list.forEach (word -> {System.out.println(word.charAt(0));});
		StringBuilder str = new StringBuilder ();
	//	func1 fLetter1 = {word, List<String> l) -> l.forEach.(str.append(word.charAt(0)));	}
		
		//func1 fLetter1 = (word) -> list.forEach(str.append(word.charAt(0));
		
		func2 fLetter2 = (List<String> l) -> l.stream().map(word -> String.valueOf(word.charAt(0))).collect(Collectors.toList()).toString();
		
		
		//word -> { System.out.println(word.charAt(0));});
		lab4 obj = new lab4();
		String strw = obj.manipulatedString(list, fLetter2);
		System.out.println(strw);
	}

	/**
	 * Exercise 2
	 *
	 * Remove the words that have even lengths from the list.
	 */
	/*
	private String printedOdd(List a, func1 fobj)
	{
		return fobj.printString(a);
	} */
	private void exercise2() {
		List<String> list = new ArrayList<>(Arrays.asList("alpha", "bravo", "charlie", "delta", "echo", "foxtrot"));
		
		list.forEach(word -> { if (word.length()%2 !=0)
									System.out.println(word);
		});
		
		lab4 obj = new lab4 ();
		
		func3 oddWords = (List<String> l) -> l.stream().filter(word -> (word.length()%2 !=0)).collect(Collectors.toList());
		
		List<String> newWords = obj.listedEvenLengths(list, oddWords);
		for(String e: list)
		{
			System.out.println(e);
		}
		
	}

	/**
	 * Exercise 3

	 *
	 * Replace every word in the list with its upper case equivalent.
	 */
	
	/*private String printedUpperCase(List a, func1 fobj)
	{
		return fobj.printString(a);
	}
	*/
	private void exercise3() {
		List<String> list = new ArrayList<>(Arrays.asList("alpha", "bravo", "charlie", "delta", "echo", "foxtrot"));
		/*(list.forEach(word -> {System.out.println(word.toUpperCase());});
		*/
		lab4 obj = new lab4();
		func1 printUpper = (List words) -> words.toString().toUpperCase();
		
		System.out.println(obj.printedString(list, printUpper));
	}

	/**
	 * Exercise 4
	 *
	 * Convert every key-value pair of the map into a string and append them all
	 * into a single string, in iteration order.
	 */
	
	interface func4 
	{
		String printMap(Map a);
		
	}
	
	
	private String printedMap(Map a , func4 fobj)
	{
		return fobj.printMap(a);
	}
	
	private void exercise4() {
		Map<String, Integer> map = new TreeMap<>();
		map.put("c", 3);
		map.put("b", 2);
		map.put("a", 1);

		map.forEach((a,b)  -> {	StringBuilder str = new StringBuilder();
								str.append(a);
								str.append(b);
								System.out.print(str);
		});
		
	
	}
	/**
	 * Main entry point for application
	 *
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		lab4 lab = new lab4();
		lab.runExercises();
		//lab.exercise3();
		//func1 printFirst;
		//func1 printMap;
				
				
		//System.out.println(obj.printedString(list, printFirst));
		//System.out.println(obj.printedString(list, printOdd));
		//System.out.println(obj.printedString(map, printedMap));
	}
}



/*
Running exercise 1 solution...
a
b
c
d
e
f
Running exercise 2 solution...
alpha
bravo
charlie
delta
foxtrot
Running exercise 3 solution...
ALPHA
BRAVO
CHARLIE
DELTA
ECHO
FOXTROT
Running exercise 4 solution...
a1b2c3


Running exercise 1 solution...
a
b
c
d
e
f
Running exercise 2 solution...
alpha
bravo
charlie
delta
foxtrot
Running exercise 3 solution...
[ALPHA, BRAVO, CHARLIE, DELTA, ECHO, FOXTROT]
Running exercise 4 solution...
a1b2c3
*/