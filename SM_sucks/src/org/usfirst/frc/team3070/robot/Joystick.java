package org.usfirst.frc.team3070.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

public interface Joystick {

	public boolean getUpButton();
	
	public void setMotor(ControlMode cm, double power);
}
