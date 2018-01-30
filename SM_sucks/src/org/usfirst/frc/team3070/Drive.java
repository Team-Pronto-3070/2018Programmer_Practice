package org.usfirst.frc.team3070;
//modules
import com.ctre.phoenix.motorcontrol.ControlMode;

public class Drive {
	Modules modules;
	public Drive(Modules modules) {
		this.modules = modules;
	

	/**
	 * Sets right side motors to a certain amount, given by arg
	 * 
	 * @param amountR
	 *            right amount
	 */

	void setRight(double amountR) {
		modules.TalRM.set(ControlMode.PercentOutput, amountR);
		modules.TalRF.set(ControlMode.Follower, Pronstants.PORT_RF);
	}

	/**
	 * Sets left side motors to a certain amount, given by amount
	 * 
	 * @param amountL
	 *            left amount
	 */
	void setLeft(double amountL) {
		modules.TalLM.set(ControlMode.PercentOutput, amountL);
		modules.TalLF.set(ControlMode.Follower, Pronstants.PORT_LF);
	}

	void stop() { // Sets both sides to 0
		setRight(0);
		setLeft(0);
	}
	{
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

		if (modules.encR.getDistance() < rotations && modules.encL.getDistance() < rotations) {
			setRight(moving);
			setLeft(moving);
		} else {
			modules.encR.reset();
			modules.encL.reset();
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
}