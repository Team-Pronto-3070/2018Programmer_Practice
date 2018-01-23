package org.usfirst.frc.team3070.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Drive {
	
TalonSRX TalRM, TalRF, TalLM, TalLF;
Encoder encR,encL;
int PORT_RM, PORT_RF,PORT_LM,PORT_LF;
<<<<<<< HEAD
	public Drive(int rm,int rf, int lm, int lf, int encoderR1, int encoderR2, int encoderL1, int encoderL2) {
		TalRM = new TalonSRX(2); //Right master Talon
		TalRF = new TalonSRX(5); //Right follower Talon
		TalLM = new TalonSRX(0); //Left master Talon
		TalLF = new TalonSRX(1); //Left follower Talon
		encR = new Encoder(encoderR1, encoderR2, false); //Right encoder
		encL = new Encoder(encoderL1, encoderL2, false); //Left encoder
	}
	//open variables:
	 /**
	  * Sets right side motors to a certain amount, given by arg
	  */

	void setRight(double amountR) {

		TalRM.set(ControlMode.PercentOutput, amountR);
		TalRF.set(ControlMode.Follower, PORT_RF);
	}
	
	/**
	  * Sets left side motors to a certain amount, given by arg
	  */
	void setLeft(double amountL) {
	
		TalLM.set(ControlMode.PercentOutput, amountL);
		TalLF.set(ControlMode.Follower, PORT_LF);
	}
	
	void stopR(boolean stoppingR) {
		if(stoppingR==true) {
		setRight(0);
		stoppingR=false;
		}
	}
	void stopL(boolean stoppingL) {
		if (stoppingL==true) {
			setLeft(0);
		stoppingL = false;
		
=======

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
>>>>>>> 00b52997e03f47bbfe7de392c8bc812f6faac7f6
	}
	
	/**
	 * Sets both sides to a certain value
	 * @param amount speed for motors
	 */
	void move(double amount) {
		setRight(amount);
		setLeft(amount);
	}
<<<<<<< HEAD
		
	void move(double moving, int rotations) {

		if (encR.getDistance() < rotations && encL.getDistance() < rotations) {
			setRight(moving);
			setLeft(moving);
		}else {
			encR.reset();
			encL.reset();
			setRight(0);
			setLeft(0);
			
		}
		
	}
=======
>>>>>>> 00b52997e03f47bbfe7de392c8bc812f6faac7f6
}
