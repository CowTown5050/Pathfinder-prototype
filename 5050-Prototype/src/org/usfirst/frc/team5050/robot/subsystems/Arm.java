package org.usfirst.frc.team5050.robot.subsystems;



import org.usfirst.frc.team5050.robot.RobotMap;
import org.usfirst.frc.team5050.robot.commands.arm;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {
	private Spark Arm = RobotMap.arm;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new arm());
    }
    
    public void move(double lefty) {
    	Arm.set(lefty);
    }
}

