package org.usfirst.frc.team5119.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RopeClimbSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
protected Talon ropeMotor1 = new Talon(0),
				ropeMotor2 = new Talon(1);
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void Climb(){
    	ropeMotor1.set(-1);
    	ropeMotor2.set(1);
    }
    public void stopClimb(){
    	ropeMotor1.set(0);
    	ropeMotor2.set(0);
    }

    public void testClimb(){
    	ropeMotor1.set(1);
    	Timer.delay(1);
    	ropeMotor1.set(0);
    	ropeMotor2.set(1);
    	Timer.delay(1);
    	ropeMotor2.set(0);
    }
    public void slowClimb(){
    	ropeMotor1.set(-.5);
    	ropeMotor2.set(.5);
    }
    public void climbDown(){
    	ropeMotor1.set(.25);
    	ropeMotor2.set(-.25);
    }
}

