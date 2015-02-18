package org.usfirst.frc4947.robot2015;

import org.usfirst.frc4947.robot2015.commands.AutonomousSimple;
import org.usfirst.frc4947.robot2015.commands.ConveyorIn;
import org.usfirst.frc4947.robot2015.commands.ConveyorManual;
import org.usfirst.frc4947.robot2015.commands.ConveyorOut;
import org.usfirst.frc4947.robot2015.commands.ConveyorStop;
import org.usfirst.frc4947.robot2015.commands.DriveAutoAlign;
import org.usfirst.frc4947.robot2015.commands.DriveBackward;
import org.usfirst.frc4947.robot2015.commands.DriveForward;
import org.usfirst.frc4947.robot2015.commands.DriveGyroInit;
import org.usfirst.frc4947.robot2015.commands.DriveRotate180;
import org.usfirst.frc4947.robot2015.commands.ElevatorDown;
import org.usfirst.frc4947.robot2015.commands.ElevatorHome;
import org.usfirst.frc4947.robot2015.commands.ElevatorHookHold;
import org.usfirst.frc4947.robot2015.commands.ElevatorHookRelease;
import org.usfirst.frc4947.robot2015.commands.ElevatorManual;
import org.usfirst.frc4947.robot2015.commands.ElevatorPercent;
import org.usfirst.frc4947.robot2015.commands.ElevatorPosition;
import org.usfirst.frc4947.robot2015.commands.ElevatorStack;
import org.usfirst.frc4947.robot2015.commands.ElevatorStackUnstack;
import org.usfirst.frc4947.robot2015.commands.ElevatorStop;
import org.usfirst.frc4947.robot2015.commands.ElevatorUnstack;
import org.usfirst.frc4947.robot2015.commands.RobotDeliverStack;
import org.usfirst.frc4947.robot2015.commands.RobotStackUnstack;
import org.usfirst.frc4947.robot2015.subsystems.Elevator;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.RumbleType;
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
		A(1),
		B(2),
		X(3),
		Y(4),
		LB(5),
		RB(6),
		Back(7),
		Start(8);

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
        driverX.whenPressed(new ElevatorUnstack());
        
    	// SmartDashboard Buttons
        SmartDashboard.putData("AutonomousSimple", new AutonomousSimple());
        
        SmartDashboard.putData("DriveAutoAlign", new DriveAutoAlign(0.6));
        SmartDashboard.putData("DriveRotate180", new DriveRotate180());
        SmartDashboard.putData("DriveGyroInit", new DriveGyroInit());
        
        SmartDashboard.putData("ConveyorStop", new ConveyorStop());
        SmartDashboard.putData("ConveyorIn", new ConveyorIn());
        SmartDashboard.putData("ConveyorManual", new ConveyorManual());
        
        SmartDashboard.putData("ElevatorStop", new ElevatorStop());
        SmartDashboard.putData("ElevatorHome", new ElevatorHome());
        SmartDashboard.putData("ElevatorManual", new ElevatorManual());
        SmartDashboard.putData("ElevatorHookRelease", new ElevatorHookRelease());
        SmartDashboard.putData("ElevatorHookHold", new ElevatorHookHold());
        SmartDashboard.putData("ElevatorStack", new ElevatorStack());
        SmartDashboard.putData("ElevatorDown", new ElevatorDown());
        SmartDashboard.putData("ElevatorStackUnstack", new ElevatorStackUnstack());
        SmartDashboard.putData("ElevatorUnstack", new ElevatorUnstack());
        
        SmartDashboard.putData("RobotStackUnstack(1)", new RobotStackUnstack(1));
        SmartDashboard.putData("RobotStackUnstack(2)", new RobotStackUnstack(2));
        SmartDashboard.putData("RobotStackUnstack(3)", new RobotStackUnstack(3));
        SmartDashboard.putData("RobotStackUnstack(4)", new RobotStackUnstack(4));
        SmartDashboard.putData("RobotStackUnstack(5)", new RobotStackUnstack(5));
        SmartDashboard.putData("RobotStackUnstack(6)", new RobotStackUnstack(6));
        SmartDashboard.putData("RobotDeliverStack)", new RobotDeliverStack());
    }
    
    public double getJoystickDriverAxis(XBoxAxis axis) {
        return joystickDriver.getRawAxis(axis.getValue());
    }

    public double getJoystickDriverAxis(XBoxAxis axis, double deadBand) {
    	double axisValue = joystickDriver.getRawAxis(axis.getValue());
    	
    	if(Math.abs(axisValue) <= deadBand){
    		axisValue = 0;
    	}
    	
    	return axisValue;
    }
    
    public void setJoystickDriverRumble(RumbleType rumbleType, float value){
    	joystickDriver.setRumble(rumbleType, value);
    }
    
    public boolean getJoystickDriverButton(XBoxButton button) {
        return joystickDriver.getRawButton(button.getValue());
    }
    
    public double getJoystickHelperAxis(XBoxAxis axis) {
        return joystickHelper.getRawAxis(axis.getValue());
    }

    public double getJoystickHelperAxis(XBoxAxis axis, double deadBand) {
    	double axisValue = joystickHelper.getRawAxis(axis.getValue());
    	
    	if(Math.abs(axisValue) <= deadBand){
    		axisValue = 0;
    	}
    	
    	return axisValue;
    }
    
    public boolean getJoystickHelperButton(XBoxButton button) {
        return joystickHelper.getRawButton(button.getValue());
    }
}

