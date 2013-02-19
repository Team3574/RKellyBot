/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.testCommands.TunePID;
import team.util.LogDebugger;

/**
 *
 * @author team3574
 */
public class PizzaBoxTilt extends PIDSubsystem {

    private static final double Kp = 0.04;
    private static final double Ki = 0.001;
    private static final double Kd = 0.0;
    
    Talon tiltingTalon = RobotMap.tiltingTalon;
    Encoder tiltingEncoder = RobotMap.tiltingEncoder;

    // Initialize your subsystem here
    public PizzaBoxTilt() {
        super("PizzaBoxTilt", Kp, Ki, Kd);
        tiltingEncoder.start();
        LogDebugger.log("pizza box constructor");
	
	LiveWindow.addSensor("PizzaBoxTilt", "encoder", tiltingEncoder);
	LiveWindow.addActuator("PizzaBoxTilt", "tilting", tiltingTalon);
	LiveWindow.addActuator("PizzaBoxTilt", "PID", getPIDController());
      

        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
//        enable();
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
//        setDefaultCommand(new TunePID());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        int elevation = tiltingEncoder.get();
        SmartDashboard.putNumber("tilt encoder", elevation);
        return elevation;
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
        tiltingTalon.set(output);
        SmartDashboard.putNumber("Elevation Output", output);
    }
    
    public void setPID (double p,double i,double d) {
        this.getPIDController().disable();
        this.getPIDController().setPID(p, i, d);
        this.getPIDController().enable();
    }
    
    public void setSetpoint (double setPoint) {
        this.getPIDController().reset();
//        LogDebugger.log("changed setpoint");
        super.setSetpoint(setPoint);
        this.enable();
    }
    
    public void manualGo(double speed){
        this.disable();
        
        tiltingTalon.set(speed);
        this.setSetpoint(tiltingEncoder.get());
        
        SmartDashboard.putNumber("Tilt/Elevation Value", tiltingTalon.get());
        LogDebugger.log("Manual Go!");
        
        this.enable();
      
    }

    public void updateStatus() {
//	SmartDashboard.putNumber("tilt encoder", elevation);
//	SmartDashboard.putNumber("Elevation Output", output);
    }
}
