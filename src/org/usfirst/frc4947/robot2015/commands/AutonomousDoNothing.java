package org.usfirst.frc4947.robot2015.commands;

import org.usfirst.frc4947.robot2015.subsystems.Elevator;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousDoNothing extends CommandGroup {
    
    public  AutonomousDoNothing() {
    	addSequential(new ElevatorHome());
    	addSequential(new ElevatorPosition(Elevator.ACCEPT));
    }
}
