package org.usfirst.frc.team5119.robot.commands;

import org.usfirst.frc.team5119.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousSide extends CommandGroup {

    public AutonomousSide(double targetAngle) {
    	requires(Robot.driveSubsystem);
    	requires(Robot.gearSubsystem);
    	requires(Robot.gyroSubsystem);
    	requires(Robot.visionSubsystem);
    	requires(Robot.ultrasonicSubsystem);
        // Add Commands here:
        addSequential(new AutonomousDrive(1, 0, -.5, 0));
        addSequential(new AutonomousTurn(5,targetAngle));
        addSequential(new AutonomousDrive(0.5, 0, 0, 0));
        addSequential(new PlaceTheGear());
        //addSequential(new AutonomousTurn(5,0));
        //if(targetAngle<180){
        //	addSequential(new AutonomousDrive(1, -.5, 0, 0);
        //}else{
        //	addSequential(new AutonomousDrive(1, .5, 0, 0);
        //}
        //addSequential(new AutonomousDrive(2,0,-.5,0));
        
        // e.g. addParallel(new Command1());
       
    }
}
