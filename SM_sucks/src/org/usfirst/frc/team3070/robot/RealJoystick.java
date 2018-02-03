package org.usfirst.frc.team3070.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

public class RealJoystick implements Joystick {
	Modules modules = new Modules();
	@Override
	public boolean getUpButton() {
		return modules.JoyR.getRawButton(3);
	}
	@Override
	public void setMotor(ControlMode cm, double power) {		
	}

}
