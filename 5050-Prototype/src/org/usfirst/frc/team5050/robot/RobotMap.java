/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5050.robot;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.I2C.Port;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	//motors
	public static VictorSP left = new VictorSP(0);
	public static VictorSP right = new VictorSP(1);
	public static Spark arm = new Spark(2);
	public static VictorSP elevator = new VictorSP(3);
	public static TalonSRX winch = new TalonSRX(0);
	//solenoids
	public static DoubleSolenoid gripper = new DoubleSolenoid(1,2);
	public static DoubleSolenoid Scissor = new DoubleSolenoid(3,4);
	public static Solenoid mast = new Solenoid(0);
	//sensors
	public static AnalogPotentiometer pot = new AnalogPotentiometer(0, 1, 0);
	public static Encoder leftenc = new Encoder(0,1);
	public static Encoder rightenc = new Encoder(2,3);
	public static I2C pixy = new I2C(Port.kOnboard,0);
	public static ADXRS450_Gyro gyro = new ADXRS450_Gyro();
}
