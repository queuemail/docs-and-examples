Webhooks feature let you to configure your own URLs in order to run processes when an event occurs at queuemail.dev.

There are the following webhook events:

- *sending_finished*: URL is called with param *qm_idsending* (id of sent mail) when email is sucessfully sent.
- *sending_error*: URL is called with param *qm_idsending* (id of sent mail) when email send fails.
- *tracking_opened*: URL is called with params *qm_idsending* (id of sent mail) and *qm_email* (recipient email) when email is opened.
- *tracking_clicked*: URL is called with params *qm_idsending* (id of sent mail), *qm_email* (recipient email) and *qm_url* (url clicked) when recipient clicks a link email (qm_url).
- *blacklisted_added*: URL is called with params *qm_idsending* (id of sent mail) and *qm_email* (email address to blacklist) when an email address is added to blacklist.

You can configure your webhooks URLs when [creating/editing your app](api-apps.md).






