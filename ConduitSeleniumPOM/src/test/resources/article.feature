Feature: Conduit Article CRUD

Background:
  When user logs in with valid credentials

Scenario Outline: Create Article
  When user creates article "<title>" "<description>" "<body>"
  Then article should be created successfully

Examples:
  | title     | description | body               |
  | Article  | Automation  | Selenium article  |
  | Article1  | Testing     | Testing article |

Scenario: Update Article
  When user creates article "UpdateTitle" "UpdateDesc" "UpdateBody"
  And user updates article using datatable
    | body                    |
    | Updated article content |
  Then article should be updated successfully

Scenario: Delete Article
  When user creates article "DeleteTitle" "DeleteDesc" "DeleteBody"
  And user deletes article using datatable
    | title       |
    | DeleteTitle |
  Then article should be deleted successfully