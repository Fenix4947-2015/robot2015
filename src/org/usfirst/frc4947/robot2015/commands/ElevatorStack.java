package org.usfirst.frc4947.robot2015.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ElevatorStack extends CommandGroup {
    
    public  ElevatorStack() {
    	addSequential(new ElevatorPercent(1, 2300));
    	addSequential(new ElevatorPercent(.35, 0));
    }
}
