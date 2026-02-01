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
| undoRedo | [v.1.10 modelViewPresenter - presentationModel - withComposite](https://github.com/js-rom/connect4/tree/v1.10.0-Release) |
| distributed | modelViewPresenter - presentationModel - withoutProxy |
| distributed | [v.1.12 modelViewPresenter - presentationModel - withProxy](https://github.com/js-rom/connect4/tree/v1.12.0-Release) |
| files | modelViewPresenter - presentationModel - withoutDAO |
| files | [v.1.14 modelViewPresenter - presentationModel - withDAO](https://github.com/js-rom/connect4/tree/v1.14.0-Release) |
| bbdd | [v.1.15 modelViewPresenter - presentationModel - withoutPrototype](https://github.com/js-rom/connect4/tree/v1.15.0-Release) |
| bbdd | [v.1.16 modelViewPresenter - presentationModel - withPrototype](https://github.com/js-rom/connect4/tree/v1.16.0-Release) |
| basic | modelViewPresenter - passiveView |
| basic | modelViewPresenter - supervisorController |
| basic | modelViewController |

![secuencia de versiones](./out/connect4/Docs/diagrams/TicTacToe.svg)

# Versión v.1.16

## enfoque

Esta versión pretende evitar la jerarquía de herencias paralelas en el paquete launchers que veníamos arrastrando en versiones anteriores.

## Diseño

Se utiliaza un patrón Bridege para instanciar el tipo de lógica para standalone o distributed.
Se utiliza un patrón Prototype para instaciar el tipo de vista o el tipo de persistencia a través de los comandos de arranque de la aplicación.
