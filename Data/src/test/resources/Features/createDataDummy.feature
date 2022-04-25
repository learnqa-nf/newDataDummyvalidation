Feature: Lending

  @data
  Scenario Outline: Generate Data Dummy
    Given Provide path file "<Excel>" existing and file name "<CSV>"
    Then Generate data dummy from "<Case>"

    Examples: 
      | Case    | Excel            | CSV                                 |
      | APPFILE | .//testData.xlsx | .//resultDataDummyFile//APPFILE.csv |
      | REAFILE | .//testData.xlsx | .//resultDataDummyFile//REAFILE.csv |
      #| PENGURUS | .//testData.xlsx | .//resultDataDummyFile//PENGURUS.csv |
