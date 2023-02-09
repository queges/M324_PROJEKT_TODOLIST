# Kurzanleitung für die Installation der Entwicklungsumgebung zum Basisprojekt im Modul 324

@TODO: FIXME, adopt to Gitlab... make me nice...

## Beschrieb: 

ToDo-Liste mit React (frontend) und Spring (backend). Weitere Details sind in den
Kommentaren vor allem in App.js zu finden.

## Relevante Dateien in den Teil-Projekten (Verzeichnisse):

1. diese Beschreibung
2. frontend (Tools: npm und VSCode)
	* App.js

3. backend (Eclipse oder VS-Code)
	* DemoApplication.java
	* Task.java
	* pom.xml (JAR configuration, mit div. Plugins s.u.)


## In VS-Code 

1. *backend* kann mit Maven gestartet werden (vorher Java Extension Pack in VS-Code installieren). Ohne Persistenz. Default Port: 8080 
2. Im Terminal ins *frontend* Verzeichnis wechseln, mit `npm install` benötige Module laden und mit `npm start` den Frontend-Server starten.

**Im Browser:** http://ocalhost:3000 zeigt das Frontend an. 

Hier kann man Tasks eingeben, die sofort darunter in der Liste mit einem *Done*-Button angezeigt werden. 

Klickt man auf den *Done*-Button eines Tasks wird dieser aus der Liste entfernt (und natürlich auch von Backend-Server). 

Die Task Beschreibungen müssen eindeutig (bzw. einmalig) sein.
Anstehende Aufgaben:
- Erweiterung der Funktionalität durch die Lernenden
- Alternatives Backend für eine VM (WAR Konfiguration)
- Test Umbegung mit Unit-Tests erweitern

(Ausgaben für white-box debugging sind bereits auf den beiden Server vorhanden)
