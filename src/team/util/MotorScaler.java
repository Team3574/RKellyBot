/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package team.util;

/**
 *
 * @author team3574
 */
public class MotorScaler {
    double lastSpeed, maxChange;
    
    public MotorScaler(){
        lastSpeed = 0.0;
        maxChange = 0.05;
    }
    public MotorScaler(double _maxChange){
        lastSpeed = 0.0;
        maxChange = _maxChange;
    }
    
    public double scale(double input){
        double newSpeed = 0;
        if (input < 0.1 && input > -0.117){
            input = 0;
        }
        if (Math.abs(input - lastSpeed) > maxChange) {
            if (input - lastSpeed > 0){
                newSpeed = lastSpeed + maxChange;
                lastSpeed = newSpeed;
                return newSpeed;
            }
            else if(input - lastSpeed < 0){
                newSpeed = lastSpeed - maxChange;
                lastSpeed = newSpeed;
                return newSpeed;
            }
            else {  //never executed!
            lastSpeed = input;
            return input;
        }
        }
        else {
            lastSpeed = input;
            return input;
        }
        
//        if (input - lastSpeed > 0.05){
//            newSpeed = lastSpeed + maxChange;
//            lastSpeed = newSpeed;
//            return newSpeed;
//        }
//        else if (input - lastSpeed < -0.05){
//            newSpeed = lastSpeed - maxChange;
//            lastSpeed = newSpeed;
//            return newSpeed;
//        }
//        else { //if we got here input - lastSpeed must be 0.
//            lastSpeed = input;
//            return input;
//
//        }
    }
}