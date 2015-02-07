package org.usfirst.frc4947.robot2015.commands;

import org.usfirst.frc4947.robot2015.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoAlignDrive extends Command {

    public AutoAlignDrive() {
        requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double leftValue = 0.5;
    	double rightValue = 0.5;
    	
    	if(!Robot.driveTrain.getAntennaLeft()){
    		leftValue = 0;
    	}
    	
    	if(!Robot.driveTrain.getAntennaRight()){
    		rightValue = 0;
    	}
    	
    	Robot.driveTrain.tankdrive(leftValue, rightValue);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !Robot.driveTrain.getAntennaLeft() && !Robot.driveTrain.getAntennaRight();
    }

    // Called once after isFinished returns true
    protected void end() {
    	// Stop the robot when interrupted
    	Robot.driveTrain.tankdrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
