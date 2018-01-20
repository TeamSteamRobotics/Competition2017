package org.usfirst.frc.team5119.robot.subsystems;

import org.usfirst.frc.team5119.robot.RobotMap;
import org.usfirst.frc.team5119.robot.commands.Drive;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;



import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Talon;
//import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

/**
 *
 */
public class DriveSubsystem extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	protected Talon frontLeft = new Talon(2),
			frontRight = new Talon(3),
			backLeft = new Talon(4),
			backRight = new Talon(5);
	/*protected  WPI_TalonSRX frontLeft = new WPI_TalonSRX(RobotMap.frontLeftMotor),
			frontRight = new WPI_TalonSRX(RobotMap.frontRightMotor),
			backLeft = new WPI_TalonSRX(RobotMap.backLeftMotor),
			backRight = new WPI_TalonSRX(RobotMap.backRightMotor);*/
	protected MecanumDrive drive = new MecanumDrive(frontLeft,backLeft,frontRight,backRight);


	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new Drive());

	}
	public void drive(double x,double y,double z){
		double xMod = 1;
		double yMod = 1;
		double zMod = .7;
		drive.driveCartesian(x * xMod, y * yMod, z * zMod/* + (0.2 * x)*/, 0);
		//testWheels();
	}
	public void testWheels(double xSpeed){
		drive.driveCartesian(xSpeed, 0, 0, 0);
	}
	public void driveAtAngle(double speed, double angle, double rotate){
		drive.drivePolar(speed, angle, rotate);
	}
	public void testDrive(){
		frontLeft.set(1);
		Timer.delay(1);
		frontLeft.set(0);
		frontRight.set(1);
		Timer.delay(1);
		frontRight.set(0);
		backLeft.set(1);
		Timer.delay(1);
		backLeft.set(0);
		backRight.set(1);
		Timer.delay(1);
		backRight.set(0);
	}
}

