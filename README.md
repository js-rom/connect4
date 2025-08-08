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
| files | modelViewPresenter - presentationModel - withDAO |
| bbdd | modelViewPresenter - presentationModel - withoutPrototype |
| bbdd | modelViewPresenter - presentationModel - withPrototype |
| basic | modelViewPresenter - passiveView |
| basic | modelViewPresenter - supervisorController |
| basic | modelViewController |

![secuencia de versiones](./out/connect4/Docs/diagrams/TicTacToe.svg)

# Versión v.1.12

## enfoque

En esta versión se añade un nuevo requisito para distribuir la aplicacion mediante comunicaciones TCP/IP. El objetivo no es solo distribuir la aplicación, sino permitir que convivan todas las combinaciones posibles de ejecución bajo un mismo proyecto reutilizando el mayor porcentaje de código posible:

- Interfaz consola - standalone
- Interfaz gráfica - standalone
- Interfaz consola - distribuida
- Interfaz gráfica - distribuida

## Diseño

- Patrón Proxy: para abstraer a las vistas (consola o gráfica) del tipo de arquitectura subyacente (standalone o distribuida). De esta manera, la interfaz de usuario no necesita conocer si está operando localmente o a través de la red. 

- factory method: para configurar los diferentes modos de arranque evitando así hacer jerarquias de herencia paralelas
