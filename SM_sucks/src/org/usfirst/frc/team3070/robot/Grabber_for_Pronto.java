<<<<<<< HEAD
=======
package org.usfirst.frc.team3070.robot;

import edu.wpi.first.wpilibj.DigitalInput;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


public class Grabber_for_Pronto {
	TalonSRX Lgrab, Rgrab;
	DigitalInput LimitSwitch;
	Sensors sensors;
	
	public void setGrabs(double power) {
		Lgrab.set(ControlMode.PercentOutput, power);
		Rgrab.set(ControlMode.PercentOutput, power);
	
	}
	
		public void Grabber_For_Pronto() {
		Lgrab = new TalonSRX(Pronstants.PORT_LARM);
		Rgrab = new TalonSRX(Pronstants.PORT_RARM);
		LimitSwitch = new DigitalInput(0);
		
			
	}
	if(sensors.joyL.getRawButton(1)) {
		setGrabs(.5);
	}
	if(LimitSwitch.get() == 1) {
		setGrabs(0);
	}
	if(sensors.joyL.getRawButton(4)) {
		Lgrab.set(ControlMode.PercentOutput, .3);
	}
	if(sensors.joyR.getRawButtom(5)) {
		Rgrab.set(ControlMode.PercentOutput, .3);
	}
	
}
>>>>>>> master
