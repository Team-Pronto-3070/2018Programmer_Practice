package org.usfirst.frc.team3070.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Encoder;
public class Drive {
	
TalonSRX TalRM, TalRF, TalLM, TalLF;
int PORT_RM, PORT_RF,PORT_LM,PORT_LF;
	public Drive(int rm,int rf, int lm, int lf) {
		TalRM = new TalonSRX(rm); //Right master Talon
		TalRF = new TalonSRX(rf); //Right follower Talon
		TalLM = new TalonSRX(lm); //Left master Talon
		TalLF = new TalonSRX(lf); //Left follower Talon
	}
	 /**
	  * Sets right side motors to a certain amount, given by arg
	  */
	void setRight(double amount) {
		TalRM.set(ControlMode.PercentOutput, amount);
		TalRF.set(ControlMode.Follower, PORT_RM);
	}
	void setLeft(double amount) {
		TalLM.set(controlMode.PrecentOut, amount);
		TalLF.set(controlMode.PrecentOutput, PORT_LM;
	}
	}
