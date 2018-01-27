package org.usfirst.frc.team3070.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;

public class Modules {
	//Initializing modules
	Encoder encL, encR, encLift; //Encoders
	AnalogGyro gyro; //Gyro
	TalonSRX TalRM, TalRF, TalLM, TalLF, TalGrabL, TalGrabR, TalExt; //Talons
	Joystick JoyR, JoyL; //Joysticks

	/**
	 * Constructor for sensors init
	 */
	public Modules() {

		//Setting modules
		TalRM = new TalonSRX(Pronstants.PORT_RM); // Right master Talon
		TalRF = new TalonSRX(Pronstants.PORT_RF); // Right follower Talon
		TalLM = new TalonSRX(Pronstants.PORT_LM); // Left master Talon
		TalLF = new TalonSRX(Pronstants.PORT_LF); // Left follower Talon
		TalGrabL = new TalonSRX(Pronstants.PORT_GL); // Left master Talon
		TalGrabR = new TalonSRX(Pronstants.PORT_GR); // Left follower Talon
		TalExt = new TalonSRX(Pronstants.PORT_EXT); // Extendy Talon
		
		encR = new Encoder(Pronstants.PORT_ENC_R1, Pronstants.PORT_ENC_R2, false); // Right encoder
		encL = new Encoder(Pronstants.PORT_ENC_L1, Pronstants.PORT_ENC_L2, false); // Left encoder
		encLift = new Encoder(Pronstants.PORT_ENC_LIFT1, Pronstants.PORT_ENC_LIFT2, false); //Lift encoder
		
		JoyR = new Joystick(0); //Right flight joystick
		JoyL = new Joystick(1); //Left flight joystick
	}
}