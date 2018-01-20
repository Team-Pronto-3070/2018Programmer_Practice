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
	boolean noMovement;
	void setRight(double amount) {
		if(noMovement==false) {
		TalRM.set(ControlMode.PercentOutput, amount);
		TalRF.set(ControlMode.Follower, PORT_RM);
	}
	}
	/**
	  * Sets left side motors to a certain amount, given by arg
	  */
	void setLeft(double amount) {
		if (noMovement==false) {
		TalLM.set(ControlMode.PercentOutput, amount);
		TalLF.set(ControlMode.Follower, PORT_LF);
	}
	}
	void stop(boolean stopping) {
		if(stopping==true) {
		setRight(0);
		setLeft(0);
		noMovement = true;
	}else {
		noMovement = false;
	}
		
	}
	void move(double moving) {
		if(noMovement==false) {
		TalLM.set(ControlMode.PercentOutput, moving);
		TalLF.set(ControlMode.Follower, PORT_LF);
		TalRM.set(ControlMode.PercentOutput, moving);
		TalRF.set(ControlMode.Follower, PORT_RM);
		}
	}
}
