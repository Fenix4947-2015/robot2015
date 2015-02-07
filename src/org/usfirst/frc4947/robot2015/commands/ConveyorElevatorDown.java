package org.usfirst.frc4947.robot2015.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ConveyorElevatorDown extends CommandGroup {
    
    public  ConveyorElevatorDown() {
    	addSequential(new ConveyorElevatorPercent(0.25, 250));    	
    	addSequential(new ConveyorElevatorPosition(4650));
    }
}
