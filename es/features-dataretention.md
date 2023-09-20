
Las apps, por defecto, solo conservan los datos de asunto y cuerpo del email **hasta que el email es enviado correctamente**. Después esos datos son eliminados permanentemente. 

Es decir, las apps, por defecto, eliminan los datos sensibles por motivos de privacidad. 

Si quieres conservar esos datos de forma permanente, debes marcar *Retain sensitive info* cuando [crees/edites tu app](api-apps.md). 

Ten en cuenta que si usas *attachmenttype=URL* cuando [envíes un email](api-emails.md) los datos de ficheros adjuntos se conservarán un tiempo [dependiendo de tu plan](api-limitations.md). 

Por tanto, si deseas garantizar una privacidad total entonces debes usar *attachmenttype=FILE*.

En cualquier caso, si quieres **borrar inmediatamente toda la información relativa al envío** deberás usar el endpoint de la API [/private/emails/remove](api-emails.md). 

Debido a razones de trazabilidad, nunca eliminamos las direcciones de correo (hasta que el sistema elimine los datos [dependiendo de tu plan](api-limitations.md)).

Por favor, lee nuestra [política de privacidad](legal-privatepolicy.md) para más información acerca de la privacidad de datos. 




