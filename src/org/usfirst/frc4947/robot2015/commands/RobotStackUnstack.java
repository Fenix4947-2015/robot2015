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
	    	
    		if(nbTote > 1){
		    	for(int i = 1; i <= nbTote; i++){
			    	addSequential(new ConveyorIn());
			    	
			    	if(i < nbTote){
			    		addSequential(new ElevatorStack());
				    	addSequential(new ElevatorDown());
				    	addSequential(new DriveForward(0.5, 0.5));
			    	}
			    	else{
				    	// Unstack all the tote
				    	addSequential(new ElevatorUnstack());
			    	}
		    	}
	    	}
	    	else{
	    		// If only one tote, just move elevator to transport position
	    		addSequential(new ConveyorIn());
	    		addSequential(new ElevatorPercent(0.5, Elevator.TRANSPORT));
	    	}
	    	
	    	// Prepare robot for next step
    		// TODO Remettre la rotation automatique
	    	//addParallel(new DriveBackwardAndRotate180(2));
    	}
    }
    
    @Override
    protected boolean isFinished() {
    	return super.isFinished() || Robot.oi.getJoystickDriverButton(XBoxButton.Back);
    }
}
