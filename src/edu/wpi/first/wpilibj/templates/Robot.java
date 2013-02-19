/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import team.util.LogDebugger;
import team.util.XboxController;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    //Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public NetworkTable table;
    
    public void robotInit() {
        // instantiate the command used for the autonomous period
        //autonomousCommand = new ExampleCommand();
        
        // Initialize all subsystems
        CommandBase.init();
        
        table = NetworkTable.getTable("CRIO");
        table.putBoolean("bool", true);
        table.putNumber("double", 3.1415927);
        table.putString("sring", "a string");
        
        LogDebugger.log("robot init!!!");
	
	LiveWindow.addActuator("compressor", "alt relay", RobotMap.compRelay);
	LiveWindow.addActuator("compressor", "act compressor", RobotMap.airCompressor);
	LiveWindow.addSensor("compressor", "sensor compressor", RobotMap.airCompressor);
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        //autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        updateStatus();
    }

    public void teleopInit() {
	// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        //autonomousCommand.cancel();
        RobotMap.compRelay.set(Relay.Value.kOn);
        RobotMap.compRelay.set(Relay.Value.kForward);
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        updateStatus();
        RobotMap.airCompressor.start();
	
        SmartDashboard.putBoolean("Air Compressor Full", RobotMap.airCompressor.getPressureSwitchValue());
    }
    
    public void disabledPeriodic(){
        updateStatus();
    }
    Joystick j = new Joystick(1);
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
        updateStatus();
	if (j.getRawButton(XboxController.A)){
	    RobotMap.shifterPort.set(true);
	}else {
	    RobotMap.shifterPort.set(false);
	}
	
	if (j.getRawButton(XboxController.B)){
	    RobotMap.shooterArm.set(true);
	}else {
	    RobotMap.shooterArm.set(false);
	}
	
	if (j.getRawButton(XboxController.X)){
	    RobotMap.liftTheRobotLeft.set(true);
	    RobotMap.liftTheRobotRight.set(true);
	}else {
	    RobotMap.liftTheRobotLeft.set(false);
	    RobotMap.liftTheRobotRight.set(false);
	}
	
	if (j.getRawButton(XboxController.Y)){
	    RobotMap.positionArmLeft.set(true);
	    RobotMap.positionArmRight.set(true);
	}else {
	    RobotMap.positionArmLeft.set(false);
	    RobotMap.positionArmRight.set(false);
	}
    }
    
    public void updateStatus(){
        CommandBase.theScooperCollector.updateStatus();
        CommandBase.theAccelerometer.updateStatus();
	CommandBase.thePizzaBoxTilt.updateStatus(); 
    }
}
