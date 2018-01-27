package org.usfirst.frc.team3070;

import edu.wpi.first.wpilibj.DigitalInput;

import com.ctre.phoenix.motorcontrol.ControlMode;

public class Grabber_for_Pronto {
	DigitalInput LimitSwitch;
	Modules modules;

	public void setGrabs(double power) {
		modules.TalGrabL.set(ControlMode.PercentOutput, power);
		modules.TalGrabR.set(ControlMode.PercentOutput, power);
	}

	public void Grabber_For_Pronto() {
		LimitSwitch = new DigitalInput(0);
		if (modules.JoyL.getRawButton(1)) {
			setGrabs(.5);
		}
		if (LimitSwitch.get()) {
			setGrabs(0);
		}
		if (modules.JoyL.getRawButton(4)) {
			modules.TalGrabL.set(ControlMode.PercentOutput, .3);
		}
		if (modules.JoyR.getRawButton(5)) {
			modules.TalGrabR.set(ControlMode.PercentOutput, .3);
		}
	}
}