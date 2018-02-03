package org.usfirst.frc.team3070.robot.test;

public class FakeJoystick implements Joystick {
	Joystick joy;
	boolean state = true;
	RealJoystick rj = new RealJoystick();
	
	@Override
	public boolean getRawButton(int ButNum) {
		setState();
		return state;
	}
	
	public void setState() {
		if((Math.random() * 10) % 2 == 0) {
			state = true;
		} else {
			state = false;
		}
	}

}