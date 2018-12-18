package org.usfirst.frc.team5050.robot.subsystems;

import org.usfirst.frc.team5050.robot.RobotMap;
import org.usfirst.frc.team5050.robot.commands.ArcadeDrive;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
/**
 *
 */
public class drivetrain extends PIDSubsystem {
	private DifferentialDrive drivetrain = new DifferentialDrive(RobotMap.left, RobotMap.right);

    // Initialize your subsystem here
    public drivetrain() {
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	super("drivetrain", .05,0,.002);
    	getPIDController().setContinuous(false);
    	setAbsoluteTolerance(.05);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	setDefaultCommand(new org.usfirst.frc.team5050.robot.commands.curve());
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return 0.0;
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    }
    
	public void TeleopDrive(Joystick driver) {
		drivetrain.arcadeDrive(driver.getY() * -1, driver.getX());
	}
	
	public void Stop() {
		drivetrain.arcadeDrive(0, 0);
	}
	
	public void curve(double l, double r, double turn) {
        drivetrain.tankDrive(l + turn, r - turn);
	}
}


