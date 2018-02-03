package org.usfirst.frc.team3070.robot.test;

import org.usfirst.frc.team3070.robot.Modules;

import com.ctre.phoenix.motorcontrol.ControlMode;

public class RealJoystick implements Joystick {
	Modules modules = new Modules();
	@Override
	public boolean getRawButton(int ButNum) {
		return modules.JoyR.getRawButton(ButNum);
	}
}
