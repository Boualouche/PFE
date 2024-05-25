# Utiliser l'image openjdk:21-oracle comme base
FROM openjdk:21-oracle
# Définir un volume /tmp qui peut être utilisé pour stocker des fichiers temporaires
VOLUME /tmp
# Copier le fichier JAR de votre application dans l'image Docker
COPY target/*.jar app.jar
# Définir l'entrée principale (commande) pour exécuter l'application Java
ENTRYPOINT ["java","-jar","app.jar"]