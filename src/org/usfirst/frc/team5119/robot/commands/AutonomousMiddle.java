package org.usfirst.frc.team5119.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousMiddle extends CommandGroup {

    public AutonomousMiddle() {
       
        addSequential(new PlaceTheGear());
        addSequential(new AutonomousDrive(4,-.50,0,0));
        addSequential(new AutonomousDrive(.5, 0, 0, .5));
        addSequential(new AutonomousDrive(5,0,-.40,0));
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
