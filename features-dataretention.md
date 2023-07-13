Apps, by default, retain subject and body data **until email is sucessfully sent**. Then, these data are permanently removed.

If you want to retain these data permanently, you must use *retaindata=true* when [creating/editing your app](api-apps.md).

If you want to use *attachmenttype=URL* when you [send an email](api-emails.md), you must use *retaindata=true* in your app.

Whether you use *retaindata=true* or not you can call [/private/emails/remove](api-emails.md) endpoint to remove all data and logs of finished emails.

Due to traceability reasons, we do not remove any email address.

Please, read our [private policy](legal-privatepolicy.md) for more info about data privacy. 




