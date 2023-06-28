# DevOps Engineer application challenge

Your challenge is to build a simple Java software project harness from scratch, packaging it with Jib and
write a small test using Goss.

We're interested in seeing how you:

- Understand and implement a simple solution according to the requirements
- Set up a trivial software development project from scratch
- Understand potentially unfamiliar tools by reading documentation

## Requirements

Setup a small Java project using Spring Boot and Spring Web. The application should offer a single REST
endpoint which returns the current date in ISO 8601 format. Here's how the application should behave:

```shell
$ curl -s http://localhost:8080/date
2023-06-26
```

This application should then be packaged into a container image by using [jib](https://github.com/GoogleContainerTools/jib)
integrated with Gradle. A container image should be pushed to the local Docker daemon by executiung:

```shell
$ gradle jibDockerBuild
```

Run the container, with its application port mapped to the local port `8090`, in order to have the output:

```shell
$ curl -s http://localhost:8090/date
2023-06-26
```

Write a test using [goss](https://github.com/goss-org/goss), which verifies the reponse code 200 and the
current date by supplying a value on the command-line. Here's how the test harness should behave:

```shell
goss --vars-inline "expected: 2023-06-26" validate                                                                                                                                                                                          3 ✘
.

Total Duration: 0.078s
Count: 1, Failed: 0, Skipped: 0
```

Finally, provide a small script that:

1. Builds the application
2. Packages it into a container image
3. Runs the image locally
4. Executes the goss test

Ensure to use multiple meaningful commits in Git to create a trail of work. If there's anything note-worthy, add
in-line comments. While not required, you may add comments on any design choice to the main README file.


Moving Random Notes to the README:

1: Tooling Check
1.1 nötiges Tooling auf Arbeitsgerät installiert.
Da ich den PC vor kurzen neu aufgesetzt hatte, war das so gut wie alles.
1.2 Project Tooling
Überlegung ob Base Projekt mit JHipster erstellt werden soll, aber da es ein sehr simples Projekt ohne Datenbank ist, habe ich mich für Spring Initializer entschieden


2: Doku Check, verschiedene bekannte Toolings nochmal überprüfen und neue Doku lesen
2.1: Spring initializr: https://start.spring.io/
Zum erstellen der Base App benutze ich Spring initializr, check welche Dependencies inkludiert werden können. Jib und Goss muss ich selber einbinden.
Kurz überlegt ob ich weitere Sachen einbinden will die ich normalerweise benutzen würde, wie z.B. actuators, Lombok, testcontainers.
Dagegen entschieden um das Projekt klein zu halten. -> KISS
2.2 Jib Doku angeschaut
https://github.com/GoogleContainerTools/jib
https://github.com/GoogleContainerTools/jib/tree/master/jib-gradle-plugin
https://cloud.google.com/java/getting-started/jib?hl=de
spezifische Tutorial gefunden: https://www.baeldung.com/jib-dockerizing
2.3 Goss Doku angeschaut
https://github.com/goss-org/goss
https://github.com/goss-org/goss/tree/master/extras/dgoss

		added Goss to IntelliJ according to https://github.com/goss-org/goss#manually-editing-goss-files

Goss habe ich local hinzugefügt da ich docker auch auf windows aufgesetzt hab. Wäre wahrscheinlich besser gewesen alles in WSL/Ubuntu aufzusetzen.


Additional Links used:
https://stackoverflow.com/questions/32073971/stopping-docker-containers-by-image-name-ubuntu
https://stackoverflow.com/questions/21183088/how-can-i-wait-for-a-docker-container-to-be-up-and-running