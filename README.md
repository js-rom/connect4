## Diferentes versiones del juego Connect 4

| Requistios  | Versión |
|:------------- |:-------------|
| basic  | domainModel - basic|
| machine | domainModel - machine |
| basic | documentView - basic |
| machine | [v.1.0 documentView - machine - doubleDispatching](https://github.com/js-rom/connect4/tree/v.1.0) |
| machine | [v.1.1 documentView - machine - Menu](https://github.com/js-rom/connect4/tree/v.1.1) |
| machine | [v.1.2 documentView - machine - IA Player Open Close](https://github.com/js-rom/connect4/tree/v.1.2) |
| machine | [v.1.3 documentView - machine - prototype](https://github.com/js-rom/connect4/tree/v.1.3) |
| graphics | [v.1.4 documentView - withoutFactoryMethod](https://github.com/js-rom/connect4/tree/v.1.4) |
| graphics | [v.1.5 documentView - withFactoryMethod](https://github.com/js-rom/connect4/tree/v.1.5) |
| graphics | [v.1.6 modelViewPresenter - presentationModel - basic](https://github.com/js-rom/connect4/tree/v.1.6) |
| graphics | [v.1.7 modelViewPresenter - presentationModel - withFacade](https://github.com/js-rom/connect4/tree/v1.7.0-Release) |
| graphics | [v.1.8 modelViewPresenter - presentationModel - withoutDoubleDispatching](https://github.com/js-rom/connect4/tree/v1.8.0-Release) |
| graphics | modelViewPresenter - presentationModel - withDoubleDispatching |
| undoRedo | modelViewPresenter - presentationModel - withComposite |
| distributed | modelViewPresenter - presentationModel - withoutProxy |
| distributed | modelViewPresenter - presentationModel - withProxy |
| files | modelViewPresenter - presentationModel - withoutDAO |
| files | modelViewPresenter - presentationModel - withDAO |
| bbdd | modelViewPresenter - presentationModel - withoutPrototype |
| bbdd | modelViewPresenter - presentationModel - withPrototype |
| basic | modelViewPresenter - passiveView |
| basic | modelViewPresenter - supervisorController |
| basic | modelViewController |

![secuencia de versiones](./out/connect4/Docs/diagrams/TicTacToe.svg)

# Versión v.1.8

## Problemas de diseño de la versión v.1.8

- Violación del Principio de Sustitución de Barbara Liskov.
En connect4.ConsoleConnect4 y connect4.GraphicsConnect4 estamos preguntado por el tipo de un objeto polimórfico en una **estructura de control de flujo de ejecución** para en función del tipo hacer una cosa u otra.

```java

if (logic.getController() instanceof StartController) {
    graphicsView.start((StartController) logic.getController());
} else {
    if (logic.getController() instanceof PlayController) {
        graphicsView.play((PlayController) logic.getController());
    } else {
        graphicsView.resume((ResumeController) logic.getController());
    }
}

```

>Lo que se quiere aquí es algo como la siguiente propiedad de sustitución: si para cada objeto oT de un tipo T, hay un objeto oS de tipo S tal que para todo progama P definido en términos de T, el comportamiento de P no cambia cuando oT es sustituido por oS, entonces S es un subtipo de T
— Barbara Liskov
A behavioral notion of subtyping. ACM Transactions on Programming Languages and Systems (TOPLAS). Volume 16. Issue 6 (November 1994). pp. 1811. 1841

- incurre en cambios divergentes para atender con una nueva rama en cada clase cliente que hay que localizar por toda la aplicación

- rompe el principio Open/Close con cambios en el interior de los métodos del cliente

## Soluciones de diseño a la versión v.1.7

- ~~Vistas con DRY en la lógica de control.~~
El control de flujo de ejecución del juego es gestionado ahora por lo controladores. El bucle sigue estando en la vista, pero la responsabilidad de cómo cambiar el estado de juego está implementada en los controladores. Las vistas simplemente quedan a la espera de qué controlador va a llegar y actuarán en consecuencia.

- ~~Clase Logic no adecuada por número de parámetros y creación de controladores.~~
Pasamos de tener potencialemnte 240 atributos en una clase a tener un solo Map.


## Problemas de diseño de la versión v.1.7

- Vistas con DRY en la lógica de control.
- Clase Logic no adecuada por número de parámetros y creación de controladores.
