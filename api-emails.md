# 📤 Email Sending API

These endpoints allow you to queue emails for sending, retrieve email details, cancel queued emails, and remove completed ones.

---

## ✉️ Send (Queue) an Email

**Endpoint:**  
`POST /private/emails/send`

### 🔹 Parameters

| Parameter              | Description                                                                 | Required | Default                    |
|------------------------|-----------------------------------------------------------------------------|----------|----------------------------|
| `idapp`                | App ID                                                                      | ✅ Yes   | –                          |
| `from`                 | Sender email address                                                        | No       | App default                |
| `fromname`             | Sender name                                                                 | No       | App default                |
| `tos`                  | Recipient email addresses (comma-separated)                                 | ✅ Yes   | –                          |
| `tonames`              | Recipient names (comma-separated)                                           | No       | Matches email addresses    |
| `ccs`                  | CC addresses (comma-separated)                                              | No       | –                          |
| `bccs`                 | BCC addresses (comma-separated)                                             | No       | –                          |
| `replyto`              | Reply-to email address                                                      | No       | –                          |
| `mimetype`             | `text/html` or `text/plain`                                                 | No       | `text/plain`               |
| `subject`              | Email subject                                                               | ✅ Yes   | –                          |
| `subjectencoding`      | Subject encoding (`UTF-8`, `ISO-8859-1`, etc.)                              | No       | `UTF-8`                    |
| `body`                 | Email body                                                                  | ✅ Yes   | –                          |
| `bodyencoding`         | Body encoding (`UTF-8`, `ISO-8859-1`, etc.)                                 | No       | `UTF-8`                    |
| `attachments`          | File attachments                                                            | No       | –                          |
| `urlattachments`       | URL attachments                                                             | No       | –                          |
| `attachmenttype`       | `FILE` or `URL`                                                             | No       | `FILE`                     |
| `includetracking`      | Include open/click tracking                                                 | No       | `false`                    |
| `includeunregisterlink`| Include unsubscribe link (blacklist)                                        | No       | `false`                    |
| `senddate`             | Scheduled send datetime (`yyyy-MM-dd'T'HH:mm:ssZ`)                          | No       | –                          |

### 🧾 Status Codes

| Code | Description                              |
|------|------------------------------------------|
| 200  | Success                                  |
| 400  | Missing/invalid parameter                |
| 401  | Unauthorized                             |
| 403  | Invalid credentials                      |
| 406  | Specific error                           |
| 500  | Internal server error                    |

**Specific errors:**

1. App not found  
2. Remote server not allowed: `xxxx`  
3. Remote domain not allowed: `xxxx`  
4. No active SMTP for App  
5. Sender domain does not exist  
6. Cannot use `includetracking=true` with CC or BCC  
7. Cannot use `includeUnregisterLink=true` with CC or BCC  
8. `from` is not a valid email  
9. `to` is not a valid email  
10. `replyto` is not a valid email  
11. `replyto` domain lacks MX records  
12. All TO recipients are invalid  
13. All TO recipients are blacklisted  
14. Monthly email limit exceeded

### ✅ Sample Response

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

### 📘 Notes

- `status = Q` – Email has been successfully queued.
- `inittime` – Estimated time of sending.
- `logsdeleledby` – Time when logs will be deleted.
- `attachments` – List of attachment URLs.
- `blacklisted` – List of blacklisted recipients.
- `autoblacklisted` – List of auto-blacklisted recipients.
- `notvalidrecipients` – List of invalid recipients.

---

## 📋 Get Email Info

**Endpoint:**  
`GET /private/emails/info`

### 🔹 Parameters

| Parameter  | Description   | Required | Default |
|------------|---------------|----------|---------|
| `idemail`  | Email ID      | ✅ Yes   | –       |

### 🧾 Status Codes

Same as above.  
**Specific error:** 1. Email not found

### ✅ Sample Response

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

### 📘 Notes

- `status`:  
  - `Q` – Queued  
  - `R` – Sending in progress  
  - `C` – Cancelled  
  - `E` – Failed  
  - `F` – Successfully sent  
- `log` – Log entries  
- `opened` – Opened email events (with timestamp)

---

## ⛔ Cancel an Email

**Endpoint:**  
`POST /private/emails/cancel`

### 🔹 Parameters

| Parameter  | Description   | Required | Default |
|------------|---------------|----------|---------|
| `idemail`  | Email ID      | ✅ Yes   | –       |

### 🧾 Status Codes

Same as above.  
**Specific errors:**

1. Some recipients already processed  
2. Email not found  
3. App not found  
4. Sending finished or in progress – cannot be cancelled

### ✅ Sample Response

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

- `status = C` means the email was successfully cancelled.

---

## 🗑️ Remove a Finished Email

Removes a sent email along with logs and tracking info.

**Endpoint:**  
`POST /private/emails/remove`

### 🔹 Parameters

| Parameter  | Description | Required | Default |
|------------|-------------|----------|---------|
| `idemail`  | Email ID    | ✅ Yes   | –       |

### 🧾 Status Codes

Same as above.  
**Specific errors:**

1. Email not found  
2. App not found  
3. Unfinished sendings cannot be removed

### ✅ Response

Returns an empty response on success.
