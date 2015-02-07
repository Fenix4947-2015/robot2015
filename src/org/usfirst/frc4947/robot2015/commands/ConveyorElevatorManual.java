package org.usfirst.frc4947.robot2015.commands;

import org.usfirst.frc4947.robot2015.OI.XBoxAxis;
import org.usfirst.frc4947.robot2015.OI.XBoxButton;
import org.usfirst.frc4947.robot2015.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ConveyorElevatorManual extends Command {

    public ConveyorElevatorManual() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.conveyorElevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.conveyorElevator.setModePercent();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.conveyorElevator.setValue(Robot.oi.getJoystickDriver().getRawAxis(XBoxAxis.RightStickY.getValue()));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.oi.getJoystickDriver().getRawButton(XBoxButton.X.getValue()); 
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
