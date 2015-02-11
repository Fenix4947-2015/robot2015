package org.usfirst.frc4947.robot2015.commands;

import org.usfirst.frc4947.robot2015.OI;
import org.usfirst.frc4947.robot2015.Robot;
import org.usfirst.frc4947.robot2015.OI.XBoxButton;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveRotate180 extends Command {

    public DriveRotate180() {
        requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	// TODO Trouver la bonne valeur de temps pour faire un 180
    	//Robot.driveTrain.initGyro();
    	setTimeout(10.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Robot.driveTrain.tankdrive(-0.5, 0.5);      	
    	Robot.driveTrain.getGyroAngle();   	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return (isTimedOut() || Robot.oi.getJoystickDriverButton(XBoxButton.Back));
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
