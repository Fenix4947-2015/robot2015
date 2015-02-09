package org.usfirst.frc4947.robot2015.commands;

import org.usfirst.frc4947.robot2015.subsystems.Elevator;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ElevatorDown extends CommandGroup {
    
    public  ElevatorDown() {
    	addSequential(new ElevatorPercent(0.25, Elevator.HOOK));    	
    	addSequential(new ElevatorPosition(Elevator.ACCEPT));
    }
}
