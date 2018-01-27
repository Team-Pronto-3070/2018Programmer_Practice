package org.usfirst.frc.team3070.robot;

public interface Pronstants {

	final int PORT_RM = 2; // Right master CIM port
	final int PORT_RF = 5; // Right follower CIM port

	final int PORT_LM = 0; // Left master CIM port
	final int PORT_LF = 1; // Left follower CIM port

	final int PORT_ENC_R1 = 1; // Right encoder first port
	final int PORT_ENC_R2 = 2; // Right encoder second port

	final int PORT_ENC_L1 = 7; // Left encoder first port
	final int PORT_ENC_L2 = 8; // Left encoder second port

	final double STANDARD_SPEED = .3;
	final double WEAK_SPEED = -.5;
	final double STRONG_SPEED = .5;
	final int PORT_GYRO = 9;
	
	public enum Auto_Path { // List of all possible paths (PATH_[Left, Center, or Right starting
						   // position][sCale or sWitch][Right or Left Side])
		PATH_LCL, // Left starting position combinations
		PATH_LWL, PATH_LCR, PATH_LWR,
		
		PATH_CCL, // Center starting position combinations
		PATH_CWL, PATH_CCR, PATH_CWR,
		
		PATH_RCL, // Right starting position combinations
		PATH_RWL, PATH_RCR, PATH_RWR
	}

	final double PI = 3.141; // Variable equal to pi
	final double DIS_TO_AUTO_LINE = 120; // Distance in inches to the auto line
	final double DIS_TO_SWITCH = 168; // Distance in inches to the middle of the switch
	final double DIS_TO_SCALE = 324; // Distance in inches to the middle of the scale
	final double WHEEL_DIAMETER = 6; // Distance in inches of wheel diameter
	final double WHEEL_CIRCUM = WHEEL_DIAMETER * PI; // Distance in inches of wheel circumference
	final double ROT_TO_AUTO_LINE = DIS_TO_AUTO_LINE / WHEEL_CIRCUM; // Number of rotations to the autoline
	final double ROT_TO_SWITCH = DIS_TO_SWITCH / WHEEL_CIRCUM; // Number of rotations to the middle of the switch
	final double ROT_TO_SCALE = DIS_TO_SCALE / WHEEL_CIRCUM; // Number of rotations to the middle of the scale
}
