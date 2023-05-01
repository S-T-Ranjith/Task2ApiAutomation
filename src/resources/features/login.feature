Feature: Feature to test APIs


  @apiTest @register_user
  Scenario: Check Single user APIs with get request
    Given User set "/api/register" service endpoint
    When User perform "POST" request type for "REGISTER_USER"
    Then User receives valid response code
    Then User verify sample response

  @apiTest @create_user
  Scenario: Check Single user APIs with get request
    Given User set "/api/users" service endpoint
    When User perform "POST" request type for "CREATE"
    Then User receives valid response code
    Then User verify sample response

  @apiTest @single_user
  Scenario: Check Single user APIs with get request
    Given User set "/api/users/2" service endpoint
    When User perform "GET" request type for "SINGLE_USER"
    Then User receives valid response code
    Then User verify sample response

  @apiTest @list_user
  Scenario: Check Single user APIs with get request
    Given User set "/api/users?page=2" service endpoint
    When User perform "GET" request type for "LIST_USERS"
    Then User receives valid response code
    Then User verify sample response

  @apiTest @single_user_not_found
  Scenario: Check Single user APIs with get request
    Given User set "/api/users/23" service endpoint
    When User perform "GET" request type for "LIST_USERS_NOT_FOUND"
    Then User receives valid response code
    Then User verify sample response

  @apiTest @update_user
  Scenario: Check Single user APIs with get request
    Given User set "/api/users/2" service endpoint
    When User perform "PUT" request type for "PUT"
    Then User receives valid response code
    Then User verify sample response

  @apiTest @patch_user
  Scenario: Check Single user APIs with get request
    Given User set "/api/users/2" service endpoint
    When User perform "PATCH" request type for "PATCH"
    Then User receives valid response code
    Then User verify sample response


  @apiTest @delete_user
  Scenario: Check Single user APIs with get request
    Given User set "/api/users/2" service endpoint
    When User perform "DELETE" request type for "DELETE"
    Then User receives valid response code
    Then User verify sample response





