

You can define one or more SMTPs asociated to an App. 

If you are using *FREE TIER* you must to create at least a SMTP.

If you are using a *PAID PLAN* you don't need to create a SMTP because you can use SYSTEM SMTPs.

With *FREE TIER* SMTP servers you define are been used in RANDOM order.

With a *PAID PLAN* you can define a RANDOM or PRIORITY based strategy for SMTP use.

<!-- tabs:start -->

<!-- tab:Create/edit an SMTP -->


**REQUEST:** 

*POST* /private/smtps/save

|Parameter|Description|Required| Default |
|---------|-----------|--------|---------|
|idsmtp | SMTP id | Yes for editing, No for creating |  |
|idapp | App id | Yes |  |
|priority | Priority (0=highest priority)  | No | 10 |
|port | SMTP port  | Yes  |  |
|username | SMTP user name  | Yes  |
|password | SMTP user password | Yes |  |
|auth | If SMTP auth is used (true) or not (false) | false |  |
|startstls | If STARTTLS is used (true) or not (false)  | false |  |
|ssltls | If SSL/TLS is used (true) or not (false)  | false |  |
|defaulfromemail | Default from email if domain not allowed | No |  |
|defaultfromname | Default from name if domain not allowed  | No |  |

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

1. SMTP not found
2. App not found



**RESPONSE:**

You will get a JSON response like this:

```
{
    "_id": "6474690367e43f0f33a3a08a",
    "idapp": "63ca4eba50b39905400fc201",
    "priority": 50,
    "host": "smtp.yourserver.net",
    "port": 25,
    "username": "user@yourserver.net",
    "password": "smtppassword1234",
    "auth": true,
    "startstls": true,
    "sslTls": false,
    "debug": false,
    "defaultfromemail": "info@yourserver.xyz",
    "defaultfromname": "Jonh Smith",
    "numerrors": 0,
    "created": "2023-05-29T08:57:39.129027959",
    "modified": "2023-05-29T08:57:39.129027959",
    "status": "A"
}
```

<!-- tab:List SMTPs by app -->



**REQUEST:** 

*GET* /private/smtps/findByApp

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
[
    {
        "_id": "63eb5c67db7fa34c44d64783",
        "idapp": "63ca4eba50b39905400fc201",
        "priority": 50,
        "host": "smtp.yourserver.net",
        "port": 587,
        "username": "user1",
        "password": "Yourpass1234",
        "auth": true,
        "startstls": true,
        "sslTls": false,
        "debug": false,
        "defaultfromemail": "info@yourserver.xyz",
        "defaultfromname": "Jonh Smith",
        "numerrors": 0,
        "created": "2023-02-14T10:03:19.308",
        "modified": "2023-02-14T10:03:19.308",
        "status": "A"
    },
    {
        "_id": "6474690367e43f0f33a3a08a",
        "idapp": "63ca4eba50b39905400fc201",
        "priority": 150,
        "host": "smtp.anothersmtp.net",
        "port": 25,
        "username": "user2",
        "password": "YourPASS1234",
        "auth": true,
        "startstls": true,
        "sslTls": false,
        "debug": false,
        "defaultfromemail": "info@anothersmtp.xyz",
        "defaultfromname": "Jonh Smith",
        "numerrors": 0,
        "created": "2023-05-29T08:57:39.129",
        "modified": "2023-05-29T08:57:39.129",
        "status": "A"
    }
]
```




<!-- tab:Find a SMTP by id -->




**REQUEST:** 

*GET* /private/smtps/findById

|Parameter|Description|Required| Default |
|---------|-----------|--------|---------|
|idsmtp | SMTP id | Yes |  |

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
    "_id": "6474690367e43f0f33a3a08a",
    "idapp": "63ca4eba50b39905400fc201",
    "priority": 150,
    "host": "smtp.anothersmtp.net",
    "port": 25,
    "username": "user2",
    "password": "YourPASS1234",
    "auth": true,
    "startstls": true,
    "sslTls": false,
    "debug": false,
    "defaultfromemail": "info@anothersmtp.xyz",
    "defaultfromname": "Jonh Smith",
    "numerrors": 0,
    "created": "2023-05-29T08:57:39.129",
    "modified": "2023-05-29T08:57:39.129",
    "status": "A"
}
```



<!-- tab:Delete a SMTP -->

**REQUEST:** 


*POST* /private/smtps/remove

|Parameter|Description|Required| Default |
|---------|-----------|--------|---------|
|idapp | SMTP id | Yes |  |

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

1. SMTP not found


**RESPONSE:**

*empty*


<!-- tab:Check a SMTP -->

Sends a email to app test email for checking correct SMTP configuration.

**REQUEST:** 


*POST* /private/smtps/check

|Parameter|Description|Required| Default |
|---------|-----------|--------|---------|
|idapp | SMTP id | Yes |  |

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

1. SMTP not found
2. App not found


**RESPONSE:**

*empty*

<!-- tabs:end -->

