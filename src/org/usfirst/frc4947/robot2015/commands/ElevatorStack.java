package org.usfirst.frc4947.robot2015.commands;

import org.usfirst.frc4947.robot2015.subsystems.Elevator;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ElevatorStack extends CommandGroup {
    
    public  ElevatorStack() {
    	addSequential(new ElevatorPercent(1, Elevator.SLOWDOWN));
    	addSequential(new ElevatorPercent(.35, Elevator.STACK));
    }
}
