package com.test.run;

public class PracticeParameter {
	int salary;
	
	public PracticeParameter(int salary){
		this.salary =salary;
	}//end
	
	public void getSalary(){//static = No
		
		System.out.println(salary);
		
	}
	
	
	public static void main(String[] args) {
		PracticeParameter obj = new PracticeParameter(7000);
		obj.getSalary();
		
	}

}
