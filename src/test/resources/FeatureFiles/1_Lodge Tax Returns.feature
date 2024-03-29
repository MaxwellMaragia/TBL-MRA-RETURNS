Feature: [SUC:09-01]-Lodge Paper Return

  @SUC:09-01 @UAT_M4-01-01 @BR01 @lodge @returns
  Scenario Outline: UAT_M4-01-01-Verify the process of Lodge Paper Return for <Return>
    Given User navigates to the login page
    When Enters the username "tripsuser" and password "Passw0rd" to login
    And Click on return filing and processing > Lodge return
    Then Click Return document search button
    Then Search for taxtype "<Return>" for period year "<Year>" and number "<Number>" and tin "<Tin>"
    Then Enter liability
    Then Submit lodge return application
    Then Verify success message "Returns Lodgement is Successfull with Reference Number"
    Then Verify and obtain ARN "<Arn>"
    Then go to taxpayer accounting > taxpayer account inquiry
    Then Search for tin "<Tin>"
    Then Search for taxtype "<Taxtype>"
    Then Verify taxtype "<Taxtype>" and status "Lodged" is shown in table for "<Return>"
    Then Click on case
    Then Verify lodgement screen has data
    Examples:
      | Return                          | Tin      | Number | Year | Arn  | Taxtype               |
      | Capital Gain Tax(CGT) Return    | C0105274 |        |      | CGTR | Capital Gain Tax(CGT) |
      | Company Income Tax(CIT) Return  | V0105280 | 1      | 2020 | CIRT | Company Income Tax    |
      | Dividend Tax Return             | V0105280 |        |      | DIVR | Dividend Tax          |
      | Domestic Excise Return          | V0105280 | 1      | 2022 | DEXR | Domestic Excise       |
      | Domestic VAT Return             | C0105274 | 1      | 2022 | VATR | Domestic VAT          |
      | Fringe Benefit Tax Return       | C0105274 | 1      | 2022 | FBTR | Fringe Benefit Tax    |
      | Non Resident Tax(NRT) Return    | C0105274 |        |      | NRTR | Non Resident Tax(NRT) |
      | PAYE Tax Return                 | C0105274 | 1      | 2022 | EPMR | PAYE                  |
      | Personal Income Tax(PIT) Return | C0105274 | 1      | 2020 | PIRF | Personal Income Tax   |
      | Provisional Tax(CIT) Return     | V0105306 | 1      | 2020 | CIRP | Company Income Tax    |
      | Provisional Tax(PIT) Return     | C0105292 | 1      | 2020 | PIRP | Personal Income Tax   |
      | Turnover Tax(TOT) Return        | C0104524 | 3      | 2022 | TOTR | Turnover Tax(TOT)     |
      | Withholding Tax(WHT) Return     | C0105274 | 1      | 2022 | WITR | Withholding Tax(WHT)  |