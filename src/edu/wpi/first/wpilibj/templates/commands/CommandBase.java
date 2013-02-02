package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.subsystems.Drive;
import edu.wpi.first.wpilibj.templates.subsystems.Flinger;
import edu.wpi.first.wpilibj.templates.subsystems.Hopper;
import edu.wpi.first.wpilibj.templates.subsystems.Lifter;
import edu.wpi.first.wpilibj.templates.subsystems.ScooperCollector;
import edu.wpi.first.wpilibj.templates.subsystems.TheShifter;
import edu.wpi.first.wpilibj.templates.subsystems.Tracking;


/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    // Create a single static instance of all of your subsystems
    //public static ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
    public static Drive theDrive = new Drive ();
    public static Flinger theFlinger = new Flinger ();
    public static Hopper theHopper = new Hopper ();
    public static Lifter theLifter = new Lifter ();
    public static ScooperCollector theScooperCollector = new ScooperCollector ();
    public static Tracking theTracking = new Tracking ();
    public static TheShifter theShifter = new TheShifter ();

    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();

        // Show what command your subsystem is running on the SmartDashboard
        //SmartDashboard.putData(exampleSubsystem);
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
