## Managing SMTP Servers

To manage your SMTP servers, access the [Control Panel](https://queuemail.dev/qmadmin/login).

### 📬 SMTP Requirement

To use **QUEUEMAIL.DEV** on the free tier, you must define at least one SMTP server associated with your app.

If you're on a **QUEUEMAIL professional plan (paid)**, you do **not** need to configure any SMTP servers, as all outgoing mail will be routed through QUEUEMAIL’s professional SMTP infrastructure.

> Don't have your own SMTP server?  
> 👉 [Get a free SMTP server here](other-freesmtps.md)

<div style="width:100%; text-align:center;">
    <img src="/list-smtps.png" alt="SMTP server list" />
</div>

---

### Creating a New SMTP Server

To add a new SMTP server, click the **NEW SMTP SERVER** button. The following screen will appear:

<div style="width:100%; text-align:center;">
    <img src="/new-smtp.png" alt="New SMTP server screen" />
</div>

You must provide the following **required fields**:
- The **App** to associate with this SMTP server
- The **Host** (or IP address) of the SMTP server
- The **Port** used by the SMTP server

Additionally, you can configure the following **optional settings**:

1. **Use Authentication**  
   Enable this if the SMTP server requires a username and password to send emails.

2. **Use STARTTLS**  
   Enable if the server supports [STARTTLS](https://en.wikipedia.org/wiki/Opportunistic_TLS) encryption.

3. **Use SSL/TLS**  
   Enable if the server uses [SSL/TLS](https://en.wikipedia.org/wiki/Transport_Layer_Security) for encrypted connections.

4. **Priority**  
   Used when your app is configured with the `PRIORITY` SMTP strategy. A lower value means higher priority.

5. **Username**  
   The username for SMTP authentication.

6. **Password**  
   The password for SMTP authentication.

7. **Default Sender Email Address**  
   If set, all emails sent through this SMTP will use this address as the sender.

8. **Default Sender Name**  
   If set, all emails sent through this SMTP will use this name as the sender.

---

### Saving and Testing the SMTP Server

Once all the required fields are filled in, click **CHECK AND SAVE**.  
The system will attempt to send a test email to the **test email address** of the associated app:

- ✅ If the test is successful, the SMTP server will be **enabled** (green circle).
- ❌ If it fails, the SMTP server will be **disabled** (red circle) and remain so until corrected and saved again.

Regardless of the result, a new **SMTP Server API ID** will be generated. This ID is required for making SMTP-related API calls.

<div style="width:100%; text-align:center;">
    <img src="/list-smtps-2.png" alt="SMTP server details screen" />
</div>
