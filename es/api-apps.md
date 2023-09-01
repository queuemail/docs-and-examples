Una vez accedes al <a target="_blank" href="https://queuemail.dev/qmadmin/login">panel de control</a> tienes la posibilidad de gestionar tus apps.

Necesitas crear al menos una app para usar QUEUEMAIL. 

Cada app puede corresponder a un proyecto o parte del proyecto con diferente comportamiento.

<div style="width:100%; text-align:center;">
    <img src="/list-apps.png" />
</div>

Para crear una app pulsarás el botón NEW APP y aparecerá la siguiente pantalla:

<div style="width:100%; text-align:center;">
    <img src="/new-app.png">
</div>

Como mínimo debes completar el nombre de tu APP. El resto de parámetros significa lo siguiente:

1. <b>Retain sensitive info</b>: Si se marca, la información sensitiva del email (asunto, cuerpo y url de adjuntos) serán conservados en la base de datos hasta que no se borren manualmente. En otro caso esta información no se guardará en la base de datos.

2. <b>Use blacklist</b>: Si se marca, los receptores de los emails podrán bloquear futuros envíos pulsando el enlace de baja.

3. <b>Use auto-blacklist</b>: Si se marca, el sistema puede bloquear envíos a receptores con problemas permanentes o repetitivos.

4. <b>Strategy</b>: Si la app usa la estrategia de prioridad (PRIORITY) o aleatoria (RANDOM) para seleccionar el servidor SMTP que se usará para el envío. Para la capa gratuita solo es posible RANDOM.

5. <b>Seconds between emails</b>: Este valor controla cuanto tiempo mínimo se espera entre el envío de emails para esta APP. Para la capa gratuita será siempre un mínimo de 60 segundos.

6. <b>Origin hosts/IPs</b>: Si se marca, solo puedes enviar emails desde los hosts/IPs especificados. Se pueden poner varios separados por comas.

7. <b>Test email address</b>: Dirección de correo de pruebas. Si no se especifica será la dirección de correo del usuario registrado.

8. <b>Default sender email address</b>: Dirección de correo del emisor del envío por defecto. Si al envíar un correo no se especifica dirección de correo del emisor (from) se usará esta dirección de correo. Si no se especifica será la dirección de correo del usuario registrado.

9. <b>Default sender name</b>: Nombre del emisor del envío por defecto. Si al envíar un correo no se especifica nombre de emisor (fromname) se usará este nombre. Si no se especifica será la dirección de correo del usuario registrado.

10. <b>Webhook URL for email is sent ok</b>: URL llamada cuando los emails son enviados correctamente. Esta URL recibe el parámetro qm_idsending con el id del email como valor.

11. <b>Webhook URL for email is not sent</b>: URL llamada cuando los emails fallan. Esta URL recibe el parámetro qm_idsending con el id del email como valor.

12. <b>Webhook URL for email opened</b>: URL llamada cuando el destinatario abre un email. Esta URL recibe el parámetro qm_idsending con el id del email como valor y el parámetro qm_email con la dirección de correo del destinatario que ha abierto el email como valor.

13. <b>Webhook URL for link clicked</b>: URL llamada cuando el destinatario hace click en un enlace del email recibido. Esta URL recibe el parámetro qm_idsending con el id del email como valor, el parámetro qm_email con la dirección de correo del destinatario que ha abierto el email como valor y el parámetro qm_url con la URL del enlace accedido como valor.

14. <b>Webhook URL for recipient added to blacklist</b>: URL llamada cuando el destinatario se añade a la blacklist. Esta URL recibe el parámetro qm_idsending con el id del email como valor y el parámetro qm_email con la dirección de correo del destinatario que se añade la blacklist como valor.


Una vez completado los datos de la app pulsaremos SAVE y en nuestro listado aparecerá la app creada con el valor de API ID que debemos usar para las llamadas a la API:

<div style="width:100%; text-align:center;">
    <img src="/list-apps-2.png" />
</div>    
