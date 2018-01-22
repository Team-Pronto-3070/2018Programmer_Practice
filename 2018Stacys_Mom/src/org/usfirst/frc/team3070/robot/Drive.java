package org.usfirst.frc.team3070.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Encoder;
import org.usfirst.frc.team3070.robot.Robot;
public class Drive {
	
	@SuppressWarnings("unused")
TalonSRX TalRM, TalRF, TalLM, TalLF;
	Robot robot = new Robot();
final int PORT_RM = robot.PORT_RM;
final int PORT_RF = robot.PORT_RF;
final int PORT_LM = robot.PORT_LM;
final int PORT_LF = robot.PORT_LF;
	void initialize() {
		TalRM = new TalonSRX(PORT_RM); //Right master Talon
		TalRF = new TalonSRX(PORT_RF); //Right follower Talon
		TalLM = new TalonSRX(PORT_LM); //Left master Talon
		TalLF = new TalonSRX(PORT_LF); //Left follower Talon
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
	void stop(boolean stopping) {
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
