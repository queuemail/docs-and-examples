## 📊 Email Tracking – Opens and Clicks

Use this endpoint to retrieve tracking information for a specific email, including **open events** and **link clicks**.

<!-- tabs:start -->

### 📥 Get Tracking Info by Email

**Endpoint:**  
`GET /private/tracking/findByEMail`

---

#### 🔹 Parameters

| Parameter | Description       | Required | Default |
|-----------|-------------------|----------|---------|
| `idemail` | The ID of the email | ✅ Yes   | –       |

---

#### 🧾 Status Codes

| Code | Description                                      |
|------|--------------------------------------------------|
| 200  | Success                                          |
| 400  | Missing or invalid parameter                     |
| 401  | Unauthorized access                              |
| 403  | Invalid credentials                              |
| 500  | Internal server error                            |

---

#### 🔄 Sample Response (JSON)

```json
[
  {
    "_id": "6475cd84fc67f96b4d0cd808",
    "idsending": "6475ccb2fc67f96b4d0cd803",
    "idemailing": null,
    "email": "xxxx@gmail.com",
    "type": "OPEN",
    "url": null,
    "created": "2023-05-30T10:18:44.385",
    "ip": "xx.xx.xx.xx"
  },
  {
    "_id": "6475cd84fc67f96b4d0cd809",
    "idsending": "6475ccb2fc67f96b4d0cd803",
    "idemailing": null,
    "email": "xxxx@gmail.com",
    "type": "CLICK",
    "url": "https://google.com",
    "created": "2023-05-30T10:18:44.558",
    "ip": "xx.xx.xx.xx"
  }
]
```
### 📘 Response Details

- The response is an array of tracking events associated with the sent email (`idsending`).
- **`email`**: The recipient's email address associated with the event (i.e., who opened the email or clicked a link).
- **`type`**: Indicates the event type:
  - `OPEN` – The email was opened.
  - `CLICK` – A link within the email was clicked.
- **`created`**: The timestamp when the event occurred.
- **`idapp`**: The ID of the app that sent the email (may be `null` for some events).
- **`ip`**: The IP address from which the email was opened or the link was clicked.
- **`url`**: The destination URL that was clicked (only present for `CLICK` events).

<!-- tabs:end -->
