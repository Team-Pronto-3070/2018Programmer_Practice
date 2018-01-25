/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package org.usfirst.frc.team3070.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.AnalogGyro;
import org.usfirst.frc.team3070.robot.Drive;
import org.usfirst.frc.team3070.robot.Pronstants;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
@SuppressWarnings("unused")
public class Robot extends IterativeRobot implements Pronstants {
	private static final String kDefaultAuto = "Default";
	private static final String kCustomAuto = "My Auto";
	private String m_autoSelected;
	private SendableChooser<String> m_chooser = new SendableChooser<>();

	Joystick JoyR = new Joystick(0);
	Joystick JoyL = new Joystick(1);


	// Initializing class instances
	Drive drive;
	Pronstants pronstants;
	Sensors sensors;
	Auto auto;

	boolean Turned = false;

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

	// declaring classes
	Drive drive;
	// Initializing Gyros-caused crashess
	AnalogGyro gyro = new AnalogGyro(PORT_GYRO);

	Encoder encR = new Encoder(pronstants.PORT_ENC_R1, pronstants.PORT_ENC_R2, false); // Right encoder
	Encoder encL = new Encoder(pronstants.PORT_ENC_L1, pronstants.PORT_ENC_L2, false); // Left encoder

	// Initializing Talons
	TalonSRX TalRM = new TalonSRX(pronstants.PORT_RM); // Right master Talon
	TalonSRX TalRF = new TalonSRX(pronstants.PORT_RF); // Right follower Talon
	TalonSRX TalLM = new TalonSRX(pronstants.PORT_LM); // Left master Talon
	TalonSRX TalLF = new TalonSRX(pronstants.PORT_LF); // Left follower Talon


	final int PORT_RM = 2; // Right master CIM port
	final int PORT_RF = 5; // Right follower CIM port

	final int PORT_LM = 0; // Left master CIM port
	final int PORT_LF = 1; // Left follower CIM port

	final int PORT_ENC_R1 = 1; // Right encoder first port

	final int PORT_ENC_L1 = 7; // Left encoder first port
	final int PORT_ENC_L2 = 8; // Left encoder second port

	final double STANDARD_SPEED = .3;
	final double WEAK_SPEED = -.3;
	final double STRONG_SPEED = .5;
	final int PORT_GYRO = 0;

	final double PI = 3.141; // Variable equal to pi
	final double DIS_TO_AUTO_LINE = 120; // Distance in inches to the auto line
	final double DIS_TO_SWITCH = 168; // Distance in inches to the middle of the switch
	final double DIS_TO_SCALE = 324; // Distance in inches to the middle of the scale
	final double WHEEL_DIAMETER = 6; // Distance in inches of wheel diameter
	final double WHEEL_CIRCUM = WHEEL_DIAMETER * PI; // Distance in inches of wheel circumference
	final double ROT_TO_AUTO_LINE = DIS_TO_AUTO_LINE / WHEEL_CIRCUM; // Number of rotations to the autoline
	final double ROT_TO_SWITCH = DIS_TO_SWITCH / WHEEL_CIRCUM; // Number of rotations to the middle of the switch
	final double ROT_TO_SCALE = DIS_TO_SCALE / WHEEL_CIRCUM; // Number of rotations to the middle of the scale
	// Initializing class instances
	Drive drive;
	Pronstants pronstants;

	boolean Turned = false;

	public enum Auto_Path { // List of all possible paths (PATH_[Left, Center, or Right starting
							// postition][sCale or sWitch][Right or Left Side])
		PATH_LCL, // Left starting position combinations
		PATH_LWL, PATH_LCR, PATH_LWR,

		PATH_CCL, // Center starting position combinations
		PATH_CWL, PATH_CCR, PATH_CWR,

		PATH_RCL, // Right starting position combinations
		PATH_RWL, PATH_RCR, PATH_RWR
	}

	// Initializing encoders
	// Encoder encR = new Encoder(PORT_ENC_R1, PORT_ENC_R2, false); //Right encoder
	// Encoder encL = new Encoder(PORT_ENC_L1, PORT_ENC_L2, false); //Left encoder

