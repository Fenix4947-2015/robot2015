package org.usfirst.frc4947.robot2015.commands;

import org.usfirst.frc4947.robot2015.OI.XBoxButton;
import org.usfirst.frc4947.robot2015.Robot;
import org.usfirst.frc4947.robot2015.subsystems.Elevator;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RobotStackUnstack extends CommandGroup {
    
    public  RobotStackUnstack(int nbTote) {
    	if(nbTote >= 1 && nbTote <= 6){
	    	// Start the stacking sequence if more than one tote

	    	// Prepare to receive tote
    		addSequential(new ElevatorHookHold());
	    	addSequential(new ElevatorPosition(Elevator.ACCEPT));
	    	addSequential(new ConveyorIn());
	    	
    		if(nbTote > 1){
		    	// Stack First Tote
		    	addSequential(new ElevatorStackFirst());

		    	// Stack Other Tote
		    	for(int i = 1; i < nbTote; i++){
			    	addSequential(new ElevatorDown());
			    	addSequential(new ConveyorIn());
			    	addSequential(new ElevatorStack());
		    	}
		    	
		    	// Unstack all the tote
		    	addParallel(new ElevatorUnstack());
	    	}
	    	else{
	    		// If only one tote, just move elevator to transport position
		    	addParallel(new ElevatorPercent(0.5, Elevator.TRANSPORT));
	    	}
	    	
	    	// Prepare robot for next step
	    	addParallel(new DriveBackwardAndRotate180(2));
    	}
    }
    
    @Override
    protected boolean isFinished() {
    	return super.isFinished() || Robot.oi.getJoystickDriverButton(XBoxButton.Back);
    }
}
