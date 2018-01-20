package org.usfirst.frc.team5119.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;


public class AutonomousSwitches extends Subsystem {

   
	protected DigitalInput autoSwitch1 = new DigitalInput(2);
	protected DigitalInput autoSwitch2 = new DigitalInput(3);
    protected void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public int ChooseAuto(){
    	if(autoSwitch1.get()){
    		if(autoSwitch2.get()){
    			return 0;
    		}else{
    			return 1;
    		}
    	}else{
    		if(autoSwitch2.get()){
    			return 2;
    		}else{
    			return 3;
    		}
    	}
    }
    public boolean isSwitch1(){
    	return autoSwitch1.get();
    }
    public boolean isSwitch2(){
    	return autoSwitch2.get();
    }
}

