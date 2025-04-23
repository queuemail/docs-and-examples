## 🔒 Data Retention & Privacy Policy

By default, QUEUEMAIL.DEV apps **only retain the subject and body of an email until it has been successfully sent**.  
Once delivery is confirmed, this sensitive data is **permanently deleted** to ensure privacy.

This default behavior is designed to minimize sensitive data storage and enhance data protection.

---

### 🧾 Want to Retain Sensitive Email Content?

If you want to **retain subject and body data permanently**, you must check the option  
**_Retain sensitive info_** when [creating or editing your app](api-apps.md).

---

### 📎 Attachments and Privacy

- If you use `attachmenttype=URL` when [sending an email](api-emails.md), attachment data will be temporarily stored — the duration depends on your [current plan](api-limitations.md).
- For **maximum privacy**, we recommend using `attachmenttype=FILE`, which avoids storing external URLs on our infrastructure.

---

### 🧹 Immediate Data Deletion

To delete all data related to a sent email **immediately**, use the following endpoint:

```
/private/emails/remove
```

Refer to the [Email API documentation](api-emails.md) for usage details.

---

### 📧 Email Address Retention

For traceability purposes, **email addresses are not deleted immediately** — they are retained based on your [plan’s retention policy](api-limitations.md).

---

### 🔐 Full Privacy Option

If you're looking for **total privacy and full control** over your data:

- Host your own database
- Retain or delete data on your terms
- Ensure no external access to sensitive content

👉 This is available by [subscribing to a professional plan](api-limitations.md).

---

### 📄 Learn More

See our [Privacy Policy](legal-privatepolicy.md) for full details on how your data is handled.
