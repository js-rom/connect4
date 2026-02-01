# Connect 4. Solution v.1.16 modelViewPresenter - presentationModel - withPrototype

## Índice

1. [Requisitos](#requisitos-6-files)

2. [Vista de Casos de Uso](#vista-de-casos-de-uso)
  - [Vista de Caso de Uso Start](#vista-de-caso-de-uso-start)
  - [Vista de Caso de Uso Open](#vista-de-caso-de-uso-open)
  - [Vista de Caso de Uso Play](#vista-de-caso-de-uso-play)  
  - [Vista de Caso de Uso Undo](#vista-de-caso-de-uso-undo)  
  - [Vista de Caso de Uso Redo](#vista-de-caso-de-uso-redo)
  - [Vista de Caso de Uso Exit](#vista-de-caso-de-uso-exit)
  - [Vista de Caso de Uso Save](#vista-de-caso-de-uso-save)
  - [Vista de Caso de Uso Resume](#vista-de-caso-de-uso-resume)

3. [Vista de Lógica/Diseño](#vista-de-lógicadiseño)
  - [Arquitectura](#arquitectura)
    - [summary view](#summary-view)
    - [detailed view](#detailed-view)
  - [launchers Package](#launchers-package)
  - [connect4.controllers Package](#connect4controllers-package)
  - [connect4.views.views Package](#connect4viewsviews-package)
  - [connect4.views.console Package](#connect4viewsconsole-package)
  - [connect4.models Package](#connect4models-package)
  - [connect4.daos Package](#connect4daos-package)
  - [connect4.net Package](#connect4net-package)
  - [connect4.types Package](#connect4types-package)
  - [connect4.utils Package](#connect4utils-package)

4. [Vista de Desarrollo/Implementación](#vista-de-desarrolloimplementación)

5. [Vista de Procesos](#vista-de-procesos)

6. [Calidad del Software](#calidad-del-software)

# Requisitos 6. *Files*

* Funcionalidad: 
  * **Jugador persona, máquina aleatorio y máquina con inteligencia artificial**
  * **Undo - Redo**
  * **Salir de la partida actual**
  * **Guardar la partida**
  * **crear una partida o abrir una partida guardada**

* Interfaz: **Texto**
* Distribución: **Standalone & distributed**
* Persistencia: **Files & bbdd**

# Vista de Casos de Uso

## Diagrama de Actores y Casos de Uso

![](../out/connect4/Docs/diagrams/src/requisites/useCaseView.actorsAndUseCasesDiagram/useCaseView.actorsAndUseCasesDiagram.svg)

## Diagrama de Contexto

![](../out/connect4/Docs/diagrams/src/requisites/useCaseView.contextDiagram/useCaseView.contextDiagram.svg)

## Vista de Caso de Uso Start

![](../out/connect4/Docs/diagrams/src/requisites/useCaseView.start/useCaseView.start.svg)

## Vista de Caso de Uso Open

![](../out/connect4/Docs/diagrams/src/requisites/useCaseView.open/useCaseView.start.svg)

## Vista de Caso de Uso Play 

![](../out/connect4/Docs/diagrams/src/requisites/useCaseView.play/useCaseView.start.svg)

## Vista de Caso de Uso Undo 

![](../out/connect4/Docs/diagrams/src/requisites/useCaseView.undo/useCaseView.start.svg)

## Vista de Caso de Uso Redo  

![](../out/connect4/Docs/diagrams/src/requisites/useCaseView.redo/useCaseView.start.svg)

## Vista de Caso de Uso Exit

![](../out/connect4/Docs/diagrams/src/requisites/useCaseView.exit/useCaseView.exit.svg)

## Vista de Caso de Uso Save

![](../out/connect4/Docs/diagrams/src/requisites/useCaseView.save/useCaseView.exit.svg)

## Vista de Caso de Uso Resume 

![](../out/connect4/Docs/diagrams/src/requisites/useCaseView.resume/useCaseView.exit.svg)

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
  - Patrón DAO para el acceso a datos
  - Patrón repository para desacoplar la lógica de la persistencia
  - Patrón prototype y Bridse para los launchers para evitar jerarquías de herencias paralelas.

## Arquitectura

- modelViewPresenter - presentationModel
- basada en el modelo del dominio
- El conjunto de paquetes forma un Grafo Dirigído **Acíclico**

### summary view

![Package_connect4](../out/connect4/Docs/diagrams/src/packages/packageDiagramSummary/packageDiagramSummary.svg)

### detailed view

![Package_connect4](../out/connect4/Docs/diagrams/src/packages/packageDiagram/packageDiagram.svg)

## launchers Package

![Package_connect4](../out/connect4/Docs/diagrams/src/packages/connect4.connect4.launchers/connect4.connect4.launchers.svg)

![Package_connect4](../out/connect4/Docs/diagrams/src/packages/connect4.connect4.launchers.distributed.server/connect4.connect4.launchers.distributed.server.svg)

## connect4.controllers Package

![Package_connect4.controllers](../out/connect4/Docs/diagrams/src/packages/connect4.connect4.controllers-pkg/connect4.connect4.controllers-pkg.svg)

![Package_connect4.controllers](../out/connect4/Docs/diagrams/src/packages/connect4.connect4.controllers.core/connect4.connect4.controllers.core.svg)

![Package_connect4.controllers](../out/connect4/Docs/diagrams/src/packages/connect4.connect4.controllers.implementation/connect4.connect4.controllers.implementation.svg)

![Package_connect4.controllers](../out/connect4/Docs/diagrams/src/packages/connect4.connect4.controllers.proxies/connect4.connect4.controllers.proxies.svg)


## connect4.views.views Package

![Package_connect4.views](../out/connect4/Docs/diagrams/src/packages/connect4.connect4.views/connect4.connect4.views.svg)

## connect4.views.console Package

![Package_connect4.views.console](../out/connect4/Docs/diagrams/src/packages/connect4.connect4.views.console-pkg/connect4.connect4.views.console-pkg.svg)

![Package_connect4.views.console](../out/connect4/Docs/diagrams/src/packages/connect4.connect4.views.console/connect4.connect4.console.console.svg)

![Package_connect4.views.console](../out/connect4/Docs/diagrams/src/packages/connect4.connect4.views.console.shared/connect4.connect4.console.shared.svg)

![Package_connect4.views.console](../out/connect4/Docs/diagrams/src/packages/connect4.connect4.views.console.start/connect4.connect4.console.start.svg)

![Package_connect4.views.console](../out/connect4/Docs/diagrams/src/packages/connect4.connect4.views.console.play/connect4.connect4.console.play.svg)

![Package_connect4.views.console](../out/connect4/Docs/diagrams/src/packages/connect4.connect4.views.console.turn/connect4.connect4.console.turn.svg)

![Package_connect4.views.console](../out/connect4/Docs/diagrams/src/packages/connect4.connect4.views.console.turn.player/connect4.connect4.console.turn.player.svg)


## connect4.models Package

![Package_connect4.models](../out/connect4/Docs/diagrams/src/packages/connect4.connect4.models/connect4.connect4.models.svg)

## connect4.persistence Package

![Package_connect4.persistence](../out/connect4/Docs/diagrams/src/packages/connect4.connect4.persistence/connect4.connect4.daos.svg)

![Package_connect4.persistence](../out/connect4/Docs/diagrams/src/packages/connect4.connect4.persistence.files/connect4.connect4.persistence.files.svg)

![Package_connect4.persistence](../out/connect4/Docs/diagrams/src/packages/connect4.connect4.persistence.bbdd/connect4.connect4.persistence.bbdd.svg)

## connect4.net Package

![Package_connect4.models](../out/connect4/Docs/diagrams/src/packages/connect4.connect4.net/connect4.net.svg)

## connect4.types Package

![Package_connect4.types](../out/connect4/Docs/diagrams/src/packages/connect4.connect4.types/connect4.connect4.types.svg)

## connect4.utils Package

![Package_connect4.utils](../out/connect4/Docs/diagrams/src/packages/connect4.utils/utils.svg)


![Package_connect4.utils](../out/connect4/Docs/diagrams/src/packages/connect4.utils.net/utils.net.svg)

# Vista de Desarrollo/Implementación

![](../out/connect4/Docs/diagrams/src/development/clientComponentDiagram/clientComponentDiagram.svg)

![](../out/connect4/Docs/diagrams/src/development/serverComponentDiagram/serverComponentDiagram.svg)


![](../out/connect4/Docs/diagrams/src/development/standAloneComponentDiagram/standAloneComponentDiagram.svg)

# Vista de Despliegue/Física

# Vista de Procesos

- No hay concurrencia

# Calidad del Software



