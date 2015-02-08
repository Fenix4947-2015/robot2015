package org.usfirst.frc4947.robot2015.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ElevatorDown extends CommandGroup {
    
    public  ElevatorDown() {
    	addSequential(new ElevatorPercent(0.25, 250));    	
    	addSequential(new ElevatorPosition(4650));
    }
}
