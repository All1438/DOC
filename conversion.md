
ça avance très bien.



* J'ai effectué des tests de comparaison entre Java 8 et Java 21, cette fois-ci en analysant les résultats dans la base de données. J'ai commencé cette semaine et je n'ai terminé que deux modules pour l'instant, qui est Aggregate en Mode standard et Mode Booking Only et AggregatesVirtual

* le blocage c'est que j'ai pas accées a un instance pour executer java 8. l'execution de java 8 en local prends beaucoup de temps. et il faut corriger d'abord aussi la partie code commit avant le test de comparaison

* J'ai été initié par Mamy le Lundi pour quel sont les étapes et comment créer les tables avec l'utilisateur kowee de preprod qui est l'administrateur

* l'étape c'est de créer une table à partir de l'utilisateur kowee de preprod des tables que la même des output du module à tester. 
puis donner la permission de lecture, m-a-j, insert et suppression pour l'utilisateur adpapp de bdd preprod pour qu'on peut manipuler aussi dans adpapp.
par exemple on a créer une table identique a agg_day qui se nomme agg_day_tmp c'est l'un des output de aggregate. agg_ day c'est la sortie de java8 et pour java21 c'est agg_day_tmp.

* et la façon de le faire c'est d'éxécuter d'abord en java 21 et copier les output du modules vers l' autres tables créer pour les comparer.
ensuite, lancer le java 8 et comparer les 2 requêtes avec la même ligne de command avec la requête SQL 