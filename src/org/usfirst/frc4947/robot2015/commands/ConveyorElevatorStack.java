package org.usfirst.frc4947.robot2015.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ConveyorElevatorStack extends CommandGroup {
    
    public  ConveyorElevatorStack() {
    	addSequential(new ConveyorElevatorPercent(1, 2300));
    	addSequential(new ConveyorElevatorPercent(.35, 0));
    }
}
