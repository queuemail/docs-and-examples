

Using these endpoint you manage blacklists.

<!-- tabs:start -->


<!-- tab:Add an email to blacklist -->


**REQUEST:** 

*POST* /private/blacklist/add

|Parameter|Description|Required| Default |
|---------|-----------|--------|---------|
|idapp | App id | Yes |  |
|email | Email to blacklist | Yes |  |

**STATUS CODES:**

|Code|Description|
|----|-------|
|200 | Success |
|400 | Missing required parameter or wrong parameter type |
|401 | User not authorized |
|403 | Credentials not valid |
|406 | Specific error |
|500 | Internal error|

Specific errors:

1. App not found



You will get a JSON response like this:

```
{
    "_id": "6474908d7ff70117d6a938dc",
    "idapp": "647095de67e43f0f33a3a089",
    "idsending": null,
    "email": "kk@kk.com",
    "ip": "xx.xx.xx.xx",
    "created": "2023-05-29T11:46:21.685157634"
}
```

- **idsending** mail sending id if blacklist has been created due to a mail sending.
- **ip** ip origin of blacklist add.
- **created** when the email has been added to blacklist.

<!-- tab:Blacklist info -->

Get blacklist & auto-blacklist info by app.

**REQUEST:** 

*GET* /private/blacklist/findByApp

|Parameter|Description|Required| Default |
|---------|-----------|--------|---------|
|idapp | App id | Yes |  |
|page | Page number | Yes |  |
|size | Page size | Yes |  |

**STATUS CODES:**

|Code|Description|
|----|-------|
|200 | Success |
|400 | Missing required parameter or wrong parameter type |
|401 | User not authorized |
|403 | Credentials not valid |
|500 | Internal error|


**RESPONSE:**


You will get a JSON response like this:

```
{
    "blacklisted": {
        "content": [
            {
                "_id": "6474908d7ff70117d6a938dc",
                "idapp": "647095de67e43f0f33a3a089",
                "idsending": null,
                "email": "kk@kk.com",
                "ip": "xx.xx.xx.xx",
                "created": "2023-05-29T11:46:21.685"
            }
        ],
        "pageable": {
            "sort": {
                "empty": true,
                "sorted": false,
                "unsorted": true
            },
            "offset": 0,
            "pageNumber": 0,
            "pageSize": 10,
            "paged": true,
            "unpaged": false
        },
        "last": true,
        "totalPages": 1,
        "totalElements": 1,
        "size": 10,
        "number": 0,
        "sort": {
            "empty": true,
            "sorted": false,
            "unsorted": true
        },
        "first": true,
        "numberOfElements": 1,
        "empty": false
    },
    "autoblacklisted": {
        "content": [],
        "pageable": {
            "sort": {
                "empty": true,
                "sorted": false,
                "unsorted": true
            },
            "offset": 0,
            "pageNumber": 0,
            "pageSize": 10,
            "paged": true,
            "unpaged": false
        },
        "last": true,
        "totalPages": 0,
        "totalElements": 0,
        "size": 10,
        "number": 0,
        "sort": {
            "empty": true,
            "sorted": false,
            "unsorted": true
        },
        "first": true,
        "numberOfElements": 0,
        "empty": true
    }
}
```



<!-- tab:Check if an email is blacklisted -->




**REQUEST:** 

*GET* /private/blacklist/isBlackListed

|Parameter|Description|Required| Default |
|---------|-----------|--------|---------|
|idapp | App id | Yes |  |
|email | Email address to check | Yes |  |

**STATUS CODES:**

|Code|Description|
|----|-------|
|200 | Success |
|400 | Missing required parameter or wrong parameter type |
|401 | User not authorized |
|403 | Credentials not valid |
|500 | Internal error|





**RESPONSE:**

*true* or *false*  (text format, not JSON)





<!-- tab:Remove an email from blacklist -->



**REQUEST:** 


*POST* /private/blacklist/remove

|Parameter|Description|Required| Default |
|---------|-----------|--------|---------|
|idapp | App id | Yes |  |
|email | Email address to check | Yes |  |

**STATUS CODES:**

|Code|Description|
|----|-------|
|200 | Success |
|400 | Missing required parameter or wrong parameter type |
|401 | User not authorized |
|403 | Credentials not valid |
|406 | Specific error |
|500 | Internal error|

Specific errors:

1. Mail not found
2. Mail added by the recipient. Cannot delete it



**RESPONSE:**

*empty*

<!-- tabs:end -->

