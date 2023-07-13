When [creating/editing your app](api-apps.md) optionally you can set a origin server or IP in order to limit servers/IPs from which [call to send emails](api-emails.md) can be made.

If you don't set this parameter your app can be used from any IP without checking request origin.

For specify origin server you must use *originserver* parameter with values like "*myserver.com*" or "*192.168.0.1*". 

Also, you can specify multiple servers/IPs with comma separated values: "*myserver.com,192.168.0.1*"

If you are using this feature, when sending emails, you will receive error if the origin email does not match with *originserver* specified in your app. At the error description you will get received server/IP as origin of your request. Thus, you can fix *originserver* whith the correct value.












