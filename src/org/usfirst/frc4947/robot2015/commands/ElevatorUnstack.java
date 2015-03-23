package org.usfirst.frc4947.robot2015.commands;

import org.usfirst.frc4947.robot2015.subsystems.Elevator;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ElevatorUnstack extends CommandGroup {
    
    public  ElevatorUnstack() {
    	addSequential(new ElevatorPosition(Elevator.STACK));
    	addSequential(new ElevatorHookRelease());
    	//addSequential(new ElevatorPercent(0.5, Elevator.TRANSPORT));
    	addSequential(new ElevatorPosition(Elevator.TRANSPORT));
    }
}
