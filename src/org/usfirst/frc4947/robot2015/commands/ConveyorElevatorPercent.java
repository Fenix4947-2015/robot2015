package org.usfirst.frc4947.robot2015.commands;

import org.usfirst.frc4947.robot2015.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ConveyorElevatorPercent extends Command {

	public double percent;
	public double position;
	
	public boolean isForwardDirection;
	
    public ConveyorElevatorPercent(double percent, double position) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.conveyorElevator);
    	
    	this.percent = percent;
    	this.position = position;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	isForwardDirection = Robot.conveyorElevator.getPosition() < position;
    	Robot.conveyorElevator.setModePercent();
    }
    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(isForwardDirection){
    		Robot.conveyorElevator.setValue(percent);
    	}
    	else{
    		Robot.conveyorElevator.setValue(-percent);
    	}
    	
    	
    	SmartDashboard.putNumber("ElevatorPercent", percent);
    	SmartDashboard.putNumber("ElevatorSetPosition", position);
    	SmartDashboard.putBoolean("ElevatorFwdDirection", isForwardDirection);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(isForwardDirection){
    		return Robot.conveyorElevator.getPosition() >= position;
    	}
    	else{
    		return Robot.conveyorElevator.getPosition() <= position;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.conveyorElevator.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
