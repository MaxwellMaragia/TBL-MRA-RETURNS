Feature: [SUC:09-06]-Process Tax Return

  @SUC:09-06 @UAT_M4-06-01 @file @returns
  Scenario Outline: UAT_M4-06-01-Verify the Process of Process Tax Return for <Return>
    Given User navigates to the login page
    When Enters the username "tripsuser" and password "Passw0rd" to login
    And Click on return filing and processing > File return
    Then Select return document as "<Return>"
    Then Find tax return for tin "<Tin>" with year "<Year>" and number "<Number>"
    Then Fill in file return details for taxtype "<Return>"
    Then Submit file return application
    Then Verify success message "Record successfully saved with reference number"
    Then Verify and obtain ARN for file "<Arn>"
    Then go to taxpayer accounting > taxpayer account inquiry
    Then Search for tin "<Tin>"
    Then Search for taxtype "<Taxtype>"
    Then Verify taxtype "<Taxtype>" and status "Posted" is shown in table for "<Return>"
    Then Click on case
    Then Verify file returns screen has data for "<Return>"
    Examples:
      | Return                          | Tin      | Number | Year | Arn  | Taxtype               |
      | Capital Gain Tax(CGT) Return    | C0104499 |        |      | CGTR | Capital Gain Tax(CGT) |
      | Company Income Tax(CIT) Return  | V0104530 | 1      | 2021 | CIRT | Company Income Tax    |
      | Dividend Tax Return             | V0104503 |        |      | DIVR | Dividend Tax          |
      | Domestic Excise Return          | C0104499 | 1      | 2022 | DEXR | Domestic Excise       |
      | Domestic VAT Return             | C0104499 | 1      | 2022 | VATR | Domestic VAT          |
      | Fringe Benefit Tax Return       | C0104499 | 1      | 2022 | FBTR | Fringe Benefit Tax    |
      | Non Resident Tax(NRT) Return    | C0104499 |        |      | NRTR | Non Resident Tax(NRT) |
      | PAYE Tax Return                 | C0104515 | 1      | 2022 | EPMR | PAYE                  |
      | Personal Income Tax(PIT) Return | C0104515 | 1      | 2021 | PIRF | Personal Income Tax   |
      | Provisional Tax(CIT) Return     | V0104503 | 1      | 2022 | CIRP | Company Income Tax    |
      | Provisional Tax(PIT) Return     | C0104515 | 1      | 2022 | PIRP | Personal Income Tax   |
      | Turnover Tax(TOT) Return        | C0104524 | 1      | 2022 | TOTR | Turnover Tax(TOT)     |
      | Withholding Tax(WHT) Return     | C0104499 | 1      | 2022 | WITR | Withholding Tax(WHT)  |