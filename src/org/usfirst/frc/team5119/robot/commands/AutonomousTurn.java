package org.usfirst.frc.team5119.robot.commands;

import org.usfirst.frc.team5119.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class AutonomousTurn extends TimedCommand {
double targetAngle;
	
    public AutonomousTurn(double timeout,double angle) {
    	super(timeout);
    	targetAngle = angle;
    	// Use requires() here to declare subsystem dependencies
    	requires(Robot.driveSubsystem);
    	requires(Robot.gyroSubsystem);
    	//requires(Robot.visionSubsystem);
    	// TODO Auto-generated constructor stub
    }

	

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	//double gyroAngle = Robot.gyroSubsystem.gyroAngle();

    	//if (gyroAngle <= targetAngle - 5 || gyroAngle >= targetAngle + 5){
    		//double correctionSpeed = ((gyroAngle - targetAngle)/70);
    		/*double correctionSpeed = (Robot.gyroSubsystem.relativeAngle(targetAngle)-180)/70;
    		DriverStation.reportError("targetAngle=" + targetAngle + ", correctionSpeed=" + correctionSpeed+", relativeAngle="+Robot.gyroSubsystem.relativeAngle(targetAngle) + "gyro="+Robot.gyroSubsystem.gyroAngle(), false);
    		if(correctionSpeed<-.5){
    			correctionSpeed = -.5;
    		}else if(correctionSpeed>.5){
    			correctionSpeed = .5;

    		}*/
    		double correctionSpeed = Robot.gyroSubsystem.relativeAngle(targetAngle)/60;
    		if(correctionSpeed<-.5){
    			correctionSpeed=-.5;
    		}else if(correctionSpeed>.5){
    			correctionSpeed=.5;
    		}
    			
    		Robot.driveSubsystem.drive(0, 0, correctionSpeed);
    	//} else {
    		//Robot.driveSubsystem.drive(0, 0, 0);
    	//}
    	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut()||Math.abs(Robot.gyroSubsystem.relativeAngle(targetAngle)) < 5;
        //||(Robot.visionSubsystem.horizontalCenter()>300&&Robot.visionSubsystem.horizontalCenter()<340);
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
