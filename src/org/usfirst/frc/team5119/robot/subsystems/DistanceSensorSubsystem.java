package org.usfirst.frc.team5119.robot.subsystems;

import java.nio.ByteBuffer;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DistanceSensorSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	protected I2C distanceSensor;
	
	byte[] dataBuffer = new byte[12];
	
	
	public DistanceSensorSubsystem(){
		distanceSensor = new I2C(I2C.Port.kOnboard, 0x29);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void readDistance(){
    	
    	distanceSensor.read(0x00, 12, dataBuffer);
    	
    	ByteBuffer compBuffer = ByteBuffer.wrap(dataBuffer);
    	
    	/*int ambientCount = ((dataBuffer[6] & 0xFF) << 8) | (dataBuffer[7] & 0xFF);
		int signalCount = ((dataBuffer[8] & 0xFF) << 8) | (dataBuffer[9] & 0xFF);
		int distance = ((dataBuffer[10] & 0xFF) << 8) | (dataBuffer[11] & 0xFF);
		int deviceRangeStatusInternal = ((dataBuffer[0] & 0x78) >> 3);
		DriverStation.reportError(ambientCount+"am", false);
		DriverStation.reportError(signalCount+"si", false);
		DriverStation.reportError(distance+"di", false);
		DriverStation.reportError(deviceRangeStatusInternal+"de", false);
		DriverStation.reportError(""+distanceSensor.addressOnly(), false);*/
    	//DriverStation.reportError(dataBuffer+"", false);
    	//return distance;
    }
}

