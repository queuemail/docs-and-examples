By accessing <a target="_blank" href="https://queuemail.dev/qmadmin/login">control panel</a> you can manage your SMTP servers.

You must define at least a SMTP server asociated to your app in order you can use QUEUEMAIL for free.

If you use QUEUEMAIL professional plan (not free) you don't need to define any SMTP server because for your mail send you will use QUEUEMAIL professional SMTP servers.

If you don't have an own SMTP server you can [get a free SMTP server here](other-freesmtps.md).

<div style="width:100%; text-align:center;">
    <img src="/list-smtps.png" />
</div>

For creating a new SMTP server click NEW SMTP SERVER button and you will access the following screen:

<div style="width:100%; text-align:center;">
    <img src="/new-smtp.png">
</div>

You must set at lest app you want to asociate to SMTP server, host (or IP) of the server and port used by SMTP server. Moreover, you can define:

1. <b>Use authentication</b>: If SMTP server needs user and password authentication for sending emails.

2. <b>Use STARTTLS</b>: If SMTP server uses <a href="https://en.wikipedia.org/wiki/Opportunistic_TLS">STARTTLS</a>.

3. <b>Use SSLTLS</b>: If SMTP server uses <a href="https://en.wikipedia.org/wiki/Transport_Layer_Security">SSLTLS</a>.

4. <b>Priority</b>: Used for select SMTP to use if app has PRIORITY strategy (lower value, higher priority).

5. <b>User name</b>: User name used for authentification on the SMTP server.

6. <b>Password</b>: Password used for authefication on the SMTP server.

7. <b>Default sender email address</b>: If set, sender email address is always replaced by this value for all emails sent using this SMTP server.

8. <b>Default sender name</b>: If set, sender name is always replaced by this value for all emails sent using this SMTP server.

When completed these data we will click CHECK AND SAVE to check if SMTP server works ok by sending an email to test email address of the asociated app. If works, SMTP server will be shown as enabled (green circle). Otherwise it will be shown as disabled (red circle) and it will remain disabled until we edit it and save it with correct data.

Anyway, the new SMTP sever API ID will be show. We need this info in order to make API calls.

<div style="width:100%; text-align:center;">
    <img src="/list-smtps-2.png" />
</div>
