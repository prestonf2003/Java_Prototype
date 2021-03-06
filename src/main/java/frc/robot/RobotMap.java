/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

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

  /**
   *
   */

  // SRX
  public static int frontLeftMotor = 1;
  public static int middleLeftMotor = 5;
  public static int backLeftMotor = 3;
  
  public static int frontRightMotor = 2;
  public static int middleRightMotor = 6;
  public static int backRightMotor = 4;
  

  public static int elevator_talon = 7;
  public final static int kTimeoutMs = 30;
public static double elevatorGearDiameter= 2.1;//this is not the real number this is a non magical number.  
public final static int hold = -1;
public final static int floorHeight = 0;
public final static int jogLowerLimit = 0;
public final static int  switchHeight = 5168;
public final static int  lowScaleHeight = 14116;
public final static int highScaleHeight = 21044;
public final static int jogUpperLimit = 21500; 
public static int elevatorCommandedPosition = hold;
public static int ElevatorLimitSwitchInput = 2;
public static int ElevatorJogUpButton = 5;
public static int ElevatorJogDownButton = 6;
public static int ElevatorRate = 200; //encoder counts per 20 mil secs
public static double JogUpdateDistanceOvertravelOffset = 4.0; /* inches */
public static double JogDownDistanceOvertravelOffset = 4.5; /* inches */
public static double ElevatorTicksPerInch = 288.669f; /*  ticks */
private static int ElevatorTicksAtBottomFromFloor = 2915; /* ticks */

public static int driverController = 0; // driver joystick
  public static int operatorController = 1; // operator joystick
  public static int forwardReverseAxis = 1;
  public static int leftRightAxis = 4;

  public final static int PID_PRIMARY = 0;

  public static int intake_talon_1 = 11;
  public static int intake_talon_2 = 10; 

  public static double intakeInSpeed = 0.5; // controls speed of motors for bringing in a cube
  public static double intakeOutSpeed = -0.5; // controls speed of motors for shooting out a cube
  public static double intakeHoldSpeed = 0.3; // controls speed of motors to hold cube
  public static double joystickIsActive = 0.1; 
  public static int intakeStop = 0; 

  public static int intakeInAxisNumber = 3;
  public static int intakeOutAxisNumber = 2;
  
  public static int wristTalon = 8;
  public static int wristUpAxisNumber = 2;
  public static int wristDownAxisNumber = 3;

  public static double wristDownSpeed = -0.3;
  public static double wristUpSpeed = 0.75;
  public static double wristHoldSpeed = 0.4;
  public static int wristMotorStop = 0; 

  public int convertRelativeInchesToElevatorTicks(double inches) {
    return (int)(inches * ElevatorTicksPerInch);
  }

  public int convertAbsoluteInchesToElevatorTicks(double inches) {
    return (int)(inches * ElevatorTicksPerInch) + ElevatorTicksAtBottomFromFloor;

    /* y = m(x) + b

    where:
    y is the number of ticks to send to the talon set() function
    m is the number of ticks per inch of elevator travel
    b is the number of ticks that represent the height of the lowest point the elevator can travel
     (the "0" tick) and the floor.
     */
  }

  public static int wristMotorStop = 0;
  public static int WristRate = 100; //encoder counts per 20 mil secs 
  public static int ButtonWristFortyFiveButton = 2; // Takes wrist to 45 degree angle position
  public static int wristJogLowerLimit = 100; // Don't go below this encoder count on the way down
  public static int wristJogUpperLimit = 500; // Don't go above this encoder count on the way up
}