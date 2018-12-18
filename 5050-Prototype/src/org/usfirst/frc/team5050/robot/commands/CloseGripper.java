package org.usfirst.frc.team5050.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5050.robot.Robot;



/**
 *
 */
public class CloseGripper extends Command {

    public CloseGripper() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.gripper);
    	setTimeout(.1);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.gripper.close();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
