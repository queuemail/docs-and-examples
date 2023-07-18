
Usando esta llamada puedes obtener toda la información de logs y actividad del email.



<!-- tabs:start -->


<!-- tab:Obtener logs por email -->


**PETICIÓN:** 

*GET* /private/logs/findByEMail

|Parámetro|Descripción|Requerido| Valor por defecto|
|---------|-----------|--------|---------|
|idemail | Email id | Sí |  |

**CÓDIGOS DE ESTADO:**

|Code|Description|
|----|-------|
|200 | Operación correcta |
|400 | Falta parámetro obligatorio o tipo de parámetro incorrecto |
|401 | Usuario no autorizadodo |
|403 | Credenciales no válidas |
|500 | Error interno|




Recibirás una respuesta en formato JSON como esta::

```
[
    {
        "_id": "63eb5f944986cc0ed366fc5b",
        "idsending": "63eb5f324986cc0ed366fc5a",
        "idsmtp": "63eb5c67db7fa34c44d64783",
        "idapp": null,
        "to": "xxxxx@gmail.com",
        "resultcode": "OK",
        "created": "2023-02-14T10:16:52.128"
    },
    {
        "_id": "63eb5f994986cc0ed366fc5c",
        "idsending": "63eb5f324986cc0ed366fc5a",
        "idsmtp": "63eb5c67db7fa34c44d64783",
        "idapp": null,
        "to": "xxxxx@outlook.com",
        "resultcode": "OK",
        "created": "2023-02-14T10:16:57.98"
    }
]
```

- La respuesta está compuesta por una lista con todas las operaciones asociadas al email (**idsending**)
- **idsmtp** id del servidor SMTP usado para el envío.
- **resultcode** puede ser "OK" para envío correcto, "BLACKLISTED" si el destinatario está incluido en la blacklsit. "AUTOBLACKLISTED" está incluido en la auto-blacklist. También puede ser un error específico (ATTACHMENT_PROBLEM, SMTP_CONNECT_FAILS, SMTP_CONNECT_TIMEOUT, etc.)
- **created** fecha/hora de la operación.
- **idapp** id de la app (solo tiene valor en ciertas operaciones)
- **to** destinatario relacionado con la operación.


<!-- tabs:end -->

