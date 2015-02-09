package org.usfirst.frc4947.robot2015.commands;

import org.usfirst.frc4947.robot2015.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorPercent extends Command {

	public double percent;
	public double position;
	
	public boolean isForwardDirection;
	
    public ElevatorPercent(double percent, double position) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.elevator);
    	
    	this.percent = percent;
    	this.position = position;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	isForwardDirection = Robot.elevator.getPosition() < position;
    	Robot.elevator.setModePercent();
    }
    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(isForwardDirection){
    		Robot.elevator.setValue(percent);
    	}
    	else{
    		Robot.elevator.setValue(-percent);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(isForwardDirection){
    		return Robot.elevator.getPosition() >= position;
    	}
    	else{
    		return Robot.elevator.getPosition() <= position;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevator.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
