package org.usfirst.frc.team5119.robot.commands;
import org.usfirst.frc.team5119.robot.Robot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TestAll extends Command {

    public TestAll() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.climbSubsystem);
        requires(Robot.driveSubsystem);
        requires(Robot.gearSubsystem);
        requires(Robot.gyroSubsystem);
        requires(Robot.ultrasonicSubsystem);
        requires(Robot.autoSwitches);
        requires(Robot.visionSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveSubsystem.testDrive();
    	Timer.delay(1);
    	Robot.climbSubsystem.testClimb();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putBoolean("gearSensor", Robot.gearSubsystem.hasGear());
		SmartDashboard.putBoolean("doorIsOpen", Robot.gearSubsystem.isOpen());
		SmartDashboard.putNumber("gyro",(Robot.gyroSubsystem.gyroAngle()));
		SmartDashboard.putNumber("X-axis", Robot.oi.stick.getX());
		SmartDashboard.putNumber("Y-axis", Robot.oi.stick.getY());
		SmartDashboard.putNumber("Z-axis", Robot.oi.stick.getZ());
		SmartDashboard.putString("PegX", Robot.visionSubsystem.horizontalActual());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
