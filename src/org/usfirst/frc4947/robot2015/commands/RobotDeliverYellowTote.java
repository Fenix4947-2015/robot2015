package org.usfirst.frc4947.robot2015.commands;

import org.usfirst.frc4947.robot2015.OI.XBoxButton;
import org.usfirst.frc4947.robot2015.Robot;
import org.usfirst.frc4947.robot2015.subsystems.Elevator;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RobotDeliverYellowTote extends CommandGroup {
    
    public  RobotDeliverYellowTote() {
    	
    	// Move elevator to the delivering position
    	addSequential(new ElevatorPercent(0.5, Elevator.DELIVER_YELLOW));
    	
    	// Deliver the stack
    	addSequential(new ConveyorOut(5.0));
    }
    
    @Override
    protected boolean isFinished() {
    	return super.isFinished() || Robot.oi.getJoystickDriverButton(XBoxButton.Back);
    }
}
