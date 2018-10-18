/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.*;
import frc.robot.commands.ElevatorManualCommand;
import com.ctre.phoenix.motorcontrol.*;
/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class elevator extends Subsystem {
public static WPI_TalonSRX m_elevator_talon = new WPI_TalonSRX (RobotMap.elevator_talon);
public enum  ElevatorDirection {
  Up, Down, Hold
};


public void periodic() {



}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new ElevatorManualCommand());
		m_elevator_talon.configSelectedFeedbackSensor(	FeedbackDevice.QuadEncoder,				// Local Feedback Source

		RobotMap.PID_PRIMARY,					// PID Slot for Source [0, 1]

    RobotMap.kTimeoutMs);	
    m_elevator_talon.configSensorTerm(SensorTerm.Sum0, FeedbackDevice.RemoteSensor0, RobotMap.kTimeoutMs);				// Feedback Device of Remote Talon

		m_elevator_talon.configSensorTerm(SensorTerm.Sum1, FeedbackDevice.CTRE_MagEncoder_Relative, RobotMap.kTimeoutMs);	// Quadrature Encoder of current Talon		
  }
  public void elevatorJog(ElevatorDirection Direction ) {
    //getQuadraturePosition();


  }
}
