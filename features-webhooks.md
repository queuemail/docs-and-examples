## 🔔 Webhooks – Event Notifications

The **webhooks** feature allows you to configure custom URLs that QUEUEMAIL.DEV will call automatically when specific events occur.

This enables seamless integration with your backend processes, automation systems, or analytics platforms.

---

### 📌 Available Webhook Events

Each webhook is triggered with specific parameters:

- **`sending_finished`**  
  Triggered when an email is successfully sent.  
  - Parameter: `qm_idsending` (the ID of the email)

- **`sending_error`**  
  Triggered when an email fails to send.  
  - Parameter: `qm_idsending` (the ID of the email)

- **`tracking_opened`**  
  Triggered when a recipient opens the email.  
  - Parameters:  
    - `qm_idsending` – Email ID  
    - `qm_email` – Recipient email address

- **`tracking_clicked`**  
  Triggered when a recipient clicks a link in the email.  
  - Parameters:  
    - `qm_idsending` – Email ID  
    - `qm_email` – Recipient email address  
    - `qm_url` – Clicked URL

- **`blacklisted_added`**  
  Triggered when a recipient is added to the blacklist.  
  - Parameters:  
    - `qm_idsending` – Email ID  
    - `qm_email` – Blacklisted email address

---

### ⚙️ How to Configure Webhooks

You can define your webhook URLs when [creating or editing your app](api-apps.md).  
Each event type has a corresponding input field where you can enter the URL to be called.

> 💡 Ensure your webhook endpoints are secure and capable of handling the expected parameters.

---

Webhooks allow you to build powerful automations around email delivery, tracking, and unsubscribe events.
