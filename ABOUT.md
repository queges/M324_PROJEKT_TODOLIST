# Kurzanleitung für die Installation der Entwicklungsumgebung zum Basisprojekt im Modul 324

@TODO: FIXME, adopt to Gitlab... make me nice...

## Beschrieb: 

ToDo-Liste mit React (frontend) und Spring (backend). Weitere Details sind in den
Kommentaren vor allem in App.js zu finden.

## Relevante Dateien in den Teil-Projekten (Verzeichnisse):
1. diese Beschreibung
2. frontend_react.zip (Tools: npm und VSCode)
	a) App.js (detailliert kommentiert)
3. eclipsebackend.zip (Ecipse EE)
	a) DemoApplication.java
	b) Task.java
	c) pom.xml (JAR configuration, mit div. Plugins s.u.)

Beide Zip Dateien in eigene Verzeichnisse entpacken.

**In VS-Code** 
Backend-Projekt importieren
Kann dann mit Maven gestartet werden, sollte keine Fehler produzieren. Somit läuft dann die
Spring-Server Demo Anwendung, das Backend-Model der Todo Liste, ohne die Persistenz.
Im Terminal ins entpackte Frontend Verzeichnis wechseln und mit npm start den zweiten server
starten.

**Im Browser** localhost:3000 zeigt das Frontend an. Hier kann man Tasks eingeben, die sofort
darunter in der Liste mit einem «Done»-Button angezeigt werden. Auch ein Refresh mit F5
verändert nicht die Liste. Klickt man auf den Done Button eines Tasks wird diese aus der Liste
entfernt. Die Task Beschreibungen müssen eindeutig sein.
Anstehende Aufgaben:
- Erweiterung der Funktionalität durch die Lernenden
- Alternatives Backend für eine VM (WAR Konfiguration)
- Test Umbegung mit Unit-Tests erweitern
(Ausgaben für white-box debugging sind bereits auf den beiden Server vorhanden)