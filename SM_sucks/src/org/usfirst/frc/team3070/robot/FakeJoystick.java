package org.usfirst.frc.team3070.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

public class FakeJoystick implements Joystick {

	boolean state = true;
	public ControlMode cm;
	public double power; 
	RealJoystick rj = new RealJoystick();
	@Override
	public boolean getUpButton() {
		setState();
		return state;
	}
	
	public void setState() {
		if(state) {
			state = false;
		}
		if(!state) {
			state = true;
		}
	}

	@Override
	public void setMotor(ControlMode cm, double power) {
		this.cm = cm;
		this.power = power;
		System.out.print("ControlMode: " + this.cm);
		System.out.println("Power: " + this.power);
	}

}
