

Usa estas llamadas para manejar las blacklist.

<!-- tabs:start -->


<!-- tab:Añadir email a la blacklist -->


**PETICIÓN:** 

*POST* /private/blacklist/add

|Parámetro|Descripción|Requerido| Valor por defecto|
|---------|-----------|--------|---------|
|idapp | App id | Sí |  |
|email | Email a añadir a la blacklist | Sí |  |

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



Recibirás una respuesta en formato JSON como esta::

```
{
    "_id": "6474908d7ff70117d6a938dc",
    "idapp": "647095de67e43f0f33a3a089",
    "idsending": null,
    "email": "kk@kk.com",
    "ip": "xx.xx.xx.xx",
    "created": "2023-05-29T11:46:21.685157634"
}
```

- **idsending** id del email enviado en el caso de que se haya añadido a través de un email recibido.
- **ip** ip origen desde donde se ha realizado la inclusión del email en la blacklist.
- **created** cuando ha sido realizada la inclusión del email en la blacklist.

<!-- tab:Información de Blacklist  -->

Obtener información blacklist y auto-blacklist por app.

**PETICIÓN:** 

*GET* /private/blacklist/findByApp

|Parámetro|Descripción|Requerido| Valor por defecto|
|---------|-----------|--------|---------|
|idapp | App id | Sí |  |
|page | Número de página | Sí |  |
|size | Tamaño de página | Sí |  |

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
    "blacklisted": {
        "content": [
            {
                "_id": "6474908d7ff70117d6a938dc",
                "idapp": "647095de67e43f0f33a3a089",
                "idsending": null,
                "email": "kk@kk.com",
                "ip": "xx.xx.xx.xx",
                "created": "2023-05-29T11:46:21.685"
            }
        ],
        "pageable": {
            "sort": {
                "empty": true,
                "sorted": false,
                "unsorted": true
            },
            "offset": 0,
            "pageNumber": 0,
            "pageSize": 10,
            "paged": true,
            "unpaged": false
        },
        "last": true,
        "totalPages": 1,
        "totalElements": 1,
        "size": 10,
        "number": 0,
        "sort": {
            "empty": true,
            "sorted": false,
            "unsorted": true
        },
        "first": true,
        "numberOfElements": 1,
        "empty": false
    },
    "autoblacklisted": {
        "content": [],
        "pageable": {
            "sort": {
                "empty": true,
                "sorted": false,
                "unsorted": true
            },
            "offset": 0,
            "pageNumber": 0,
            "pageSize": 10,
            "paged": true,
            "unpaged": false
        },
        "last": true,
        "totalPages": 0,
        "totalElements": 0,
        "size": 10,
        "number": 0,
        "sort": {
            "empty": true,
            "sorted": false,
            "unsorted": true
        },
        "first": true,
        "numberOfElements": 0,
        "empty": true
    }
}
```



<!-- tab:Comprobar si un email está en la blacklist -->




**PETICIÓN:** 

*GET* /private/blacklist/isBlackListed

|Parámetro|Descripción|Requerido| Valor por defecto|
|---------|-----------|--------|---------|
|idapp | App id | Sí |  |
|email | Email a comprobar | Sí |  |

**CÓDIGOS DE ESTADO:**

|Code|Description|
|----|-------|
|200 | Operación correcta |
|400 | Falta parámetro obligatorio o tipo de parámetro incorrecto |
|401 | Usuario no autorizado |
|403 | Credenciales no válidas |
|500 | Error interno|





**RESPUESTA:**

*true* o *false*  (en formato texto, no JSON)





<!-- tab:Eliminar un email de la blacklist -->



**PETICIÓN:** 


*POST* /private/blacklist/remove

|Parámetro|Descripción|Requerido| Valor por defecto|
|---------|-----------|--------|---------|
|idapp | App id | Sí |  |
|email | Email a eliminar | Sí |  |

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
2. Email añadido por un destinatario. No se puede borrar.



**RESPUESTA:**

*vacía*

<!-- tabs:end -->

