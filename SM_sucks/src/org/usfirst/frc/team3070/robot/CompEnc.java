package org.usfirst.frc.team3070.robot;

import edu.wpi.first.wpilibj.Encoder;

public class CompEnc {

	Encoder enc;
	double encInit;

	public CompEnc(Encoder enc) {
		this.enc = enc;
		encInit = this.enc.get();
	}

	public double get() {
		return enc.get() - encInit;
	}

	public void reset() {
		enc.reset();
	}
}
