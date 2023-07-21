# QUEUEMAIL.DEV - API confiable para envío de emails. Capa gratuita. Envía de forma asíncrona

Página principa de documentación aquí --> [https://docs.queuemail.dev/](https://docs.queuemail.dev/es/)

QUEUEMAIL.DEV te permite enviar emails, vía API, usando uno o más servidores SMTP para incrementar la capacidad de entrega y evitar errores de sobreuso y estrés en los servidores SMTP.

Algunos ejemplos de características que ofrece:

- Puedes programar envío de emails de forma síncrona o asíncrona: Con el [endpoint para consulta de logs](api-logs.md) puedes comprobar el estado de envío para cada email enviado.

- También, con [los webhooks](features-webhooks.md), puedes ejectuar procesos en tu sistema o sistemas de terceros cuando un evento (como por ejemplo, un envío con éxisto) ocurra para así tener una integración completa.

- Con [endpoint para envío de emails](api-emails.md) puedes descartar errores de envío antes de forzar el comienzo de una sesión SMTP.

- Puedes hacer tracking de emails abiertos y enlaces donde se ha hecho click con [endpoint de tracking](api-tracking.md).

- ...y mucho más en la [documentación](https://docs.queuemail.dev/es).

La capa gratuita no incluye el uso de los servidores SMTP profesionales de Queuemail. Por tanto, para usar esta capa gratuita, puedes configurar [servidores SMTP grauitos](other-freesmtps.md) o bien usar tu propio servidor SMTP.



### CLIENTES:

* [queuemail-client: Cliente básico en Java para usar la API de QUEUEMAIL.DEV](https://github.com/queuemail/docs-and-examples/tree/main/queuemail-client).

### EJEMPLOS:

* [Hardy Client: Un cliente en Java robusto para usar QUEUEMAIL.DEV API](examples-hardyservice.md).


### REGISTRO DE CAMBIOS:

* **2023-07-18**: Se añade el parámetro **sendate** a la llamada para [enviar emails](api-emails.md) que permite programar envíos en el futuro.

* **2023-07-21**: Añadido el ejemplo: [Hardy Client: Un cliente en Java robusto para usar QUEUEMAIL.DEV API](examples-hardyservice.md).
