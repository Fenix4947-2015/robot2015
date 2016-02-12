package org.usfirst.frc4947.robot2015.subsystems;

import org.usfirst.frc4947.robot2015.commands.DriveArcade;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class DriveTrain extends Subsystem {
	private AnalogGyro gyro = new AnalogGyro(0);
	private BuiltInAccelerometer accelerometer = new BuiltInAccelerometer();
	
	private DigitalInput antennaLeft = new DigitalInput(1);
	private DigitalInput antennaRight = new DigitalInput(0);
    
	private CANTalon motorLeftRear = new CANTalon(2);
	private CANTalon motorRightRear = new CANTalon(0);
	private CANTalon motorLeftFront = new CANTalon(3);
	private CANTalon motorRightFront = new CANTalon(1);
    
    RobotDrive robotDrive = new RobotDrive(motorLeftRear, motorLeftFront, motorRightRear, motorRightFront);

    public DriveTrain() {
		super();

		// TODO Voir si on a besoin d'activer la securite
		//robotDrive.setSafetyEnabled(true);

		motorLeftRear.enableBrakeMode(true);
		motorLeftFront.enableBrakeMode(true);
		motorRightRear.enableBrakeMode(true);
		motorRightFront.enableBrakeMode(true);

		
		LiveWindow.addSensor("DriveTrain", "Gyro", gyro);      
		LiveWindow.addSensor("DriveTrain", "Accelerometer", accelerometer);
        LiveWindow.addSensor("DriveTrain", "AntennaLeft", antennaLeft);
        LiveWindow.addSensor("DriveTrain", "AntennaRight", antennaRight);
	}
    
    public void initDefaultCommand() {
        setDefaultCommand(new DriveArcade());
    	//setDefaultCommand(new DriveTank());
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
    
    public void initGyro(){
    	gyro.initGyro();
    }
    
    public double getGyroAngle(){
    	return gyro.getAngle();
    }

    public void log() {
        SmartDashboard.putBoolean("DriveTrainLeft", getAntennaLeft());
        SmartDashboard.putBoolean("DriveTrainRight", getAntennaRight());
        SmartDashboard.putNumber("Gyro", getGyroAngle());
    }
}

