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
	/**
	  * Sets left side motors to a certain amount, given by arg
	  */
	void setLeft(double amount) {
		TalLM.set(ControlMode.PercentOutput, amount);
		TalLF.set(ControlMode.Follower, PORT_LF);
	}
	void stop(boolean stoping) {
		setRight(0);
		setLeft(0);
	}
	void move(double moving) {
		TalLM.set(ControlMode.PercentOutput, moving);
		TalLF.set(ControlMode.Follower, PORT_LF);
		TalRM.set(ControlMode.PercentOutput, moving);
		TalRF.set(ControlMode.Follower, PORT_RM);
		
	}
}
