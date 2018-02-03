/*package org.usfirst.frc.team3070.robot.test;

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

}
*/