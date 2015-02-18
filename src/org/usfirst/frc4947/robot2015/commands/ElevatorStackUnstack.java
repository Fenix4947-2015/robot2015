package org.usfirst.frc4947.robot2015.commands;

import org.usfirst.frc4947.robot2015.subsystems.Elevator;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ElevatorStackUnstack extends CommandGroup {
    
    public  ElevatorStackUnstack() {
    	addSequential(new ElevatorPosition(Elevator.HOOK));
    	addSequential(new ElevatorHookRelease());
    	addSequential(new ElevatorPercent(0.5, Elevator.TRANSPORT));
    }
}
