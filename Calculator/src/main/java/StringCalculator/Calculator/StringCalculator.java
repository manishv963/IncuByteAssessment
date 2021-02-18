package StringCalculator.Calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import StringCalculator.Calculator.NegativeNumberException;

public class StringCalculator {

	
	public int add(String numbers) throws Exception {
		
		String delim = ",";
		int result =0;
		delim = getDelimetters(numbers);
		if(delim.contains("__")) {
			numbers = delim.split("__")[1];

			delim =delim.split("__")[0];
		}
		
		List<String> linesOfInput = new ArrayList<String>();
		if(numbers.contains("\n")) {
			linesOfInput =  Arrays.asList(numbers.split("\n"));
		}
		
			
			if(linesOfInput.size() == 0) {
				linesOfInput.add(numbers);
			}
			for(String s : linesOfInput) {
				List<String> inputList = Arrays.asList(s.split(delim));
			System.out.println("Input length "+inputList.size());
			int subResult = performAddOperation(inputList);
			if(subResult < 0 ) {
				System.out.println("List contain more than 2 elements");
				return 0;
			}
			 result = result  + subResult;
			}
			return result;
		
		
		
		
	}
	
	public int performAddOperation(List<String> inputList) throws NegativeNumberException{
		
		if(inputList.size()  >0) {
			System.out.println("checking for negative  numbers");
			List<String> negativeNumbersList = (List<String>) inputList.stream()
					
					  .filter(num -> num.contains("-"))
					  .collect(Collectors.toList());
			if(negativeNumbersList.size() > 0 ) {
				
				throw  new NegativeNumberException("Negatives not allowed "+negativeNumbersList.toString());
			}
			
		}
		if(inputList.size()  < 1) {
			System.out.println("Should contain atleast one number");
			return 0;
		}
		else if(inputList.size()  == 1) {
			if(Integer.parseInt(inputList.get(0)) > 1000)
				return 0;
			else
				return Integer.parseInt(inputList.get(0));
		}
		else  if(inputList.size()  == 2)  {
			int num1 =Integer.parseInt(inputList.get(0));
			int num2 =Integer.parseInt(inputList.get(1));
			if(num1 > 1000)
				num1 = 0;
			if(num2> 1000)
				num2 = 0;
			return num1+num2;
		}
		else
		{
			// if the input is more than 2 number
			return -1;
		}
	
	
	}
	
	public String getDelimetters(String numbers) {
		String delim = "";
		if(numbers.contains("[") && numbers.contains("]") ) {
			System.out.println("multiple characters in delimetter");
			int index1 = numbers.indexOf('[');
			int index2 = numbers.indexOf(']');
			delim = numbers.substring(index1+1, index2);
			if(delim.contains("*"))
				delim= "\\\\"+delim;
			delim =delim+"__"+ numbers.substring(index2+1);
			return delim;
		}
		if(numbers.contains("//")) {
			delim = numbers.substring(2, 3);
			if(delim.contains("*"))
				delim= "\\\\"+delim;
			delim =delim+"__"+ numbers.substring(3);
		}
		
		return delim;
	}
}

