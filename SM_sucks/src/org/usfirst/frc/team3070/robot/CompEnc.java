package org.usfirst.frc.team3070.robot;

import edu.wpi.first.wpilibj.Encoder;

public class CompEnc {

	Encoder enc;
	double encInit;

	public CompEnc(Encoder enc) {
		this.enc = enc;
		enc.setDistancePerPulse(4096);
		encInit = this.enc.getDistance();
	}

	public double getDistance() {
		return enc.getDistance() - encInit;
	}

	public void reset() {
		enc.reset();
	}
}
