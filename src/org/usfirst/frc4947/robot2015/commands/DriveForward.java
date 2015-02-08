package org.usfirst.frc4947.robot2015.commands;

import org.usfirst.frc4947.robot2015.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveForward extends Command {

	private double timeout;
	
    public DriveForward(double timeout) {
        requires(Robot.driveTrain);
        
        this.timeout = timeout;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(timeout);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.tankdrive(0.5, 0.5);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
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
