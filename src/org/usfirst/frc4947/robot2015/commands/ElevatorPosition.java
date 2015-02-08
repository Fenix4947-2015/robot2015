package org.usfirst.frc4947.robot2015.commands;

import org.usfirst.frc4947.robot2015.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorPosition extends Command {

	public double position;
	
    public ElevatorPosition(double position) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.elevator);
    	
    	this.position = position;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.elevator.setModePosition();
    	Robot.elevator.setValue(position);
    	Timer.delay(0.1);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	// SetPoint must be set repeatedly if we don't want the safety feature to disable the motor
    	Robot.elevator.setValue(position);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	// TODO determiner la bonne valeur d'erreur qu'il est acceptable d'avoir avant de considerer la commande comme terminee
        return Math.abs(Robot.elevator.getClosedLoopError()) <= 20;
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
