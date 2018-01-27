package src.org.usfirst.frc.team3070.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;

public class Sensors {
	Encoder encL, encR;
	AnalogGyro gyro;
	TalonSRX TalRM, TalRF, TalLM, TalLF;
	Joystick JoyR, JoyL;

	/**
	 * Constructor for sensors
	 */
	@SuppressWarnings("unused")
	public Sensors() {

		// Initializing encoders, gyro and talons
		TalRM = new TalonSRX(Pronstants.PORT_RM); // Right master Talon
		TalRF = new TalonSRX(Pronstants.PORT_RF); // Right follower Talon
		TalLM = new TalonSRX(Pronstants.PORT_LM); // Left master Talon
		TalLF = new TalonSRX(Pronstants.PORT_LF); // Left follower Talon
		encR = new Encoder(Pronstants.PORT_ENC_R1, Pronstants.PORT_ENC_R2, false); // Right encoder
		encL = new Encoder(Pronstants.PORT_ENC_L1, Pronstants.PORT_ENC_L2, false); // Left encoder
		JoyR = new Joystick(0);
		JoyL = new Joystick(1);
	}
}