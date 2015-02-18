package org.usfirst.frc4947.robot2015.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousDoNothing extends CommandGroup {
    
    public  AutonomousDoNothing() {
    	addSequential(new ElevatorHome());
    }
}
