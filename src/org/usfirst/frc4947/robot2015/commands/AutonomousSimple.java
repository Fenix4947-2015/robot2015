package org.usfirst.frc4947.robot2015.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousSimple extends CommandGroup {
    
    public  AutonomousSimple() {
    	addSequential(new DriveForward(0.75, 3));
    }
}
