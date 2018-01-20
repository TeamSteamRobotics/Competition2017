package org.usfirst.frc.team5119.robot;

import org.usfirst.frc.team5119.robot.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;



/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public final ScaledJoystick stick = new ScaledJoystick(0);
	
	//backLeft(id1)=backRight,FrontLeft(id3)=,FrontRight(id0)=,backRight(id2)=
	public final Button hangGearButton = new JoystickButton(stick, 2);
	public final Button climbRopeButton = new JoystickButton(stick, 7);
	public final Button centerPegButton = new JoystickButton(stick, 1);
	public final Button leftPegButton = new JoystickButton(stick, 5);
	public final Button rightPegButton = new JoystickButton(stick, 6);
	public final Button resetGyroButton = new JoystickButton(stick, 8);
	public final Button driveForwardButton = new JoystickButton(stick, 3);
	public final Button gearPickupButton = new JoystickButton(stick, 11);
	public final Button stayOnRopeButton = new JoystickButton(stick, 9);
	public final Button testWheelButton = new JoystickButton(stick, 4);
	public final Button testWheelButton2 = new JoystickButton(stick, 10);
	//public final Button climbDownButton = new JoystickButton(stick, 10);
	//public final Button changePinout = new JoystickButton(stick, 4);
	//public final Button testMotorButton = new JoystickButton(stick, 9);
	
	public OI(){
		
		hangGearButton.whileHeld(new PlaceTheGear());
		climbRopeButton.whileHeld(new ClimbRope());
		centerPegButton.whenPressed(new AutonomousTurn(5,0));
		leftPegButton.whenPressed(new AutonomousTurn(2,60));
		gearPickupButton.whileHeld(new BackDistance());
		rightPegButton.whenPressed(new AutonomousTurn(5,-60));
		resetGyroButton.whileHeld(new ResetGyro());
		driveForwardButton.whileHeld(new AutonomousDrive(7,0,-.125,0));
		stayOnRopeButton.whileHeld(new StopClimbing());
		testWheelButton.whileHeld(new TestWheels(0.25));
		testWheelButton2.whileHeld(new TestWheels(-0.25));
		//climbDownButton.whileHeld(new ClimbDown());
		//changePinout.whileHeld(new PinChange());
		//testMotorButton.whileHeld(new TestWheels());
	}
}
