package org.usfirst.frc.team5050.robot.subsystems;

import org.usfirst.frc.team5050.robot.RobotMap;
import org.usfirst.frc.team5050.robot.commands.raisemast;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Mast extends Subsystem {
	Solenoid Mast = RobotMap.mast;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	Mast.set(false);
    	setDefaultCommand(new raisemast());
    }
    public void up(int POV) {
    	if (POV == 0) {
    		Mast.set(true);
    	}
    	
    	
    }
    
    public void down(int POV) {
    	if (POV == 180) {
    		Mast.set(false);
    	}
    }
}

