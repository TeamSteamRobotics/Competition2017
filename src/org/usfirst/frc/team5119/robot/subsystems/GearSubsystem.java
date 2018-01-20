package org.usfirst.frc.team5119.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	protected DigitalInput openedSensor = new DigitalInput(0);
	protected DigitalInput gearSensor = new DigitalInput(1);
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public boolean isOpen(){
    	return !openedSensor.get();
    }
    public boolean hasGear(){
    	return gearSensor.get();
    }
}

