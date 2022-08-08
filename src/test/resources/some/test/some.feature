Feature:

  Background: background nnSome
    Given first step

  Scenario: somesome do math
    Given 1 and 2
    When do sum
    Then expect 3

  Scenario: somesome do math2
    Given 5 and 3
    When do sum
    Then expect 8