
Usa tu nombre de usuario y contraseña para obtener un bearer token que usarás en todas las operaciones de la API.

Use your username and password to get a bearer token you will use in all API operations.

**PETICIÓN:** 

*POST* /auth/login

|Parameter|Description|Required|
|---------|-----------|--------|
|username | Nombre de usuario | Sí |
|password | Contraseña  | Sí |

**CÓDIGOS DE ESTADO:**

|Code|Description|
|----|-------|
|200 | Login correcto |
|400 | Falta parámetro obligatorio o tipo de parámetro incorrecto |
|403 | Usuario/contraseña no válido |
|500 | Error interno|

**OK RESPONSE:**

Si el login es correcto, recibirás una respuesta en formato JSON como esta::

```
{
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2M2JiZTU4NmRkMDcwYjc4ZmI0OTVlZDIiLCJzdWIiOiJ1c2VyMSIsImF1ZCI6InVzZXIiLCJpc3MiOiJDSS0xNTFhY2U2OS1kZTkyLTQwYjQtYmY5NC04OGRmZWIzNTc1ZjQiLCJpYXQiOjE2ODQ3NDg0MTUsImV4cCI6MTY4NDgzNDgxNX0.CcNyo8Ug45dNLNZ0Q41wpPObrFI-hagaJdat3ryxqdo",
    "role": "user",
    "userId": "63bbe586dd070b78fb495ed2",
    "username": "username",
    "clientId": "CI-151ace69-de92-40b4-bf94-88dfeb3575f4"
}
```

Ahora puedes usar el valor del campo **token** en la cabecera *Authorization* como bearer token en todas las operaciones de la API:

```
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2M2JiZTU4NmRkMDcwYjc4ZmI0OTVlZDIiLCJzdWIiOiJ1c2VyMSIsImF1ZCI6InVzZXIiLCJpc3MiOiJDSS0xNTFhY2U2OS1kZTkyLTQwYjQtYmY5NC04OGRmZWIzNTc1ZjQiLCJpYXQiOjE2ODQ3NDg0MTUsImV4cCI6MTY4NDgzNDgxNX0.CcNyo8Ug45dNLNZ0Q41wpPObrFI-hagaJdat3ryxqdo
```


