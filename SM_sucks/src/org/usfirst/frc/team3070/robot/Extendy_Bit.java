package org.usfirst.frc.team3070.robot;

//modules
import com.ctre.phoenix.motorcontrol.ControlMode;

public class Extendy_Bit {

	boolean extended = false;
	boolean moving;
	Modules modules;
public Extendy_Bit(Modules modules) {
		this.modules = modules;
		

		if (modules.JoyR.getRawButton(3) || modules.JoyL.getRawButton(3)) { // If button 3 (Middle button on top)
			if (!extended) {// If the lift is not completely extended          is pressed
				moving = true;
				if(moving) {
					modules.encLift.reset(); // Resets gyro
				}
				modules.TalExt.setInverted(Pronstants.UP_INVERTION); // Sets Talon to the invertion for going up
				if (modules.encLift.get() <= 30) { // If motor is not done moving
					modules.TalExt.set(ControlMode.PercentOutput, 1);
				} else { // If the motor is done extending
					modules.TalExt.set(ControlMode.PercentOutput, 0); //Stops motors
					extended = true; //Sets extended to true
					moving = false;
				}
			}
		}
		if (modules.JoyR.getRawButton(2) || modules.JoyL.getRawButton(2)) {
			if (extended) {// If the lift is not completely extended          is pressed
				moving = true;
				if(moving) {
					modules.encLift.reset(); // Resets gyro
				}
				modules.TalExt.setInverted(Pronstants.DOWN_INVERTION); // Sets Talon to the invertion for going up
				if (modules.encLift.get() <= 30) { // If motor is not done moving
					modules.TalExt.set(ControlMode.PercentOutput, 1);
				} else { // If the motor is done extending
					modules.TalExt.set(ControlMode.PercentOutput, 0); //Stops motors
					extended = false; //Sets extended to true
					moving = false;
				}
			}
		}
}
}