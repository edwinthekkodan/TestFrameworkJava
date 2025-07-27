Feature: Sample API Tests

  Background:
    * url 'https://reqres.in/api'

  Scenario: Get all users
    Given path '/users'
    And param page = 2
    When method GET
    Then status 200
    And match response.page == 2
    And match response.data[0].id == '#number'
    And match response.data[0].email == '#string'

  Scenario: Get specific user
    Given path '/users/2'
    When method GET
    Then status 200
    And match response.data.id == 2
    And match response.data.email == 'janet.weaver@reqres.in'
    And match response.data.first_name == 'Janet'

  Scenario: Create new user
    Given path '/users'
    And request { "name": "John", "job": "QA Engineer" }
    When method POST
    Then status 201
    And match response.name == 'John'
    And match response.job == 'QA Engineer'
    And match response.id == '#string'

  Scenario: Update user
    Given path '/users/2'
    And request { "name": "Jane Updated", "job": "Senior QA" }
    When method PUT
    Then status 200
    And match response.name == 'Jane Updated'
    And match response.job == 'Senior QA'

  Scenario: Delete user
    Given path '/users/2'
    When method DELETE
    Then status 204