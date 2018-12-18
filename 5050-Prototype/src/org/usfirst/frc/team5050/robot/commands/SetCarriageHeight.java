package org.usfirst.frc.team5050.robot.commands;

import org.usfirst.frc.team5050.robot.Robot;
import org.usfirst.frc.team5050.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/*
 */
public class SetCarriageHeight extends Command {
	private double Setpoint;
	public static boolean enabled = false;
    
	public SetCarriageHeight(double setpoint) {
		Setpoint = setpoint;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.Carriage);
    }
	
	/*public SetCarriageHeight(boolean set) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		if(set) {
			Setpoint = RobotMap.pot.get();
			Robot.Carriage.enable();
	    	Robot.Carriage.setSetpoint(Setpoint);
    		
		} else {
			
		}
    }*/

    // Called just before this Command runs the first time
    protected void initialize() {
    	enabled = true;
    	if (Robot.m_oi.operatorController.xButton.get()) {
    		Setpoint = RobotMap.pot.get();
    	}
    	
    	
    	Robot.Carriage.enable();
    	Robot.Carriage.setSetpoint(Setpoint);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	enabled = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(Robot.m_oi.operatorController.getRightStickY() <= -.2 || Robot.m_oi.operatorController.getRightStickY() >= .2) {
    		return true;
    	} else {
    		return false;
    	}
        	
        
    }

    // Called once after isFinished returns true
    protected void end() {
    	enabled = false;
    }
    

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	enabled = false;
    }
    
   
}
