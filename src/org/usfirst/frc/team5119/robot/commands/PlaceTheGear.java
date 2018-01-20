package org.usfirst.frc.team5119.robot.commands;

import org.usfirst.frc.team5119.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PlaceTheGear extends CommandGroup {

    public PlaceTheGear() {
        requires(Robot.driveSubsystem);
        requires(Robot.gearSubsystem);
        requires(Robot.ultrasonicSubsystem);
        requires(Robot.visionSubsystem);
        
        
        addSequential(new AimForPin());
        addSequential(new AutonomousDrive(.5, 0, 0, 0));
        //addSequential(new DriveBack());

        addSequential(new AutonomousDrive(.5, .25,0,0));
        addSequential(new AutonomousDrive(.5, -.25,0,0));
        
        addSequential(new AutonomousDrive(2, 0, .25, 0));
        
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
       
    }
}
