Cuando [crees o edites una app](api-apps.md), opcionalmente puedes especificar el host o IP de origen para limitar que solo peticiones desde ese host/IP para [enviar emails](api-emails.md) sean permitidas.

Si no utilizas este parámetro tu app podrá ser usada desde cualquier IP sin comprobar su origen.

Para especifivar el host origen debes usar el parámetro *originserver* con valores como "*myserver.com*" o "*192.168.0.1*". 

También puedes especificar múltiples hosts/IPs con valores separados por comas: "*myserver.com,192.168.0.1*"

Si usas esta caraterística y al enviar emails recibes un error es debido a que el origen de la llamada no coincide con el valor de *originserver* en tu app. En la descripción del error recibirás el host/IP que ha sido considerado para tu petición. Así puedes cambiar el valor de *originserver* con el valor adecuado.












