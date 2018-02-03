package org.usfirst.frc.team3070.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;

public class Modules {
	// Initializing modules
	Encoder encLBase, encRBase, encLiftBase; // Encoders
	CompEnc encL, encR, encLift;
	AnalogGyro gyro; // Gyro
	TalonSRX TalRM, TalRF, TalLM, TalLF, TalGrabL, TalGrabR, TalExt; // Talons
	public Joystick JoyR; // Joysticks=
	Joystick JoyL;

	/**
	 * Constructor for sensors init
	 */
	public Modules() {

		// Setting modules
		TalRM = new TalonSRX(Pronstants.PORT_RM); // Right master Talon
		TalRF = new TalonSRX(Pronstants.PORT_RF); // Right follower Talon
		TalLM = new TalonSRX(Pronstants.PORT_LM); // Left master Talon
		TalLF = new TalonSRX(Pronstants.PORT_LF); // Left follower Talon
		TalGrabL = new TalonSRX(Pronstants.PORT_GL); // Left master Talon
		TalGrabR = new TalonSRX(Pronstants.PORT_GR); // Left follower Talon
		TalExt = new TalonSRX(Pronstants.PORT_EXT); // Extendy Talon

		encRBase = new Encoder(Pronstants.PORT_ENC_R1, Pronstants.PORT_ENC_R2, false); // Right encoder
		encLBase = new Encoder(Pronstants.PORT_ENC_L1, Pronstants.PORT_ENC_L2, false); // Left encoder
		encLiftBase = new Encoder(Pronstants.PORT_ENC_LIFT1, Pronstants.PORT_ENC_LIFT2, false); // Lift encoder

		encR = new CompEnc(encRBase);
		encL = new CompEnc(encLBase);
		encLift = new CompEnc(encLiftBase);

		JoyR = new Joystick(0); // Right flight joystick
		JoyL = new Joystick(1); // Left flight joystick
	}
}