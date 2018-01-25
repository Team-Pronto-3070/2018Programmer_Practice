// Welcome to the Auto class here we have all the auto code in an easy!
package src.org.usfirst.frc.team3070.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.AnalogGyro;
<<<<<<< HEAD

=======
>>>>>>> a2d613ec0d522d48fe2238b98bcce7f973191af7

<<<<<<< HEAD
public class Auto {
	public enum Auto_Path { // List of all possible paths (PATH_[Left, Center, or Right starting
=======
public class Auto implements Pronstants {
	Drive drive;
	Sensors sensors;

	/**
	 * Constructor for auto
	 * 
	 * @param d
	 *            Drive
	 * @param s
	 *            Sensors
	 */
	public Auto(Drive d, Sensors s) {
		drive = d;
		sensors = s;
	}


	public enum Auto_Path { // List of all possible paths (PATH_[Left, Center, or Right starting

							// postition][sCale or sWitch][Right or Left Side])
							// max numbers of fowards possible

	public enum Auto_Path
	{ // List of all possible paths (PATH_[Left, Center, or Right starting
<<<<<<< HEAD

	public enum Auto_Path
	{ // List of all possible paths (PATH_[Left, Center, or Right starting

=======
>>>>>>> 55e75067a78964c03a32a45669d3ab5db525f904
>>>>>>> 1eff99ad1ee34d889c73820be95645343219d522
>>>>>>> a2d613ec0d522d48fe2238b98bcce7f973191af7
							// position][sCale or sWitch][Right or Left Side])
							// max numbers of forwards possible

		Forward1, Forward2, Foward3, Foward4,

		// max number of turns needed
		Turn1, Turn2, Turn3, Turn4,

		// Right starting position combinations

	}

<<<<<<< HEAD
		// Strings for auto selector
		private static final String kDefaultAuto = "Default";
		private static final String kCustomAuto = "My Auto";
		private String m_autoSelected;
		Auto_Path impPath;

		// Variables used in subcodes-need to change later
		boolean Turned = false;
		int case_number = 1;
=======
	// Strings for auto selector
	private static final String kDefaultAuto = "Default";
	private static final String kCustomAuto = "My Auto";
	private String m_autoSelected;
	Auto_Path impPath = Auto_Path.Forward1;
	Encoder encR = new Encoder(Pronstants.PORT_ENC_R1, Pronstants.PORT_ENC_R2, false); // Right encoder
	Encoder encL = new Encoder(Pronstants.PORT_ENC_L1, Pronstants.PORT_ENC_L2, false); // Left encoder
>>>>>>> a2d613ec0d522d48fe2238b98bcce7f973191af7

	// Variables used in subcodes-need to change later
	boolean Turned = false;
	int case_number = 1;
	boolean square = true;
	boolean triangle = true;

