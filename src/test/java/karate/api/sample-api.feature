Feature: Sample API Tests

  Background:
    * url baseUrl

  Scenario: Get all posts
    Given path '/posts'
    When method GET
    Then status 200
    And match response[0].userId == 1
    And match response[0].id == 1

  Scenario: Get specific post
    Given path '/posts/1'
    When method GET
    Then status 200
    And match response.userId == 1
    And match response.id == 1
    And match response.title == '#string'
    And match response.body == '#string'

  Scenario: Create new post
    Given path '/posts'
    And request { title: 'Test Post', body: 'Test Body', userId: 1 }
    When method POST
    Then status 201
    And match response.title == 'Test Post'
    And match response.body == 'Test Body'
    And match response.userId == 1

  Scenario: Update post
    Given path '/posts/1'
    And request { id: 1, title: 'Updated Title', body: 'Updated Body', userId: 1 }
    When method PUT
    Then status 200
    And match response.title == 'Updated Title'
    And match response.body == 'Updated Body'

  Scenario: Delete post
    Given path '/posts/1'
    When method DELETE
    Then status 200