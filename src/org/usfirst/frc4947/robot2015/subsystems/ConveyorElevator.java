// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4947.robot2015.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class ConveyorElevator extends Subsystem {
    CANTalon motorMaster = new CANTalon(5);
    CANTalon motorSlave = new CANTalon(6);
    
    DigitalInput homeSwitch = new DigitalInput(4);
    
    Solenoid releaseHook = new Solenoid(5);

    // Initialize your subsystem here
    public ConveyorElevator() {
        super();
        
        motorSlave.changeControlMode(CANTalon.ControlMode.Follower);
        motorSlave.set(motorMaster.getDeviceID());
        
        motorMaster.changeControlMode(CANTalon.ControlMode.Position);
        motorMaster.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
        motorMaster.setPID(10,  0,  0);
        
        LiveWindow.addActuator("ConveyorElevator", "HomeSwitch", homeSwitch);
        LiveWindow.addActuator("ConveyorElevator", "ReleaseHook", releaseHook);
    }
    
    public void initDefaultCommand() {
    }
    
    public boolean getHomeLimit(){
    	return homeSwitch.get();
    }
    
    public boolean getForwardLimit(){
    	return motorMaster.isFwdLimitSwitchClosed();
    }
    
    public boolean getReverseLimit(){
    	return motorMaster.isRevLimitSwitchClosed();
    }
    
    public void setSetPoint(double setPoint){
    	motorMaster.set(setPoint);
    }
    
    public void resetEncoder(){
    	motorMaster.setPosition(0);
    }
    
    public void setReleaseHook(boolean state){
    	releaseHook.set(state);
    }
}
