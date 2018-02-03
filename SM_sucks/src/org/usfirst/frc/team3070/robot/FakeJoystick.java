<<<<<<< HEAD:SM_sucks/src/org/usfirst/frc/team3070/robot/test/FakeJoystick.java
/*package org.usfirst.frc.team3070.robot.test;
=======
package org.usfirst.frc.team3070.robot;
>>>>>>> parent of c870df3... clearing list 2/2:SM_sucks/src/org/usfirst/frc/team3070/robot/FakeJoystick.java

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
*/