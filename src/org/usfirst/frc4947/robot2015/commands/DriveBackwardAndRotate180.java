package org.usfirst.frc4947.robot2015.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveBackwardAndRotate180 extends CommandGroup {
    
    public  DriveBackwardAndRotate180(double backwardTimeout) {
    	addSequential(new DriveBackward(0.75, backwardTimeout));    	
    	addSequential(new DriveRotate180());
    }
}
