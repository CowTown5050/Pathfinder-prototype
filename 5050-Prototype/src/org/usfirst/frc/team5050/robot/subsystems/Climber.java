package org.usfirst.frc.team5050.robot.subsystems;

import org.usfirst.frc.team5050.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {
	private DoubleSolenoid climber = RobotMap.Scissor;
	private TalonSRX winch = RobotMap.winch;
	

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	climber.set(DoubleSolenoid.Value.kOff);
    	winch.set(ControlMode.PercentOutput, 0);
    	
    }
    
    public void fire() {
    	climber.set(DoubleSolenoid.Value.kForward);
    }
    
    public void airborne() {
    	climber.set(DoubleSolenoid.Value.kReverse);
    	winch.set(ControlMode.PercentOutput, 1);
    }
    
    public void cease() {
    	climber.set(DoubleSolenoid.Value.kReverse);
    	winch.set(ControlMode.PercentOutput, 0);
    }
}

