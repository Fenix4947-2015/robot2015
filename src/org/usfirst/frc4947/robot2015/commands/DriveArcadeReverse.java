package org.usfirst.frc4947.robot2015.commands;

import org.usfirst.frc4947.robot2015.OI.XBoxAxis;
import org.usfirst.frc4947.robot2015.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveArcadeReverse extends Command {

    public DriveArcadeReverse() {
        requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		// TODO Voir si on veut limiter la vitesse maximale
    	Robot.driveTrain.setMaxOutput(0.5);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double moveValue = Robot.oi.getJoystickHelperAxis(XBoxAxis.RightTrigger) - Robot.oi.getJoystickHelperAxis(XBoxAxis.LeftTrigger);
    	double rotateValue = Robot.oi.getJoystickHelperAxis(XBoxAxis.LeftStickX, 0.1);
    	
    	Robot.driveTrain.arcadeDrive(-moveValue, rotateValue);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	// Execute this command until interrupted
        return false;
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
