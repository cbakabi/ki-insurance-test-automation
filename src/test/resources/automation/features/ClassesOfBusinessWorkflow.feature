Feature: Verify current class of business workflow works as expected

  Scenario Outline: Workflow by business class
    Given I am on the Ki Insurance Mock Platform page
    And I click the button to Create a new quote
    When I click the button to the next page
    Then I select a country from the drop down menu for primary country "<country>"
    And I select a company from the drop down menu for primary insured "<insured>"
    And I select a business type from the list of options for class of business "<business>"
    When I click on the Next button
    Then I input the Inception date "<date>", "<month>", "<year>"
    And I enter the "<AUM value>" for the quote
    And I enter the "<premium value>" in dollars for the quote
    When I click on the Next button
    And I verify that the message body contains "Submission completed. Your quote has been created successfully."
    And I verify that the message body contains "You will receive an email when the quote is ready. You can check the status of your pending quotes from the Pending Quotes screen."
    And I click the button to See my pending quotes
    When I click the button to the next page
    Then I verify that a quote for "<business name>" is present in the pending quotes
    And I verify that the class and premium is "<class and premium value>"
    And I leave the Ki Insurance Mock Platform page
    Examples:
      | country                  | insured           | business | date | month | year | AUM value  | premium value | business name     | class and premium value             |
      | Germany                  | Newco Ltd         | Cyber    | 06   | 10    | 2022 | 20000000   | 30000000      | Newco Ltd         | CLASS: Cyber // PREMIUM: $30M       |
      | Spain                    | AAA Inc           | Energy   | 20   | 03    | 2021 | 39999999   | 1000000000    | AAA Inc           | CLASS: Energy // PREMIUM: $1B       |
      | United States of America | Finance Group Ltd | Property | 04   | 07    | 1990 | 64590000   | 15720000      | Finance Group Ltd | CLASS: Property // PREMIUM: $15.72M |


  Scenario Outline: Verify quotes in the pending quotes
    Given I am on the Ki Insurance Mock Platform page
    And I click the button to See my pending quotes
    When I click the button to the next page
    Then I verify that a quote for "<business name>" is present in the pending quotes
    And I verify that the class and premium is "<class and premium value>"
    And I leave the Ki Insurance Mock Platform page
    Examples:
      | business name           | class and premium value           |
      | Service Tech Ltd        | CLASS: Cyber // PREMIUM: $560K    |
      | Logistics Worldwide Inc | CLASS: Property // PREMIUM: $2.4M |
      | XYZ Holdings PLC        | CLASS: Energy // PREMIUM: $1.3M   |

