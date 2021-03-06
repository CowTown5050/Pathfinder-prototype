package org.usfirst.frc.team5050.robot.models;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;

/**
 *
 * @author mwtidd
 */
public class XboxRightTrigger extends Button {

	private final Joystick joystick;

	public XboxRightTrigger(Joystick joystick) {
		this.joystick = joystick;

	}

	public boolean get() {
		return joystick.getRawAxis(3) >= .9;
	}

}