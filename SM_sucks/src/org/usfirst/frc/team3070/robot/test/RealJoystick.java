package org.usfirst.frc.team3070.robot.test;

import org.usfirst.frc.team3070.robot.Modules;

public class RealJoystick implements Joystick {
	Modules modules = new Modules();
	@Override
	public boolean getRawButton(int ButNum) {
		return modules.JoyR.getRawButton(ButNum);
	}
}
