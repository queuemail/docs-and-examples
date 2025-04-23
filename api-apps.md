## Managing Your Apps

To manage your apps, go to the [Control Panel](https://queuemail.dev/qmadmin/login).

You must create at least one app to start using **QUEUEMAIL.DEV**.

Each app should represent a project or a part of a project with its own configuration and behavior.

<div style="width:100%; text-align:center;">
    <img src="/list-apps.png" alt="List of apps" />
</div>

### Creating a New App

To create a new app, click the **NEW APP** button. You will see the following screen:

<div style="width:100%; text-align:center;">
    <img src="/new-app.png" alt="New app screen" />
</div>

At a minimum, you must specify an **App Name**. You can also configure the following options:

1. **Retain Sensitive Info**  
   If enabled, sensitive email data (subject, body, and attachment URLs) will be stored in the database until you manually delete it. Otherwise, this data is not saved.

2. **Use Blacklist**  
   Allows recipients to unsubscribe by clicking the unsubscribe link in emails. Future emails will be blocked for those recipients.

3. **Use Auto-Blacklist**  
   Automatically blocks recipients who consistently bounce or encounter permanent delivery issues.

4. **SMTP Selection Strategy**  
   Choose between `PRIORITY` and `RANDOM` strategies for selecting SMTP servers. The **free tier only supports the RANDOM strategy**.

5. **Seconds Between Emails**  
   Sets the minimum interval between sent emails. The free tier enforces a minimum of **60 seconds**.

6. **Allowed Origin Hosts/IPs**  
   Restrict email sending to specified hostnames or IP addresses. Use commas to separate multiple values.

7. **Test Email Address**  
   An email address used for testing purposes. By default, this is the email used during signup.

8. **Default Sender Email Address**  
   Sets the default "from" email address for this app. Defaults to the signup email.

9. **Default Sender Name**  
   Sets the default sender name for this app. Defaults to the signup email's associated name.

10. **Webhook – Email Sent Successfully**  
    A URL that will be called when an email is sent successfully. It receives the `qm_idsending` parameter with the email ID.

11. **Webhook – Email Failed to Send**  
    A URL that will be called when an email fails to send. It receives the `qm_idsending` parameter with the email ID.

12. **Webhook – Email Opened**  
    A URL triggered when a recipient opens an email. It receives `qm_idsending` (email ID) and `qm_email` (recipient address).

13. **Webhook – Link Clicked**  
    A URL triggered when a recipient clicks a link inside an email. It receives `qm_idsending`, `qm_email`, and `qm_url` (the clicked link).

14. **Webhook – Added to Blacklist**  
    A URL triggered when a recipient unsubscribes or is added to your app’s blacklist. It receives `qm_idsending` and `qm_email`.

---

### Saving the App

Once all information is filled in, click **SAVE**. The system will generate an **App API ID** that you'll use for all API requests related to this app.

<div style="width:100%; text-align:center;">
    <img src="/list-apps-2.png" alt="App API ID screen" />
</div>
