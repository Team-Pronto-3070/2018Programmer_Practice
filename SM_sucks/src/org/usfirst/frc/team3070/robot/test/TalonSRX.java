package org.usfirst.frc.team3070.robot.test;

import com.ctre.phoenix.motorcontrol.ControlMode;

public class TalonSRX implements ITalonSRX {
	ControlMode cm;
	double power;
	final double ROTS_PER_SECOND = 120;
	String TalOne;
	double TalOneSpeed;
	String TalTwo;
	double TalTwoSpeed;
	String TalThree;
	double TalThreeSpeed;
	String TalFour;
	double TalFourSpeed;
	String TalFive;
	double TalFiveSpeed;

	public TalonSRX(String TalName) {
		if (TalOne != null) {
			TalOne = TalName;
		} else if (TalTwo != null) {
			TalTwo = TalName;
		} else if (TalThree != null) {
			TalThree = TalName;
		} else if (TalFour != null) {
			TalFour = TalName;
		} else if (TalFive != null) {
			TalFive = TalName;
		} else {
			System.out.println("screw you");
		}
	}

	@Override
	public void set(ControlMode cm, double power, String TalName) {
		if (TalName != null) {
			if(TalName == TalOne) {
				TalOneSpeed = power;
			}
			else if(TalName == TalTwo) {
				TalTwoSpeed = power;
			}
			else if(TalName == TalThree) {
				TalThreeSpeed = power;
			}
			else if(TalName == TalFour) {
				TalFourSpeed = power;
			}
			else if(TalName == TalFive) {
				TalFiveSpeed = power;
			} else {
				System.out.println("screw you");
			}
			this.cm = cm;
			this.power = power;
			System.out.println(TalName + " ");
			System.out.print("ControlMode: " + this.cm);
			System.out.println("Power: " + this.power);
		}
	}

	@Override
	public double getSpeed(String TalName) {
		if(TalName == TalOne) {
			power = TalOneSpeed;
		}
		else if(TalName == TalTwo) {
			power = TalTwoSpeed;
		}
		else if(TalName == TalThree) {
			power = TalThreeSpeed;
		}
		else if(TalName == TalFour) {
			power = TalFourSpeed;
		}
		else if(TalName == TalFive) {
			power = TalFiveSpeed;
		} else {
			System.out.println("screw you");
		}
		double speed = ROTS_PER_SECOND * power;
		return speed;
	}

}
