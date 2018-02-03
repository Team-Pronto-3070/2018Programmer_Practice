package org.usfirst.frc.team3070.robot.test;

import com.ctre.phoenix.time.StopWatch;

public class Encoder implements IEncoder {

	double rotations = 0;
	StopWatch sw;
	double time;
	TalonSRX tsrx;

	public Encoder() {
		sw.start();
		tsrx = new TalonSRX(0);
	}

	@Override
	public double getDistance() {
		rotations = tsrx.getSpeed() * sw.getDuration();
		return rotations;
	}

	@Override
	public void reset() {
		sw.start();
		rotations = 0;
	}
}
