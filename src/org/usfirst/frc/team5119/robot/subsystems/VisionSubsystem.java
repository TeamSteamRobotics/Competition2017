
package org.usfirst.frc.team5119.robot.subsystems;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class VisionSubsystem extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	NetworkTable table;
	protected double[] horizontalContourCenters;
	protected double[] verticalContourCenters;
	protected double[] defaultValue = new double[0];
	protected double horizontalTarget;


	protected double averageX;




	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		//setDefaultCommand(new MySpecialCommand());
	}
	public VisionSubsystem(){
		table = NetworkTable.getTable("GRIP/contourTable");

	}
	public double horizontalCenter(){

		horizontalContourCenters = table.getNumberArray("centerX",defaultValue);
		verticalContourCenters = table.getNumberArray("centerY", defaultValue);
		//DriverStation.reportError(horizontalContourCenters.length+"", false);
		double sum = 0;
		double numberOfContours = 0;
		if (horizontalContourCenters.length>1){
			for(int i = 0; i<horizontalContourCenters.length ; i++){

				//if (verticalContourCenters[i]>90){
					sum += horizontalContourCenters[i];
					numberOfContours++;
				//}
			}
			if (numberOfContours>0){
				return averageX = sum/numberOfContours;
			}
		}
		return 320;
	}
	
	public String horizontalActual(){

		horizontalContourCenters = table.getNumberArray("centerX",defaultValue);
		verticalContourCenters = table.getNumberArray("centerY", defaultValue);
		//DriverStation.reportError(horizontalContourCenters.length+"", false);
		double sum = 0;
		double numberOfContours = 0;
		if (horizontalContourCenters.length>1){
			for(int i = 0; i<horizontalContourCenters.length ; i++){

				//if (verticalContourCenters[i]>90){
					sum += horizontalContourCenters[i];
					numberOfContours++;
				//}
			}
			if (numberOfContours>0){
			averageX = sum/numberOfContours;
			return averageX+"";
			}
		}
		return "No contours";
		
	}
	
}