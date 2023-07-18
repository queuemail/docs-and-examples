Necesitas al menos crar una app para usar QUEUEMAIL. 

Cada app puede corresponder a un proyecto o parte del proyecto con diferente comportamiento.



<!-- tabs:start -->

<!-- tab:Crear/editar una app -->


**PETICIÓN:** 

*POST* /private/apps/save

|Parámetro|Descripción|Requerido| Valor por defecto|
|---------|-----------|--------|---------|
|idapp | App id | Si para edición, No para creación |  |
|name | App name  | Sí para creación, No para edición |  |
|retaindata | Si esta app debe preservar los datos de subject, body y url de adjuntos | No | No |
|strategy | RANDOM / PRIORITY  | No  | RANDOM |
|originserver | Si se establece, se pueden hacer llamadas solo desde el host/IP especificado (para muchos valores se separan por coma) | No  |
|defaultfromemail | Dirección origen del correo por defecto | No | Email del usuario |
|defaultfromname | Nombre origen del correo | No | Email del usuario |
|testemail | Email de destinatario para emails de prueba  | No | Email del usuario |
|timebetweenemails | Segundos entre emails  | No | 60 |
|useblacklist | Si la app usa black list  | No | No |
|useautoblacklist | Si la app usa auto black list  | No | No |
|webhook_sending_finished | URL llamada cuando el envío de email termina correctamente  | No |
|webhook_sending_error | URL llamada cuando el envío de email falla | No |
|webhook_tracking_opened | URL llamada cuando el email es abierto  | No |
|webhook_tracking_clicked | URL llamada cuando se hace click en un enlace del email recibido | No |
|webhook_blacklisted_added | URL llamada cuando un remitente se añade a la blacklist | No |

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

1. Ya existe una app con el mismo nombre
2. App no encontrada
3. Debes especificar un nombre



**RESPUESTA:**

Recibirás una respuesta en formato JSON como esta::

```
{
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2M2JiZTU4NmRkMDcwYjc4ZmI0OTVlZDIiLCJzdWIiOiJ1c2VyMSIsImF1ZCI6InVzZXIiLCJpc3MiOiJDSS0xNTFhY2U2OS1kZTkyLTQwYjQtYmY5NC04OGRmZWIzNTc1ZjQiLCJpYXQiOjE2ODQ3NDg0MTUsImV4cCI6MTY4NDgzNDgxNX0.CcNyo8Ug45dNLNZ0Q41wpPObrFI-hagaJdat3ryxqdo",
    "role": "user",
    "userId": "63bbe586dd070b78fb495ed2",
    "username": "username",
    "clientId": "CI-151ace69-de92-40b4-bf94-88dfeb3575f4"
}
```

Ahora puedes usar el valor de **token** en la cabecera *Authorization* de todas las operaciones de la API como un Bearer token:

```
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2M2JiZTU4NmRkMDcwYjc4ZmI0OTVlZDIiLCJzdWIiOiJ1c2VyMSIsImF1ZCI6InVzZXIiLCJpc3MiOiJDSS0xNTFhY2U2OS1kZTkyLTQwYjQtYmY5NC04OGRmZWIzNTc1ZjQiLCJpYXQiOjE2ODQ3NDg0MTUsImV4cCI6MTY4NDgzNDgxNX0.CcNyo8Ug45dNLNZ0Q41wpPObrFI-hagaJdat3ryxqdo
```
<!-- tab:Listar todas las apps -->



**PETICIÓN:** 

*GET* /private/apps/findAll

|Parámetro|Descripción|Requerido| Valor por defecto|
|---------|-----------|--------|---------|
|page | Página inicial | Sí |  |
|size | Tamaño máximo de página | Sí |  |

**CÓDIGOS DE ESTADO:**

|Code|Description|
|----|-------|
|200 | Operación correcta |
|400 | Falta parámetro obligatorio o tipo de parámetro incorrecto |
|401 | Usuario no autorizado |
|403 | Credenciales no válidas |
|500 | Error interno|



**RESPUESTA:**


Recibirás una respuesta en formato JSON como esta::

```
{
    "content": [
        {
            "_id": "63ca50f0c9557c7ac25f1715",
            "iduser": "63bbe586dd070b78fb495ed2",
            "name": "APP2",
            "strategy": "PRIORITY",
            "origindomain": null,
            "defaultfromemail": "user1@email.xxx",
            "defaultfromname": "Jonh Smith",
            "testemail": "user1@email.xxx",
            "timebetweenemails": 0,
            "useblacklist": true,
            "useautoblacklist": false,
            "webhook_sending_finished": null,
            "webhook_sending_error": null,
            "webhook_tracking_opened": null,
            "webhook_tracking_clicked": null,
            "webhook_blacklisted_added": null,
            "webhook_mailing_finished": null,
            "language": "EN",
            "created": "2023-01-20T08:29:36.763",
            "modified": "2023-01-20T08:29:36.763",
            "status": "A"
        }
    ],
    "pageable": {
        "sort": {
            "empty": true,
            "sorted": false,
            "unsorted": true
        },
        "offset": 1,
        "pageNumber": 1,
        "pageSize": 1,
        "paged": true,
        "unpaged": false
    },
    "last": false,
    "totalPages": 6,
    "totalElements": 6,
    "size": 1,
    "number": 1,
    "sort": {
        "empty": true,
        "sorted": false,
        "unsorted": true
    },
    "first": false,
    "numberOfElements": 1,
    "empty": false
}
```

El campo  **content** es una lista con todas las apps existentes para la cuenta conectada.


<!-- tab:Información de app -->




**PETICIÓN:** 

*GET* /private/apps/findById

|Parámetro|Descripción|Requerido| Valor por defecto|
|---------|-----------|--------|---------|
|idapp | App id | Sí |  |

**CÓDIGOS DE ESTADO:**

|Code|Description|
|----|-------|
|200 | Operación correcta |
|400 | Falta parámetro obligatorio o tipo de parámetro incorrecto |
|401 | Usuario no autorizado |
|403 | Credenciales no válidas |
|500 | Error interno|



**RESPUESTA:**


Recibirás una respuesta en formato JSON como esta::

```
{
    "_id": "63ca50f0c9557c7ac25f1715",
    "iduser": "63bbe586dd070b78fb495ed2",
    "name": "APP2",
    "strategy": "PRIORITY",
    "origindomain": null,
    "defaultfromemail": "user2@xxx.xxx",
    "defaultfromname": "Jonh Smith",
    "testemail": "user2@xxx.xxx",
    "timebetweenemails": 0,
    "useblacklist": true,
    "useautoblacklist": false,
    "webhook_sending_finished": null,
    "webhook_sending_error": null,
    "webhook_tracking_opened": null,
    "webhook_tracking_clicked": null,
    "webhook_blacklisted_added": null,
    "webhook_mailing_finished": null,
    "language": "EN",
    "created": "2023-01-20T08:29:36.763",
    "modified": "2023-01-20T08:29:36.763",
    "status": "A"
}
```



<!-- tab:Borrar una app -->

**PETICIÓN:** 


*POST* /private/apps/remove

|Parámetro|Descripción|Requerido| Valor por defecto|
|---------|-----------|--------|---------|
|idapp | App id | Sí |  |

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


**RESPUESTA:**

*vacía*

<!-- tabs:end -->

