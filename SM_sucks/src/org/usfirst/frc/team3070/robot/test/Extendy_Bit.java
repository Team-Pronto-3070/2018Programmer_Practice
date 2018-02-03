package org.usfirst.frc.team3070.robot.test;

import com.ctre.phoenix.motorcontrol.ControlMode;
import org.usfirst.frc.team3070.robot.Pronstants;

public class Extendy_Bit {
	Joystick joy;
	Encoder encLift;
	TalonSRX TalExt;
	boolean state;
	Pronstants.positions position = Pronstants.positions.Ground;

	public Extendy_Bit(TalonSRX fj) {
		this.joy = fj;
	}

	public void loop() {
		state = this.joy.getRawButton(1);
		if (state) {
			TalExt.set(ControlMode.PercentOutput, .5);
		}
	}

	/*public Extendy_Bit(Joystick JoyR, Joystick JoyL, Encoder encLift, TalonSRX TalExt) {
		this.JoyR = JoyR;
		this.JoyL = JoyL;
		this.encLift = encLift;
		this.TalExt = TalExt;
		encLift.reset();
	}

	public void run() {
		if (JoyR.getRawButton(3) || JoyL.getRawButton(3)) {
			extend();
		}
		if (JoyR.getRawButton(2) || JoyL.getRawButton(2)) {
			retract();
		}
	}

	void extend() {
		if (position == Pronstants.positions.Ground) {
			if (position != Pronstants.positions.Transit) {
				if (!(encLift.get() >= Pronstants.ROT_TO_SWITCH)) {
					position = Pronstants.positions.Transit;
					TalExt.set(ControlMode.PercentOutput, 1);
				} else {
					TalExt.set(ControlMode.PercentOutput, 0);
					position = Pronstants.positions.Switch;
				}
			}
		} else if (position == Pronstants.positions.Switch) {
			if (position != Pronstants.positions.Transit) {
				if (!(encLift.get() >= Pronstants.ROT_TO_SCALE)) {
					position = Pronstants.positions.Transit;
					TalExt.set(ControlMode.PercentOutput, 1);
				} else {
					TalExt.set(ControlMode.PercentOutput, 0);
					position = Pronstants.positions.Scale;
				}
			}
		} else if (position == Pronstants.positions.Scale) {
			System.out.println("Cannot extend farther");
		}
	}

	void retract() {
		if (position == Pronstants.positions.Ground) {
			System.out.println("Cannot retract farther");
		} else if (position == Pronstants.positions.Switch) {
			if (position != Pronstants.positions.Transit) {
				if (!(encLift.get() <= 0)) {
					position = Pronstants.positions.Transit;
					TalExt.set(ControlMode.PercentOutput, -1);
				} else {
					TalExt.set(ControlMode.PercentOutput, 0);
					position = Pronstants.positions.Ground;
				}
			}
		} else if (position == Pronstants.positions.Scale) {
			if (position != Pronstants.positions.Transit) {
				if (!(encLift.get() <= Pronstants.ROT_TO_SWITCH)) {
					position = Pronstants.positions.Transit;
					TalExt.set(ControlMode.PercentOutput, -1);
				} else {
					TalExt.set(ControlMode.PercentOutput, 0);
					position = Pronstants.positions.Switch;
				}
			}
		}
	}
*/
}