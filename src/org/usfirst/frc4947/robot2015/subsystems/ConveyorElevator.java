package org.usfirst.frc4947.robot2015.subsystems;

import org.usfirst.frc4947.robot2015.commands.ConveyorElevatorStop;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ConveyorElevator extends Subsystem {
    private CANTalon motorMaster = new CANTalon(5);
    private CANTalon motorSlave = new CANTalon(6);
    
    private Solenoid releaseHook = new Solenoid(5);

    // Initialize your subsystem here
    public ConveyorElevator() {
        super();
        
        //motorMaster.setVoltageRampRate(24);
        motorSlave.changeControlMode(CANTalon.ControlMode.Follower);
        motorSlave.set(motorMaster.getDeviceID());
        
        LiveWindow.addActuator("ConveyorElevator", "ReleaseHook", releaseHook);
    }
    
    public void initDefaultCommand() {
    	setDefaultCommand(new ConveyorElevatorStop());
    }
    
    public void setModePosition(){
        motorMaster.changeControlMode(CANTalon.ControlMode.Position);
        motorMaster.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
        motorMaster.setPID(4,  0,  0);
    }
    
    public void setModePercent(){
        motorMaster.changeControlMode(CANTalon.ControlMode.PercentVbus);
    }

    public boolean getForwardLimit(){
    	return motorMaster.isFwdLimitSwitchClosed();
    }
    
    public boolean getReverseLimit(){
    	return motorMaster.isRevLimitSwitchClosed();
    }
    
    public void setValue(double value){
    	motorMaster.set(value);
    }
    
    public int getClosedLoopError(){
    	return motorMaster.getClosedLoopError();
    }

    public void resetEncoder(){
    	motorMaster.setPosition(0);
    }
    
    public void stop(){
    	setModePercent();
    	setValue(0);
    }
    
    public double getPosition(){
    	return motorMaster.getPosition();
    }
    
    public void setReleaseHook(boolean state){
    	releaseHook.set(state);
    }
    
    public void log() {
    	SmartDashboard.putNumber("ElevatorGet", motorMaster.get());
        SmartDashboard.putNumber("ElevatorPosition", motorMaster.getPosition());
        SmartDashboard.putNumber("ElevatorClosedLoopError", motorMaster.getClosedLoopError());
    }
}
