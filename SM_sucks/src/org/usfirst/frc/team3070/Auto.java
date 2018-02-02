// Welcome to the Auto class here we have all the auto code in an easy!
package org.usfirst.frc.team3070;
//drive and modules
public class Auto {
	public enum Auto_Path { // List of all possible paths (PATH_[Left, Center, or Right starting

		// position][sCale or sWitch][Right or Left Side])
		// max numbers of forwards possible

		Forward1, Forward2, Forward3, Forward4,

		// max number of turns needed
		Turn1, Turn2, Turn3, Turn4

		// Right starting position combinations

	}

	// Strings for auto selector
	private static final String kDefaultAuto = "Default";
	private static final String kCustomAuto = "My Auto";
	private String m_autoSelected;
	Auto_Path impPath = Auto_Path.Forward1;

	// Variables used in subcodes-need to change later
	
	boolean Turned = false;
	int case_number = 1;
	boolean square = true;
	boolean triangle = true;
	Drive drive;
	Modules modules;
	/**
	 * Runs state machine to select which auto to run
	 */
	public Auto(Drive drive, Modules modules) {
		this.drive = drive;
		this.modules = modules;
		switch (m_autoSelected) {
		case kCustomAuto:
			// Put custom auto code here
			break;
		case kDefaultAuto:
		default:
			switch (impPath) {
			case Forward1://first forward of either square or triangle
				if (modules.encR.get() <= 15 && modules.encL.get() <= 15) {
					drive.move(.3, 15);//sets speed of motors and for how many revolutions the wheel go for
				}

				else {
					drive.move(.3, 0);//stops robot if 
				}
				modules.encR.reset();//resets the encoders so that the following case machines will have accurate enc values
				modules.encL.reset();
				impPath = Auto_Path.Turn1;//starts next phase
				
				break;

			case Turn1:
				if (square) {//turning for if the course is the square
					drive.setRight(Pronstants.STRONG_SPEED);//set motors to strong and weak speeds, will cause the robot to turn
					drive.setLeft(Pronstants.WEAK_SPEED);
					if (modules.gyro.getAngle() >= 90) {//gyro will tell the robot to stop when it has turned 90 degrees
						drive.setRight(0);
						drive.setLeft(0);//robot then stops to prevent turning excessively
						impPath = Auto_Path.Forward2;//starts next phase 
					}

					else if (triangle) {
						drive.setRight(Pronstants.STRONG_SPEED);//turning for specifically the triangle 
						drive.setLeft(Pronstants.WEAK_SPEED);//these speeds cause robot to turn 
						if (modules.gyro.getAngle() >= 60) {//when the robot turns 60 degrees, the gyro will stop the robot
							drive.setRight(0);// the robot will stop at 60 degrees in hopes to make an equilateral triangle
							drive.setLeft(0);
							impPath = Auto_Path.Forward2;//advances to the next step
						}
					}
					modules.encL.reset();//encoders are reset for accurate driving forward
					modules.encR.reset();
				}

				break;
			case Forward2:
				if (square) {
					drive.move(.3, 15);//driving forward after the first turn
				}//sqaure and triangle dont need to be differentiated because their side lengths are the same 
				if (modules.encL.get() >= 15 && modules.encR.get() >= 15) {
					drive.stop();//when the encoders reach fifteen rotations, the robot will stop 
					impPath = Auto_Path.Turn2;//advances to the next action
				}

				break;
			case Turn2:
				if (square) {
					drive.setRight(Pronstants.STRONG_SPEED);//if the path is square the robot will turn 90 degrees
					drive.setLeft(Pronstants.WEAK_SPEED);
				}
				if (modules.gyro.getAngle() >= 90) {
					drive.stop();//when 90 degrees is reached, the robot is stopped

				}
				if (triangle) {//if triangle is selected, then the robot will turn for 60 degrees
					drive.setRight(Pronstants.STRONG_SPEED);
					drive.setLeft(Pronstants.WEAK_SPEED);
				}
				if (modules.gyro.getAngle() >= 60) {
					drive.stop();//when robot has turned 60 degrees, it stop and proceed to the next straight
					impPath = Auto_Path.Forward3;
				}
				break;
			case Forward3:
				if (square || triangle) {//both paths will lead to going through this 
					drive.move(.3, 0);
				}//when the motors have rotated 15 times, robot will stop and move on to next step
				if (modules.encL.get() >= 15 && modules.encR.get() >= 15) {
					drive.stop();
					impPath = Auto_Path.Turn3;
				}
				break;
			case Turn3:
				if (square) {
					drive.setLeft(Pronstants.WEAK_SPEED);
					drive.setRight(Pronstants.STRONG_SPEED);//turning for the square only becuase the triangle only requires two turns
				}
				if (modules.gyro.getAngle() >= 90) {
					drive.stop();
					impPath = Auto_Path.Forward4;//from now on only the square will be executed
				}
				break;
			case Forward4:
				if (square) {
					drive.move(.3, 0);//moving forward 15 rotations, stopping and moving on to the next step
				}
				if (modules.encL.get() >= 15 && modules.encR.get() >= 15) {
					drive.stop();
					impPath = Auto_Path.Turn4;
				}
				break;
			case Turn4:
				if (square) {//final turn of the square and then the robot stops, completing the square
					drive.setLeft(Pronstants.WEAK_SPEED);
					drive.setRight(Pronstants.STRONG_SPEED);
				}
				if (modules.gyro.getAngle() >= 90) {
					drive.stop();
				}
				break;
			}
		}
	}

	/**
	 * Code for RCR
	 * 
	 * @param RCR
	 *            state the code starts at
	 */
	

	/**
	 * Code for RWR
	 */

}