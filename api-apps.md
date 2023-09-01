By accessing <a target="_blank" href="https://queuemail.dev/qmadmin/login">control panel</a> you can manage your apps.

You need to create at least an app to use QUEUEMAIL. 

Each app should correspond to a project or project part which has different behaviour.

<div style="width:100%; text-align:center;">
    <img src="/list-apps.png" />
</div>

For creating a new app cikc NEW APP button and you will acess the following screen:

<div style="width:100%; text-align:center;">
    <img src="/new-app.png">
</div>

You must set your app name at lest. Moreover you can define:

1. <b>Retain sensitive info</b>: If checked, sensitive email info (subject, body and url attachments) will be retained in database until you will delete it manually. Otherwise, this info will not be stored in database.

2. <b>Use blacklist</b>: If checked, recipients can block receiving future emails by clicking 'unsubscribe link'.

3. <b>Use auto-blacklist</b>: If checked, system can block future emails for recipients with permanent or repetitive problems.

4. <b>Strategy</b>: If app uses PRIORITY or RANDOM strategy to select SMTP server will be used for send emails. For free-tier only RANDOM strategy works.

5. <b>Seconds between emails</b>: Minimun time between emails. For free-tier 60 seconds minimun always.

6. <b>Origin hosts/IPs</b>: If set, you can send emails just from these hosts/IPs. Comma separated for multiple values.

7. <b>Test email address</b>: Email recipient to test sending emails. Email address used at sign up by default.

8. <b>Default sender email address</b>: Sender address email by defaul for this app. Email address used at sign up by default.

9. <b>Default sender name</b>: Sender name by default for this app. Email address used at sign up by default.

10. <b>Webhook URL for email is sent ok</b>: URL called when emails are sent sucessfully. This URL will receive parameter qm_idsending with email id as value.

11. <b>Webhook URL for email is not sent</b>: URL llamada cuando los emails fallan. Esta URL recibe el parámetro qm_idsending con el id del email como valor.

12. <b>Webhook URL for email opened</b>: URL called when a recipient opens email. This URL will receive parameter qm_idsending with email id as value and parameter qm_email with recipient email address as value.

13. <b>Webhook URL for link clicked</b>: URL called when a recipient clicks a link on the received email. This URL will receive parameter qm_idsending with email id as value, parameter qm_email with recipient email address as value and qm_url with URL of link clicked as value.

14. <b>Webhook URL for recipient added to blacklist</b>: URL called when a recipient requests to be included in the app blacklist. This URL will receive parameter qm_idsending with email id as value and parameter qm_email with recipient email address as value.


When completed these data we will click SAVE button and we can see app API ID value we will use for make API calls:

<div style="width:100%; text-align:center;">
    <img src="/list-apps-2.png" />
</div>
