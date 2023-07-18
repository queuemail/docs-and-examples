
Puedes definir uno o más servidores SMTP asociados a una app.

Si no tienes ningún servidor SMTP propio puedes [conseguir un servidor SMTP gratis aquí](other-freesmtps.md).

<!-- tabs:start -->

<!-- tab:Crear/editar un SMTP -->


**PETICIÓN:** 

*POST* /private/smtps/save

|Parámetro|Descripción|Requerido| Valor por defecto|
|---------|-----------|--------|---------|
|idsmtp | SMTP id | Si para edición, No para creación |  |
|idapp | App id | Sí |  |
|priority | Prioridad (0=más alta)  | No | 10 |
|port | Puerto SMTP  | Sí  |  |
|username | Nombre de usuario SMTP  | Sí  |
|password | Contraseña SMTP | Sí |  |
|auth | Si el SMTP usa autentificación (true) o no (false) | false |  |
|starttls | Si el SMTP usa STARTTLS (true) o no (false)  | false |  |
|ssltls | Si el SMTP usa SSL/TLS (true) o no (false)  | false |  |
|defaulfromemail | Dirección de origen por defecto si no se permite enviar con el dominio especificado en la dirección de origen | No |  |
|defaultfromname | Nombre de origen por defecto si no se permite enviar con el dominio especificado en la dirección de origen  | No |  |

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

1. SMTP no encontrado
2. App no encontrada



**RESPUESTA:**

Recibirás una respuesta en formato JSON como esta::

```
{
    "_id": "6474690367e43f0f33a3a08a",
    "idapp": "63ca4eba50b39905400fc201",
    "priority": 50,
    "host": "smtp.yourserver.net",
    "port": 25,
    "username": "user@yourserver.net",
    "password": "smtppassword1234",
    "auth": true,
    "starttls": true,
    "sslTls": false,
    "debug": false,
    "defaultfromemail": "info@yourserver.xyz",
    "defaultfromname": "Jonh Smith",
    "numerrors": 0,
    "created": "2023-05-29T08:57:39.129027959",
    "modified": "2023-05-29T08:57:39.129027959",
    "status": "A"
}
```

<!-- tab:Listar todos los SMTP de una app -->



**PETICIÓN:** 

*GET* /private/smtps/findByApp

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
[
    {
        "_id": "63eb5c67db7fa34c44d64783",
        "idapp": "63ca4eba50b39905400fc201",
        "priority": 50,
        "host": "smtp.yourserver.net",
        "port": 587,
        "username": "user1",
        "password": "Yourpass1234",
        "auth": true,
        "starttls": true,
        "sslTls": false,
        "debug": false,
        "defaultfromemail": "info@yourserver.xyz",
        "defaultfromname": "Jonh Smith",
        "numerrors": 0,
        "created": "2023-02-14T10:03:19.308",
        "modified": "2023-02-14T10:03:19.308",
        "status": "A"
    },
    {
        "_id": "6474690367e43f0f33a3a08a",
        "idapp": "63ca4eba50b39905400fc201",
        "priority": 150,
        "host": "smtp.anothersmtp.net",
        "port": 25,
        "username": "user2",
        "password": "YourPASS1234",
        "auth": true,
        "starttls": true,
        "sslTls": false,
        "debug": false,
        "defaultfromemail": "info@anothersmtp.xyz",
        "defaultfromname": "Jonh Smith",
        "numerrors": 0,
        "created": "2023-05-29T08:57:39.129",
        "modified": "2023-05-29T08:57:39.129",
        "status": "A"
    }
]
```




<!-- tab:Encontrar un SMTP por id -->




**PETICIÓN:** 

*GET* /private/smtps/findById

|Parámetro|Descripción|Requerido| Valor por defecto|
|---------|-----------|--------|---------|
|idsmtp | SMTP id | Sí |  |

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
    "_id": "6474690367e43f0f33a3a08a",
    "idapp": "63ca4eba50b39905400fc201",
    "priority": 150,
    "host": "smtp.anothersmtp.net",
    "port": 25,
    "username": "user2",
    "password": "YourPASS1234",
    "auth": true,
    "starttls": true,
    "sslTls": false,
    "debug": false,
    "defaultfromemail": "info@anothersmtp.xyz",
    "defaultfromname": "Jonh Smith",
    "numerrors": 0,
    "created": "2023-05-29T08:57:39.129",
    "modified": "2023-05-29T08:57:39.129",
    "status": "A"
}
```



<!-- tab:Delete a SMTP -->

**PETICIÓN:** 


*POST* /private/smtps/remove

|Parámetro|Descripción|Requerido| Valor por defecto|
|---------|-----------|--------|---------|
|idapp | SMTP id | Sí |  |

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

1. SMTP no encontrado


**RESPUESTA:**

*empty*


<!-- tab:Comprobar un SMTP -->

Envía un email a la dirección de prueba de la app para comprobar que la configuración del servidor SMTP es correcta.

Si recibes un status 200 el servidor SMTP está funcionando correctamnte. Si estaba deshabilitado se habilitará en este momento.

si recibes un status 406 el servidor SMTP tiene una configuración errónea. Si estaba habilitado se deshabilitará en este momento.

**PETICIÓN:** 


*POST* /private/smtps/check

|Parámetro|Descripción|Requerido| Valor por defecto|
|---------|-----------|--------|---------|
|idapp | SMTP id | Sí |  |

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

1. SMTP no encontrado
2. App no encontrada

... otros errores relacionados con el funcionamiento del SMTP.


**RESPUESTA:**

*vacía*

<!-- tabs:end -->

