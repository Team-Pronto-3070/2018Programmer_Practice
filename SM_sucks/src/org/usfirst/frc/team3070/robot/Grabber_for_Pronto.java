package org.usfirst.frc.team3070.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


public class Grabber_for_Pronto {
	TalonSRX Lgrab, Rgrab;
	DigitalInput LimitSwitch;
	
	public void Grabber_For_Pronto() {
		Lgrab = new TalonSRX(Pronstants.PORT_LARM);
		Rgrab = new TalonSRX(Pronstants.PORT_RARM);
		LimitSwitch = new DigitalInput(0);
		//int amount_of_genders = 2;
		
	}
	if(sensors.joyL.getRawButton(2)) {
		
	}
}
