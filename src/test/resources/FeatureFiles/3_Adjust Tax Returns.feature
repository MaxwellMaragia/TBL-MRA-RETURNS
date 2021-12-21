Feature: [SUC:09-10] Adjust Tax Return

  @SUC:09-10 @UAT_M4-10-02 @adjust @returns
  Scenario Outline: UAT_M4-10-02 Verify the Process of Return Adjustment for <Return>
    Given User navigates to the login page
    When Enters the username "tripsuser" and password "Passw0rd" to login
    And Click on return filing and processing > Adjust return
    Then Select return document as "<Return>"
    Then Find tax return for tin "<Tin>" with year "<Year>" and number "<Number>"
    Then Perform amendment for taxtype "<Return>"
    Then Submit adjust return application
    Then Verify success message "Tax return has been successfully saved.The status is now pending approval."
    Then Obtain reference number for adjust "Tax return has been successfully saved.The status is now pending approval."
    Then Open CRM and close modal
    And Click on Case management dropdown
    And click on Returns Tax return application
    Then switch to frame0
    When enters adjust reference number in search results
    Then Click on reference number
    Then switch to frame1
    And Approve adjust returns application
    Then Click on Returns Save button
    Then switch to frame1
    And Verify approval "Approved"
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