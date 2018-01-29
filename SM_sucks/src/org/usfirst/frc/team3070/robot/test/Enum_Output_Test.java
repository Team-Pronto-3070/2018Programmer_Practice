package org.usfirst.frc.team3070.robot.test;


public class Enum_Output_Test {
	
	public enum test {
		enum_1,
		enum_2,
		enum_3
	}
	static test testvar = test.enum_1;
	public static void main(String[] args) {
		System.out.println(testvar);
	}

}
