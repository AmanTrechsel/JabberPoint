# JabberPoint
## Analyse
De analyse van de originele software is te vinden in het [Analyse pdf-bestand](Analyse.pdf).
## Advies
Het gegeven advies op basis van deze analyse is te vinden in het [Advies pdf-bestand](Advies.pdf).
## Herontwerp
Voor het herontwerp is er een klassendiagram gemaakt, deze is te zien hieronder:
![Klasse Diagram](ClassDiagram.png)
Deze is ook te vinden in het [Astah-bestand](Herontwerp.asta), verder staan hier ook de diagrammen in uit het analyse.
## OTAP
## Programma
### Software
De JabberPoint Software is een presentatie programma geschreven in Java door middel van Maven. De dependencies hiervan zijn te vinden in de [Pom-file](pom.xml). Het programma is te gebruiken via de `.jar` bestand onder de releases.
### Design Patterns
#### Command Pattern
De command pattern is geïmplementeerd voor de [MenuController](src/main/java/Control/MenuController.java) en [KeyController](src/main/java/Control/KeyController.java) die commands aanroepen via de [Command-interface](src/main/java/Control/Command.java). Alle commando's zijn te vinden onder de [Commands package](src/main/java/Control/Commands/).
#### Singleton Pattern
De singleton pattern is toegepast omdat een aantal klasses slechts 1 keer bestaan in de software en geen toegevoegte waarde hebben om meerdere keren geïnstantieerd te worden. Ook geeft dit makkelijkere toegang tot deze objecten voor andere componenten.\
De singleton klasses zijn: [SlideViewerFrame](src/main/java/Accessor/SlideViewerFrame.java), [ControlPresentation](src/main/java/Presentation/ControlPresentation.java), [MenuController](src/main/java/Control/MenuController.java) en [KeyController](src/main/java/Control/KeyController.java). Ze worden allemaal aangeroepen met hun statische `getInstance()` methodes.
#### Observer Pattern
De observer pattern is toegevoegd om de [Presentation](src/main/java/Presentation/Presentation.java) en [SlideViewerComponent](src/main/java/Presentation/SlideViewerComponent.java) onafhankelijk van elkaar te maken. De SlideViewerComponent is nu geïmplementeerd uit de [PresentationListener-interface](src/main/java/Presentation/PresentationListener.java) waaruit de SlideViewerComponent informatie van de Presentation verkrijgt met de `update(Presentation, Slide)` methode.
#### Facade Pattern
### Principles
#### Single-Responsibility Principle
#### Open-Closed Principle
#### Liskov Substitution Principle
#### Dependency Inversion Principle