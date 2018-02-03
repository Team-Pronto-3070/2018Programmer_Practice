package org.usfirst.frc.team3070.robot.test;

import com.ctre.phoenix.motorcontrol.ControlMode;

public interface ITalonSRX {
	void set(ControlMode cm, double power);
	double getSpeed();
}
