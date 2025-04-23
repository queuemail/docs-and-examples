# 📧 Blacklist Management API

Use these endpoints to manage blacklist and auto-blacklist entries.

---

## ➕ Add an Email to the Blacklist

**Endpoint:**  
`POST /private/blacklist/add`

### 🔹 Parameters

| Parameter | Description          | Required | Default |
|----------|----------------------|----------|---------|
| `idapp`  | App ID               | ✅ Yes   | –       |
| `email`  | Email to blacklist   | ✅ Yes   | –       |

### 🧾 Status Codes

| Code | Description                                      |
|------|--------------------------------------------------|
| 200  | Success                                          |
| 400  | Missing or invalid parameter                    |
| 401  | Unauthorized user                               |
| 403  | Invalid credentials                             |
| 406  | Specific error (see below)                      |
| 500  | Internal server error                           |

**Specific errors:**
1. App not found

### ✅ Sample Response

```
{
  "_id": "6474908d7ff70117d6a938dc",
  "idapp": "647095de67e43f0f33a3a089",
  "idsending": null,
  "email": "kk@kk.com",
  "ip": "xx.xx.xx.xx",
  "created": "2023-05-29T11:46:21.685157634"
}
```

### 📘 Notes

- `idsending`: ID of the email sending operation if the blacklist entry was created as a result of a send.
- `ip`: IP address from which the blacklist was created.
- `created`: Timestamp when the email was added to the blacklist.

---

## 📄 Get Blacklist and Auto-Blacklist Info by App

**Endpoint:**  
`GET /private/blacklist/findByApp`

### 🔹 Parameters

| Parameter | Description       | Required | Default |
|----------|-------------------|----------|---------|
| `idapp`  | App ID            | ✅ Yes   | –       |
| `page`   | Page number       | ✅ Yes   | –       |
| `size`   | Page size         | ✅ Yes   | –       |

### 🧾 Status Codes

| Code | Description                                      |
|------|--------------------------------------------------|
| 200  | Success                                          |
| 400  | Missing or invalid parameter                    |
| 401  | Unauthorized user                               |
| 403  | Invalid credentials                             |
| 500  | Internal server error                           |

### ✅ Sample Response

```
{
  "blacklisted": {
    "content": [
      {
        "_id": "6474908d7ff70117d6a938dc",
        "idapp": "647095de67e43f0f33a3a089",
        "idsending": null,
        "email": "kk@kk.com",
        "ip": "xx.xx.xx.xx",
        "created": "2023-05-29T11:46:21.685"
      }
    ],
    "pageable": {
      "pageNumber": 0,
      "pageSize": 10
    },
    "totalPages": 1,
    "totalElements": 1,
    "first": true,
    "last": true,
    "empty": false
  },
  "autoblacklisted": {
    "content": [],
    "pageable": {
      "pageNumber": 0,
      "pageSize": 10
    },
    "totalPages": 0,
    "totalElements": 0,
    "first": true,
    "last": true,
    "empty": true
  }
}
```

---

## 🔍 Check if an Email is Blacklisted

**Endpoint:**  
`GET /private/blacklist/isBlackListed`

### 🔹 Parameters

| Parameter | Description            | Required | Default |
|----------|------------------------|----------|---------|
| `idapp`  | App ID                 | ✅ Yes   | –       |
| `email`  | Email address to check | ✅ Yes   | –       |

### 🧾 Status Codes

| Code | Description                                      |
|------|--------------------------------------------------|
| 200  | Success                                          |
| 400  | Missing or invalid parameter                    |
| 401  | Unauthorized user                               |
| 403  | Invalid credentials                             |
| 500  | Internal server error                           |

### ✅ Response

Returns a plain text response: `true` or `false`

---

## ❌ Remove an Email from the Blacklist

**Endpoint:**  
`POST /private/blacklist/remove`

### 🔹 Parameters

| Parameter | Description               | Required | Default |
|----------|---------------------------|----------|---------|
| `idapp`  | App ID                    | ✅ Yes   | –       |
| `email`  | Email address to remove   | ✅ Yes   | –       |

### 🧾 Status Codes

| Code | Description                                      |
|------|--------------------------------------------------|
| 200  | Success                                          |
| 400  | Missing or invalid parameter                    |
| 401  | Unauthorized user                               |
| 403  | Invalid credentials                             |
| 406  | Specific error (see below)                      |
| 500  | Internal server error                           |

**Specific errors:**
1. Email not found  
2. Email was added by the recipient and cannot be removed

### ✅ Response

Returns an empty response on success.
