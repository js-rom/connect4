## Diferentes versiones del juego Connect 4

| Requistios  | Versión |
|:------------- |:-------------|
| basic  | domainModel - basic|
| machine | domainModel - machine |
| basic | documentView - basic |
| machine | [documentView - machine - doubleDispatching](https://github.com/js-rom/connect4/tree/v.1.0) |
| machine | [documentView - machine - Menu](https://github.com/js-rom/connect4/tree/v.1.1) |
| machine | [documentView - machine - IA Player Open Close](https://github.com/js-rom/connect4/tree/v.1.2) |
| machine | [documentView - machine - prototype](https://github.com/js-rom/connect4/tree/v.1.3) |
| graphics | [documentView - withoutFactoryMethod](https://github.com/js-rom/connect4/tree/v.1.4) |
| graphics | documentView - withFactoryMethod |
| graphics | modelViewPresenter - presentationModel - basic |
| graphics | modelViewPresenter - presentationModel - withFacade |
| graphics | modelViewPresenter - presentationModel - withoutDoubleDispatching |
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


## Problemas de diseño de la versión

### DRY: clases principales
Existen dos arranques diferentes de la aplicación, uno para cada vista:
- ConsoleConnect4
- GraphicsConnect4

Cada una de estas clases de arranque repiten código:
- Tienen el modelo
- Tienen la vista
- Asocian el modelo con la vista
- Algoritmo general de entrada al juego (class Play)
- Main de arranque que comienza el flujo de ejecución.

Una solución a esta duplicación de código en el arranque es aplicar el patrón Factory method.



