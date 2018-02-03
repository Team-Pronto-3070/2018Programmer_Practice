package org.usfirst.frc.team3070.robot.test;

import com.ctre.phoenix.time.StopWatch;

public class Encoder implements IEncoder {

	double rotations = 0;
	StopWatch sw;
	double time;
	TalonSRX tsrx = new TalonSRX("test");

	public Encoder() {
		sw.start();
	}

	@Override
	public double get(String TalName) {
		rotations = tsrx.getSpeed(TalName) * sw.getDuration();
		return rotations;
	}

	@Override
	public void reset() {
		sw.start();
		rotations = 0;
	}
}
