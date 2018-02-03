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
import edu.wpi.first.wpilibj.Timer;
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

	// Initializing class instances
	Drive drive;// drive class
	Modules modules;// modules class
	Auto auto;// auto class
	Extendy_Bit Extendy_Bit;//lifting class
	Pronstants Pronstants; //constant class
	//Grabber_for_Pronto Grabber_for_Pronto;//grabbing class
	Timer timer;
	boolean Turned = false; // for telling if robot has turned or not (just sorta here)
	int initLDistance;
	int initRDistance; 
	

	boolean Turned = false; // for telling if robot has turned or not (just sorta here)
	Pronstants.Auto_Path impPath = Pronstants.Auto_Path.PATH_LCL;// initializing the auto path

	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code. ======= /** This function is run when the robot
	 * is first started up and should be used for any initialization code. >>>>>>>
	 * ffb48d0e0e6ff83f29dc5a7e89c241bb229d9a66
	 */
	@Override
	public void robotInit() {
		m_chooser.addDefault("Default Auto", kDefaultAuto);// initializing case machines
		m_chooser.addObject("My Auto", kCustomAuto);
		SmartDashboard.putData("Auto choices", m_chooser);
		Timer timer = new Timer();
		System.out.println("startup");
		timer.start();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * <<<<<<< HEAD between different autonomous modes using the dashboard. The
	 * sendable chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the getString
	 * line to get the auto name from the text box below the Gyro
	 *
	 * <p>
	 * You can add additional auto modes by adding additional comparisons to the
	 * switch structure below with additional strings. If using the SendableChooser
	 * make sure to add them to the chooser code above as well. ======= between
	 * different autonomous modes using the dashboard. The sendable chooser code
	 * works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
	 * remove all of the chooser code and uncomment the getString line to get the
	 * auto name from the text box below the Gyro
	 *
	 * <p>
	 * You can add additional auto modes by adding additional comparisons to the
	 * switch structure below with additional strings. If using the SendableChooser
	 * make sure to add them to the chooser code above as well.
	 * `
	 */
	@Override
	public void autonomousInit() {
		m_autoSelected = m_chooser.getSelected();// allows you to know that auto is selected (auto gen)
		// autoSelected = SmartDashboard.getString("Auto Selector",
		// defaultAuto);
		System.out.println("Auto selected: " + m_autoSelected);
		auto.initencValue = -modules.TalLM.getSelectedSensorPosition(0);
		drive.setLeft(Pronstants.STANDARD_SPEED);
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		switch (m_autoSelected) {
		auto.moveFeetForward(4);
		
	
		case kCustomAuto:
			// Put custom auto code here
			break;
		case kDefaultAuto:
		default:
			switch (impPath) {// case machine we dont use
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
				drive.setRight(Pronstants.STANDARD_SPEED);// sets motors on the right to .5 speed
				drive.setLeft(Pronstants.STANDARD_SPEED);// sets motors on the left to .5 speed
				if (modules.encR.get() >= Pronstants.ROT_TO_AUTO_LINE
						&& modules.encL.get() >= Pronstants.ROT_TO_AUTO_LINE) {
					drive.setRight(Pronstants.STRONG_SPEED);
					drive.setLeft(Pronstants.WEAK_SPEED);

				}
				if (modules.gyro.getAngle() >= Pronstants.RIGHT_ANGLE || modules.gyro.getAngle() >= 2*Pronstants.RIGHT_ANGLE) {
					drive.setRight(0);
					drive.setLeft(0);
					Turned = true;
				}
				if (gyro.getHeading() >= 90 && Turned) {
					drive.setRight(Pronstants.STANDARD_SPEED);
					drive.setLeft(Pronstants.STANDARD_SPEED);
				}
				break;
			}
			break;
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {// left joystick driving for the robot
		double amountL = (-1 * (modules.JoyL.getRawAxis(1)/* * (-1 * (modules.JoyL.getRawAxis(2) / 2)) */));
		if (amountL >= .2 || amountL <= -.2) {
			drive.setLeft(amountL); // sets the motors to the joysticks position, with a dead zone of |.2|
		} else {
			drive.stop();// stops robot if joystick is in the dead zone
		} // right joystick driving the robot
		double amountR = (-1 * (modules.JoyR.getRawAxis(1)/* * (-1 * (modules.JoyR.getRawAxis(2) / 2)) */));
		if (amountR >= .2 || amountR <= -.2) {
			drive.setRight(amountR);
		} else if(modules.JoyR.getRawAxis(1) >= .2){
		} else {// sets motor to joysticks position, with a dead zone of |.2|
			drive.stop();// stops robot if joystick is in the dead zone
		}

	}

	@Override
	public void testPeriodic() {
	}
}