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

    		// Prepare to receive tote
    		addSequential(new ElevatorHookHold());
    		addParallel(new ElevatorPosition(Elevator.ACCEPT));
	    	
    		if(nbTote > 1){
		    	for(int i = 1; i <= nbTote; i++){
		    		// Activate the conveyor in with delay if not first tote
	    			addSequential(new ConveyorIn());
	    			
	    			addParallel(new ConveyorReverse(1));
			    	
			    	if(i < nbTote){
			    		addSequential(new ElevatorStack());
			    		addParallel(new DriveForward(0.6, 0.6));
			    		//addParallel(new ElevatorPosition(Elevator.ACCEPT));
			    		addSequential(new ElevatorPosition(Elevator.ACCEPT));
			    		//addParallel(new ElevatorDown()); 
			    	}
			    	else{
				    	// Unstack all the tote
			    		addParallel(new ElevatorStackUnstack());
			    	}
		    	}
	    	}
	    	else{
	    		// If only one tote, just move elevator to transport position
	    		addSequential(new ConveyorIn());
	    		//addSequential(new ElevatorPercent(0.65, Elevator.TRANSPORT));
	    		addSequential(new ElevatorPosition(Elevator.TRANSPORT));
	    	}
	    	
	    	// Prepare robot for next step
    		addParallel(new DriveBackward(0.6, 1));
    		//addParallel(new DriveBackwardAndRotate180(0.6, 2));
    	}
    }
    
    @Override
    protected boolean isFinished() {
    	return super.isFinished() || Robot.oi.getJoystickDriverButton(XBoxButton.Back);
    }
}
