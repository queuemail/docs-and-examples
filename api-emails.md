

Using these endpoints you can send (queue up) emails, get emails send information, cancel (dequeue) emails and remove a finished (sent) emails.

<!-- tabs:start -->


<!-- tab:Send (queue up) an email -->


**REQUEST:** 

*POST* /private/emails/send

|Parameter|Description|Required| Default |
|---------|-----------|--------|---------|
|idapp | App id | Yes |  |
|from | Email from address | No | App default from email |
|fromname | Name from address | No | App default from name  |
|tos | Recipients email addresses (comma separeted)  | Yes  |  |
|tonames | Recipients names (comma separated) | No | Recipients email addresses  |
|ccs | Carbon copy recipients email addresses (comma separated) | No |  |
|bccs | Blind carbon copy recipients email addresses (comma separated) | No |  |
|replyto | Reply email address  | No |  |
|mimetype | text/html or text/plain  | No | text/plain |
|subject | Email subject  | Yes |  |
|subjectencoding | Email subject encoding (UTF-8, ISO-8859-1, etc.) | No | UTF-8  |
|body | Email body  | Yes |  |
|bodyencoding | Email body encoding (UTF-8, ISO-8859-1, etc.)  | No | UTF-8  |
|attachments | Email file attachments  | No |  |
|urlattachments | Email url attachments  | No |  |
|attachmenttype | Email attachments type (FILE / URL)  | No | FILE |
|includetracking | Include tracking in email?  | No | false |
|includeunregisterlink | Include unregister link (blacklist) in email?  | No | false |
|senddate | Date/time to send the email in format yyyy-MM-dd'T'HH:mm:ssZ and must be a future date/time. Example: 2033-09-29T18:46:19-0700 where -0700 means GMT-7 timezone  | No |  |

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
2. Remote server not allowed: xxxx
3. Remote domain not allowed: xxxx
3. No active SMTP for App
4. Sender domain does not exist
5. Cannot use includetracking=true if you provide CCS or BCCS. Please, use includetracking=false or remove CCS and BCCS email addressses
6. Cannot use includeUnregisterLink=true if you provide CCS or BCCS. Please, use includeUnregisterLink=false or remove CCS and BCCS email addressses
7. *from* is not a valid email address
9. *to* is not a valid email address
10. *replyto* is not a valid email address
11. *replyto* domain has not MX records
12. All TO recipients are invalid
13. All TO recipients are blacklisted
14. Emails limit per month exceeded.



You will get a JSON response like this:

```
{
    "id": "64747cae67e43f0f33a3a08b",
    "status": "Q",
    "inittime": "2023-05-29T10:22:33.895254204",
    "logsdeleledby": "2023-06-28T10:22:33.895254204",
    "attachments": [
        "https://cdn.queuemail.dev/static/sendings/b74f118e-eab2-4aa9-b72d-xec21fa2368b/c.xml"
    ],
    "blacklisted": [],
    "autoblacklisted": [],
    "notvalidrecipients": []
}
```

- **status** field = 'Q' means email has been queued up correctly.
- **inittime** is the estimated time for sending email.
- **logsdeleledby** it the time when email logs will be deleted.
- **attachments** array with all url attachments.
- **blacklisted** array with all recipient emails addresses blacklisted.
- **autoblacklisted** array with all recipient emails addresses auto-blacklisted.
- **notvalidrecipients** array with all recipient not valid emails addresses.


<!-- tab:Get email info -->



**REQUEST:** 

*GET* /private/emails/info

|Parameter|Description|Required| Default |
|---------|-----------|--------|---------|
|idemail | Email id | Yes |  |

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

**RESPONSE:**


You will get a JSON response like this:

```
{
    "id": "64747cae67e43f0f33a3a08b",
    "status": "Q",
    "inittime": "2023-05-29T10:22:33.895",
    "logsdeleledby": "2023-06-28T10:22:33.895",
    "attachments": [
        "https://cdn.queuemail.dev/static/sendings/7723743-34838743-34343/c.xml"
    ],
    "log": [],
    "opened": []
}
```

- **status** = 
    - 'Q' means email has been queued up correctly. 
    - 'R' means email is been sent at now. 
    - 'C' means email has been cancelled. 
    - 'E' means email send has failled. 
    - 'F' means email has been sent sucessfully.
- **inittime** is the estimated time for sending email.
- **logsdeleledby** it the time when email logs will be deleted.
- **attachments** array with all url attachments.
- **blacklisted** array with all recipient emails addresses blacklisted.
- **autoblacklisted** array with all recipient emails addresses auto-blacklisted.
- **notvalidrecipients** array with all recipient not valid emails addresses.
- **log** array with all log email information.
- **opened** array with all recipient emails time addresses & open time.




<!-- tab:Cancel an email send -->




**REQUEST:** 

*POST* /private/emails/cancel

|Parameter|Description|Required| Default |
|---------|-----------|--------|---------|
|idemail | Email id | Yes |  |

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

1. Some recipients have been processed. Sending cannot be cancelled
2. Mail not found
3. App not found
4. Sending finished or in process. It cannot be cancelled





**RESPONSE:**


You will get a JSON response like this:

```
{
    "id": "64747cae67e43f0f33a3a08b",
    "status": "C",
    "inittime": "2023-05-29T10:22:33.895",
    "logsdeleledby": "2023-06-28T10:22:33.895",
    "attachments": [
        "https://cdn.queuemail.dev/static/sendings/b74fdc8e-eab3-4aa9-b72d-0ec21fa2368b/c.xml"
    ]
}
```

**status** field = C means the email send has been canceled.



<!-- tab:Remove an email -->

Remove a finished email. Also remove all logs and tracking info.

**REQUEST:** 


*POST* /private/emails/remove

|Parameter|Description|Required| Default |
|---------|-----------|--------|---------|
|idemail | SMTP id | Yes |  |

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
2. App not found
3. Unfinished sendings cannot be removed



**RESPONSE:**

*empty*

<!-- tabs:end -->

