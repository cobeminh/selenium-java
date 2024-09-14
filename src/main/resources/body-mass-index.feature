Feature: Body mass index
  Background:
    as a user i want to calculate my BMI in Unit metric
    Scenario: metric unit
      Given user open chrome
      And navigate to BMI calculate page
      When user choose metric tab
      And clear form
      When user input age is 25
      And gender is female
      And height is 175
      And weight is 67
      And submit the form
      Then the result is 21.9