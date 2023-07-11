You can improve app fault tolerance if you define several SMTP servers. 

Thus, if a SMTP fails, then the app will retry to send emails with another one.

When [creating/editing your app](apps.md), you can choose beetween RANDOM and PRIORITY strategies for SMTP selection. 

If you don't specify *strategy* parameter, RANDOM strategy is assumed by default.

If you specify *strategy=PRIORITY*, in each mail sending SMTP server with higher priority will be use at first. In case of error, next SMTP with higher priority will be used, and so on.

You can define priority for each SMTP when [creating/editing your SMTP servers](api-smtps.md).

With *strategy=RANDOM* also any SMTP server are used in case of error using the previous one, but they are randomly selected.












