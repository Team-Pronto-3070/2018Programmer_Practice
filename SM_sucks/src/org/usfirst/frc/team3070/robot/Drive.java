package org.usfirst.frc.team3070.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

public class Drive {

	Sensors sensors = new Sensors();

	// open variables:
	/**
	 * Sets right side motors to a certain amount, given by arg
	 * @param amountR
	 * 				right amount
	 */

	void setRight(double amountR) {
		sensors.TalRM.set(ControlMode.PercentOutput, amountR);
		sensors.TalRF.set(ControlMode.Follower, Pronstants.PORT_RF);
	}

	/**
	 * Sets left side motors to a certain amount, given by arg
	 * @param amountL
	 * 				left amount
	 */
	void setLeft(double amountL) {
		sensors.TalLM.set(ControlMode.PercentOutput, amountL);
		sensors.TalLF.set(ControlMode.Follower, Pronstants.PORT_LF);
	}

	void stop() {
		setRight(0);
		setLeft(0);
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

	void move(double moving, int rotations) {

		if (sensors.encR.getDistance() < rotations && sensors.encL.getDistance() < rotations) {
			setRight(moving);
			setLeft(moving);
		} else {
			sensors.encR.reset();
			sensors.encL.reset();
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
