package org.usfirst.frc4947.robot2015.subsystems;

import org.usfirst.frc4947.robot2015.commands.ConveyorStop;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;


/**
 *
 */
public class Conveyor extends Subsystem {
	private Talon motor = new Talon(0);
    
	private DigitalInput limitSwitchLeft = new DigitalInput(2);
	private DigitalInput limitSwitchRight = new DigitalInput(3);

    public Conveyor(){
    	super();
    	
        LiveWindow.addSensor("Conveyor", "LimitSwitchLeft", limitSwitchLeft);
        LiveWindow.addSensor("Conveyor", "LimitSwitchRight", limitSwitchRight);
        LiveWindow.addActuator("Conveyor", "Motor", (Talon) motor);
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new ConveyorStop());
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

