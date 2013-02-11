/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package team.util;

import com.sun.squawk.util.MathUtils;
import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author team3574
 */
public class XboxController {

    private Joystick xbox;
    public double joystickCurve;
    
    public static final int A = 1,
                            B = 2,
                            X = 3,
                            Y = 4,
                            LB = 5,
                            RB = 6,
                            Select = 7,
                            Start = 8,
                            LeftStickClick = 9,
                            RightStickClick = 10;

    XboxController(int port) {
        xbox = new Joystick(port);
        joystickCurve = 1.0;
    }


    /*----------------------------------------*/
    /*
     * This is where the sticks
     * and triggers are gotten
     */
    double GetLeftX() {
        return MathUtils.pow(xbox.getRawAxis(1), joystickCurve);
    }

    double GetLeftY() {
        return MathUtils.pow(xbox.getRawAxis(2), joystickCurve);
    }

    double GetLeftTrigger() {
        double trigger = MathUtils.pow(xbox.getRawAxis(3), joystickCurve);

        //adds a little bit of tolerance of .1 for trigger
        if (trigger >= .1) {
            return trigger;
        } else {
            return 0;
        }
    }

    double GetRightTrigger() {
        double trigger = MathUtils.pow(xbox.getRawAxis(3), joystickCurve);

        //adds a little bit of tolerance of .1 for trigger
        if (trigger <= -.1) {
            return trigger;
        } else {
            return 0;
        }
    }

    double GetTriggerAxis() {
        double trigger = MathUtils.pow(xbox.getRawAxis(3), joystickCurve);

        //adds a little bit of tolerance of .1 for trigger
        return trigger;
    }

    double GetRightX() {
        return MathUtils.pow(xbox.getRawAxis(4), joystickCurve);
    }

    double GetRightY() {
        return MathUtils.pow(xbox.getRawAxis(5), joystickCurve);
    }


    /*----------------------------------------*/
    /*
     * This Gets Raw sate of button
     * It is good for things that
     * need to have the button held
     * down to work.
     */
    boolean GetA() {
        return xbox.getRawButton(1);
    }

    boolean GetB() {
        return xbox.getRawButton(2);
    }

    boolean GetX() {
        return xbox.getRawButton(3);
    }

    boolean GetY() {
        return xbox.getRawButton(4);
    }

    boolean GetLB() {
        return xbox.getRawButton(5);
    }

    boolean GetRB() {
        return xbox.getRawButton(6);
    }

    boolean GetSelect() {
        return xbox.getRawButton(7);
    }

    boolean GetStart() {
        return xbox.getRawButton(8);
    }

    boolean GetLeftStickClick() {
        return xbox.getRawButton(9);
    }

    boolean GetRightStickClick() {
        return xbox.getRawButton(10);
    }
}
