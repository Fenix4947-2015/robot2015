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

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc4947.robot2015.Robot;

/**
 *
 */
public class  ConveyorIn extends Command {
	// TODO Trouver la bonne valeur de timeout
	private final static double TIMEOUT = 1.0;
			
	private double timestamp = 0;
	
    public ConveyorIn() {
        requires(Robot.conveyor);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.conveyor.setSpeed(-1);
    	Robot.conveyor.setGreenLight(true);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	// TODO Voir si on voudrait compter le temps seulement quand les 2 switch sont active en meme temps
    	if(!Robot.conveyor.getLimitSwitchLeft() && !Robot.conveyor.getLimitSwitchRight()){
    		if(timestamp == 0){
    			// Record the timestamp to start timeout timer
    			timestamp = Timer.getFPGATimestamp();
    		}
    	}
		else{
			// Reset the timestamp since no limit are activated
			timestamp = 0;
		}
    }
    
    public double timeSinceLimitSwitch() {
        return timestamp == 0 ? 0 : Timer.getFPGATimestamp() - timestamp;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	// Execute until limit switch are activated for a certain period of time
        return timeSinceLimitSwitch() >= TIMEOUT;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.conveyor.setGreenLight(false);
    	Robot.conveyor.setSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
