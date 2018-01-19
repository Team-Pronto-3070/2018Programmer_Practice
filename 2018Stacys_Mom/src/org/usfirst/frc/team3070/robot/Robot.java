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



/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot {
	private static final String kDefaultAuto = "Default";
	private static final String kCustomAuto = "My Auto";
	private String m_autoSelected;
	private SendableChooser<String> m_chooser = new SendableChooser<>();
	
	final int PORT_RM = 3; //Right master CIM port
	final int PORT_RF = 6; //Right follower CIM port
	
	final int PORT_LM = 4; //Left master CIM port
	final int PORT_LF = 5; //Left follower CIM port
	
	final int PORT_ENC_R1 = 1; //Right encoder first port
	final int PORT_ENC_R2 = 2; //Right encoder second port
	
	final int PORT_ENC_L1 = 7; //Left encoder first port
	final int PORT_ENC_L2 = 8; //Left encoder second port
	
	public enum Auto_Path{ //List of all possible paths (PATH_[Starting Position][Scale or Switch][Right or Left Side])
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
	
	//Initializing encoders
	Encoder encR = new Encoder(PORT_ENC_R1, PORT_ENC_R2, false); //Right encoder
	Encoder encL = new Encoder(PORT_ENC_L1, PORT_ENC_L2, false); //Left encoder
	
	//Initializing Talons
	TalonSRX TalRM = new TalonSRX(PORT_RM); //Right master Talon
	TalonSRX TalRF = new TalonSRX(PORT_RF); //Right follower Talon
	TalonSRX TalLM = new TalonSRX(PORT_LM); //Left master Talon
	TalonSRX TalLF = new TalonSRX(PORT_LF); //Left follower Talon
	
	//Initializing classes
	Drive drive;
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_chooser.addDefault("Default Auto", kDefaultAuto);
		m_chooser.addObject("My Auto", kCustomAuto);
		SmartDashboard.putData("Auto choices", m_chooser);
		drive = new Drive(PORT_RM,PORT_RF,PORT_LM,PORT_LF);
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional comparisons to
	 * the switch structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomousInit() {
		m_autoSelected = m_chooser.getSelected();
		// autoSelected = SmartDashboard.getString("Auto Selector",
		// defaultAuto);
		System.out.println("Auto selected: " + m_autoSelected);
	}

	Auto_Path impPath =  Auto_Path.PATH_LCL; //Implemented path. 
	
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
				
					break;	
				}
				break;
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		
		
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
	 /**
	  * Sets right side motors to a certain amount, given by arg
	  */
	void setRight(double amount) {
		TalRM.set(ControlMode.PercentOutput, amount);
		TalRF.set(ControlMode.Follower, PORT_RM);
	}
	/**
	  * Sets left side motors to a certain amount, given by arg
	  */
	void setLeft(double amount) {
		TalLM.set(ControlMode.PercentOutput, amount);
		TalLF.set(ControlMode.Follower, PORT_LF);
	}
}
