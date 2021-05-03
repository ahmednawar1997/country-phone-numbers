# country-phone-numbers
List of all phone numbers available in the DB. Filter by country and state.

## Development Process
* Used SQLiteStudio to view DB schema
* Add two new columns country and state(isValid)
* Migrate old data using regex to validate phone number and set the state in db
* Migrate old data by extracting the country code and setting the country in db
* Decided that changing the db schema is better and more scalable when dealing with big data, so when we need to filter by country or state we can query it directly from the db
* REGEXP function is not supported in SQLite
* Enabled CORS

## Architecture
* **CustomerController** with two endpoints:
  * Fetch all customers with filters
    * URL: "/"
    * method: GET
    * Required params: [int] page, [int] numPerPage
    * Non required params: [String] country, [Boolean] state

  * Count customers with filters
    * URL: "/count"
    * method: GET
    * Non required params: [String] country, [Boolean] state
* **CustomerService** : Logic is implemented here to alter and validate data
* **CustomerDao** : To access the database and write the queries
* **CustomerSetter** : To set values in jdbc template methods to avoid sql injection
* **CustomerMapper** : To fill model with data on retrieval from db

* **CountryUtils** : Helper functions
* **DataMigration** : This code ran only once on application start to migrate data



## Entities
* **Customer Model** : Holds Customer data
* **Country Enum** : To restrict country initialization
* **Filter Object** : To wrap filter attributes and navigation object
* **Navigation Object** : To wrap pagination attributes


## Testing
### Built unit tests to test the service methods
* countCustomers: To test that data retieved from db is the correct count
* searchCustomers: Test that count and fetch customers filter the same criteria
* searchCustomers: Test customers retrieved with correct country
* checkPagination: Test pagination fetches correct number of data
* checkFirstCustomer: Test first customer retrieved from db
