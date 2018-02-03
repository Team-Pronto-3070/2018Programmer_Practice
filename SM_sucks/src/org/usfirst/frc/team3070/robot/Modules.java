package org.usfirst.frc.team3070.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;

public class Modules {
	//Initializing modules
	Encoder encL, encR, encLift; //Encoders
	 //Gyro
	TalonSRX TalRM, TalRF, TalLM, TalLF, TalGrabL, TalGrabR, TalExt; //Talons
	Joystick JoyR, JoyL; //Joysticks
	BNO055 gyro;

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
		
		TalRM.configSelectedFeedbackSensor(com.ctre.phoenix.motorcontrol.FeedbackDevice.QuadEncoder, 0, 0);
		TalLM.configSelectedFeedbackSensor(com.ctre.phoenix.motorcontrol.FeedbackDevice.QuadEncoder, 0, 0);
		encLift = new Encoder(Pronstants.PORT_ENC_LIFT1, Pronstants.PORT_ENC_LIFT2, false); //Lift encoder
		gyro = BNO055.getInstance(BNO055.opmode_t.OPERATION_MODE_IMUPLUS,
				        		BNO055.vector_type_t.VECTOR_EULER);
		JoyR = new Joystick(0); //Right flight joystick
		JoyL = new Joystick(1); //Left flight joystick
	}
}