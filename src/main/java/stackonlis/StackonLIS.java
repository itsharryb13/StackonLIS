package stackonlis;

//**question 4
//**Harpreet, Luisa, Ryan 
import java.util.Stack;

public class StackonLIS{ //stack used to store the LIS
	public static void main(String[] args) {
		int[]numbers = {4,6,11,3,5,2,4,23,5,3,9,34,36,13,90};
		//Output for length of the (LIS)
		System.out.println(longest_increasing_subsequence(numbers));
			}
	
	
	public static int longest_increasing_subsequence(int[] numbers) {
		//check for null or empty array	
		if (numbers == null || numbers.length == 0) {
			return 0; //return o if array is empty	
		
		}
		
		//stack use to store elements on LIS
		Stack<Integer> stack = new Stack<>();
			stack.push(numbers[0]);//push first element on stack
			
			//Iterate through array 
			for (int i = 1; i < numbers.length; i++) {
				//if the element is greater than the top of the stack 
			if (numbers[i]> stack.peek()) {
				stack.push(numbers[i]); // add current element to LIS
				
			} else {
				//if not greater than top of the stack  
				int count = 0;
				//counter to keep track of elements removed
				//pop elements from stack until finding an element smaller or equal 
				while (!stack.isEmpty()&&stack.peek() < numbers[i]) {
					stack.pop();
					count++;
				}
				
				//add current element to the stack 
			
				stack.push(numbers[i]);
			}
