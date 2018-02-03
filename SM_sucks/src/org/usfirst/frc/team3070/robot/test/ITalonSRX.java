package org.usfirst.frc.team3070.robot.test;

import com.ctre.phoenix.motorcontrol.ControlMode;

public interface ITalonSRX {
	
	public void set(ControlMode cm, double power, String TalName);
	public double getSpeed(String TalName);
}
