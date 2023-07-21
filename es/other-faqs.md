

### ¿Qué sucede si hay cortes de red o caída del servidor mientras se usa la la API de QUEUEMAIL.DEV?

La solución es implementar una cola loca para almacenar los emails que fallan cuando QUEUEMAIL no responde.

El ejemplo [Hardy client](examples-hardyservice.md) muestra como implementar esta cola local.


### Puedo enviar emails usando direcciones de mi propio dominio?


* Con la capa gratuita: 

    - Puedes usar un servidor SMTP de tu propio dominio y podrás enviar sin problema usando direcciones de ese dominio.

    O bien...

    - Algunos servidores SMTP como Gmail/Google permiten enviar email usando tu dirección de correo. Sigue las instrucciones para cada servidor SMTP para poder enviar emails con tu propio dominio.


* Con los servidores SMTP profesionales de Queuemail: Te enviaremos instrucciones para hacer los cambios correspondientes en las zonas DNS de tu dominio paa que así puedas enviar con direcciones de tu dominio usando nuestros servidores profesionales.

