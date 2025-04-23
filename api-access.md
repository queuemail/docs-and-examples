## 🚀 Getting Started with the QUEUEMAIL API

To start using the QUEUEMAIL API, you must first [register for an account](https://queuemail.dev/qmadmin/register).

### ✅ Steps to Access the API

1. **Log in** to the [Control Panel](https://queuemail.dev/qmadmin/) using your username and password.

2. **[Create an App](api-apps.md)** in the Control Panel.  
   Each app will generate a unique **App ID**, which is required for all API requests.

3. **[Create at least one SMTP Server](api-smtps.md)** and associate it with your app.  
   Each SMTP server will also have a unique **SMTP ID** needed for email-related API operations.

4. **[Log in via the API](api-login.md)** using your username and password to obtain a **Bearer Token**.  
   This token is required in the `Authorization` header of all API requests.

> ⏱ **Token Expiration:** 24 hours

---

### 🌐 Base API Endpoint

https://api.queuemail.dev/api 





