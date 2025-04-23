## Retrieve Email Logs

Use the following endpoints to retrieve logs associated with a specific email.

<!-- tabs:start -->

### 📩 Get Logs by Email

**Endpoint:**  
`GET /private/logs/findByEMail`

#### 🔹 Parameters

| Parameter | Description          | Required | Default |
|-----------|----------------------|----------|---------|
| `idemail` | The ID of the email. | ✅ Yes   | –       |

#### 🔸 Status Codes

| Code | Description                                         |
|------|-----------------------------------------------------|
| 200  | Success                                             |
| 400  | Missing or invalid parameter                        |
| 401  | Unauthorized access                                 |
| 403  | Invalid credentials                                 |
| 500  | Internal server error                               |

#### 🔄 Sample Response (JSON)

```json
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
    "created": "2023-02-14T10:16:57.980"
  }
]
```
### 📘 Response Details

- The response is an array of all operations related to the sent email (`idsending`).
- **`idsmtp`**: The ID of the SMTP server used to send the email.
- **`resultcode`**: Indicates the outcome of the operation:
  - `"OK"` – Email was sent successfully.
  - `"BLACKLISTED"` – The recipient is on the app’s blacklist.
  - `"AUTOBLACKLISTED"` – The recipient has been automatically blacklisted due to repeated issues.
  - Other possible error codes include:  
    - `ATTACHMENT_PROBLEM`  
    - `SMTP_CONNECT_FAILS`  
    - `SMTP_CONNECT_TIMEOUT`  
    - etc.
- **`created`**: The date and time when the operation occurred.
- **`idapp`**: The ID of the app used to send the email (may be `null` for some operations).
- **`to`**: The recipient’s email address associated with the operation.


<!-- tabs:end -->

