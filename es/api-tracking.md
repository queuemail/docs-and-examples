
Usando esta llamada puedes gestionar el tracking de envíos: Emails abiertos y clics hechos en los enlaces del email.

<!-- tabs:start -->


<!-- tab:Obtener información de tracking por email -->


**REQUEST:** 

*GET* /private/tracking/findByEMail

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
|500 | Error interno|


Recibirás una respuesta en formato JSON como esta::

```
[
    {
        "_id": "6475cd84fc67f96b4d0cd808",
        "idsending": "6475ccb2fc67f96b4d0cd803",
        "idemailing": null,
        "email": "xxxx@gmail.com",
        "type": "OPEN",
        "url": null,
        "created": "2023-05-30T10:18:44.385",
        "ip": "xx.xx.xx.xx"
    },
    {
        "_id": "6475cd84fc67f96b4d0cd809",
        "idsending": "6475ccb2fc67f96b4d0cd803",
        "idemailing": null,
        "email": "xxxx@gmail.com",
        "type": "CLICK",
        "url": "https://google.com",
        "created": "2023-05-30T10:18:44.558",
        "ip": "xx.xx.xx.xx"
    }
]
```

- La respuesta está compuesta de una lista con todas las operaciones de trackong asociadas al email enviado (**idsending**)
- **email** es el destinatario asociado con esta información de tracking (quién abrió el email o quién hizo clic en un enlace)
- **type** OPEN para tracking de emails abiertos, CLICK para tracking de enlaces en los que se ha hecho clic.
- **created** es la fecha/hora de la aplicación.
- **idapp** id de la app usada. Solo aparece en algunas operaciones donde tiene sentido.
- **ip** IP origen desde la cual el destinatario abrió el email o hizo click en el enlace.
- **url** URL del enlace donde ha hecho clic. 


<!-- tabs:end -->