	// Initializing Talons
	TalonSRX TalRM = new TalonSRX(PORT_RM); // Right master Talon
	TalonSRX TalRF = new TalonSRX(PORT_RF); // Right follower Talon
	TalonSRX TalLM = new TalonSRX(PORT_LM); // Left master Talon
	TalonSRX TalLF = new TalonSRX(PORT_LF); // Left follower Talon


	// declaring classes
	Drive drive;
	// Initializing Gyros-caused crashess
	AnalogGyro gyro=new AnalogGyro(PORT_GYRO);

	
	// Initializing and declaring Gyros-caused crashes

	 Sensors sensors;
	Auto auto;

	Encoder encR = new Encoder(pronstants.PORT_ENC_R1, pronstants.PORT_ENC_R2, false); // Right encoder
	Encoder encL = new Encoder(pronstants.PORT_ENC_L1, pronstants.PORT_ENC_L2, false); // Left encoder

	// Initializing Talons
	TalonSRX TalRM = new TalonSRX(pronstants.PORT_RM); // Right master Talon
	TalonSRX TalRF = new TalonSRX(pronstants.PORT_RF); // Right follower Talon
	TalonSRX TalLM = new TalonSRX(pronstants.PORT_LM); // Left master Talon
	TalonSRX TalLF = new TalonSRX(pronstants.PORT_LF); // Left follower Talon


	// Initializing Gyros
	AnalogGyro gyro = new AnalogGyro(pronstants.PORT_GYRO);

	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_chooser.addDefault("Default Auto", kDefaultAuto);
		m_chooser.addObject("My Auto", kCustomAuto);
		SmartDashboard.putData("Auto choices", m_chooser);

		drive = new Drive(PORT_RM, PORT_RF, PORT_LM, PORT_LF);
		sensors = new Sensors();
		auto = new Auto(drive, sensors);
	}
	SmartDashboard.putData("Auto choices",m_chooser);




	
	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable chooser
	 * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
	 * remove all of the chooser code and uncomment the getString line to get the
	 * auto name from the text box below the Gyro
	 *
	 * <p>
	 * You can add additional auto modes by adding additional comparisons to the
	 * switch structure below with additional strings. If using the SendableChooser
	 * make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomousInit() {
		m_autoSelected = m_chooser.getSelected();
		// autoSelected = SmartDashboard.getString("Auto Selector",
		// defaultAuto);
		System.out.println("Auto selected: " + m_autoSelected);
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {

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

					break;
					case PATH_RWR:
					drive.setRight(pronstants.STANDARD_SPEED);//sets motors on the right to .5 speed
					drive.setLeft(pronstants.STANDARD_SPEED);//sets motors on the left to .5 speed
					if( encR.get() >= pronstants.ROT_TO_AUTO_LINE && encL.get() >= pronstants.ROT_TO_AUTO_LINE){
						drive.setRight(pronstants.STRONG_SPEED);
						drive.setLeft(pronstants.WEAK_SPEED);
						
					}
					if(gyro.getAngle() >= 90 || gyro.getAngle() >= 180) {
						drive.setRight(0);
						drive.setLeft(0);
						Turned = true; 
					}
					if(gyro.getAngle() >= 90 && Turned) {
						drive.setRight(pronstants.STANDARD_SPEED);
						drive.setLeft(pronstants.STANDARD_SPEED);
					}
					break;	
				}
				break;
		}
		
		auto.auto();
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		double amountL = (-1 * (JoyL.getRawAxis(1)/* * (-1 * (JoyL.getRawAxis(2) / 2)) */));
		if (amountL >= .2 || amountL <= -.2) {
			drive.setLeft(amountL);
		} else {
			drive.stopL(true);
		}
		double amountR = (-1 * (JoyR.getRawAxis(1)/* * (-1 * (JoyR.getRawAxis(2) / 2)) */));
		if (amountR >= .2 || amountR <= -.2) {
			drive.setRight(amountR);
		} else {
			drive.stopR(true);
		}

		if (JoyR.getRawButton(1) || JoyL.getRawButton(1)) {
			System.out.println("pew pew");
		}

	}

	@Override
	public void testPeriodic() {
	}

}
