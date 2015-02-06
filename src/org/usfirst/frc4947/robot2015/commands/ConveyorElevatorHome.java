package org.usfirst.frc4947.robot2015.commands;

import org.usfirst.frc4947.robot2015.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ConveyorElevatorHome extends Command {

    public ConveyorElevatorHome() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.conveyorElevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.conveyorElevator.setModePercent();
    	Robot.conveyorElevator.setValue(-0.1);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return Robot.conveyorElevator.getReverseLimit();
    }

    // Called once after isFinished returns true
    protected void end() {
    	interrupted();
    	Robot.conveyorElevator.resetEncoder();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.conveyorElevator.setValue(0);
    }
}
