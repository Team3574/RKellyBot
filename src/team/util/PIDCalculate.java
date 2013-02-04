/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package team.util;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;

/**
 *
 * @author team3574
 */
public class PIDCalculate {
    public double P = 0.0,
            I = 0.0,
            D = 0.0,
            F = 0.0;
    
    public double setpoint = 0.0,
            error = 0.0,
            maximumInput = 1.0,
            minimumInput = 0.0,
            maximumOutput = 1.0,
            minimumOutput = -1.0,
            prevError = 0.0,
            result = 0.0,
            totalError = 0.0;
    
    public boolean continuous = false;
    
    public PIDCalculate(double p, double i, double d) {
        this.P = p;
        this.I = i;
        this.D = d;
    }
    
    public void setSetpoint(double newSetpoint)
    {
        this.setpoint = newSetpoint;
    }

    /**
     * Read the input, calculate the output accordingly, and write to the
     * output. This should only be called by the PIDTask and is created during
     * initialization.
     */
    public double calculate(double input) {
        double theLocalResult;

        synchronized (this) {
            error = setpoint - input;
            if (continuous) {
                if (Math.abs(error)
                        > (maximumInput - minimumInput) / 2) {
                    if (error > 0) {
                        error = error - maximumInput + minimumInput;
                    } else {
                        error = error
                                + maximumInput - minimumInput;
                    }
                }
            }

            if (I != 0) {
                double potentialIGain = (totalError + error) * I;
                if (potentialIGain < maximumOutput) {
                    if (potentialIGain > minimumOutput) {
                        totalError += error;
                    } else {
                        totalError = minimumOutput / I;
                    }
                } else {
                    totalError = maximumOutput / I;
                }
            }

            result = P * error + I * totalError + D * (error - prevError) + setpoint * F;
            prevError = error;

            if (result > maximumOutput) {
                result = maximumOutput;
            } else if (result < minimumOutput) {
                result = minimumOutput;
            }
            theLocalResult = result;
        }

        return theLocalResult;
    }
}
