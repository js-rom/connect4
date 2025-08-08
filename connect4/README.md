# Connect 4. Solution v.1.12 modelViewPresenter - presentationModel - withProxy

# Requisitos 5. *Distribuido*

* Funcionalidad: 
  * **Jugador persona, máquina aleatorio y máquina con inteligencia artificial**
  * **undo - redo**
* Interfaz: **Gráfica y Texto**
* Distribución: **Standalone & distributed**
* Persistencia: **No**

# Vista de Lógica/Diseño

- Modelo/Vista/Presentador con Presentador del Modelo con Vista Achicada
  - Patrón Command, para el menú de consola e interfaz gráfica
  - Patrón Facade, para multicontroladores y sesión
  - Patrón Memento, para la funcionalidad undo/redo
  - Patrón Factory Method para los launchers
  - Patrón Proxy para los controladores standalone & distributed
  - Patrón Prototype para los diferentes tipos de Board View según los tipos de Player
  - Técnica Doble Despacho para visitadores de vistas
  - Inversión de Control para vistas principales
  - Patrón template method para extender el comportamiento de jerarquías de herencias

## Arquitectura

El conjunto de paquetes forma un Grafo Dirigído **Acíclico**

### summary view

![Package_connect4](../out/connect4/Docs/diagrams/src/packages/packageDiagramDistributedSummary/packageDiagramDistributedSummary.svg)

### detailed view

![Package_connect4](../out/connect4/Docs/diagrams/src/packages/packageDiagramDistributed/packageDiagramDistributed.svg)

## launchers Package

![Package_connect4](../out/connect4/Docs/diagrams/src/packages/connect4.connect4.launchers/connect4.connect4.launchers.svg)

![Package_connect4](../out/connect4/Docs/diagrams/src/packages/connect4.connect4.launchers.distributed.server/connect4.connect4.launchers.distributed.server.svg)

## connect4.controllers Package

![Package_connect4.controllers](../out/connect4/Docs/diagrams/src/packages/connect4.connect4.controllers-pkg/connect4.connect4.controllers-pkg.svg)

![Package_connect4.controllers](../out/connect4/Docs/diagrams/src/packages/connect4.connect4.controllers.core/connect4.connect4.controllers.core.svg)

![Package_connect4.controllers](../out/connect4/Docs/diagrams/src/packages/connect4.connect4.controllers.implementation/connect4.connect4.controllers.implementation.svg)

![Package_connect4.controllers](../out/connect4/Docs/diagrams/src/packages/connect4.connect4.controllers.proxies/connect4.connect4.controllers.implementation.svg)


## connect4.views.views Package

![Package_connect4.views](../out/connect4/Docs/diagrams/src/packages/connect4.connect4.views/connect4.connect4.views.svg)

## connect4.views.console Package

![Package_connect4.views.console](../out/connect4/Docs/diagrams/src/packages/connect4.connect4.views.console-pkg/connect4.connect4.views.console-pkg.svg)

![Package_connect4.views.console](../out/connect4/Docs/diagrams/src/packages/connect4.connect4.views.console/connect4.connect4.console.console.svg)


## connect4.views.graphics Package

![Package_connect4.views.graphics](../out/connect4/Docs/diagrams/src/packages/connect4.connect4.views.graphics/connect4.connect4.views.graphics.svg)

## connect4.models Package

![Package_connect4.models](../out/connect4/Docs/diagrams/src/packages/connect4.connect4.models/connect4.connect4.models.svg)

## connect4.net Package

![Package_connect4.models](../out/connect4/Docs/diagrams/src/packages/connect4.connect4.net/connect4.net.svg)

## connect4.types Package

![Package_connect4.types](../out/connect4/Docs/diagrams/src/packages/connect4.connect4.types/connect4.connect4.types.svg)

## connect4.utils Package

![Package_connect4.utils](../out/connect4/Docs/diagrams/src/packages/connect4.utils/utils.svg)


![Package_connect4.utils](../out/connect4/Docs/diagrams/src/packages/connect4.utils.net/utils.net.svg)

# Vista de Desarrollo/Implementación

# Vista de Despliegue/Física

# Vista de Procesos

- No hay concurrencia

# Calidad del Software


