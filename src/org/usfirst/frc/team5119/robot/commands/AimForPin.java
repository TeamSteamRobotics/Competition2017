package org.usfirst.frc.team5119.robot.commands;

import org.usfirst.frc.team5119.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AimForPin extends Command {

    public AimForPin() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.visionSubsystem);
        requires(Robot.driveSubsystem);
        requires(Robot.gearSubsystem);
        requires(Robot.ultrasonicSubsystem);
        requires(Robot.gyroSubsystem);
    }
    protected double startingAngle = Robot.gyroSubsystem.gyroAngle();
    // Called just before this Command runs the first time
    protected void initialize() {
    	startingAngle = Robot.gyroSubsystem.gyroAngle();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putNumber("ultrasonic",Robot.ultrasonicSubsystem.distance());

    	//if (Robot.ultrasonicSubsystem.distance()>2){
    	double correctionConstant = 1;
    	double turningScale = 1/90;
    	double pegX;
    	double xCorrectionSpeed;
    	double turnCorrection;
    	
    	SmartDashboard.putNumber("horizontalCenter",  pegX = Robot.visionSubsystem.horizontalCenter());
    	xCorrectionSpeed = correctionConstant*(pegX-320)/640;
    	
    	turnCorrection = (Robot.gyroSubsystem.gyroAngle()-startingAngle)*turningScale;
    	
    	Robot.driveSubsystem.drive(xCorrectionSpeed, -.3, turnCorrection);
    	if (xCorrectionSpeed <-.1){
    		SmartDashboard.putString("pegDirection", "left"+xCorrectionSpeed);
    	}else if (xCorrectionSpeed>.1){
    		SmartDashboard.putString("pegDirection", "right"+xCorrectionSpeed);
    	}else{
    		SmartDashboard.putString("pegDirection", "straight");
    	}
    	//}else{
    	//	Robot.driveSubsystem.drive(0, -.2, 0);
    	//}

    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.gearSubsystem.isOpen();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveSubsystem.drive(0, 0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.driveSubsystem.drive(0, 0, 0);
    }
}
