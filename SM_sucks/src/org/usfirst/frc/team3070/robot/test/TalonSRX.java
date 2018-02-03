package org.usfirst.frc.team3070.robot.test;

import com.ctre.phoenix.motorcontrol.ControlMode;

public class TalonSRX implements ITalonSRX {
	ControlMode cm;
	double power;
	final double ROTS_PER_SECOND = 120;
	int port;

	public TalonSRX(int port) {
		this.port = port;
	}

	@Override
	public void set(ControlMode cm, double power) {
		this.cm = cm; 
		this.power = power;
	}

	@Override
	public double getSpeed() {
		return power;
	}

}
