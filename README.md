# Projet Pharma5 - Application de Gestion de Médicaments (Introduction JDBC - DAO Mocké)

Ce dépôt contient la cinquième itération du projet "Pharma". Cette version introduit les bases du code JDBC (Java Database Connectivity) dans le `MedicamentDao`, mais les opérations de persistance des données sont **toujours simulées par un "objet mock"**. L'objectif est de montrer la structure et le processus de connexion à une base de données sans encore implémenter la persistance réelle. La configuration de Spring continue d'utiliser les annotations Java.

## Contexte

- **Pharma1** : Bases en Java pur avec DAO mocké.
- **Pharma2** : Injection de dépendances manuelle.
- **Pharma3** : Conteneur Spring avec configuration XML.
- **Pharma4** : Conteneur Spring avec configuration Java (`@Configuration`, `@Bean`).
- **Pharma5** : Le `MedicamentDao` contient le **squelette du code JDBC** pour la gestion des connexions, statements et result sets. Cependant, les méthodes de persistance (CRUD) **retournent toujours des données mockées** ou affichent des messages de simulation. L'application ne se connecte pas encore activement à une base de données pour la lecture/écriture.

## Fonctionnalités (Démo 5)

- **Gestion des Médicaments** : Les opérations CRUD (Création, Lecture, Mise à jour, Suppression) sont appelées, mais leur implémentation dans le DAO est toujours basée sur des données "mockées".
- **Introduction du Code JDBC** : Le `MedicamentDao` inclut le code pour :
  - Charger le driver JDBC (`Class.forName("com.mysql.cj.jdbc.Driver")`).
  - Tenter de récupérer une `Connection` en utilisant `DriverManager.getConnection` avec des informations codées en dur (URL, login, password).
  - Créer des `Statement` et `ResultSet`.
  - Les blocs `try-catch-finally` pour la gestion des exceptions et la fermeture des ressources JDBC.
  - **Note importante :** Bien que le code JDBC soit présent, la méthode `recuperationMedicament` par exemple, renvoie un objet `Medicament` créé en dur si l'ID est 2, et non une donnée de la base de données. Les autres méthodes CRUD affichent des messages sans effectuer d'opérations réelles sur une DB.
- **Conteneur Spring avec Configuration Java** :
  - La configuration des beans Spring (`MedicamentDao`, `ServiceMedicament`) se fait via une classe de configuration Java (`@Configuration`, `@Bean`).
  - La classe `Laucher` utilise `AnnotationConfigApplicationContext` pour charger le contexte Spring.

## Technologies Utilisées

- Java (JDK 8 ou supérieur recommandé)
- **Maven** (pour la gestion des dépendances et du build)
- **Spring Framework** (pour l'injection de dépendances et la gestion des beans)
- **JDBC API** (le code est inclus dans le DAO)
- **MySQL Connector/J** (dépendance Maven nécessaire pour le chargement du driver JDBC).

## Préparation de l'Environnement (Facultatif pour cette démo)

Bien que l'application ne se connecte pas réellement pour des opérations CRUD persistantes, la présence d'un serveur MySQL avec une base de données `syspharma_dev` et la table `Medicament` (ainsi qu'un utilisateur `spring`/`spring`) serait nécessaire si vous activiez la persistance réelle à l'avenir. Pour cette démo, le code du DAO simule cela.

## Comment Exécuter l'Application

1.  **Prérequis :**

    - Assurez-vous d'avoir le [JDK (Java Development Kit)](https://www.oracle.com/java/technologies/downloads/) installé (version 8 ou supérieure).
    - Assurez-vous d'avoir [Maven](https://maven.apache.org/download.cgi) installé et configuré.

2.  **Cloner le dépôt :**

    ```bash
    git clone [https://github.com/votre_utilisateur/Pharma5.git](https://github.com/votre_utilisateur/Pharma5.git)
    cd Pharma5
    ```

3.  **Construire le projet et télécharger les dépendances (via Maven) :**

    ```bash
    mvn clean install
    ```

    Cela compilera le code et téléchargera les dépendances Spring et `mysql-connector-java`.

4.  **Exécuter l'application (depuis l'IDE) :**
    - Importez le projet `Pharma5` dans votre IDE (IntelliJ IDEA, Eclipse, VS Code) comme un projet Maven existant.
    - Exécutez la classe `com.sidoCop.sysPharma.launcher.Laucher` en tant qu'application Java.
    - Vous devriez voir les messages de console indiquant le chargement du contexte Spring et les messages de simulation du DAO. Aucune erreur de connexion à la base de données ne devrait apparaître si le code de connexion est géré pour ne pas échouer sans une DB réelle.

## Prochaines Étapes Possibles

- **Implémentation de la persistance réelle** : Modifier le `MedicamentDao` pour qu'il se connecte et effectue réellement les opérations CRUD sur la base de données MySQL.
- **Externalisation des propriétés de connexion DB** : Utiliser un fichier `datasource.properties` et l'injection de propriétés Spring pour éviter de coder en dur les informations de base de données.
- **Utilisation d'un pool de connexions** : Intégrer un pool de connexions (comme HikariCP ou Apache DBCP) pour une gestion plus performante et robuste des connexions.
- **Utilisation de Spring JDBC Template** : Simplifier le code du DAO en utilisant les classes d'abstraction JDBC de Spring, ce qui réduit le boilerplate code (gestion des `try-catch-finally` pour les ressources).

---

**Auteur :**

- Sidonie sidoniedjuissifohouo@gmail.com

- www.linkedin.com/in/sidonie-djuissi-fohouo

**Date :** 12 juin 2025
