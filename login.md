# Login

Use your username and password to get a bearer token you will use in all API operations.

**REQUEST:** 

*POST* /auth/login

|Parameter|Description|Required|
|---------|-----------|--------|
|username | Your user name | Yes |
|password | Your password  | Yes |

**STATUS CODES:**

|Code|Description|
|----|-------|
|200 | Login ok |
|400 | Missing required parameter or wrong parameter type |
|403 | User/password not valid |
|500 | Internal error|

**OK RESPONSE:**

If login ok, you will get a JSON response like this:

```
{
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2M2JiZTU4NmRkMDcwYjc4ZmI0OTVlZDIiLCJzdWIiOiJ1c2VyMSIsImF1ZCI6InVzZXIiLCJpc3MiOiJDSS0xNTFhY2U2OS1kZTkyLTQwYjQtYmY5NC04OGRmZWIzNTc1ZjQiLCJpYXQiOjE2ODQ3NDg0MTUsImV4cCI6MTY4NDgzNDgxNX0.CcNyo8Ug45dNLNZ0Q41wpPObrFI-hagaJdat3ryxqdo",
    "role": "user",
    "userId": "63bbe586dd070b78fb495ed2",
    "username": "username",
    "clientId": "CI-151ace69-de92-40b4-bf94-88dfeb3575f4"
}
```

Now, you can use the value of **token** field in header *Authorization* in all API operations as a bearer token:

```
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2M2JiZTU4NmRkMDcwYjc4ZmI0OTVlZDIiLCJzdWIiOiJ1c2VyMSIsImF1ZCI6InVzZXIiLCJpc3MiOiJDSS0xNTFhY2U2OS1kZTkyLTQwYjQtYmY5NC04OGRmZWIzNTc1ZjQiLCJpYXQiOjE2ODQ3NDg0MTUsImV4cCI6MTY4NDgzNDgxNX0.CcNyo8Ug45dNLNZ0Q41wpPObrFI-hagaJdat3ryxqdo
```


