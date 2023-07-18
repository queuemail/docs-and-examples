
Las apps, por defecto, solo conservan los datos de asunto y cuerpo del email **hasta que el email es enviado correctamente**. Después esos datos son elimnados permanentemente.

Si quieres conservar esos datos de forma permanente, debes usar *retaindata=true* cuando [crees/edites tu app](api-apps.md).

Si quieres usar *attachmenttype=URL* cuando [envíes un email](api-emails.md), debes usar *retaindata=true* en tu app.

Uses *retaindata=true* o no, siempre puedes usar la llamada [/private/emails/remove](api-emails.md) para eliminar todos los datos y logs de envíos de emails finalizados.

Debido a razones de trazabilidad, nunca eliminamos las direcciones de correo.

Por favor, lee nuestra [política de privacidad](legal-privatepolicy.md) para más información acerca de la privacidad de datos. 




