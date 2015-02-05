package org.usfirst.frc4947.robot2015.commands;

import org.usfirst.frc4947.robot2015.Robot;
import org.usfirst.frc4947.robot2015.subsystems.ConveyorElevator;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ConveyorElevatorUp extends Command {

    public ConveyorElevatorUp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.conveyorElevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    //TODO il reste à savoir quelle valeur a mettre pour la position up
    	Robot.conveyorElevator.setSetPoint(1500);
    
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.conveyorElevator.getForwardLimit() &&;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
