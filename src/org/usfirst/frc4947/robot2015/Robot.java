package org.usfirst.frc4947.robot2015;

import org.usfirst.frc4947.robot2015.commands.AutonomousDoNothing;
import org.usfirst.frc4947.robot2015.commands.AutonomousSimple;
import org.usfirst.frc4947.robot2015.subsystems.Conveyor;
import org.usfirst.frc4947.robot2015.subsystems.DriveTrain;
import org.usfirst.frc4947.robot2015.subsystems.Elevator;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    Command autonomousCommand;
    SendableChooser autonomousChooser = new SendableChooser();

    public static OI oi;

    public static DriveTrain driveTrain;
    public static Conveyor conveyor;
    public static Elevator elevator;;


    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	// Initialize all subsystems
        driveTrain = new DriveTrain();
        conveyor = new Conveyor();
        elevator = new Elevator();

        // Initialize the Operator Interface
        oi = new OI();

        // Instantiate the command used for the autonomous period
        autonomousChooser.addDefault("AutonomousSimple", new AutonomousSimple());
        autonomousChooser.addObject("AutonomousDoNothing", new AutonomousDoNothing());
        SmartDashboard.putData("AutonomousMode", autonomousChooser);
       
        // Show what command your subsystem is running on the SmartDashboard
        SmartDashboard.putData(driveTrain);
        SmartDashboard.putData(conveyor);
        SmartDashboard.putData(elevator);
    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    public void autonomousInit() {
    	autonomousCommand = (Command)autonomousChooser.getSelected();
    	
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        log();
    }

    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        log();
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
    
    private void log() {
        driveTrain.log();
        conveyor.log();
        elevator.log();
    }
}
