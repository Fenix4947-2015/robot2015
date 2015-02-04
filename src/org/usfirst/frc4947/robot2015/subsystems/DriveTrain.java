package org.usfirst.frc4947.robot2015.subsystems;

import org.usfirst.frc4947.robot2015.commands.ArcadeDrive;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;


/**
 *
 */
public class DriveTrain extends Subsystem {
    Gyro gyro = new Gyro(0);
	BuiltInAccelerometer accelerometer = new BuiltInAccelerometer();
	
    DigitalInput antennaLeft = new DigitalInput(0);
    DigitalInput antennaRight = new DigitalInput(1);
    
    CANTalon motorRearLeft = new CANTalon(0);
    CANTalon motorFrontLeft = new CANTalon(1);
    CANTalon motorFrontRight = new CANTalon(2);
    CANTalon motorRearRight = new CANTalon(3);
    
    RobotDrive robotDrive = new RobotDrive(motorFrontLeft, motorRearLeft, motorFrontRight, motorRearRight);

    public DriveTrain() {
		super();
		
		//robotDrive.setSafetyEnabled(true);

		LiveWindow.addSensor("DriveTrain", "Gyro", gyro);      
		LiveWindow.addSensor("DriveTrain", "Accelerometer", accelerometer);
        LiveWindow.addSensor("DriveTrain", "AntennaLeft", antennaLeft);
        LiveWindow.addSensor("DriveTrain", "AntennaRight", antennaRight);
	}
    
    public void initDefaultCommand() {
        setDefaultCommand(new ArcadeDrive());
    }
    
    public void arcadeDrive(Joystick joystick){
		robotDrive.arcadeDrive(joystick);
    }
    
    public void tankdrive(double leftValue, double rightValue){
    	robotDrive.tankDrive(leftValue, rightValue);
    }
    
    public boolean getAntennaLeft(){
    	return antennaLeft.get();
    }
    
    public boolean getAntennaRight(){
    	return antennaRight.get();
    }
}

