// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4947.robot2015.commands;

import org.usfirst.frc4947.robot2015.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class  ConveyorInDelay extends Command {
	private double delay = 0;
	private boolean isEmpty = false;
	
    public ConveyorInDelay(double delay) {
        requires(Robot.conveyor);
        this.delay = delay;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		if (timeSinceInitialized() >= delay){
			if(Robot.conveyor.getLimitSwitchLeft() && Robot.conveyor.getLimitSwitchRight()){
				isEmpty = true;
			}
			
			if(isEmpty){
				Robot.conveyor.setSpeed(-1);
		    	Robot.conveyor.setGreenLight(true);			
			}
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return isEmpty && !Robot.conveyor.getLimitSwitchLeft() && !Robot.conveyor.getLimitSwitchRight();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
