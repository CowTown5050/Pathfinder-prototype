package org.usfirst.frc.team5050.robot.subsystems;

import org.usfirst.frc.team5050.robot.RobotMap;
import org.usfirst.frc.team5050.robot.commands.*;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.*;

/**
 *
 */
public class Carriage extends PIDSubsystem {
	VictorSP elevator = RobotMap.elevator;
	AnalogPotentiometer pot = RobotMap.pot;
	
    // Initialize your subsystem here
    public Carriage() {
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	super("Carriage", 20,0,0);
    	getPIDController().setContinuous(false);
    	setAbsoluteTolerance(.05);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new Manual());
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return pot.get();
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	elevator.pidWrite(output);
    }
    
    public void manual(double righty) {
    	elevator.set(-righty);
    }
    
}
