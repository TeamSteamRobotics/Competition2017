package org.usfirst.frc.team5119.robot.commands;

import org.usfirst.frc.team5119.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class AutonomousDrive extends TimedCommand {
double x;
double y;
double z;
	
    public AutonomousDrive(double timeout,double X,double Y,double Z) {
		super(timeout);
		x=X;
		y=Y;
		z=Z;
		// TODO Auto-generated constructor stub
		requires(Robot.driveSubsystem);
	}

	public AutonomousDrive(String name, double timeout) {
		super(name, timeout);
		// TODO Auto-generated constructor stub
	}

	

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveSubsystem.drive(x, y, z);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
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
