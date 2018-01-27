package org.usfirst.frc.team3070.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class Grabber_for_Pronto {
	DigitalInput LimitSwitch;
	Sensors sensors;

	public void Grabber_For_Pronto() {
		LimitSwitch = new DigitalInput(0);
		// final int amount_of_genders = 2;

		if (sensors.JoyL.getRawButton(2)) {
			sensors.TalGrabL.set(ControlMode.PercentOutput, .6);
		}
		if (sensors.JoyR.getRawButton(2)) {
			sensors.TalGrabR.set(ControlMode.PercentOutput, .6);
		}
	}
}