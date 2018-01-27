package org.usfirst.frc.team3070.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

public class Extendy_Bit {
	Sensors sensors;

	public Extendy_Bit() {
		Sensors sensors = new Sensors();
		if (sensors.JoyR.getRawButton(3) || sensors.JoyL.getRawButton(3)) {
			sensors.encLift.reset();
			sensors.TalExt.setInverted(Pronstants.UP_INVERTION);
			if (sensors.encLift.get() <= 30) {
				sensors.TalExt.set(ControlMode.PercentOutput, 1);
			}
			else {
				sensors.TalExt.set(ControlMode.PercentOutput, 0);
			}

		}
		if (sensors.JoyR.getRawButton(2) || sensors.JoyL.getRawButton(2)) {
			sensors.encLift.reset();
			sensors.TalExt.setInverted(Pronstants.DOWN_INVERTION);
			if (sensors.encLift.get() <= 30) {
				sensors.TalExt.set(ControlMode.PercentOutput, 1);
			}
			else {
				sensors.TalExt.set(ControlMode.PercentOutput, 0);
			}
		}
	}

}
