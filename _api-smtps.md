## 📡 SMTP Server Management

You can associate one or more **SMTP servers** to an app for sending emails.

If you don’t have your own SMTP server, you can get one for free:  
👉 [List of free SMTP servers](other-freesmtps.md)

---

<!-- tabs:start -->

<!-- tab:Create or Edit an SMTP -->

### ✏️ Create or Edit an SMTP Server

**Endpoint:**  
`POST /private/smtps/save`

#### 🔹 Parameters

| Parameter            | Description                                                  | Required                        | Default   |
|---------------------|--------------------------------------------------------------|----------------------------------|-----------|
| `idsmtp`            | SMTP ID (for editing)                                        | Yes (edit only)                 | –         |
| `idapp`             | Associated App ID                                            | ✅ Yes                           | –         |
| `priority`          | SMTP priority (lower = higher priority)                      | No                              | 10        |
| `host`              | SMTP host address                                            | ✅ Yes                           | –         |
| `port`              | SMTP port                                                    | ✅ Yes                           | –         |
| `username`          | SMTP user login                                              | ✅ Yes                           | –         |
| `password`          | SMTP password                                                | ✅ Yes                           | –         |
| `auth`              | Enable SMTP authentication (`true`/`false`)                  | No                              | false     |
| `starttls`          | Use STARTTLS (`true`/`false`)                                | No                              | false     |
| `ssltls`            | Use SSL/TLS (`true`/`false`)                                 | No                              | false     |
| `defaulfromemail`   | Default "From" email if sender domain is restricted          | No                              | –         |
| `defaultfromname`   | Default "From" name if sender domain is restricted           | No                              | –         |

#### 🧾 Status Codes

| Code | Description                        |
|------|------------------------------------|
| 200  | Success                            |
| 400  | Missing or invalid parameters      |
| 401  | Unauthorized                       |
| 403  | Invalid credentials                |
| 406  | Specific error                     |
| 500  | Internal server error              |

**Specific Errors:**
1. SMTP not found  
2. App not found

#### ✅ Sample Response

```json
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
  "defaultfromemail": "info@yourserver.xyz",
  "defaultfromname": "Jonh Smith",
  "status": "A"
}
```

---

<!-- tab:List SMTPs by App -->

### 📋 List All SMTP Servers for an App

**Endpoint:**  
`GET /private/smtps/findByApp`

#### 🔹 Parameters

| Parameter | Description  | Required | Default |
|-----------|--------------|----------|---------|
| `idapp`   | App ID       | ✅ Yes   | –       |

#### ✅ Sample Response

Returns an array of all SMTP servers linked to the specified app.

```json
[
  {
    "_id": "63eb5c67db7fa34c44d64783",
    "host": "smtp.yourserver.net",
    "port": 587,
    "username": "user1",
    "defaultfromemail": "info@yourserver.xyz",
    "status": "A"
  },
  {
    "_id": "6474690367e43f0f33a3a08a",
    "host": "smtp.anothersmtp.net",
    "port": 25,
    "username": "user2",
    "defaultfromemail": "info@anothersmtp.xyz",
    "status": "A"
  }
]
```

---

<!-- tab:Find SMTP by ID -->

### 🔍 Get SMTP Server Details by ID

**Endpoint:**  
`GET /private/smtps/findById`

#### 🔹 Parameters

| Parameter | Description | Required | Default |
|-----------|-------------|----------|---------|
| `idsmtp`  | SMTP ID     | ✅ Yes   | –       |

#### ✅ Sample Response

```json
{
  "_id": "6474690367e43f0f33a3a08a",
  "host": "smtp.anothersmtp.net",
  "port": 25,
  "username": "user2",
  "defaultfromemail": "info@anothersmtp.xyz",
  "status": "A"
}
```

---

<!-- tab:Delete SMTP -->

### 🗑️ Delete an SMTP Server

**Endpoint:**  
`POST /private/smtps/remove`

#### 🔹 Parameters

| Parameter | Description | Required | Default |
|-----------|-------------|----------|---------|
| `idapp`   | SMTP ID     | ✅ Yes   | –       |

#### ✅ Response

Returns an empty body on success.

---

<!-- tab:Check SMTP -->

### ✅ Test an SMTP Server

This will send a test email to the app's test address.

- If successful (`200`), the SMTP is marked as enabled.
- If it fails (`406`), the SMTP is marked as disabled.

**Endpoint:**  
`POST /private/smtps/check`

#### 🔹 Parameters

| Parameter | Description | Required | Default |
|-----------|-------------|----------|---------|
| `idapp`   | SMTP ID     | ✅ Yes   | –       |

#### 🧾 Status Codes

| Code | Description                                |
|------|--------------------------------------------|
| 200  | SMTP working properly                      |
| 406  | SMTP test failed – SMTP marked as disabled |
| 400  | Missing or invalid parameters              |
| 401  | Unauthorized                               |
| 403  | Invalid credentials                        |
| 500  | Internal server error                      |

**Specific Errors:**
- SMTP not found  
- App not found  
- Any SMTP-level failure

#### ✅ Response

*empty*

---

<!-- tabs:end -->
