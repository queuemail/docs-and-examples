

Using these endpoint you can manage email logs.

<!-- tabs:start -->


<!-- tab:Get logs by email -->


**REQUEST:** 

*GET* /private/logs/findByMail

|Parameter|Description|Required| Default |
|---------|-----------|--------|---------|
|idmail | Mail id | Yes |  |

**STATUS CODES:**

|Code|Description|
|----|-------|
|200 | Success |
|400 | Missing required parameter or wrong parameter type |
|401 | User not authorized |
|403 | Credentials not valid |
|500 | Internal error|




You will get a JSON response like this:

```
[
    {
        "_id": "63eb5f944986cc0ed366fc5b",
        "idsending": "63eb5f324986cc0ed366fc5a",
        "idsmtp": "63eb5c67db7fa34c44d64783",
        "idapp": null,
        "to": "xxxxx@gmail.com",
        "resultcode": "OK",
        "created": "2023-02-14T10:16:52.128"
    },
    {
        "_id": "63eb5f994986cc0ed366fc5c",
        "idsending": "63eb5f324986cc0ed366fc5a",
        "idsmtp": "63eb5c67db7fa34c44d64783",
        "idapp": null,
        "to": "xxxxx@outlook.com",
        "resultcode": "OK",
        "created": "2023-02-14T10:16:57.98"
    }
]
```

- Response is composed by an array with all operations associated with the mail sent (**idsending**)
- **idsmtp** is the id of the SMTP used for sending.
- **resultcode** can be "OK" for sucess sending. "BLACKLISTED" if recipient has been included in blacklsit. "AUTOBLACKLISTED" if recipient has been included in auto-blacklist. Also can be a specific error code (ATTACHMENT_PROBLEM, SMTP_CONNECT_FAILS, SMTP_CONNECT_TIMEOUT, etc.)
- **created** is the operation date/time.
- **idapp** is the id of the App used but only has value in some operations.
- **to** is the recipient related with the operation.


<!-- tabs:end -->

