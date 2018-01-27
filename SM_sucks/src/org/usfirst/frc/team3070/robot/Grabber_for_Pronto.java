package org.usfirst.frc.team3070.robot;

import edu.wpi.first.wpilibj.DigitalInput;

import com.ctre.phoenix.motorcontrol.ControlMode;
<<<<<<< HEAD
=======
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
>>>>>>> a8b1c47c3b3d6413adf63a8c630bfc99f5d751d6

public class Grabber_for_Pronto {
	DigitalInput LimitSwitch;
<<<<<<< HEAD
	Modules modules;

	public void setGrabs(double power) {
		modules.TalGrabL.set(ControlMode.PercentOutput, power);
		modules.TalGrabR.set(ControlMode.PercentOutput, power);
	}

	public void Grabber_For_Pronto() {
		LimitSwitch = new DigitalInput(0);
		if (modules.JoyL.getRawButton(1)) {
			setGrabs(.5);
		}
		if (LimitSwitch.get()) {
			setGrabs(0);
		}
		if (modules.JoyL.getRawButton(4)) {
			modules.TalGrabL.set(ControlMode.PercentOutput, .3);
		}
		if (modules.JoyR.getRawButton(5)) {
			modules.TalGrabR.set(ControlMode.PercentOutput, .3);
		}
	}
}
=======
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

	if(sensors.joyL.getRawButton(1))

	{
		setGrabs(.5);
	}if(LimitSwitch.get()==1)
	{
		setGrabs(0);
	}if(sensors.joyL.getRawButton(4))
	{
		Lgrab.set(ControlMode.PercentOutput, .3);
	}if(sensors.joyR.getRawButtom(5))
	{
		Rgrab.set(ControlMode.PercentOutput, .3);
	}

}
>>>>>>> a8b1c47c3b3d6413adf63a8c630bfc99f5d751d6
