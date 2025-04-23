## 🔐 Authentication – Get Bearer Token

Use your **username** and **password** to obtain a bearer token, which must be included in the `Authorization` header for all authenticated API requests.

---

### 📤 Request

**Endpoint:**  
`POST /auth/login`

#### 🔹 Parameters

| Parameter | Description     | Required |
|-----------|-----------------|----------|
| `username` | Your username   | ✅ Yes   |
| `password` | Your password   | ✅ Yes   |

---

### 🧾 Status Codes

| Code | Description                                       |
|------|---------------------------------------------------|
| 200  | Login successful                                  |
| 400  | Missing required parameter or invalid parameter   |
| 403  | Invalid username or password                      |
| 500  | Internal server error                             |

---

### ✅ Successful Response Example

If login is successful, the response will return a JSON object containing the authentication token and user information:

```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2M2JiZTU4NmRkMDcwYjc4ZmI0OTVlZDIiLCJzdWIiOiJ1c2VyMSIsImF1ZCI6InVzZXIiLCJpc3MiOiJDSS0xNTFhY2U2OS1kZTkyLTQwYjQtYmY5NC04OGRmZWIzNTc1ZjQiLCJpYXQiOjE2ODQ3NDg0MTUsImV4cCI6MTY4NDgzNDgxNX0.CcNyo8Ug45dNLNZ0Q41wpPObrFI-hagaJdat3ryxqdo",
  "role": "user",
  "userId": "63bbe586dd070b78fb495ed2",
  "username": "username",
  "clientId": "CI-151ace69-de92-40b4-bf94-88dfeb3575f4"
}
```

### 🔐 Using the Bearer Token

Once you receive the token, include it in the `Authorization` header of **all** authenticated API requests using the **Bearer** scheme:


```
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2M2JiZTU4NmRkMDcwYjc4ZmI0OTVlZDIiLCJzdWIiOiJ1c2VyMSIsImF1ZCI6InVzZXIiLCJpc3MiOiJDSS0xNTFhY2U2OS1kZTkyLTQwYjQtYmY5NC04OGRmZWIzNTc1ZjQiLCJpYXQiOjE2ODQ3NDg0MTUsImV4cCI6MTY4NDgzNDgxNX0.CcNyo8Ug45dNLNZ0Q41wpPObrFI-hagaJdat3ryxqdo
```


> 💡 Make sure to include the full token exactly as received.  
> This header must be present in every API call that requires authentication.

