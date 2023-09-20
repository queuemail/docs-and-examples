Apps, by default, just retain subject and body data **until email is sucessfully sent**. Then, these data are permanently removed.

That is, apps, by default, remove all sensitive information due to privacity reasons.

If you want to retain these data permanently, you must check *Retain sensitive info* when [creating/editing your app](api-apps.md).

Keep in mind that if you use *attachmenttype=URL* when you [send an email](api-emails.md) attachments data will be kept for a while [depending on your plan](api-limitations.md). 

Therefore, if you want to guarantee complete privacy then you shoud use *attachmenttype=FILE*.

In any case, if you want to **immediately delete all information related to the sending** you must use API endpoint [/private/emails/remove](api-emails.md).

Due to traceability reasons, we do not remove any email address (until system delete them [depending on your plan](api-limitations.md)).

If you are looking for total privacy, we suggest that you use your own database by [contracting a professional plan with us](api-limitations.md).

Please, read our [private policy](legal-privatepolicy.md) for more info about data privacy. 




