/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.VictorSP;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends IterativeRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  Joystick joyStk = new Joystick(0);
  
  /* create value for each of the 8 current motor controllers. These are based
  *  value from the PhoenixTuner.
  */
  int leftFrontUpperMotorID = 8;
  int leftFrontLowerMotorID = 7;
  int leftRearUpperMotorID = 10;
  int leftRearLowerMotorID = 5;
  int rightFrontUpperMotorID = 4;
  int rightFrontLowerMotorID = 5;
  int rightRearUpperMotorID = 2;
  int rightRearLowerMotorID = 3;

  TalonSRX motorLA = new TalonSRX(leftRearUpperMotorID);
  TalonSRX motorLB = new TalonSRX(leftFrontUpperMotorID);
  TalonSRX motorLC = new TalonSRX(leftFrontLowerMotorID);
  TalonSRX motorLD = new TalonSRX(leftRearLowerMotorID);
  VictorSPX motorRA = new VictorSPX(rightRearUpperMotorID);
  VictorSPX motorRB = new VictorSPX(rightFrontUpperMotorID);
  VictorSPX motorRC = new VictorSPX(rightFrontLowerMotorID);
  VictorSPX motorRD = new VictorSPX(rightRearLowerMotorID);
  
  // Right front motor Id
  //int rightFrontMotorId = 0;
  //int leftFrontMotorID = 11;
  //int rightBackMotorID = 2;
  //int leftBackMotorID = 3;
  //TalonSRX motorControllerRightFrontMotor = new TalonSRX(rightFrontMotorId);
  //TalonSRX motorCLeftFront = new TalonSRX(leftFrontMotorID);
  //TalonSRX motorCRightBack = new TalonSRX(rightBackMotorID);
  //TalonSRX motorCLeftBack = new TalonSRX(leftBackMotorID);

 
  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like diagnostics that you want ran during disabled, autonomous,
   * teleoperated and test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable chooser
   * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
   * remove all of the chooser code and uncomment the getString line to get the
   * auto name from the text box below the Gyro
   *
   * <p>
   * You can add additional auto modes by adding additional comparisons to the
   * switch structure below with additional strings. If using the SendableChooser
   * make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // autoSelected = SmartDashboard.getString("Auto Selector",
    // defaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    switch (m_autoSelected) {
    case kCustomAuto:
      // Put custom auto code here
      break;
    case kDefaultAuto:
    default:
      // Put default auto code here
      break;
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {

    double joyStkOutput = joyStk.getY();

    //motorControllerRightFrontMotor.set(ControlMode.PercentOutput, joyStkOutput);
    //motorCLeftFront.set(ControlMode.PercentOutput, joyStkOutput);
    motorLA.set(ControlMode.PercentOutput,joyStkOutput);
    motorLB.set(ControlMode.PercentOutput,joyStkOutput);
    motorLC.set(ControlMode.PercentOutput,joyStkOutput);
    motorLD.set(ControlMode.PercentOutput,joyStkOutput);
    motorRA.set(ControlMode.PercentOutput,joyStkOutput);
    motorRB.set(ControlMode.PercentOutput,joyStkOutput);
    motorRC.set(ControlMode.PercentOutput,joyStkOutput);
    motorRD.set(ControlMode.PercentOutput,joyStkOutput);
    //motorCRightBack.set(ControlMode.PercentOutput, joyStkOutput);
    //motorCLeftBack.set(ControlMode.PercentOutput, joyStkOutput);
  }
 

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
