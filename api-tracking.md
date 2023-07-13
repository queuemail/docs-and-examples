

Using this endpoint you can manage email tracking: opened emails and email link clicks.

<!-- tabs:start -->


<!-- tab:Get tracking info by email -->


**REQUEST:** 

*GET* /private/tracking/findByEMail

|Parameter|Description|Required| Default |
|---------|-----------|--------|---------|
|idmail | Email id | Yes |  |

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
        "_id": "6475cd84fc67f96b4d0cd808",
        "idsending": "6475ccb2fc67f96b4d0cd803",
        "idmailing": null,
        "email": "xxxx@gmail.com",
        "type": "OPEN",
        "url": null,
        "created": "2023-05-30T10:18:44.385",
        "ip": "xx.xx.xx.xx"
    },
    {
        "_id": "6475cd84fc67f96b4d0cd809",
        "idsending": "6475ccb2fc67f96b4d0cd803",
        "idmailing": null,
        "email": "xxxx@gmail.com",
        "type": "CLICK",
        "url": "https://google.com",
        "created": "2023-05-30T10:18:44.558",
        "ip": "xx.xx.xx.xx"
    }
]
```

- Response is composed by an array with all operations associated with the email sent (**idsending**)
- **idmailing** is the id of the mailing (if exists) asociated with this email sending
- **email** is the recipient asocciated with this tracking info (who opened email or clicked email link)
- **type** is OPEN for tracking opened emails and CLICK for tracking clicked links.
- **created** is the operation date/time.
- **idapp** is the id of the App used but only has value in some operations.
- **ip** is the origin ip from the recipient opened email or clicked email link.
- **url** is the target URL in an clicked link tracking info.


<!-- tabs:end -->

