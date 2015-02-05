package org.usfirst.frc4947.robot2015.commands;

import org.usfirst.frc4947.robot2015.Robot;

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
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//TODO il reste � savoir quelle valeur a mettre pour la position up
    	// SetPoint must be set repeatedly if we don't want the safety feature to disable the motor
    	Robot.conveyorElevator.setSetPoint(1500);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	// TODO d�terminer la bonne valeur d'erreur qu'il est acceptable d'avoir avant de consid�rer la commande comme termin�e
        return Math.abs(Robot.conveyorElevator.getClosedLoopError()) <= 50; 
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
