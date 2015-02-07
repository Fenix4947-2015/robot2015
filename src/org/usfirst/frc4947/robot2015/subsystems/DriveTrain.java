package org.usfirst.frc4947.robot2015.subsystems;

import org.usfirst.frc4947.robot2015.commands.ArcadeDrive;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class DriveTrain extends Subsystem {
	private Gyro gyro = new Gyro(0);
	private BuiltInAccelerometer accelerometer = new BuiltInAccelerometer();
	
	private DigitalInput antennaLeft = new DigitalInput(0);
	private DigitalInput antennaRight = new DigitalInput(1);
    
	private CANTalon motorRearLeft = new CANTalon(0);
	private CANTalon motorFrontLeft = new CANTalon(1);
	private CANTalon motorFrontRight = new CANTalon(2);
    private CANTalon motorRearRight = new CANTalon(3);
    
    RobotDrive robotDrive = new RobotDrive(motorFrontLeft, motorRearLeft, motorFrontRight, motorRearRight);

    public DriveTrain() {
		super();

		// TODO Voir si on a besoin d'activer la securite
		//robotDrive.setSafetyEnabled(true);

		LiveWindow.addSensor("DriveTrain", "Gyro", gyro);      
		LiveWindow.addSensor("DriveTrain", "Accelerometer", accelerometer);
        LiveWindow.addSensor("DriveTrain", "AntennaLeft", antennaLeft);
        LiveWindow.addSensor("DriveTrain", "AntennaRight", antennaRight);
	}
    
    public void initDefaultCommand() {
        setDefaultCommand(new ArcadeDrive());
    }
    
    public void arcadeDrive(double moveValue, double rotateValue){
		robotDrive.arcadeDrive(moveValue, rotateValue);
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
    
    public void setMaxOutput(double maxOutput){
    	robotDrive.setMaxOutput(maxOutput);
    }
    
    public void log() {
        SmartDashboard.putBoolean("DriveTrainLeft", getAntennaLeft());
        SmartDashboard.putBoolean("DriveTrainRight", getAntennaRight());
    }
}

