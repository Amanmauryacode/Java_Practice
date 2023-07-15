package com.masai.cw;

import java.util.*;

public interface Stack {
	 void push(int element) throws OverflowException;
	  int pop() throws UnderflowException;
	  int peek() throws UnderflowException;
	  static String displayStackElements(int stack[]){
		
		return Arrays.toString(stack);
	    //write code to convert the stack elements to comma separate String sequence from index 0 to top
	  }
}
