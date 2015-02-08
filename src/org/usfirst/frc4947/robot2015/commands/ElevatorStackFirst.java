package org.usfirst.frc4947.robot2015.commands;

import org.usfirst.frc4947.robot2015.subsystems.Elevator;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ElevatorStackFirst extends CommandGroup {
    
    public  ElevatorStackFirst() {
    	addSequential(new ElevatorPercent(1, Elevator.HOOK));
    	addSequential(new ElevatorPercent(.60, Elevator.STACK));
    }
}
