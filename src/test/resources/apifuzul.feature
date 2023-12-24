@API
Feature: Fuzul API Test

  @TC001 @smoke
  Scenario:TC001_For_Entity_API_Test
    Given Send GET request for Entity
    Then Verifies that status code is equal to 200
    Then Verifies that data with id number 15 exists
    Then Verifies that the data.value contains "Satılık"


  @TC002 @smoke
  Scenario:TC002_For_EntityGroup_API_Test
    Given Send a GET request for EntityGroup
    Then Verifies that status code is equal to 200
    Then Verifies that data with id number 15 20 23 exists
    Then Verifies that the Emlak tipi contains "Satılık" "Kiralık" "Günlük"
    Then User verifies that the Oda Sayisi contains "3 + 1"



  @TC003 @smoke
  Scenario:TC003_For_Item_API_Test
    Given Sends a GET request for Product
    Then Verifies that status code is equal to 200
    Then Verifies that pageSize is equal to 30
    Then Verifies that apiResultType is equal to 1
    Then Verifies that the data contains 30 values




