# Rapport SAE développement d'application Android



## Architecture
Notre projet respecte l'architecture MVVM :


- Nous utilisons un repository pour les requêtes concernant les auteurs et un pour celles concernant les livres.
- Nous utilisons un ViewModel pour les livres et un pour les auteurs.
- Nous utilisons des adapters pour chaque fragment qui utilise un recyclerView 
- Nous avons une classe MyRequestQueue pour gérer les requêtes avec Volley.

## Fonctionnalités Attendues
- Affichage de la liste des livres 
- Affichage de la liste des auteurs
- Clique sur un livre pour afficher ses détails
- Clique sur un auteur pour afficher ses livres
- Clique sur un livre d'un auteur pour afficher ses détails
- Création d'un Livre via FAB
- Création d'un auteur via FAB
- Suppression d'un livre via ses détails
- Suppression d'un auteur via ses livres 

## Ce qui Fonctionne
- Affichage de la liste des livres 
- Affichage de la liste des auteurs
- Clique sur un livre pour afficher ses détails
- Clique sur un auteur pour afficher ses livres
- Clique sur un livre d'un auteur pour afficher ses détails
- Création d'un Livre via FAB
- Création d'un auteur via FAB

## Ce qui ne Fonctionne pas Encore
- Suppression d'un livre via ses détails
- Suppression d'un auteur via ses livres 

## Difficultés Rencontrées
- Bottom navigation qui ne réagissait plus après un clique sur un livre qui s'est résolu avec une bonne gestion de la navigation et des fragments
- La bonne mise en forme des données pour les requêtes ainsi que la compréhension des objets manipulés.
- Une erreur où Prisma panique : This is a non-recoverable error which probably happens when the Prisma Query Engine has a panic. que j'ai résolu en redémarrant mon ordinateur. 


