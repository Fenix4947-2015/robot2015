// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4947.robot2015.subsystems;

import org.usfirst.frc4947.robot2015.RobotMap;
import org.usfirst.frc4947.robot2015.commands.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.can.*;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class DriveTrain extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    DigitalInput antennaLeft = RobotMap.driveTrainAntennaLeft;
    DigitalInput antennaRight = RobotMap.driveTrainAntennaRight;
    Gyro gyro = RobotMap.driveTrainGyro;
    CANJaguar motorRearLeft = RobotMap.driveTrainMotorRearLeft;
    CANJaguar motorFrontLeft = RobotMap.driveTrainMotorFrontLeft;
    CANJaguar motorFrontRight = RobotMap.driveTrainMotorFrontRight;
    CANJaguar motorRearRight = RobotMap.driveTrainMotorRearRight;
    RobotDrive robotDrive = RobotMap.driveTrainRobotDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

