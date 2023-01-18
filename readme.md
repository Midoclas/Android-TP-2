# Fonctionnalité 1 : Homepage
(2 points)

- ~~Implémenter une activité contenant les informations des personnes du groupe.~~
- ~~L’activité doit supporter le mode nuit~~
- Contenir 2 boutons :
- ~~Rediriger vers la fonctionnalité 2 du sujet~~
- Rediriger vers la fonctionnalité 3 du sujet.
- ~~Traduisez quelques textes en Français et en Anglais.~~


### Bonus (1 point)
- Implémenter une SplashScreen qui se lance à l’ouverture de cette activité.

# Fonctionnalité 2 : RecyclerView avancé
(10 points)

- ~~Choisir 1 api que vous souhaitez manipuler (ChuckNorris quote est interdit) et qui possèdent un /random de préférence ou à défaut un random fait de votre côté.~~
- ~~Stocker les valeurs de l’API dans une base de données ROOM~~
- Au moment de l'insertion en base de donnée, vous devez récupérer le current timestamp et l’ajouter à votre objet dans room. (Api : System.currentTimeMillis).
- L’adapter doit contenir un Header ET un Footer, comme vous avez la date d'insertion avec le prérequis de la ligne du dessus, vous pouvez regrouper par heure / jours par exemple.
- ~~2 boutons devront être implémenter~~
- ~~Ajouter un random de l’API~~
- ~~Vide toute la table qui a le contenu de l’API.~~
- ~~Le contenu attendu des items doit être le plus fourni possible (c'est-à-dire afficher le plus de champ disponible via le json de l’API).~~
- ~~Respecter les 3 layers vu en cours, View, Domain, Data, avec les mappage aux bons endroits, (Ne pas oublier les usecase)~~
- Au clique d’un item, vous devez afficher une notification (Code disponible ici : https://github.com/Jordroide/Android-UE-Android-Cloud-Insset-2021/commit/d5d44860f2aa86c931b1d8988d3f1f362286675c)

### Bonus (2 points)
- Chaque item devra contenir une icône permettant la suppression de l'élément dans la base de données.
- ~~Mettre en place une animation à l’apparition de la liste~~



# Fonctionnalité 3 : Firebase
(6 points)

- Utiliser Firebase Authentification (Avec la méthode que vous voulez)
- Mettre en place une page de connexion / déconnexion avec un bouton redirigeant vers une activité d’inscription.
- Afficher l’id du current user quand vous êtes connecté.

### Bonus (1 points par Authentification différente) [Attention c’est coûteux en temps]
- S’authentifier avec Facebook, Twitter, Google ou Github.

# Fonctionnalité 4 : Cloud messaging
(2 points)

- Implémenter une compatibilité avec Cloud messaging (Code pour la notification ici : https://github.com/Jordroide/Android-UE-Android-Cloud-Insset-2021/commit/d5d44860f2aa86c931b1d8988d3f1f362286675c)

### Bonus (1 point)
- Ajouter une clé / valeur dans la notification et afficher la valeur via un toast ou le moyen que vous voulez dans l’application.
