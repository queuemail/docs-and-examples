La característica de Webhooks permite configurar tus propias URLS para que ejecuten procesos en tu sistema una vez ocurre un evento en queuemail.dev.

Existen los siguientes eventos para webhooks:

- *sending_finished*: Se llama la URL especificada con el parámetro *qm_idsending* (id del email enviado) cuando el email es enviado con éxito.
- *sending_error*: Se llama la URL especificada con el parámetro *qm_idsending* (id del email enviado) cuando el envío del email falla.
- *tracking_opened*: Se llama la URL especificada con el parámetros *qm_idsending* (id del email enviado) y *qm_email* (dirección de email del destinatario) cuando el email es abierto por el destinatario.
- *tracking_clicked*: Se llama la URL especificada con el parámetros *qm_idsending* (id del email enviado), *qm_email* (dirección de email del destinatario) y *qm_url* (url en la que se hace click) cuando el destinatario hace click en la url *qm_url*.
- *blacklisted_added*: Se llama la URL especificada con el parámetros *qm_idsending* (id del email enviado) y *qm_email* (dirección de email a incluir en blacklist) cuando esa dirección de email se va a incluir blacklist.

Puedes configurar las URLs de webhook cuando [creas/editas tu app](api-apps.md).






