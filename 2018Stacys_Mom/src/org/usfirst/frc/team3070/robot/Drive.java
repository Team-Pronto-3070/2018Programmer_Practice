package org.usfirst.frc.team3070.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import org.usfirst.frc.team3070.robot.Robot;

public class Drive {

	Talon SRX TalRM=new TalonSRX(pronstants.PORT_RM); // Right master Talon
	Talon SRX TalRF=new TalonSRX(pronstants.PORT_RF); // Right follower Talon
	TalonSRX TalLM = new TalonSRX(pronstants.PORT_LM); // Left master Talon
	Talon SRXTalLF = new TalonSRX(pronstants.PORT_LF); // Left follower Talon
	Encoder encR = new Encoder(pronstants.PORT_ENC_R1, pronstants.PORT_ENC_R2, false); // Right encoder
	Encoder encL = new Encoder(pronstants.PORT_ENC_L1, pronstants.PORT_ENC_L2, false); // Left encoder

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

	void stop(boolean stopping) {
		setRight(0);
		setLeft(0);
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

	void move(double moving, int rotations) {
	

			if (encR.getDistance() < rotations && encL.getDistance() < rotations) {
				setRight(moving);
				setLeft(moving);
			}else {
				encR.reset();
				encL.reset();
				stopL(true);
				stopR(true);
				
			}

	/**
	 * Sets both sides to a certain value
	 * 
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
		}else {
			encR.reset();
			encL.reset();
			stopL(true);
			stopR(true);

			
		}

}
