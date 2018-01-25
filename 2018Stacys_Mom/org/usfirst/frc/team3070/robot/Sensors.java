package org.usfirst.frc.team3070.robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;

public class Sensors {
	Encoder encL, encR;
	AnalogGyro gyro;

	/**
	 * Constructor for sensors
	 */
	public Sensors() {

		// Initializing encoders
		encR = new Encoder(Pronstants.PORT_ENC_R1, Pronstants.PORT_ENC_R2, false); // Right encoder
		encL = new Encoder(Pronstants.PORT_ENC_L1, Pronstants.PORT_ENC_L2, false); // Left encoder
	}
}
