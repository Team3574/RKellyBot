/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

///////   THIS CODE IS NOT YET WORKING
//  TODO:  make it work
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;
import team.util.LogDebugger;

/**
 *
 * @author team3574
 */
public class Flinger extends PIDSubsystem {
    Encoder spinnerEncoder = RobotMap.spinnerEncoder;
    Jaguar spinnerMotor = RobotMap.spinnerMotor;
    
    private static final double Kp = 0.0;
    private static final double Ki = 0.0;
    private static final double Kd = 0.0;
    
    public static final double NORMAL_SPEED = 1,
            PYRIMID_SPEED = 0.5,
            POWER_SAVING_MODE = 0.2,
            OFF = 0;

    // Initialize your subsystem here
    public Flinger() {
        super("FlingerMotor", Kp, Ki, Kd);
        
        spinnerEncoder.start();
        
        LogDebugger.log("Flinger Started!");
        
        setSetpoint(-2000);
        enable();

        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        SmartDashboard.putNumber("Flinger PID In", spinnerEncoder.getRate());
        return spinnerEncoder.getRate();
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
        SmartDashboard.putNumber("Flinger setpoint", this.getSetpoint());
        SmartDashboard.putNumber("Flinger PID Out", output);
        LogDebugger.log("PID");
        spinnerMotor.set(output);
    }
}
