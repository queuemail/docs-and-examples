# QUEUEMAIL.DEV - Reliable email delivery API. Free tier. Send asynchronously.

Main docs page here --> [https://docs.queuemail.dev/](https://docs.queuemail.dev/)

QUEUEMAIL.DEV allows you to send emails via API using one or more SMTP servers in order to ensure deliverability and avoid SMTP stress.

Some sample features:

- You can program sending emails in a synchronous or asynchronous way: With [logs endpoint](api-logs.md) you can check send status for every email sent. 

- Also, with [webhooks](features-webhooks.md), you can run processes when an event (like email sucessfully sent) occurs for a complete integration.

- With [sending email endpoint](api-emails.md) you can discard sending errors before you start a SMTP session.

- Track opened emails and clicked email links with [tracking endpoint](api-tracking.md).

- ...and much more at [docs](https://docs.queuemail.dev).

Free tier does not support Queuemail professional SMTP servers. So you must to configure [free SMTP servers](other-freesmtps.md) or your custom SMTP server.


#### CLIENTS:

* [queuemail-client: A basic Java client to use QUEUEMAIL.DEV API](https://github.com/queuemail/docs-and-examples/tree/main/queuemail-client).

#### EXAMPLES:

* [Hardy Client: A robust Java client to use QUEUEMAIL.DEV API](examples-hardyservice.md).


### CHANGELOG:

* **2023-09-20**: <a href="https://queuemail.dev/qmadmin/login">Control panel</a> improvements: Now yu can create and send newsletters (contacts, templates and mailing management).

* **2023-09-19**: <a href="https://queuemail.dev/qmadmin/login">Control panel</a> improvements: Now you can managa queue, logs, tracking and blacklists.

* **2023-09-01**: <a href="https://queuemail.dev/qmadmin/login">Control panel</a> acccess. Apps and SMTP servers must be created via control panel. API calls for manage apps and SMTP servers are removed.

* **2023-07-21**: Added example: [Hardy Client: A robust Java client to use QUEUEMAIL.DEV API](examples-hardyservice.md).

* **2023-07-18**: Added *senddate* parameter to [sending emails endpoint](api-emails.md) in order to schedule emails to send.
