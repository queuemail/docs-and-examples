Puedes mejorar la toleranzia a fallos de tu app si defines más de un servidor SMTP.

Si un servidor SMTP falla en el envío, entonces la app intentará con otro distinto.

Cuando [creamos/editamos una app](api-apps.md), podemos elegir entre estrategia RANDOM y PRIORITY para la selección de qué SMTP se usará.

Si no especifícas el parámetro *strategy*, se usará la estrategia RANDOM por defecto.

Si especificas *strategy=PRIORITY* entonces, al enviar email, se usará primero el servidor SMTP con prioridad más alta (menor número). En caso de error se usará el siguiente SMTP con prioridad más alta y así sucesivamente.

Puedes definir la prioridad para cada servidor SMTP al [crear/editar los servidores SMTP](api-smtps.md).

Con *strategy=RANDOM* también otros servidores son usados en caso de fallar uno previo pero, en este caso, se selecciona de forma aleatoria cuál va a ser el siguiente a ser usado.











