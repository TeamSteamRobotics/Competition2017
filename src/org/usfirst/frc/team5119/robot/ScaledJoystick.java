package org.usfirst.frc.team5119.robot;

import edu.wpi.first.wpilibj.Joystick;

public class ScaledJoystick extends Joystick {

	public ScaledJoystick(int port) {
		super(port);
	}
	
	public double getScaledZ() {
		double Z = super.getZ();
		//if (Math.abs(Z)<.1){
		return Math.pow(Z, 3);
		//}else{
			//return 0;
		//}
	}
	
	public double getScaledX(){
		double X = super.getX();
		return Math.pow(X, 3);
	}
	
	public double getScaledY(){
		double Y = super.getY();
		return Math.pow(Y, 3);
	}
}