package org.usfirst.frc4947.robot2015.commands;

import org.usfirst.frc4947.robot2015.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveAutoLimit extends Command {
	private double speed;

    public DriveAutoLimit(double speed) {
        requires(Robot.driveTrain);
        
        this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.tankdrive(speed, speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.driveTrain.getAntennaLeft() || Robot.driveTrain.getAntennaRight();
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
