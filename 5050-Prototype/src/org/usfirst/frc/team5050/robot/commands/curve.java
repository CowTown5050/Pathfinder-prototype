package org.usfirst.frc.team5050.robot.commands;

import org.usfirst.frc.team5050.robot.Robot;
import org.usfirst.frc.team5050.robot.RobotMap;
import org.usfirst.frc.team5050.robot.subsystems.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.followers.EncoderFollower;
import jaci.pathfinder.modifiers.TankModifier;

/**
 *
 */
public class curve extends Command {

    public curve() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		Waypoint[] points = new Waypoint[] {
        	    new Waypoint(-2, -4, Pathfinder.d2r(-45)),      // Waypoint @ x=-4, y=-1, exit angle=-45 degrees
        	    new Waypoint(-2, -2, 0),                        // Waypoint @ x=-2, y=-2, exit angle=0 radians
        	    new Waypoint(0, 0, 0)                           // Waypoint @ x=0, y=0,   exit angle=0 radians
        	};

    	Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH, 0.05, 1.7, 2.0, 60.0);
    	Trajectory trajectory = Pathfinder.generate(points, config);
        TankModifier modifier = new TankModifier(trajectory).modify(0.5);
        EncoderFollower left = new EncoderFollower(modifier.getLeftTrajectory());
        EncoderFollower right = new EncoderFollower(modifier.getRightTrajectory());
        left.configureEncoder(RobotMap.leftenc.get(), 1000, 6);
        right.configureEncoder(RobotMap.rightenc.get(), 1000, 6);
        left.configurePIDVA(0.05, 0.0, 0.002, 1/10.62, 5);
        right.configurePIDVA(0.05, 0.0, 0.002, 1/10.62, 5);
        double l = left.calculate(RobotMap.leftenc.get());
        double r = right.calculate(RobotMap.leftenc.get());

        double gyro_heading = RobotMap.gyro.getAngle();    // Assuming the gyro is giving a value in degrees
        double desired_heading = Pathfinder.r2d(left.getHeading());  // Should also be in degrees
        double angleDifference = Pathfinder.boundHalfDegrees(desired_heading - gyro_heading);
        double turn = 0.8 * (-1.0/80.0) * angleDifference;
    	Robot.drivetrain.curve(l, r, turn);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
