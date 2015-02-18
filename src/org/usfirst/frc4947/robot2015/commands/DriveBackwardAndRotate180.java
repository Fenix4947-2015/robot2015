package org.usfirst.frc4947.robot2015.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveBackwardAndRotate180 extends CommandGroup {
    
    public  DriveBackwardAndRotate180(double speed, double backwardTimeout) {
    	addSequential(new DriveBackward(speed, backwardTimeout));    	
    	addSequential(new DriveRotate180());
    }
}
