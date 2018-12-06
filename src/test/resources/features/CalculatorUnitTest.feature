Feature: Calculator unit test

  @CalculatorTest
  Scenario Outline: Test of <function>
    Given that I have a calculator
    When I perform the function <function> with the numbers <x> and <y>
    Then the calculator should give the result <result>

    Examples:
      | function       | x | y | result |
      | addition       | 6 | 8 | 14     |
      | subtraction    | 8 | 6 | 2      |
      | multiplication | 5 | 4 | 20     |
      | division       | 1 | 2 | 0.5    |
      | modulo         | 5 | 2 | 1      |
      | percentage     | 8 | 4 | 50.0   |
