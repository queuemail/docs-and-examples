
Usando estas llamadas puedes enviar emails (meterlos en cola), obtener información del envío del email, cancelar (sacar de la cola) emails y eliminar un email que haya terminado su envío.


<!-- tabs:start -->


<!-- tab:Enviar (meter en la cola) un email -->


**PETICIÓN:** 

*POST* /private/emails/send

|Parámetro|Descripción|Requerido| Valor por defecto|
|---------|-----------|--------|---------|
|idapp | App id | Sí |  |
|from | Dirección de origen del email | No | Dirección de origen por defecto de la app |
|fromname | Nombre de origen del email | No | Nombre de origen por defecto de la app  |
|tos | Direcciones de remitentes (separadas por coma)  | Sí  |  |
|tonames | Nombres de remitentes (separadas por coma) | No | Direcciones de remitentes  |
|ccs | Direcciones de remitentes en copia (separadas por com) | No |  |
|bccs | Direcciones de remitentes en copia oculta (separadas por com) | No |  |
|replyto | Dirección de respuesta  | No |  |
|mimetype | text/html o text/plain  | No | text/plain |
|subject | Asunto del email  | Sí |  |
|subjectencoding | Codificación del asunto del email (UTF-8, ISO-8859-1, etc.) | No | UTF-8  |
|body | Cuerpo del email | Sí |  |
|bodyencoding | Codificación del cuerpo del email (UTF-8, ISO-8859-1, etc.)  | No | UTF-8  |
|attachments | Ficheros adjuntos al email | No |  |
|urlattachments | Url's adjuntas al email | No |  |
|attachmenttype | Tipo de adjuntos (FILE / URL)  | No | FILE |
|includetracking | ¿Incluir tracking?  | No | false |
|includeunregisterlink | ¿Incluir enlace de baja (blacklist)?  | No | false |

**CÓDIGOS DE ESTADO:**

|Code|Description|
|----|-------|
|200 | Operación correcta |
|400 | Falta parámetro obligatorio o tipo de parámetro incorrecto |
|401 | Usuario no autorizado |
|403 | Credenciales no válidas |
|406 | Error específico |
|500 | Error interno|

Error específicos:

1. App no encontrada
2. Host origen no permitido: xxxx
3. No ha SMTP activo para esta app
4. El dominio del remitente no existe
5. No se puede usar includetracking=true si usas CCS o BCCS. Por favor, usa includetracking=false o elimina las direcciones de CCS y BCCS
6. No se puede usar includeUnregisterLink=true si usas CCS o BCCS. Por favor, usa includetracking=false o elimina las direcciones de CCS y BCCS
7. *from* no es una dirección de correo válida
9. *to* no es una dirección de correo válida
10. *replyto* no es una dirección de correo válida
11. *replyto* el dominio no tiene registros MX
12. Ningún destinatario es válido.
13. Todos ls destinatarios están incluidos en una blacklist
14. Para usar el tipo de adjunto URL debes configurar tu app con retaindata=true
15. Límite de enviós de emails por mes excedido



Recibirás una respuesta en formato JSON como esta::

```
{
    "id": "64747cae67e43f0f33a3a08b",
    "status": "Q",
    "inittime": "2023-05-29T10:22:33.895254204",
    "logsdeleledby": "2023-06-28T10:22:33.895254204",
    "attachments": [
        "https://cdn.queuemail.dev/static/sendings/b74f118e-eab2-4aa9-b72d-xec21fa2368b/c.xml"
    ],
    "blacklisted": [],
    "autoblacklisted": [],
    "notvalidrecipients": []
}
```

- **status** El valor = 'Q' significa que el email ha sido entrado en la cola de envío con éxito.
- **inittime** hora aproximada de envío del email.
- **logsdeleledby** cuando los logs del email serán eliminados.it the time when email logs will be deleted.
- **attachments** lista de adjuntos (urls).
- **blacklisted** lista de destinatarios a los que no se enviará el email por estar incluidos en la blacklist.
- **autoblacklisted** lista de destinatarios a los que no se enviará el email por estar incluidos en la auto-blacklist.
- **notvalidrecipients** lista destinatarios a los que no se enviará el email por no ser direcciones de correo válidas.


<!-- tab:Obtener información de un envío de email -->



