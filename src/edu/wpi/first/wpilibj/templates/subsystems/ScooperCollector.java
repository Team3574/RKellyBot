/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.CollectorDoNothing;


/**
 *
 * @author team3574
 */
public class ScooperCollector extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Talon moverUpperTalon = RobotMap.moverUpperTalon;
    Talon collectorTalon = RobotMap.collectorTalon;
    
    DigitalInput collectSenPort1 = RobotMap.collectSenPort1;
    DigitalInput collectSenPort2 = RobotMap.collectSenPort2;
    DigitalInput collectSenPort3 = RobotMap.collectSenPort3;
    
        //initilize subsystem here
    public ScooperCollector(){
	LiveWindow.addSensor("ScooperCollector", "sensor port 1", collectSenPort1);
	LiveWindow.addSensor("ScooperCollector", "sensor port 2", collectSenPort2);
	LiveWindow.addSensor("ScooperCollector", "sensor port 3", collectSenPort3);
	LiveWindow.addActuator("ScooperCollector", "Move up", moverUpperTalon);
	LiveWindow.addActuator("ScooperCollector", "Collector", collectorTalon);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        //setDefaultCommand(new LogCollectSensor());
        setDefaultCommand(new CollectorDoNothing());
    }
    
    public void setCollectorMotor(double speed) {
        collectorTalon.set(speed);
    }
    
    public void setElevatorMotor(double speed) {
        moverUpperTalon.set(speed);
    }
    
    public boolean isPresentSensor1() {
        return collectSenPort1.get();
    }
    
    public boolean isPresentSensor2() {
        return collectSenPort2.get();
    }
    
    public boolean isPresentSensor3() {
        return collectSenPort3.get();
    }
    
    public void updateStatus(){
        SmartDashboard.putBoolean("Collector Sensor Port 1", isPresentSensor1());
        SmartDashboard.putBoolean("Collector Sensor Port 2", isPresentSensor2());
        SmartDashboard.putBoolean("Collector Sensor Port 3", isPresentSensor3());
    }
}
