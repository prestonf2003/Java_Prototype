/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.commands.ElevatorManualCommand;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.subsystems.elevator;
import com.ctre.phoenix.motorcontrol.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class ElevatorJogDownCommand extends Command {

  public ElevatorJogDownCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.m_elevator);

    SmartDashboard.putNumber("JogDownDistanceOvertravelOffset",4.5);

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    Robot.m_elevator.setTargetPosition(Robot.m_elevator.getTargetPosition() - RobotMap.ElevatorRate) ;
   
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    RobotMap myMap = new RobotMap();

    int elevatorOvershoot = myMap.convertRelativeInchesToElevatorTicks(SmartDashboard.getNumber("JogDownDistanceOvertravelOffset",0.0));
    Robot.m_elevator.setTargetPosition(Robot.m_elevator.getActualPosition()-elevatorOvershoot);
  }
}