**PETICIÓN:** 

*GET* /private/emails/info

|Parámetro|Descripción|Requerido| Valor por defecto|
|---------|-----------|--------|---------|
|idemail | Email id | Sí |  |

**CÓDIGOS DE ESTADO:**

|Code|Description|
|----|-------|
|200 | Operación correcta |
|400 | Falta parámetro obligatorio o tipo de parámetro incorrecto |
|401 | Usuario no autorizado |
|403 | Credenciales no válidas |
|406 | Error específico |
|500 | Error interno|

Error específicos:

1. Email no encontrado.

**RESPUESTA:**


Recibirás una respuesta en formato JSON como esta::

```
{
    "id": "64747cae67e43f0f33a3a08b",
    "status": "Q",
    "inittime": "2023-05-29T10:22:33.895",
    "logsdeleledby": "2023-06-28T10:22:33.895",
    "attachments": [
        "https://cdn.queuemail.dev/static/sendings/7723743-34838743-34343/c.xml"
    ],
    "log": [],
    "opened": []
}
```

- **status** = 
    - 'Q' significa que el email ha sido entrado en la cola correctamente.
    - 'R' significa que el envío del email está siendo procesado en este momento.
    - 'C' significa que el envío del email ha sido cancelado.
    - 'E' significa que el envío del email ha fallado.
    - 'F' significa que el envío del email ha finalizado con éxito.
 **inittime** hora aproximada de envío del email.
- **logsdeleledby** cuando los logs del email serán eliminados.it the time when email logs will be deleted.
- **attachments** lista de adjuntos (urls).
- **blacklisted** lista de destinatarios a los que no se enviará el email por estar incluidos en la blacklist.
- **autoblacklisted** lista de destinatarios a los que no se enviará el email por estar incluidos en la auto-blacklist.
- **notvalidrecipients** lista destinatarios a los que no se enviará el email por no ser direcciones de correo válidas.
- **log** lista con toda la información de log de actividad y error del email.
- **opened** lista con todos los destinatarios que hah abierto el email (momento y dirección de correo).




<!-- tab:Cancelar el envío de un email -->




**PETICIÓN:** 

*POST* /private/emails/cancel

|Parámetro|Descripción|Requerido| Valor por defecto|
|---------|-----------|--------|---------|
|idemail | Email id | Sí |  |

**CÓDIGOS DE ESTADO:**

|Code|Description|
|----|-------|
|200 | Operación correcta |
|400 | Falta parámetro obligatorio o tipo de parámetro incorrecto |
|401 | Usuario no autorizado |
|403 | Credenciales no válidas |
|406 | Error específico |
|500 | Error interno|


Error específicos:

1. Algunos destinatarios ya han sido procesados. No se puede cancelar el envío.
2. Email no encontrado.
3. App no encontrada.
4. El envío ha finalizado o está en proceso. No se puede cancelar el envío.





**RESPUESTA:**


Recibirás una respuesta en formato JSON como esta::

```
{
    "id": "64747cae67e43f0f33a3a08b",
    "status": "C",
    "inittime": "2023-05-29T10:22:33.895",
    "logsdeleledby": "2023-06-28T10:22:33.895",
    "attachments": [
        "https://cdn.queuemail.dev/static/sendings/b74fdc8e-eab3-4aa9-b72d-0ec21fa2368b/c.xml"
    ]
}
```

**status** el valor = C significa que el envío ha sido cancelado.



<!-- tab:Eliminar un email -->

Elimina un email finalizado. También elimina toda la información de log y tracking asociada.


**PETICIÓN:** 


*POST* /private/emails/remove

|Parámetro|Descripción|Requerido| Valor por defecto|
|---------|-----------|--------|---------|
|idemail | SMTP id | Sí |  |

**CÓDIGOS DE ESTADO:**

|Code|Description|
|----|-------|
|200 | Operación correcta |
|400 | Falta parámetro obligatorio o tipo de parámetro incorrecto |
|401 | Usuario no autorizado |
|403 | Credenciales no válidas |
|406 | Error específico |
|500 | Error interno|

Error específicos:

1. Mail not found
2. App no encontrada
3. Los envíos no finalizados no pueden ser eliminados.



**RESPUESTA:**

*vacía*

<!-- tabs:end -->

