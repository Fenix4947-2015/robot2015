// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4947.robot2015;

import org.usfirst.frc4947.robot2015.commands.AutoAlignDrive;
import org.usfirst.frc4947.robot2015.commands.AutonomousCommand;
import org.usfirst.frc4947.robot2015.commands.CloseHook;
import org.usfirst.frc4947.robot2015.commands.ConveyorElevatorDown;
import org.usfirst.frc4947.robot2015.commands.ConveyorElevatorHome;
import org.usfirst.frc4947.robot2015.commands.ConveyorElevatorManual;
import org.usfirst.frc4947.robot2015.commands.ConveyorElevatorPercent;
import org.usfirst.frc4947.robot2015.commands.ConveyorElevatorPosition;
import org.usfirst.frc4947.robot2015.commands.ConveyorElevatorResetEncoder;
import org.usfirst.frc4947.robot2015.commands.ConveyorElevatorStack;
import org.usfirst.frc4947.robot2015.commands.ConveyorElevatorStop;
import org.usfirst.frc4947.robot2015.commands.ConveyorIn;
import org.usfirst.frc4947.robot2015.commands.ConveyorManual;
import org.usfirst.frc4947.robot2015.commands.ConveyorOut;
import org.usfirst.frc4947.robot2015.commands.ConveyorStop;
import org.usfirst.frc4947.robot2015.commands.OpenHook;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public enum XBoxAxis{
		LeftStickX(0),
		LeftStickY(1),
		LeftTrigger(2),
		RightTrigger(3),
		RightStickX(4),
		RightStickY(5);		

		private int value;
		XBoxAxis(int value){
			this.value = value;
		}
		
		public int getValue() {
			return value;
		}
	}
	
	public enum XBoxButton{
		A(0),
		B(1),
		X(2),
		Y(3),
		LB(4),
		RB(5),
		Back(6),
		Start(7);

		private int value;
		XBoxButton(int value){
			this.value = value;
		}
		
		public int getValue() {
			return value;
		}
	}	
	
    private Joystick joystickDriver = new Joystick(0);
    private Joystick joystickHelper = new Joystick(1);

    @SuppressWarnings("unused")
	public OI() {
        // Create some buttons
        JoystickButton driverA = new JoystickButton(joystickDriver, XBoxButton.A.getValue());
        JoystickButton driverB = new JoystickButton(joystickDriver, XBoxButton.B.getValue());
        JoystickButton driverX = new JoystickButton(joystickDriver, XBoxButton.X.getValue());
        JoystickButton driverY = new JoystickButton(joystickDriver, XBoxButton.Y.getValue());
        JoystickButton driverLB = new JoystickButton(joystickDriver, XBoxButton.LB.getValue());
        JoystickButton driverRB = new JoystickButton(joystickDriver, XBoxButton.RB.getValue());
        JoystickButton driverBack = new JoystickButton(joystickDriver, XBoxButton.Back.getValue());
        JoystickButton driverStart = new JoystickButton(joystickDriver, XBoxButton.Start.getValue());
        
        JoystickButton helperA = new JoystickButton(joystickHelper, XBoxButton.A.getValue());
        JoystickButton helperB = new JoystickButton(joystickHelper, XBoxButton.B.getValue());
        JoystickButton helperX = new JoystickButton(joystickHelper, XBoxButton.X.getValue());
        JoystickButton helperY = new JoystickButton(joystickHelper, XBoxButton.Y.getValue());
        JoystickButton helperLB = new JoystickButton(joystickHelper, XBoxButton.LB.getValue());
        JoystickButton helperRB = new JoystickButton(joystickHelper, XBoxButton.RB.getValue());
        JoystickButton helperBack = new JoystickButton(joystickHelper, XBoxButton.Back.getValue());
        JoystickButton helperStart = new JoystickButton(joystickHelper, XBoxButton.Start.getValue());

        // TODO Linker les boutons avec des commandes comme plus bas
        //helperA.whenPressed(new ConveyorIn());
        
    	// SmartDashboard Buttons
        SmartDashboard.putData("AutonomousCommand", new AutonomousCommand());
        SmartDashboard.putData("AutoAlignDrive", new AutoAlignDrive());
        SmartDashboard.putData("ConveyorIn", new ConveyorIn());
        SmartDashboard.putData("ConveyorOut", new ConveyorOut());
        SmartDashboard.putData("ConveyorStop", new ConveyorStop());
        SmartDashboard.putData("ConveyorManual", new ConveyorManual());
        SmartDashboard.putData("ConveyorElevatorStack", new ConveyorElevatorStack());
        SmartDashboard.putData("ConveyorElevatorDown", new ConveyorElevatorDown());
        SmartDashboard.putData("ConveyorElevatorStop", new ConveyorElevatorStop());
        SmartDashboard.putData("ConveyorElevatorResetEncoder", new ConveyorElevatorResetEncoder());
        SmartDashboard.putData("ConveyorElevatorHome", new ConveyorElevatorHome());
        SmartDashboard.putData("ConveyorElevatorManual", new ConveyorElevatorManual());
        SmartDashboard.putData("ConveyorElevatorPosition 0", new ConveyorElevatorPosition(0));
        SmartDashboard.putData("ConveyorElevatorPosition 1000", new ConveyorElevatorPosition(1000));
        SmartDashboard.putData("ConveyorElevatorPosition 2200", new ConveyorElevatorPosition(2200));
        SmartDashboard.putData("ConveyorElevatorPosition 4000", new ConveyorElevatorPosition(4000));
        SmartDashboard.putData("ConveyorElevatorPosition 4650", new ConveyorElevatorPosition(4650));
        SmartDashboard.putData("ConveyorElevatorPercent 25, 1000", new ConveyorElevatorPercent(0.25, 1000));
        SmartDashboard.putData("ConveyorElevatorPosition 25, 3000", new ConveyorElevatorPercent(0.25,  3000));
        SmartDashboard.putData("OpenHook", new OpenHook());
        SmartDashboard.putData("CloseHook", new CloseHook());
    }
    
    public Joystick getJoystickDriver() {
        return joystickDriver;
    }

    public Joystick getJoystickHelper() {
        return joystickHelper;
    }
}

