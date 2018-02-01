/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package org.usfirst.frc.team3070.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.AnalogGyro;
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

	// Initializing Gyros
	//AnalogGyro gyro = new AnalogGyro(Pronstants.PORT_GYRO); // gyro used for turning in auto


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
		
		modules = new Modules();
		auto = new Auto(drive, modules);
		drive = new Drive(modules);
		Extendy_Bit = new Extendy_Bit(modules);
		//Grabber_for_Pronto = new Grabber_for_Pronto(modules);
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
	 * 
	 */
	@Override
	public void autonomousInit() {
		m_autoSelected = m_chooser.getSelected();// allows you to know that auto is selected (auto gen)
		// autoSelected = SmartDashboard.getString("Auto Selector",
		// defaultAuto);
		System.out.println("Auto selected: " + m_autoSelected);
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		drive.setLeft(.5);
		drive.setRight(.5);
		System.out.println("auto periodic");
		//auto.AutoCode();
		/*switch (m_autoSelected) {
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
				if (gyro.getAngle() >= 90 || gyro.getAngle() >= 180) {
					drive.setRight(0);
					drive.setLeft(0);
					Turned = true;
				}
				if (gyro.getAngle() >= 90 && Turned) {
					drive.setRight(Pronstants.STANDARD_SPEED);
					drive.setLeft(Pronstants.STANDARD_SPEED);
				}
				break;
			}
			break;
		}*/
	}

	/**`	
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		//modules.TalLM.set(ControlMode.PercentOutput, .5);
		// left joystick driving for the robot
		
		
		if (modules.JoyL.getRawAxis(1) >= .2 || modules.JoyL.getRawAxis(1) <= -.2) {
			drive.setLeft(.5); // sets the motors to the joysticks position, with a dead zone of |.2|
		} else {
			drive.setLeft(0);// stops robot if joystick is in the dead zone
		} // right joystick driving the robot

		if (modules.JoyR.getRawAxis(1) >= .2 || modules.JoyR.getRawAxis(1) <= -.2) {
			drive.setRight(.5);
		} else {// sets motor to joysticks position, with a dead zone of |.2|
			drive.setRight(0);// stops robot if joystick is in the dead zone
		}


	}
	void Disabled() {
		while(isDisabled()) {}
	}

	@Override
	public void testPeriodic() {
		SmartDashboard.putString("DB/String 2", "encL value" + Double.toString(modules.encL.get()));
		SmartDashboard.putString("DB/String 3", "encR value" + Double.toString(modules.encR.get()));
		SmartDashboard.putString("DB/String 4", "gyro value" + Double.toString(modules.gyro.getAngle()));
	}
}