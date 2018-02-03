// Welcome to the Auto class here we have all the auto code in an easy!
package org.usfirst.frc.team3070.robot;

import edu.wpi.first.wpilibj.AnalogGyro;

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
	Drive drive;
	boolean Turned = false;
	int case_number = 1;
	boolean square = true;
	boolean triangle = true;
	double init_heading;

	AnalogGyro gyro;
	CompEnc encL, encR;

	public Auto(AnalogGyro gyro, CompEnc encL, CompEnc encR) {
		this.gyro = gyro;
		this.encL = encL;
		this.encR = encR;
		encL.reset();
		encR.reset();
		init_heading = gyro.getAngle();
	}

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
			case Forward1:// first forward of either square or triangle
				if (encR.getDistance() <= Pronstants.SHORT_DISTANCE
						&& encL.getDistance() <= Pronstants.SHORT_DISTANCE) {
					drive.move(Pronstants.WEAK_SPEED, Pronstants.SHORT_DISTANCE);// sets speed of motors and for how
																					// many revolutions the wheel go for
				}

				else {
					drive.move(Pronstants.WEAK_SPEED, Pronstants.ZERO);// stops robot if
				}
				impPath = Auto_Path.Turn1;// starts next phase

				break;

			case Turn1:
				if (square) {// turning for if the course is the square
					drive.setRight(Pronstants.STRONG_SPEED);// set motors to strong and weak speeds, will cause the
															// robot to turn
					drive.setLeft(Pronstants.WEAK_SPEED);

					if ((init_heading - gyro.getAngle()) >= Pronstants.RIGHT_ANGLE) {// gyro will tell the robot to stop
																						// when it has turned
																						// Pronstants.RIGHT_ANGLE
																						// degrees
						drive.setRight(Pronstants.ZERO);
						drive.setLeft(Pronstants.ZERO);// robot then stops to prevent turning excessively
						impPath = Auto_Path.Forward2;// starts next phase
					}

					else if (triangle) {
						drive.setRight(Pronstants.STRONG_SPEED);// turning for specifically the triangle
						drive.setLeft(Pronstants.WEAK_SPEED);// these speeds cause robot to turn
						if ((init_heading - gyro.getAngle()) >= Pronstants.TRIANGLE_ANGLE) {// when the robot turns 60
																							// degrees, the gyro will
																							// stop the robot
							drive.setRight(Pronstants.ZERO);// the robot will stop at 60 degrees in hopes to make an
															// equilateral triangle
							drive.setLeft(Pronstants.ZERO);
							impPath = Auto_Path.Forward2;// advances to the next step
						}
					}
					encL.reset();// encoders are reset for accurate driving forward
					encR.reset();
				}

				break;
			case Forward2:
				if (square) {
					drive.move(Pronstants.WEAK_SPEED, Pronstants.SHORT_DISTANCE);// driving forward after the first turn
				} // sqaure and triangle dont need to be differentiated because their side lengths
					// are the same
				if (encL.getDistance() >= Pronstants.SHORT_DISTANCE
						&& encR.getDistance() >= Pronstants.SHORT_DISTANCE) {
					drive.stop();// when the encoders reach fifteen rotations, the robot will stop
					impPath = Auto_Path.Turn2;// advances to the next action
				}

				break;
			case Turn2:
				if (square) {
					drive.setRight(Pronstants.STRONG_SPEED);// if the path is square the robot will turn
															// Pronstants.RIGHT_ANGLE degrees
					drive.setLeft(Pronstants.WEAK_SPEED);
				}
				if ((init_heading - gyro.getAngle()) >= Pronstants.RIGHT_ANGLE) {
					drive.stop();// when Pronstants.RIGHT_ANGLE degrees is reached, the robot is stopped

				}
				if (triangle) {// if triangle is selected, then the robot will turn for 60 degrees
					drive.setRight(Pronstants.STRONG_SPEED);
					drive.setLeft(Pronstants.WEAK_SPEED);
				}
				if ((init_heading - gyro.getAngle()) >= Pronstants.TRIANGLE_ANGLE) {
					drive.stop();// when robot has turned 60 degrees, it stop and proceed to the next straight
					impPath = Auto_Path.Forward3;
				}
				break;
			case Forward3:
				if (square || triangle) {// both paths will lead to going through this
					drive.move(Pronstants.WEAK_SPEED, Pronstants.ZERO);
				} // when the motors have rotated Pronstants.SHORT_DISTANCE times, robot will stop
					// and move on to next step
				if (encL.getDistance() >= Pronstants.SHORT_DISTANCE
						&& encR.getDistance() >= Pronstants.SHORT_DISTANCE) {
					drive.stop();
					impPath = Auto_Path.Turn3;
				}
				break;
			case Turn3:
				if (square) {
					drive.setLeft(Pronstants.WEAK_SPEED);
					drive.setRight(Pronstants.STRONG_SPEED);// turning for the square only becuase the triangle only
															// requires two turns
				}
				if ((init_heading - gyro.getAngle()) >= Pronstants.RIGHT_ANGLE) {
					drive.stop();
					impPath = Auto_Path.Forward4;// from now on only the square will be executed
				}
				break;
			case Forward4:
				if (square) {
					drive.move(Pronstants.WEAK_SPEED, Pronstants.ZERO);// moving forward Pronstants.SHORT_DISTANCE
																		// rotations, stopping and moving on to the next
																		// step
				}
				if (encL.getDistance() >= Pronstants.SHORT_DISTANCE
						&& encR.getDistance() >= Pronstants.SHORT_DISTANCE) {
					drive.stop();
					impPath = Auto_Path.Turn4;
				}
				break;
			case Turn4:
				if (square) {// final turn of the square and then the robot stops, completing the square
					drive.setLeft(Pronstants.WEAK_SPEED);
					drive.setRight(Pronstants.STRONG_SPEED);
				}
				if ((init_heading - gyro.getAngle()) >= Pronstants.RIGHT_ANGLE) {
					drive.stop();
				}
				break;
			default:
				drive.stop();
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