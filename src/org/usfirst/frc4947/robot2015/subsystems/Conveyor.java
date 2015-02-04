package org.usfirst.frc4947.robot2015.subsystems;

import org.usfirst.frc4947.robot2015.commands.ConveyorStop;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;


/**
 *
 */
public class Conveyor extends Subsystem {
    CANTalon motor = new CANTalon(4);
    
    DigitalInput limitSwitchLeft = new DigitalInput(2);
    DigitalInput limitSwitchRight = new DigitalInput(3);

    public Conveyor(){
    	super();
    	
        motor.changeControlMode(CANTalon.ControlMode.PercentVbus);
    	
        LiveWindow.addSensor("Conveyor", "LimitSwitchLeft", limitSwitchLeft);
        LiveWindow.addSensor("Conveyor", "LimitSwitchRight", limitSwitchRight);
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new ConveyorStop());
    }
    
    public void resetEncoder(){
    	motor.setPosition(0);
    }
    
    public void setSpeed(double speed){
    	motor.set(speed);
    }
    
    public boolean getLimitSwitchLeft(){
    	return limitSwitchLeft.get();
    }
    
    public boolean getLimitSwitchRight(){
    	return limitSwitchRight.get();
    }
    
}

