# QUEUEMAIL.DEV – Reliable Email Delivery API (Free Tier, Asynchronous Support)

📄 Main documentation: [https://docs.queuemail.dev/](https://docs.queuemail.dev/)

**QUEUEMAIL.DEV** is a flexible email delivery platform that lets you send emails through one or multiple SMTP servers to maximize deliverability and prevent server overload.

## 🔧 Key Features

- **Synchronous and Asynchronous Sending**  
  Choose how emails are sent. Use the [Logs Endpoint](api-logs.md) to check the delivery status of every email.

- **Webhook Support**  
  Set up [Webhooks](features-webhooks.md) to trigger actions when events occur—such as successful delivery—enabling full system integration.

- **Pre-send Error Handling**  
  The [Email Sending Endpoint](api-emails.md) allows you to catch errors before initiating an SMTP session.

- **Email Tracking**  
  Monitor email opens and link clicks using the [Tracking Endpoint](api-tracking.md).

- ...and much more in the [official documentation](https://docs.queuemail.dev)

> ⚠️ **Note:** The free tier does not include access to Queuemail’s professional SMTP servers. You must configure your own or use one of the [recommended free SMTP servers](other-freesmtps.md).

---

## 💻 Clients

- [**queuemail-client**: Basic Java client for the QUEUEMAIL.DEV API](https://github.com/queuemail/docs-and-examples/tree/main/queuemail-client)

## 🧪 Examples

- [**Hardy Client**: A robust Java client for interacting with the QUEUEMAIL.DEV API](examples-hardyservice.md)

---

## 📝 Changelog

- **2025-04-23** - Documentation improvement
- **2024-01-09** – Automatic deletion of unused free-tier accounts. See [API Limitations](api-limitations.md).  
- **2023-09-20** – Control Panel updates: You can now manage newsletters (contacts, templates, and mailings). [Access the panel](https://queuemail.dev/qmadmin/login)  
- **2023-09-19** – Control Panel enhancements: Queue, logs, tracking, and blacklist management added.  
- **2023-09-01** – Control Panel required for app and SMTP server creation. Related API calls have been deprecated.  
- **2023-07-21** – New example added: [Hardy Client](examples-hardyservice.md).  
- **2023-07-18** – `senddate` parameter added to the [Email Sending Endpoint](api-emails.md) to allow scheduling.

