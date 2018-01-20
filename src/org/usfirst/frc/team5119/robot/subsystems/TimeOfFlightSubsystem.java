package org.usfirst.frc.team5119.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *
 */
public class TimeOfFlightSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	NetworkTable table;
	double[] defaultValue = new double[0];
	
	public TimeOfFlightSubsystem(){
		table = NetworkTable.getTable("TimeOfFlight1");
	}
	public double SensorDistance(int sensorNumber){
		double[] sensorDistance = table.getNumberArray("SensorDistances",defaultValue);
		return sensorDistance[sensorNumber];

	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

