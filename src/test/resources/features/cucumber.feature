Feature: Register a Medical Equipment
  As a Hospital manager
  I want to register my Medical Equipment
  To be able to see it in a future check

  Scenario: The Manager has registered his Medical Equipment successfully
    Given a Manager in the Medical Equipments register view
    And the information entered is correct
    When the Manager clicks the register button
    And make a post request to "/medical_equipments"
    Then the system promotes the add of the equipment
    And the result received has a status code of 200


  Scenario: The Manager has not registered his Medical Equipment
    Given a Manager in the Medical Equipments register view
    And the information entered is incorrect
    When the Manager clicks the register button
    And make a post request to "/models/100/medical_equipments"
    Then the system asks to correct the wrong data
    And the result received has a status code of 405



