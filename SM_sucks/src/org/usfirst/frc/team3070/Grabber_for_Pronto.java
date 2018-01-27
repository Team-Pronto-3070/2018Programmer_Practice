package org.usfirst.frc.team3070;

import edu.wpi.first.wpilibj.DigitalInput;

import com.ctre.phoenix.motorcontrol.ControlMode;

public class Grabber_for_Pronto {
	DigitalInput LimitSwitch; // Limit switch for turning off belts
	Modules modules = new Modules(); // Initialize Modules class

	/**
	 * Sets both belts, with left inverted
	 * 
	 * @param power
	 */

	public void setGrabs(double power) { // Sets both belts
		modules.TalGrabL.setInverted(true);
		modules.TalGrabL.set(ControlMode.PercentOutput, power); // Sets left belt
		modules.TalGrabR.set(ControlMode.PercentOutput, power); // Sets right belt
	}

	public void Grabber_For_Pronto() {
		LimitSwitch = new DigitalInput(Pronstants.PORT_LS); // Sets limit switch port
		if (modules.JoyR.getRawButton(1) || modules.JoyL.getRawButton(1)) { // If the trigger is
			setGrabs(Pronstants.STRONG_SPEED);
		}
		if (LimitSwitch.get()) { // If limit switch is pressed
			setGrabs(0); // Stops motors
		}
		if (modules.JoyR.getRawButton(4) || modules.JoyL.getRawButton(4)) { // If button 4 is pressed
			modules.TalGrabL.set(ControlMode.PercentOutput, Pronstants.STANDARD_SPEED); // Sets left motor
		}
		if (modules.JoyR.getRawButton(5) || modules.JoyR.getRawButton(5)) { // If button 5 is pressed
			modules.TalGrabR.set(ControlMode.PercentOutput, Pronstants.STANDARD_SPEED); // Sets right motor
		}
	}
}