package org.usfirst.frc.team3070.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Drive {
	
TalonSRX TalRM, TalRF, TalLM, TalLF;
int PORT_RM, PORT_RF,PORT_LM,PORT_LF;

	/**
	 * Constructor for Drive
	 * @param rm right master
	 * @param rf right follower
	 * @param lm left master
	 * @param lf left follower
	 */
	public Drive(int rm,int rf, int lm, int lf) {
		TalRM = new TalonSRX(rm); //Right master Talon
		TalRF = new TalonSRX(rf); //Right follower Talon
		TalLM = new TalonSRX(lm); //Left master Talon
		TalLF = new TalonSRX(lf); //Left follower Talon
	}
	
	/**
	 * Sets right side motors to a certain value
	 * @param amount speed for motors
	 */
	void setRight(double amount) {
		TalRM.set(ControlMode.PercentOutput, amount);
		TalRF.set(ControlMode.Follower, PORT_RM);
	}
	
	/**
	 * Sets left side motors to a certain value
	 * @param amount speed for motors
	 */
	void setLeft(double amount) {
		TalLM.set(ControlMode.PercentOutput, amount);
		TalLF.set(ControlMode.PercentOutput, PORT_LM);
	}
	
	/**
	 * Sets both sides to a certain value
	 * @param amount speed for motors
	 */
	void move(double amount) {
		setRight(amount);
		setLeft(amount);
	}
}
