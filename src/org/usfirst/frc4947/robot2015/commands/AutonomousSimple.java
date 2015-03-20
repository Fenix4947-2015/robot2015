package org.usfirst.frc4947.robot2015.commands;

import org.usfirst.frc4947.robot2015.subsystems.Elevator;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousSimple extends CommandGroup {
    
    public  AutonomousSimple() {
    	addSequential(new ElevatorHome());
    	addSequential(new ElevatorPosition(Elevator.ACCEPT));
    	addSequential(new DriveBackward(0.6, 2.0));
    }
}
