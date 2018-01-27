package org.usfirst.frc.team3070;

import com.ctre.phoenix.motorcontrol.ControlMode;

public class Extendy_Bit {
	Modules modules;

	public Extendy_Bit() {
		Modules modules = new Modules();
		if (modules.JoyR.getRawButton(3) || modules.JoyL.getRawButton(3)) {
			modules.encLift.reset();
			modules.TalExt.setInverted(Pronstants.UP_INVERTION);
			if (modules.encLift.get() <= 30) {
				modules.TalExt.set(ControlMode.PercentOutput, 1);
			}
			else {
				modules.TalExt.set(ControlMode.PercentOutput, 0);
			}

		}
		if (modules.JoyR.getRawButton(2) || modules.JoyL.getRawButton(2)) {
			modules.encLift.reset();
			modules.TalExt.setInverted(Pronstants.DOWN_INVERTION);
			if (modules.encLift.get() <= 30) {
				modules.TalExt.set(ControlMode.PercentOutput, 1);
			}
			else {
				modules.TalExt.set(ControlMode.PercentOutput, 0);
			}
		}
	}

}
