package org.usfirst.frc.team5119.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5119.robot.commands.*;
import org.usfirst.frc.team5119.robot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final DriveSubsystem driveSubsystem = new DriveSubsystem();
	public static final GearSubsystem gearSubsystem = new GearSubsystem();
	public static final GyroSubsystem gyroSubsystem = new GyroSubsystem();
	public static VisionSubsystem visionSubsystem;
	public static final RopeClimbSubsystem climbSubsystem= new RopeClimbSubsystem();
	public static final UltrasonicSubsystem ultrasonicSubsystem = new UltrasonicSubsystem();
	public static final AutonomousSwitches autoSwitches = new AutonomousSwitches();
	public static final DistanceSensorSubsystem distanceSensorSubsystem = new DistanceSensorSubsystem();
	//public static final TimeOfFlightSubsystem timeOfFlightSubsystem = new TimeOfFlightSubsystem();

	public static OI oi;
	CameraServer camera;
	
	
	
	CameraServer server; 	


	Command autonomousCommand;// = new AutonomousMiddle();
	//SendableChooser chooser;
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		visionSubsystem = new VisionSubsystem();
		//distanceSensorSubsystem = new DistanceSensorSubsystem();
		oi = new OI();
		/*switch(autoSwitches.ChooseAuto()){
		case 0: default: autonomousCommand = null; break;
		case 1: autonomousCommand = new AutonomousSide(60);break;
		case 2: autonomousCommand = new AutonomousSide(-60);break;
		case 3: autonomousCommand = new AutonomousMiddle();}
		*/
		//autonomousCommand = new AutonomousSide(60);							//Camera
		camera = CameraServer.getInstance(); 
		camera.startAutomaticCapture();
		/*chooser = new SendableChooser();
		chooser.addDefault("forward", new AutonomousDrive(3, 0, .5, 0));
		chooser.addObject("right", new AutonomousSide(300));
		chooser.addObject("middle", new AutonomousMiddle());
		chooser.addObject("left", new AutonomousSide(60));
		
		SmartDashboard.putData("Autonomous mode Chooser", chooser);
		*/
		
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		//autonomousCommand = new AutonomousSide(300);//(Command) chooser.getSelected();
		gyroSubsystem.resetGyro();
		switch(autoSwitches.ChooseAuto()){
		case 0: default: autonomousCommand = new AutonomousDrive(5, 0, -0.25, 0); break;
		case 1: autonomousCommand = new AutonomousSide(60);break;
		case 2: autonomousCommand = new AutonomousSide(300);break;
		case 3: autonomousCommand = new AutonomousMiddle();break;}
		
		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putBoolean("gearSensor", gearSubsystem.hasGear());
		SmartDashboard.putBoolean("doorIsOpen", gearSubsystem.isOpen());
		SmartDashboard.putNumber("gyro",(gyroSubsystem.gyroAngle()));
		SmartDashboard.putData("scheduler", Scheduler.getInstance());
		SmartDashboard.putNumber("X-axis", oi.stick.getX());
		SmartDashboard.putNumber("Y-axis", oi.stick.getY());
		SmartDashboard.putNumber("Z-axis", oi.stick.getZ());
		SmartDashboard.putString("PegX", visionSubsystem.horizontalActual());
		SmartDashboard.putNumber("ultrasonic", ultrasonicSubsystem.distance());
		//DriverStation.reportError(distanceSensorSubsystem.readDistance()+"", false);
		distanceSensorSubsystem.readDistance();
		//DriverStation.reportError(autoSwitches.ChooseAuto()+"", false);
		//DriverStation.reportError("ultrasonic = "+ultrasonicSubsystem.distance(),false);
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
