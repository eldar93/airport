# airport
Test task Accenture

##### -- Input CVS files are loaded into in-memory H2 database during application startup.

##### -- Applciation supports two selection strategies: for direct search (enabled by default) and fuzzy input parameter (use "fuzzy" parameter set to "true", "1" or "yes" to enable fuzzy search. See for examples below).

##### -- The application also supports pagination by specifying parameters "page" - page number and "size" - page size (count of records per page).

### Endpoints examples:

*-- to search by country name:*  http://localhost:8080/airports/countryName/Netherlands

*-- to search by country code:*  http://localhost:8080/airports/countryCode/FR

*-- to search by country name with pagination params:* http://localhost:8080/airports/countryName/Netherlands?page=1&size=2

*-- to enable fuzzy search by country name (country name specified partially):* http://localhost:8080/airports/countryName/Belg?fuzzy=true

*-- to get top ten countries with highest numbers of airports:*  http://localhost:8080/airports/topTenCountries

Output example:

```JSON
{
    "_embedded": {
        "countries": [
            {
                "name": "United States",
                "code": "US",
                "airportsCount": 23820
            },
            {
                "name": "Brazil",
                "code": "BR",
                "airportsCount": 5324
            },
            {
                "name": "Canada",
                "code": "CA",
                "airportsCount": 2803
            },
            {
                "name": "Australia",
                "code": "AU",
                "airportsCount": 2021
            },
            {
                "name": "Mexico",
                "code": "MX",
                "airportsCount": 1531
            },
            {
                "name": "South Korea",
                "code": "KR",
                "airportsCount": 1374
            },
            {
                "name": "United Kingdom",
                "code": "GB",
                "airportsCount": 1267
            },
            {
                "name": "Russia",
                "code": "RU",
                "airportsCount": 1123
            },
            {
                "name": "Germany",
                "code": "DE",
                "airportsCount": 963
            },
            {
                "name": "France",
                "code": "FR",
                "airportsCount": 903
            }
        ]
    },
    "_links": {
        "self": {
            "href": "http://localhost:8080/airports/topTenCountries"
        }
    }
}
```