	/**
	 * Runs state machine to select which auto to run
	 */
	public void auto() {
		switch (m_autoSelected) {
		case kCustomAuto:
			// Put custom auto code here
			break;
		case kDefaultAuto:
		default:
			switch (impPath) {
			case Forward1 :
<<<<<<< HEAD
				if(EncR <= 15 && EncL <= 15 ) {
					drive.move(STRONG_SPEED, 15);
					}
				
			else {
				drive.stop(true);
=======
				if(encR.get() <= 15 && encL.get() <= 15 ) {
					Drive.driveForward(15);
					}
				
			else {
<<<<<<< HEAD
				Drive.move(0);
				}
			encR.reset();
			encL.reset();
			impPath = Auto_Path.Turn1;
=======
				drive.move(0)}
>>>>>>> a2d613ec0d522d48fe2238b98bcce7f973191af7
			encR.reset;
			encL.reset;

			}
			Auto_PATH = Turn1;

			Auto_Path = Turn1
<<<<<<< HEAD

=======
>>>>>>> 1eff99ad1ee34d889c73820be95645343219d522
>>>>>>> a2d613ec0d522d48fe2238b98bcce7f973191af7
			
					}
			
				

				break;

			case Turn1:
				if (square) {
					drive.setRight(STRONG_SPEED);
					drive.setLeft(WEAK_SPEED);
					if(sensors.gyro.get() >= 90) {
						drive.setRight(0);
						drive.setLeft(0);
						Auto_Path = Forward2;
						
					}
				
				else if (triangle) {
					drive.setRight(STRONG_SPEED);
					drive.setLeft(WEAK_SPEED);
					if(sensors.gyro.get() >= 60) {
						drive.setRight(0);
						drive.setLeft(0);
						Auto_Path = Forward2;	
					}
				}
				encL.reset;
				encR.reset;
				}

				break;
			case Forward2:
				if(square) {
					drive.driveForward();
				}
				if (encL.get() >= 15 && encR.get() >= 15) {
					drive.move(0);
					Auto_Path = Turn2;
				}
				
				

				break;
			case Turn2:
				if (square) {
					setRight(STRONG_SPEED);
					setLeft(WEAK_SPEED);
				}
				if(sensors.gyro.get() >= 90) {
					drive.move(0);
					 
				}
				if(triangle) {
					setRight(STRONG_SPEED);
					setLeft(WEAK_SPEED);
				}
				if(sensors.gyro.get() >= 60) {
					drive.move(0);
					Auto_Path = Forward3
				}
				break;
			case Forward3:
				if(square) {
					drive.driveForward;
				}
				if(encL.get() >= 15 && encR.get() >=15) {
					drive.stop();
					Auto_Path = Turn3;
				}
				break;
			case Turn3:
				if(square) {
					setLeft(WEAK_SPEED);
					setRight(STRONG_SPEED);
				}
				if(gyro.get() >= 90) {
					drive.stop();
					Auto_Path = Forward4;
				}
				break;
			case Forward4 :
				if(square) {
					drive.driveForward();
				}
				if(encL.get() >= 15 && encR.get() >= 15) {
					drive.stop();
					Auto_Path = Turn4
				}
				break;
			case Turn4:
				if(square) {
					setLeft(WEAK_SPEED);
					setRight(STRONG_SPEED);
				}
				if(gyro.get() >= 90) {
					drive.stop();
				}
				break;
			
		}
	}

		/**
		 * Code for RCR
		 * 
		 * @param RCR
		 *            state the code starts at
		 */
		public void RCR(int RCR) {

			switch (RCR) {
			case 1:
				drive.move(STANDARD_SPEED);// sets both sides to same speed
				if (sensors.encR.get() >= ROT_TO_SCALE && sensors.encL.get() >= ROT_TO_SCALE) {
					RCR = 2;
					// when robot reaches the scale RCR = 2 and turning happens
				}
				break;
			case 2:
				drive.setRight(STRONG_SPEED);
				drive.setLeft(WEAK_SPEED);
				if (sensors.gyro.getAngle() >= 90 && sensors.encR.get() >= ROT_TO_SCALE
						&& sensors.encL.get() >= ROT_TO_SCALE) {
					RCR = 3;
				}
				break;
			case 3:
				drive.setRight(0);
				drive.setRight(0);
				Turned = true;
				if (sensors.gyro.getAngle() >= 90 && Turned) {
					RCR = 4;
				}
				break;
			case 4:
				// insert code for raising cube and placing in the scale
			}

		}

		/**
		 * Code for RWR
		 */
		public void RWR() {
			drive.setRight(STANDARD_SPEED);// sets motors on the right to .5 speed
			drive.setLeft(STANDARD_SPEED);// sets motors on the left to .5 speed
			if (sensors.encR.get() >= ROT_TO_AUTO_LINE && sensors.encL.get() >= ROT_TO_AUTO_LINE) {
				drive.setRight(STRONG_SPEED);
				drive.setLeft(WEAK_SPEED);

			}
			if (sensors.gyro.getAngle() >= 90 || sensors.gyro.getAngle() >= 180) {
				drive.setRight(0);
				drive.setLeft(0);
				Turned = true;
			}
			if (sensors.gyro.getAngle() >= 90 && Turned) {
				drive.setRight(STANDARD_SPEED);
				drive.setLeft(STANDARD_SPEED);
			}
		}
}
