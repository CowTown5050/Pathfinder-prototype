package org.usfirst.frc.team5050.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team5050.robot.RobotMap;
/**
 *
 */
public class Gripper extends Subsystem {
	
	DoubleSolenoid Gripper = RobotMap.gripper;
	
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	Gripper.set(DoubleSolenoid.Value.kOff);
    }
    
    public void open() {
    	Gripper.set(DoubleSolenoid.Value.kReverse);
    	
    }
    public void close() {
    	Gripper.set(DoubleSolenoid.Value.kForward);
    }
    
    
    
}


