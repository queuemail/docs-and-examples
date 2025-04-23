## 📦 Apps Management

To use the QUEUEMAIL API, you must first create at least one **App**.

Each App represents a project or sub-project, allowing you to define specific configurations and behaviors.

---

<!-- tabs:start -->

<!-- tab:Create or Edit an App -->

### 🛠️ Create or Edit an App

**Endpoint:**  
`POST /private/apps/save`

#### 🔹 Parameters

| Parameter                   | Description                                                                 | Required                  | Default         |
|----------------------------|-----------------------------------------------------------------------------|---------------------------|-----------------|
| `idapp`                    | App ID (use for editing)                                                    | Yes (for edit), No (new)  | –               |
| `name`                     | App name                                                                    | Yes (for create)          | –               |
| `retaindata`               | Retain subject, body, and URL attachments                                   | No                        | false           |
| `strategy`                 | SMTP selection strategy: `RANDOM` or `PRIORITY`                             | No                        | RANDOM          |
| `originserver`             | Limit allowed IPs/hosts (comma-separated)                                   | No                        | –               |
| `defaultfromemail`         | Default "From" email address for sends                                      | No                        | User's email    |
| `defaultfromname`          | Default "From" name                                                         | No                        | User's email    |
| `testemail`                | Test recipient email                                                        | No                        | User's email    |
| `timebetweenemails`        | Minimum seconds between sends                                               | No                        | 60              |
| `useblacklist`             | Enable blacklist                                                            | No                        | false           |
| `useautoblacklist`         | Enable auto-blacklist                                                       | No                        | false           |
| `webhook_sending_finished`| URL called on successful send                                               | No                        | –               |
| `webhook_sending_error`   | URL called when send fails                                                  | No                        | –               |
| `webhook_tracking_opened` | URL called when email is opened                                             | No                        | –               |
| `webhook_tracking_clicked`| URL called when a link is clicked                                           | No                        | –               |
| `webhook_blacklisted_added`| URL called when address is blacklisted                                     | No                        | –               |

#### 🧾 Status Codes

| Code | Description                        |
|------|------------------------------------|
| 200  | Success                            |
| 400  | Missing or invalid parameter       |
| 401  | Unauthorized                       |
| 403  | Invalid credentials                |
| 406  | Specific error (see below)         |
| 500  | Internal server error              |

**Specific Errors:**

1. An app with the same name already exists  
2. App not found  
3. App name is required

#### ✅ Sample Response

```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9...",
  "role": "user",
  "userId": "63bbe586dd070b78fb495ed2",
  "username": "username",
  "clientId": "CI-151ace69-de92-40b4-bf94-88dfeb3575f4"
}
```

Use the `token` value in the **Authorization** header for all future API calls:

```
Authorization: Bearer <your-token-here>
```

---

<!-- tab:List All Apps -->

### 📋 List All Apps

**Endpoint:**  
`GET /private/apps/findAll`

#### 🔹 Parameters

| Parameter | Description       | Required | Default |
|----------|-------------------|----------|---------|
| `page`   | Page number        | ✅ Yes   | –       |
| `size`   | Page size (limit)  | ✅ Yes   | –       |

#### 🧾 Status Codes

Same as above.

#### ✅ Sample Response

```json
{
  "content": [
    {
      "_id": "63ca50f0c9557c7ac25f1715",
      "iduser": "63bbe586dd070b78fb495ed2",
      "name": "APP2",
      "strategy": "PRIORITY",
      "defaultfromemail": "user1@email.xxx",
      "defaultfromname": "Jonh Smith",
      "testemail": "user1@email.xxx",
      "timebetweenemails": 0,
      "useblacklist": true,
      "useautoblacklist": false,
      "language": "EN",
      "created": "2023-01-20T08:29:36.763",
      "modified": "2023-01-20T08:29:36.763",
      "status": "A"
    }
  ],
  "pageable": {
    "pageNumber": 1,
    "pageSize": 1
  },
  "totalPages": 6,
  "totalElements": 6
}
```

- The `content` array lists all apps for the authenticated user.

---

<!-- tab:Get App Info -->

### 🔍 Get App Details by ID

**Endpoint:**  
`GET /private/apps/findById`

#### 🔹 Parameters

| Parameter | Description | Required | Default |
|----------|-------------|----------|---------|
| `idapp`  | App ID      | ✅ Yes   | –       |

#### ✅ Sample Response

```json
{
  "_id": "63ca50f0c9557c7ac25f1715",
  "name": "APP2",
  "strategy": "PRIORITY",
  "defaultfromemail": "user2@xxx.xxx",
  "defaultfromname": "Jonh Smith",
  "testemail": "user2@xxx.xxx",
  "timebetweenemails": 0,
  "useblacklist": true,
  "useautoblacklist": false,
  "language": "EN",
  "created": "2023-01-20T08:29:36.763",
  "modified": "2023-01-20T08:29:36.763",
  "status": "A"
}
```

---

<!-- tab:Delete an App -->

### 🗑️ Delete an App

**Endpoint:**  
`POST /private/apps/remove`

#### 🔹 Parameters

| Parameter | Description | Required | Default |
|----------|-------------|----------|---------|
| `idapp`  | App ID      | ✅ Yes   | –       |

#### 🧾 Status Codes

Same as above.

**Specific Errors:**

1. App not found

#### ✅ Response

Returns an empty body on success.

---

<!-- tabs:end -->
