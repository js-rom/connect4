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
| graphics | [v.1.9 modelViewPresenter - presentationModel - withDoubleDispatching](https://github.com/js-rom/connect4/tree/v1.9.0-Release)  |
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

# Versión v.1.10

## enfoque

En esta versión se añade la funcionalidad de deshacer y rehacer movimientos, disponible tanto para jugadores humanos como para jugadores máquina, y accesible desde ambas interfaces: consola y gráfica.

## Diseño

La nueva funcionalidad de deshacer y rehacer movimientos se ha implementado utilizando el patrón de diseño Memento.

**Cambios en el paquete `connect4.models`:**

- Se introduce la clase `Registry`, responsable de gestionar una lista de objetos `Memento` generados por `Game`. Esta clase almacena los diferentes estados por los que pasa el juego y permite restaurar el estado del juego a cualquier punto anterior o posterior.
- Se crea la fachada `Session`, que centraliza la gestión del estado en memoria de la aplicación mediante una interfaz común. Esta fachada agrupa y delega responsabilidades en las clases `Game`, `Registry` y `State`.

**Cambios en el paquete `connect4.controllers`:**

- Se incorporan nuevos controladores para gestionar la funcionalidad de deshacer y rehacer. Se diferencian entre controladores principales, que implementan la interfaz `AcceptorController` y pueden actuar como fachada de controladores secundarios, agrupando así diferentes casos de uso bajo una una misma interfaz.