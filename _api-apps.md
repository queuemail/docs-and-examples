You need to create at least an app to use QUEUEMAIL. 

Each app should correspond to a project or project part which has different behaviour.

<!-- tabs:start -->

<!-- tab:Create/edit an app -->


**REQUEST:** 

*POST* /private/apps/save

|Parameter|Description|Required| Default |
|---------|-----------|--------|---------|
|idapp | App id | Yes for editing, No for creating |  |
|name | App name  | Yes for creating, No for editing |  |
|retaindata | If this app must preserve subject, body and url attachments | No | No |
|strategy | RANDOM / PRIORITY  | No  | RANDOM |
|originserver | If set, you can make calls just from this servers/IPs (comma separated for multiple values) | No  |
|defaultfromemail | Default from email when sending emails | No | User's email |
|defaultfromname | Default from name when sending emails | No | User's email |
|testemail | Recipient email for testing emails  | No | User's email |
|timebetweenemails | Seconds between emails  | No | 60 |
|useblacklist | If this app must use black list  | No | No |
|useautoblacklist | If this app must use auto black list  | No | No |
|webhook_sending_finished | URL called when email send finish sucessfully  | No |
|webhook_sending_error | URL called when email send fails  | No |
|webhook_tracking_opened | URL called when email is opened  | No |
|webhook_tracking_clicked | URL called when when link in email is clicked | No |
|webhook_blacklisted_added | URL called when email address is added to blacklist | No |

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

1. Already exists an APP with the same name
2. App not found
3. Must provide a name



**RESPONSE:**

You will get a JSON response like this:

```
{
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2M2JiZTU4NmRkMDcwYjc4ZmI0OTVlZDIiLCJzdWIiOiJ1c2VyMSIsImF1ZCI6InVzZXIiLCJpc3MiOiJDSS0xNTFhY2U2OS1kZTkyLTQwYjQtYmY5NC04OGRmZWIzNTc1ZjQiLCJpYXQiOjE2ODQ3NDg0MTUsImV4cCI6MTY4NDgzNDgxNX0.CcNyo8Ug45dNLNZ0Q41wpPObrFI-hagaJdat3ryxqdo",
    "role": "user",
    "userId": "63bbe586dd070b78fb495ed2",
    "username": "username",
    "clientId": "CI-151ace69-de92-40b4-bf94-88dfeb3575f4"
}
```

Now, you can use the value of **token** field in header *Authorization* in all API operations as a Bearer token:

```
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2M2JiZTU4NmRkMDcwYjc4ZmI0OTVlZDIiLCJzdWIiOiJ1c2VyMSIsImF1ZCI6InVzZXIiLCJpc3MiOiJDSS0xNTFhY2U2OS1kZTkyLTQwYjQtYmY5NC04OGRmZWIzNTc1ZjQiLCJpYXQiOjE2ODQ3NDg0MTUsImV4cCI6MTY4NDgzNDgxNX0.CcNyo8Ug45dNLNZ0Q41wpPObrFI-hagaJdat3ryxqdo
```
<!-- tab:List all apps -->



**REQUEST:** 

*GET* /private/apps/findAll

|Parameter|Description|Required| Default |
|---------|-----------|--------|---------|
|page | Initial page | Yes |  |
|size | Page máximun size | Yes |  |

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
    "content": [
        {
            "_id": "63ca50f0c9557c7ac25f1715",
            "iduser": "63bbe586dd070b78fb495ed2",
            "name": "APP2",
            "strategy": "PRIORITY",
            "origindomain": null,
            "defaultfromemail": "user1@email.xxx",
            "defaultfromname": "Jonh Smith",
            "testemail": "user1@email.xxx",
            "timebetweenemails": 0,
            "useblacklist": true,
            "useautoblacklist": false,
            "webhook_sending_finished": null,
            "webhook_sending_error": null,
            "webhook_tracking_opened": null,
            "webhook_tracking_clicked": null,
            "webhook_blacklisted_added": null,
            "webhook_mailing_finished": null,
            "language": "EN",
            "created": "2023-01-20T08:29:36.763",
            "modified": "2023-01-20T08:29:36.763",
            "status": "A"
        }
    ],
    "pageable": {
        "sort": {
            "empty": true,
            "sorted": false,
            "unsorted": true
        },
        "offset": 1,
        "pageNumber": 1,
        "pageSize": 1,
        "paged": true,
        "unpaged": false
    },
    "last": false,
    "totalPages": 6,
    "totalElements": 6,
    "size": 1,
    "number": 1,
    "sort": {
        "empty": true,
        "sorted": false,
        "unsorted": true
    },
    "first": false,
    "numberOfElements": 1,
    "empty": false
}
```

Field **content** is a list containing all the existing apps for the logged account.


<!-- tab:App info -->




**REQUEST:** 

*GET* /private/apps/findById

|Parameter|Description|Required| Default |
|---------|-----------|--------|---------|
|idapp | App id | Yes |  |

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
    "_id": "63ca50f0c9557c7ac25f1715",
    "iduser": "63bbe586dd070b78fb495ed2",
    "name": "APP2",
    "strategy": "PRIORITY",
    "origindomain": null,
    "defaultfromemail": "user2@xxx.xxx",
    "defaultfromname": "Jonh Smith",
    "testemail": "user2@xxx.xxx",
    "timebetweenemails": 0,
    "useblacklist": true,
    "useautoblacklist": false,
    "webhook_sending_finished": null,
    "webhook_sending_error": null,
    "webhook_tracking_opened": null,
    "webhook_tracking_clicked": null,
    "webhook_blacklisted_added": null,
    "webhook_mailing_finished": null,
    "language": "EN",
    "created": "2023-01-20T08:29:36.763",
    "modified": "2023-01-20T08:29:36.763",
    "status": "A"
}
```



<!-- tab:Delete an app -->

**REQUEST:** 


*POST* /private/apps/remove

|Parameter|Description|Required| Default |
|---------|-----------|--------|---------|
|idapp | App id | Yes |  |

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


**RESPONSE:**

*empty*

<!-- tabs:end -->

