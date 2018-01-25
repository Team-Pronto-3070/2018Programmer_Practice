package org.usfirst.frc.team3070.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Encoder;

import org.usfirst.frc.team3070.robot.Robot;

public class Drive {

	@SuppressWarnings("unused")
	TalonSRX TalRM, TalRF, TalLM, TalLF;
	Encoder encR, encL;
	int PORT_RM, PORT_RF, PORT_LM, PORT_LF;

	public Drive(int rm,int rf, int lm, int lf, int encoderR1, int encoderR2, int encoderL1, int encoderL2) {
		TalRM = new TalonSRX(2); //Right master Talon
		TalRF = new TalonSRX(5); //Right follower Talon
		TalLM = new TalonSRX(0); //Left master Talon
		TalLF = new TalonSRX(1); //Left follower Talon
		encR = new Encoder(encoderR1, encoderR2, false); //Right encoder
		encL = new Encoder(encoderL1, encoderL2, false); //Left encoder
	Robot robot = new Robot();
final int PORT_RM = robot.PORT_RM;
final int PORT_RF = robot.PORT_RF;
final int PORT_LM = robot.PORT_LM;
final int PORT_LF = robot.PORT_LF;
	}

	void initialize() {
		TalRM = new TalonSRX(PORT_RM); // Right master Talon
		TalRF = new TalonSRX(PORT_RF); // Right follower Talon
		TalLM = new TalonSRX(PORT_LM); // Left master Talon
		TalLF = new TalonSRX(PORT_LF); // Left follower Talon
	}

	// open variables:
	/**
	 * Sets right side motors to a certain amount, given by arg
	 */

	void setRight(double amountR) {

		TalRM.set(ControlMode.PercentOutput, amountR);
		TalRF.set(ControlMode.Follower, PORT_RF);
	}

	/**
	 * Sets left side motors to a certain amount, given by arg
	 */
	void setLeft(double amountL) {

		TalLM.set(ControlMode.PercentOutput, amountL);
		TalLF.set(ControlMode.Follower, PORT_LF);
	}

	void stopR(boolean stoppingR) {
		if(stoppingR==true) {

	void stop(boolean stopping) {
		setRight(0);
		stoppingR = false;
	}

	}

	void stopL(boolean stoppingL) {
		if (stoppingL == true) {
			setLeft(0);
			stoppingL = false;
		}

	}

	/**
	 * Constructor for Drive
	 * 
	 * @param rm
	 *            right master
	 * @param rf
	 *            right follower
	 * @param lm
	 *            left master
	 * @param lf
	 *            left follower
	 */
	public Drive(int rm, int rf, int lm, int lf) {
		TalRM = new TalonSRX(rm); // Right master Talon
		TalRF = new TalonSRX(rf); // Right follower Talon
		TalLM = new TalonSRX(lm); // Left master Talon
		TalLF = new TalonSRX(lf); // Left follower Talon
	}

	/**
	 * Sets right side motors to a certain value
	 * 
	 * @param amount
	 *            speed for motors
	 *
	 * 
	 * 
	 *            /** Sets both sides to a certain value
	 * @param amount
	 *            speed for motors
	 */
	void move(double amount) {
		setRight(amount);
		setLeft(amount);
	}

	void driveForward() {
		move(STANDARD_SPEED, 15)
	}

	void stop() {
		setLeft(0);
		setRight(0);
	}

	void move(double moving, int rotations) {

		if (encR.getDistance() < rotations && encL.getDistance() < rotations) {
			setRight(moving);
			setLeft(moving);
		} else {
			encR.reset();
			encL.reset();
			stopL(true);
			stopR(true);

		}

	}

}
