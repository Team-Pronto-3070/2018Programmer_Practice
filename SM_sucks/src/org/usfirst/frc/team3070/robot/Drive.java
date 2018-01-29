package org.usfirst.frc.team3070.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Encoder;

public class Drive {
	
	TalonSRX TalRM, TalRF, TalLM, TalLF;
	Encoder encL, encR;

	public Drive(TalonSRX TalRM, TalonSRX TalRF, TalonSRX TalLM, TalonSRX TalLF, Encoder encL, Encoder encR) {
		this.TalRM = TalRM;
		this.TalRF = TalRF;
		this.TalLM = TalLM;
		this.TalLF = TalLF;
		
		this.encL = encL;
		this.encR = encR;
		encL.reset();
		encR.reset();
	}

	/**
	 * Sets right side motors to a certain amount, given by arg
	 * 
	 * @param amountR
	 *            right amount
	 */

	void setRight(double amountR) {
		TalRM.set(ControlMode.PercentOutput, amountR);
		TalRF.set(ControlMode.Follower, Pronstants.PORT_RF);
	}

	/**
	 * Sets left side motors to a certain amount, given by amount
	 * 
	 * @param amountL
	 *            left amount
	 */
	void setLeft(double amountL) {
		TalLM.set(ControlMode.PercentOutput, amountL);
		TalLF.set(ControlMode.Follower, Pronstants.PORT_LF);
	}

	void stop() { // Sets both sides to 0
		setRight(0);
		setLeft(0);
	}

	/**
	 * Sets both side to a certain speed, and continues for a certain amount of
	 * rotations
	 * 
	 * @param moving
	 *            Speed, -1 to 1
	 * @param rotations
	 *            Amount of rotations
	 */
	void move(double moving, int rotations) {

		if (encR.getDistance() < rotations && encL.getDistance() < rotations) {
			setRight(moving);
			setLeft(moving);
		} else {
			stop();

		}
	}

	/**
	 * Sets both sides to a certain value
	 * 
	 * @param amount
	 *            speed for motors
	 */

}