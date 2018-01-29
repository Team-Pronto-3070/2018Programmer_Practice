package org.usfirst.frc.team3070.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

//import com.ctre.phoenix.motorcontrol.ControlMode;

public class Extendy_Bit {
	//Modules modules = new Modules();
	Joystick joy;
	boolean state;
	int position = Pronstants.GROUND;
	boolean finished = true;
	
	public Extendy_Bit(Joystick joy) {
		this.joy = joy;
	}
	
	public void loop() {
		state = this.joy.getUpButton();
		if(state) {
			joy.setMotor(ControlMode.PercentOutput, .5);
		}
	}

	/*
	public void extendy_Bit() {
		if(finished) {
			if(modules.JoyL.getRawButton(3) || joy.getUpButton()) {
				if(!(position == 2)) {
					finished = false;
					extend();
				}
			}
			if(modules.JoyL.getRawButton(2) || modules.JoyR.getRawButton(2)) {
				if(!(position == 0)) {
					finished = false;
					extend();
				}
			}
		}
	}	
	
	void extend() {
		if(position == 0) {
			if(!(modules.encLift.get() >= Pronstants.ROTS_TO_SWITCH)) {
				modules.TalExt.set(ControlMode.PercentOutput, 1);
			} else {
				modules.TalExt.set(ControlMode.PercentOutput, 0);
			}
			position++;
			finished = true;
		}
	}
	*/
}