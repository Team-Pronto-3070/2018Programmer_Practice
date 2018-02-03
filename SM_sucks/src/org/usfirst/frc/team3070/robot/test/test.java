package org.usfirst.frc.team3070.robot.test;


import com.ctre.phoenix.motorcontrol.ControlMode;

public class test {
	public static void main(String[] args) {
		TalonSRX fj = new TalonSRX(0);
		fj.setState();
		Extendy_Bit eb = new Extendy_Bit(fj);
		System.out.println("Test start");
		eb.loop();
		if(fj.cm == ControlMode.PercentOutput && fj.power == .5) {
			System.out.println("Test pass");
		} else {
			System.out.println("Test Fail");
		}
		System.out.println("Test end");
	}
}
