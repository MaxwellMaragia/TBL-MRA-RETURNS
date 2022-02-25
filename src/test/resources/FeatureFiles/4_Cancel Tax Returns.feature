Feature: [SUC:09-11] Cancel Tax Return

  @ind  @sanity @cancel @returns-ind
  Scenario Outline: Verify the process of Cancel Tax Return for <Return>
    Given User navigates to the login page
    When Enters the username "tripsuser" and password "Passw0rd" to login
    And Click on return filing and processing > Cancel return
    Then Select return document as "<Return>"
    Then Find tax return for tin "<Tin>" with year "<Year>" and number "<Number>"
    Then Select reason for cancellation as "RETURN POSTED TO WRONG TAXPAYER" "<Return>"
    Then Click cancel return
    Then Click yes
    Then Verify success message "Tax return has successfully saved.The status is now pending cancellation"
    Then Obtain reference number for cancellation "Tax return has successfully saved.The status is now pending cancellation"
    Then Open CRM and close modal
    And Click on Case management dropdown
    And click on Returns Tax return application
    Then switch to frame0
    When enters cancel reference number in search results
    Then Click on reference number
    Then switch to frame1
    And Approve adjust returns application
    Then Click on Returns Save button
    Then switch to frame1
    And Verify approval "Approved"
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
#      | Provisional Tax(CIT) Return     | V0105306 | 1      | 2020 | CIRP | Company Income Tax    |
#      | Provisional Tax(PIT) Return     | C0105292 | 1      | 2020 | PIRP | Personal Income Tax   |
      | Turnover Tax(TOT) Return        | C0104524 | 3      | 2022 | TOTR | Turnover Tax(TOT)     |
      | Withholding Tax(WHT) Return     | C0105274 | 1      | 2022 | WITR | Withholding Tax(WHT)  |