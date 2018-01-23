package org.usfirst.frc.team3070.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Encoder;
public class Drive {
	
TalonSRX TalRM, TalRF, TalLM, TalLF;
Encoder encR,encL;
int PORT_RM, PORT_RF,PORT_LM,PORT_LF;
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
		
	}
	}
		
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
}
