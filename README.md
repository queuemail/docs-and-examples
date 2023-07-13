# QUEUEMAIL.DEV - Reliable email delivery API. Free tier. Send asynchronously.

QUEUEMAIL.DEV allows you to send emails via API using one or more SMTP servers in order to ensure deliverability and avoid SMTP stress.

Some sample features:

- You can program sending emails in a synchronous or asynchronous way: With [logs endpoint](api-logs.md) you can check send status for every email sent. 

- Also, with [webhooks](features-webhooks.md), you can run processes when an event (like email sucessfully sent) occurs for a complete integration.

- With [sending email endpoint](api-emails.md) you can discard sending errors before you start a SMTP session.

- Track opened emails and clicked email links with [tracking endpoint](api-tracking.md).

- ...and much more at [docs](https://docs.queuemail.dev).

Free tier does not support Queuemail professional SMTP servers. So you must to configure [free SMTP servers](other-freesmtps.md) or your custom SMTP server.


