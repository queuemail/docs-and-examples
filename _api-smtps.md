
You can define one or more SMTP servers asociated to an app. 

If you don't have an own SMTP server you can [get a free SMTP server here](other-freesmtps.md).

<!-- tabs:start -->

<!-- tab:Create/edit a SMTP -->


**REQUEST:** 

*POST* /private/smtps/save

|Parameter|Description|Required| Default |
|---------|-----------|--------|---------|
|idsmtp | SMTP id | Yes for editing, No for creating |  |
|idapp | App id | Yes |  |
|priority | Priority (0=highest priority)  | No | 10 |
|host | SMTP host  | Yes  |  |
|port | SMTP port  | Yes  |  |
|username | SMTP user name  | Yes  |
|password | SMTP user password | Yes |  |
|auth | If SMTP auth is used (true) or not (false) | false |  |
|starttls | If STARTTLS is used (true) or not (false)  | false |  |
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
    "starttls": true,
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

<!-- tab:List SMTP servers by app -->



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
        "starttls": true,
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
        "starttls": true,
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
    "starttls": true,
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

If you receive 200 status SMTP is working correctly. If this SMTP was disabled, it is enabled at this time.

If you receive 406 status SMTP has errors. If this SMTP was enabled, it is disabled at this time.

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

... Other errors related with SMTP working.


**RESPONSE:**

*empty*

<!-- tabs:end -->

