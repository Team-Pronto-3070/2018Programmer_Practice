package org.usfirst.frc.team3070.robot;

public interface Pronstants {
	public final int PORT_RF = 2; // Right master CIM port
	public final int PORT_RM = 5; // Right follower CIM port

	public final int PORT_LF = 0; // Left master CIM port
	public final int PORT_LM = 1; // Left follower CIM port

	public final int PORT_GR = 11;
	public final int PORT_GL = 12;

	public final int PORT_EXT = 13;

	public final int PORT_ENC_R1 = 1; // Right encoder first port
	public final int PORT_ENC_R2 = 2; // Right encoder second port
	public final int PORT_ENC_LIFT1 = 14;
	public final int PORT_ENC_LIFT2 = 15;
	public final int PORT_ENC_L1 = 7; // Left encoder first port
	public final int PORT_ENC_L2 = 8; // Left encoder second port
	
	public final int PORT_LS = 16;
	public final int encTicks = 4096;
	public final double STANDARD_SPEED = .3;
	public final double WEAK_SPEED = -.5;
	public final double STRONG_SPEED = .5;
	
	public static  enum Auto_Path { // List of all possible paths (PATH_[Left, Center, or Right starting
							// postition][sCale or sWitch][Right or Left Side])
		Forward1, Forward2, Forward3, Forward4,
		Turn1, Turn2, Turn3, Turn4;
	}
	
	public final int ROTS_PER_INCH = 2;
	public final double DIST_UP_TO_SWITCH = 12 * 1.5;
	public final int DIST_UP_TO_SCALE = 12 * 7;
	public final double ROTS_TO_SWITCH = ROTS_PER_INCH * DIST_UP_TO_SWITCH;
	public final double ROTS_TO_SCALE = ROTS_PER_INCH * DIST_UP_TO_SCALE;
	
	public final int RIGHT_ANGLE = 90; //Degrees in a right angle
	public final int SHORT_DISTANCE = 15; //Rotations in square distance
	public final int ZERO = 0;
	public final int TRIANGLE_ANGLE = 60;

	public final double PI = 3.141; // Variable equal to pi
	public final double DIST_TO_AUTO_LINE = 120; // Distance in inches to the auto line
	public final double DIST_TO_SWITCH = 168; // Distance in inches to the middle of the switch
	public final double DIST_TO_SCALE = 324; // Distance in inches to the middle of the scale
	public final double WHEEL_DIAMETER = 6; // Distance in inches of wheel diameter
	public final double WHEEL_CIRCUM = WHEEL_DIAMETER * PI; // Distance in inches of wheel circumference
	public final double ROT_TO_AUTO_LINE = DIST_TO_AUTO_LINE / WHEEL_CIRCUM; // Number of rotations to the autoline
	public final double ROT_TO_SWITCH = DIST_TO_SWITCH / WHEEL_CIRCUM; // Number of rotations to the middle of the switch
	public final double ROT_TO_SCALE = DIST_TO_SCALE / WHEEL_CIRCUM; // Number of rotations to the middle of the scale
	
	public enum positions {
		Ground,
		Switch,
		Scale,
		Transit
	}

	public final boolean UP_INVERTION = false;
	public final boolean DOWN_INVERTION = true;
}

//http://gifimage.net/cool-beans-gif-11/