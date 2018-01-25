// Welcome to the Auto class here we have all the auto code in an easy!
package org.usfirst.frc.team3070.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.AnalogGyro;
import org.usfirst.frc.team3070.robot.Drive;

public class Auto implements Pronstants {
	Drive drive;
	Sensors sensors;

	/**
	 * Constructor for auto
	 * 
	 * @param d
	 *            Drive
	 * @param s
	 *            Sensors
	 */
	public Auto(Drive d, Sensors s) {
		drive = d;
		sensors = s;
	}

	public enum Auto_Path
	{ // List of all possible paths (PATH_[Left, Center, or Right starting
							// postition][sCale or sWitch][Right or Left Side])
		// max numbers of fowards possible
		Forward1, Forward2, Foward3, Foward4,

		//max number of turns needed
		Turn1, Turn2, Turn3, Turn4,

		// Right starting position combinations
		
	}

	// Strings for auto selector
	private static final String kDefaultAuto = "Default";
	private static final String kCustomAuto = "My Auto";
	private String m_autoSelected;
	Auto_Path impPath;

	// Variables used in subcodes-need to change later
	boolean Turned = false;
	int case_number = 1;

	/**
	 * Runs state machine to select which auto to run
	 */
	public void auto() {
		switch (m_autoSelected) {
		case kCustomAuto:
			// Put custom auto code here
			break;
		case kDefaultAuto:
		default:
			switch (Auto_Path) {
			case Forward1 :
				if(EncR =< 15 && EncL =< 15 ) {
					drive.drvieForward;
					}
				
			else {
				drive.move(0)}
			encR.reset;
			encL.reset;
			Auto_PATH = Turn1
			
					}
			
				

				break;

			case Turn1:
				if (square) {
					drive.setRight(STRONG_SPEED);
					drive.setLeft(WEAK_SPEED);
					if(sensors.gyro.get() >= 90) {
						drive.setRight(0);
						drive.setLeft(0);
						AUTO_PATH = Forward2;
						
					}
				
				else if (triangle) {
					drive.setRight(STRONG_SPEED);
					drive.setLeft(WEAK_SPEED);
					if(sensors.gyro.get() >= 60) {
						drive.setRight(0);
						drive.setLeft(0);
						AUTO_PATH = Forward2;
						
					}
				}
				encL.reset;
				encR.reset;
				}

				break;
			case Forward2:
				if(square) {
					drive.driveForward;
				}
				if (encL.get() >= 15 && encR.get() >= 15) {
					drive.move(0);
					AUTO_PATH = Turn2;
				}
				
				

				break;
			case Turn2:
				if (square) {
					setRight(STRONG_SPEED);
					setLeft(WEAK_SPEED);
				}
				if(sensors.gyro.get() >= 90) {
					drive.move(0);
				}
				if(triangle) {
					setRight(STRONG_SPEED);
					setLeft(WEAK_SPEED);
				}
				if(sensors.gyro.get() >= 60) {
					drive.move(0);
					
				}
				break;
			case Forward3:
				if(square) {
					drive.driveForward;
				}
				if(encL.get() >= 15 && encR.get() >=15) {
					
				}
				break;
			case Turn3:

				break;
			case Forward4 :

				break;
			case Turn4:

				break;
			
		}
	}

	/**
	 * Code for RCR
	 * 
	 * @param RCR
	 *            state the code starts at
	 */
	public void RCR(int RCR) {

		switch (RCR) {
		case 1:
			drive.move(STANDARD_SPEED);// sets both sides to same speed
			if (sensors.encR.get() >= ROT_TO_SCALE && sensors.encL.get() >= ROT_TO_SCALE) {
				RCR = 2;
				// when robot reaches the scale RCR = 2 and turning happens
			}
			break;
		case 2:
			drive.setRight(STRONG_SPEED);
			drive.setLeft(WEAK_SPEED);
			if (sensors.gyro.getAngle() >= 90 && sensors.encR.get() >= ROT_TO_SCALE
					&& sensors.encL.get() >= ROT_TO_SCALE) {
				RCR = 3;
			}
			break;
		case 3:
			drive.setRight(0);
			drive.setRight(0);
			Turned = true;
			if (sensors.gyro.getAngle() >= 90 && Turned) {
				RCR = 4;
			}
			break;
		case 4:
			// insert code for raising cube and placing in the scale
		}

	}

	/**
	 * Code for RWR
	 */
	public void RWR() {
		drive.setRight(STANDARD_SPEED);// sets motors on the right to .5 speed
		drive.setLeft(STANDARD_SPEED);// sets motors on the left to .5 speed
		if (sensors.encR.get() >= ROT_TO_AUTO_LINE && sensors.encL.get() >= ROT_TO_AUTO_LINE) {
			drive.setRight(STRONG_SPEED);
			drive.setLeft(WEAK_SPEED);

		}
		if (sensors.gyro.getAngle() >= 90 || sensors.gyro.getAngle() >= 180) {
			drive.setRight(0);
			drive.setLeft(0);
			Turned = true;
		}
		if (sensors.gyro.getAngle() >= 90 && Turned) {
			drive.setRight(STANDARD_SPEED);
			drive.setLeft(STANDARD_SPEED);
		}
	}
}
