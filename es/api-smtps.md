Una vez accedes al <a target="_blank" href="https://queuemail.dev/qmadmin/login">panel de control</a> tienes la posibilidad de gestionar tus servidores SMTP.

Debes definir al menos un servidor SMTP asociado a tu app para poder usar QUEUEMAIL de forma gratuita. 

Si usas la opción profesional (no gratuita) de QUEUEMAIL no es necesario que definas ningún servidor SMTP ya que para tus envíos se usarán los servidores profesionales de QUEUEMAIL.

Si no dispones de un servidor SMTP propio puedes [conseguir un servidor SMTP gratis aquí](other-freesmtps.md).

<div style="width:100%; text-align:center;">
    <img src="/list-smtps.png" />
</div>

Para crear un servidor SMTP pulsarás el botón NEW SMTP SERVER y aparecerá la siguiente pantalla:

<div style="width:100%; text-align:center;">
    <img src="/new-smtp.png">
</div>

Debes establecer como mínimo la app a la que está asociada el servidor SMTP que estás creando, el host (o IP) del servidor SMTP y el puerto usado por el servidor SMTP. El resto de parámetros significa lo siguiente:

1. <b>Use authentication</b>: Si el servidor necesita autentificarse mediante usuario y contraseña para enviar.

2. <b>Use STARTTLS</b>: Si el servidor usa <a href="https://es.wikipedia.org/wiki/STARTTLS">STARTTLS</a>.

3. <b>Use SSLTLS</b>: Si el servidor usa <a href="https://es.wikipedia.org/wiki/Seguridad_de_la_capa_de_transporte">SSLTLS</a>.

4. <b>Priority</b>: Usado para seleccionar el servidor SMTP a utilizar en el envío cuando la app utiliza la estrategia PRIORITY (a menor valor, mayor prioridad).

5. <b>User name</b>: Nombre de usuario utilizado para la autentificación en el servidor.

6. <b>Password</b>: Contraseña utilizada para la autentificación en el servidor.

7. <b>Default sender email address</b>: Si se marca, la dirección de correo del remitente es reemplazada siempre por este valor cuando se usa este servidor SMTP.

8. <b>Default sender name</b>: Si se marca, el nombre del remitente es reemplazado siempre por este valor cuando se usa este servidor SMTP.

Una vez completado los datos del servidor SMTP pulsaremos CHECK AND SAVE y se comprobará si el servidor SMTP funciona correctamente enviando un correo a la dirección de correo de test de la app asociada. Si funciona aparecerá en el listado como habilitado (círculo verde). En otro caso aparecerá como deshabilitado (círculo rojo) y hasta que no lo editemos y grabemos con datos correctos permanecerá deshabilitado. 

En cualquier caso en nuestro listado aparecerá el servidor SMTP creado con el valor de API ID que debemos usar para las llamadas a la API:

<div style="width:100%; text-align:center;">
    <img src="/list-smtps-2.png" />
</div>

