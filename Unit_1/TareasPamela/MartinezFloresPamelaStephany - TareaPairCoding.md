
## PAIR CODING

El **“Pair coding”**, o también conocido como _pair programming_, consiste en dos programadores que comparten una sola estación de trabajo (una pantalla, teclado y ratón entre el par).

El programador en el teclado se llama generalmente el conductor **(driver)**, el otro, también participa activamente en la tarea de programación, pero centrarse más en la dirección general es el navegador **(navigator)** ; se espera que los programadores intercambien roles cada pocos minutos más o menos.

### **Roles**

Estas definiciones de roles de programación de pares clásicos se pueden aplicar de una u otra manera a muchos de los enfoques 
para el emparejamiento(pairing). 

El conductor es la persona al volante, es decir, el teclado. Se centra en completar la pequeña meta en cuestión e ignorando 
problemas más grandes. Un conductor siempre debe hablar a través de lo que está haciendo mientras lo hace.

El navegador está en la posición de observador, mientras el conductor está escribiendo. Se encarga de revisar el código 
sobre la marcha, da instrucciones y comparte pensamientos. El navegador también tiene el enfoque en los problemas más 
grandes, errores, y toma notas de posibles pasos u obstáculos.

La idea de esta división de roles es tener dos perspectivas diferentes sobre el código. Se supone que el pensamiento del 
conductor es más táctico, pensando en los detalles, las líneas de código a mano. El navegador puede pensar más estratégicamente 
en su papel de observación. Tienen el panorama general en mente.

Un flujo común dice así:
* Comience con una tarea razonablemente bien definida.
* Acordar una pequeña meta a la vez. Esto se puede definir mediante una prueba, o por un mensaje de confirmación, 
  o escrito en una nota adhesiva.
* Cambie el teclado y los roles con regularidad. La participación activa compartida mantiene el nivel de energía, de 
  esta manera se aprende  y se entiende mejor las cosas.
* Como navegador, evitar el modo de pensamiento "táctico", dejar los detalles de la codificación al conductor, es decir, 
  su trabajo es dar un paso atrás y complementar el modo más táctico de su pareja con el pensamiento a medio plazo. Tomar 
  en cuenta  los próximos pasos, anotar los obstáculos potenciales e ideas para discutirlos después de que se hace el pequeño 
  objetivo, con el fin de no interrumpir el flujo del conductor.

### **Técnicas**
##### ___“Ping Pong”___
Esta técnica adopta el desarrollo controlado por pruebas (TDD - Test-Driven Development). Se recomienda aplicarla 
cuando se tiene una tarea claramente definida que puede ser implementada de una manera. 

* "Ping": El desarrollador A escribe una prueba fallida.
* "Pong": El desarrollador B escribe la implementación para que pase.

A continuación, el desarrollador B inicia el siguiente "Ping", es decir, la siguiente prueba de error.

Cada "Pong" también se puede seguir refactorizando el código en conjunto, antes de pasar 
a la siguiente prueba con errores. De esta manera se sigue el enfoque "Rojo - Verde - 
Refactor": Escriba una prueba fallida (rojo), hacerlo pasar con los medios mínimos 
necesarios (verde) y luego refactorizar.

##### ___“Emparejamiento de estilo fuerte (Strong-Style Pairing)”___

Esta es una técnica particularmente útil para la transferencia de conocimientos, descrita por Llewellyn Falco.

La regla es: "Para llevar una idea de la cabeza a la computadora DEBE pasar por las manos de otra persona". 
En este estilo, el _navegador_ suele ser la persona mucho más experimentada con la configuración o tarea en 
cuestión, mientras que el _conductor_ es un principiante (con el idioma, la herramienta, el código base, ...). 
La persona experimentada se queda principalmente en el rol de navegante y guía al principiante.


## CONCLUSIÓN

El pair coding es una manera de programar en conjunto, exactamente dos personas. Una persona estará al mando de 
la computadora, es decir, manipulación de teclado, mouse y software. Se le conoce como driver porque conduce la 
programación de una meta propuesta. El tendrá que estar explicando lo que programa a la vez para que el otro 
compañero entienda que se está realizando.

La otra persona conocida como navegador es quien lleva la dirección del trabajo, por ejemplo: un director de una 
película, quien dirige las acciones, ideas y ejecuciones a realizar en el proyecto, sin embargo, el navegador es 
abierto a tener en cuenta la perspectivas distintas y opiniones de su compañero.

Al pair coding le observa una ventaja como dice el dicho: “Dos cabezas piensan mejor que una”, pero porque? 
Porque una sola mente al tratar de encontrar una solución, esta tiene ideas y conocimientos propios a otra persona.
Entonces cuando cometemos errores muchas ocasiones no podemos ver donde nos hemos equivocado. Y esta buena práctica 
nos ayuda mucho a visualizar este tipo de situaciones.
También trabajar en conjunto es muy viable para encontrar distintas soluciones, por la existencia de diferentes ideas, 
observaciones o formas de ver las cosas.

Básicamente este estilo de programación tiene el objetivo de tomar un enfoque en cumplir la meta con ayuda de dos mentes 
para encontrar soluciones, trabajando de manera eficiente ya que alguien conduce la programación y cumple metas a corto 
plazo y el navegador dirige la programación con sus ideas pero ampliando los posibles retos o escenarios que se encuentren 
a futuro en el desarrollo del proyecto.

