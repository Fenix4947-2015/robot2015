package org.usfirst.frc4947.robot2015.commands;

import org.usfirst.frc4947.robot2015.OI.XBoxButton;
import org.usfirst.frc4947.robot2015.Robot;
import org.usfirst.frc4947.robot2015.subsystems.Elevator;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RobotDeliverStack extends CommandGroup {
    
    public  RobotDeliverStack() {
    	// Move the stack forward to clear the motor
    	addParallel(new ConveyorOut(3.0));
    	
    	// Move elevator to the delivering position
    	addParallel(new ElevatorPercent(0.5, Elevator.DELIVER));
    	
    	// Deliver the stack
    	addParallel(new DriveForward(0.35, 3.0));
   	
    	
    	/*
    	// Move the stack forward to clear the motor
    	addSequential(new ConveyorOut(0.2));
    	
    	// Move elevator to the delivering position
    	addSequential(new ElevatorPercent(0.5, Elevator.DELIVER));
    	
    	// Deliver the stack
    	addParallel(new DriveForward(0.35, 5.0));
    	addSequential(new ConveyorOut(3.0));
    	
    	// Prepare robot for next step
    	//addSequential(new DriveBackwardAndRotate180(0.5));
    	 */
    }
    
    @Override
    protected boolean isFinished() {
    	return super.isFinished() || Robot.oi.getJoystickDriverButton(XBoxButton.Back);
    }
}
