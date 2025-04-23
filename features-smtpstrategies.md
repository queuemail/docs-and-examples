## Improving Fault Tolerance with Multiple SMTP Servers

You can increase your application's fault tolerance by configuring multiple SMTP servers.

If one SMTP server fails, the system will automatically attempt to resend the email using an alternative server.

When [creating or editing your app](api-apps.md), you can choose between two SMTP selection strategies: **RANDOM** and **PRIORITY**.

- If no `strategy` parameter is specified, the **RANDOM** strategy is used by default.
- If `strategy=PRIORITY` is specified, the email will first attempt to send using the SMTP server with the highest priority. If that server fails, the next highest-priority server is used, and so on.

You can assign a priority level to each SMTP server when [creating or editing your SMTP configuration](api-smtps.md).

With the **RANDOM** strategy, a different SMTP server is selected at random if the previous one fails, providing a simple form of load distribution and redundancy.
