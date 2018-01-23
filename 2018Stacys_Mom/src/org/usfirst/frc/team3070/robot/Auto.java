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
	public Auto(Drive d, Sensors s) {
		drive = d;
		sensors = s;
	}
	public enum Auto_Path{ //List of all possible paths (PATH_[Left, Center, or Right starting postition][sCale or sWitch][Right or Left Side])
		PATH_LCL, //Left starting position combinations
		PATH_LWL,
		PATH_LCR,
		PATH_LWR,
		
		PATH_CCL, //Center starting position combinations
		PATH_CWL,
		PATH_CCR,
		PATH_CWR,
		
		PATH_RCL, //Right starting position combinations
		PATH_RWL,
		PATH_RCR,
		PATH_RWR
	}
	private static final String kDefaultAuto = "Default";
	private static final String kCustomAuto = "My Auto";
	private String m_autoSelected;
	private SendableChooser<String> m_chooser = new SendableChooser<>();
	Auto_Path impPath;
	boolean Turned = false;
	int case_number = 1;
	
	public void auto() {
		switch (m_autoSelected) {
		case kCustomAuto:
			// Put custom auto code here
			break;
		case kDefaultAuto:
		default:
			switch(impPath) {
				case PATH_LCL:
				
				break;
			
				case PATH_LWL:
				
				break;
				case PATH_LCR:
						
				
				break;
				case PATH_LWR:
					
				break;
				case PATH_CCL:
					
				break;
				case PATH_CWL:
					
				break;
				case PATH_CCR:
					
				break;
				case PATH_CWR:
				
				break;
				case PATH_RCL:
					
				break;
				case PATH_RWL:
					
				break;
				case PATH_RCR:
					RCR(case_number);
						
					

				break;
				case PATH_RWR:
				drive.setRight(STANDARD_SPEED);//sets motors on the right to .5 speed
				drive.setLeft(STANDARD_SPEED);//sets motors on the left to .5 speed
				if(sensors.encR.get() >= ROT_TO_AUTO_LINE && sensors.encL.get() >= ROT_TO_AUTO_LINE){
					drive.setRight(STRONG_SPEED);
					drive.setLeft(WEAK_SPEED);
					
				}
				if(sensors.gyro.getAngle() >= 90 || sensors.gyro.getAngle() >= 180) {
					drive.setRight(0);
					drive.setLeft(0);
					Turned = true; 
				}
				if(sensors.gyro.getAngle() >= 90 && Turned) {
					drive.setRight(STANDARD_SPEED);
					drive.setLeft(STANDARD_SPEED);
				}
				break;	
			}
			break;
	}
}

/**
 * This function is called periodically during operator control.
 */
	
	public void RCR(int RCR) {

		switch(RCR){
			case 1:
				drive.move(STANDARD_SPEED);// sets both sides to same speed
				if(sensors.encR.get()>= ROT_TO_SCALE && sensors.encL.get() >= ROT_TO_SCALE) {
					RCR = 2;
					//when robot reaches the scale RCR = 2 and turning happens
				}
			break;
			case 2:
				drive.setRight(STRONG_SPEED);
				drive.setLeft(WEAK_SPEED);
				if(sensors.gyro.getAngle() >= 90 && sensors.encR.get()>= ROT_TO_SCALE && sensors.encL.get() >= ROT_TO_SCALE ) {
					RCR = 3;
				}
				break;
			case 3:
			drive.setRight(0);
			drive.setRight(0);
			Turned = true;
			if(sensors.gyro.getAngle() >= 90 && Turned ) {
				RCR = 4;
			}
			break;
			case 4:
				//insert code for raising cube and placing in the scale
				}
		
	}
}

