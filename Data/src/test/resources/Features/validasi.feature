Feature: Report Auto Validation

  Scenario Outline: Validation DataDummy with Report TextFile
    Given Provide file Excel compare "<CSV>"
    
    Examples:
    |CSV|
    |APPFILE|
    |REAFILE|
    #|PENGURUS|