# Projet Annonce

Ce projet est une application web développée avec **Spring Boot**. Il permet de gérer des annonces avec une base de données **PostgreSQL**.

## Prérequis

Avant de lancer le projet, assurez-vous d'avoir installé :
- **Java 17** ou une version compatible
- **Maven**
- **PostgreSQL**
- **Node.js** et **Angular CLI** (si vous utilisez le frontend)
- **Postman** (optionnel, pour tester les API)

## Installation et Configuration

### 1. Cloner le projet

```sh
git clone https://github.com/votre-repo/annonce.git
cd annonce
```


### 2. Configurer la base de données PostgreSQL

Créez une base de données PostgreSQL et mettez à jour le fichier `src/main/resources/application.properties` avec les informations de connexion. Vous pouvez configurer les paramètres suivants :

```properties
# Configuration de la base de données PostgreSQL
spring.datasource.url=jdbc:postgresql://localhost:5432/annonce_db  # Remplacez par votre URL de base de données
spring.datasource.username=votre_utilisateur  # Remplacez par votre nom d'utilisateur PostgreSQL
spring.datasource.password=votre_mot_de_passe  # Remplacez par votre mot de passe PostgreSQL

# Configuration de JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update  # Définit la stratégie de génération des tables (update, create, etc.)
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect  # Utilise le dialecte PostgreSQL

# Logging des requêtes SQL (facultatif)
spring.jpa.show-sql=true  # Affiche les requêtes SQL exécutées
spring.jpa.properties.hibernate.format_sql=true  # Formate les requêtes SQL
```

Exemple de création de la base de données PostgreSQL
Si la base de données annonce_db n'existe pas encore, vous pouvez la créer via la ligne de commande PostgreSQL :

```sql
CREATE DATABASE annonce_db;
```
### 3. Lancer l'application 

Une fois la base de données configurée, compilez et démarrez votre application Spring Boot avec Maven :

1. Compilation et construction du projet :
```sh
mvn clean install
```
2. Démarrage de l'application :
```sh
mvn spring-boot:run
```

### 4. Tester l'API avec Postman
   L'API expose plusieurs points d'entrée (endpoints). Voici les principales routes disponibles dans l'API :

GET /annonces → Liste de toutes les annonces

POST /annonces → Crée une nouvelle annonce

GET /annonces/{id} → Récupère une annonce par son identifiant

PUT /annonces/{id} → Met à jour une annonce par son identifiant

DELETE /annonces/{id} → Supprime une annonce par son identifiant

Pour effectuer des requêtes, vous devrez vous authentifier avec Basic Auth. Par défaut, l'authentification est configurée dans Spring Security comme suit :

Nom d'utilisateur : admin

Mot de passe : admin123

Dans Postman, vous pouvez ajouter l'authentification Basic Auth avec ces informations.

Exemple de configuration de Postman pour un GET /annonces :

1. Méthode HTTP : GET
2. URL : http://localhost:8080/annonces
3. Authentification : Basic Auth
   - Username : admin
   - Password : admin123

### 5. Les tests
Vous pouvez exécuter les tests en utilisant Maven :
```sh
mvn test
```
Les tests s'exécuteront et les résultats s'afficheront dans la console.

### 6. Logs

Les logs sont générés via **SLF4J** et **Logback**. Par défaut, les logs sont enregistrés dans des fichiers situés dans le répertoire `logs/` à la racine du projet.

- **Nom du fichier de log** : Le fichier de log est nommé selon la date du jour sous le format `app-yyyy-MM-dd.log` (par exemple, `app-2025-03-26.log` pour les logs du 26 mars 2025).
- **Emplacement** : Les fichiers de log se trouvent dans le répertoire `logs/` du projet.

**Exemple de chemin** :
logs/app-2025-03-26.log