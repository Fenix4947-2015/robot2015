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
    	// TODO Determiner tous les temps pour la sequence de livraison d'un pile
    	
    	// Align the robot with the step
    	//addSequential(new DriveAutoLimit(0.60));
    	
    	//addSequential(new DriveForward(0.60, 0.3));
    	//addSequential(new DriveWait(1.0));
    	
    	// Move the stack forward to clear the motor
    	addSequential(new ConveyorOut(0.3));
    	
    	// Move elevator to the delivering position
    	addSequential(new ElevatorPercent(0.25, Elevator.DELIVER));
    	
    	// Deliver the stack
    	addParallel(new DriveForward(0.35, 5.0));
    	addParallel(new ConveyorOut(5.0));
    	
    	// Prepare robot for next step
    	//addSequential(new DriveBackwardAndRotate180(0.5));
    }
    
    @Override
    protected boolean isFinished() {
    	return super.isFinished() || Robot.oi.getJoystickDriverButton(XBoxButton.Back);
    }
}
