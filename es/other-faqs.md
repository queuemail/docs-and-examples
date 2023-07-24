

### ¿Qué sucede si hay cortes de red o caída del servidor mientras se usa la la API de QUEUEMAIL.DEV?

La solución es implementar una cola local para almacenar los emails que fallan cuando QUEUEMAIL no responde.

El ejemplo [Hardy client](examples-hardyservice.md) muestra como implementar esta cola local.


### ¿Cuántas peticiones por minuto puedo hacer a la API?

Los servidores de QUEUEMAIL.DEV implementan proteccion contra ataques de fuerza bruta o DDoS por lo que es buena idea espaciar tus peticiones a la API en al menos 1 segundo. No pasa nada si haces más peticiones en 1 segundo, el sistema de protección evalúa otros parámetros para saber si se trata de un ataque o un uso lícito de la API pero en cualquier caso te recomendamos que siempre implemente un [envío robusto con cola local](examples-hardyservice.md) para que si en un momento dado tu IP de origen es baneada temporalmente, la cola local se encargue de repetir los envíos de emails.



### ¿Puedo enviar emails usando direcciones de mi propio dominio?


* Con la capa gratuita: 

    - Puedes usar un servidor SMTP de tu propio dominio y podrás enviar sin problema usando direcciones de ese dominio.

    O bien...

    - Algunos servidores SMTP como Gmail/Google permiten enviar email usando tu dirección de correo. Sigue las instrucciones para cada servidor SMTP para poder enviar emails con tu propio dominio.


* Con los servidores SMTP profesionales de Queuemail: Te enviaremos instrucciones para hacer los cambios correspondientes en las zonas DNS de tu dominio paa que así puedas enviar con direcciones de tu dominio usando nuestros servidores profesionales.

