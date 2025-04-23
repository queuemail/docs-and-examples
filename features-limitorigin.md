## 🌐 Restrict Email API Calls by Origin Server or IP

When [creating or editing your app](api-apps.md), you can optionally restrict the origin of API requests by specifying a **server name** or **IP address**.

This feature is useful if you want to ensure that only trusted servers can [send emails](api-emails.md) using your app.

---

### 🔧 How to Set Allowed Origins

To enable origin restrictions, set the `originserver` parameter when configuring your app. You can use:

- A single domain or IP address:
  ```
  myserver.com
  ```
  or
  ```
  192.168.0.1
  ```

- Multiple domains or IPs (comma-separated):
  ```
  myserver.com,192.168.0.1
  ```

If `originserver` is **not set**, the app can be accessed from **any origin** without restriction.

---

### ❌ What Happens If the Origin Doesn’t Match?

If you enable this restriction and a request to send an email comes from a server/IP that **does not match** the values in `originserver`, the request will be **rejected with an error**.

The error message will include the **actual origin** (server name or IP) used in the request.  
This can help you identify and correct the allowed origin list by updating the `originserver` value accordingly.

---

✅ Use this feature to enhance your app’s security by allowing email operations **only from approved sources**.
