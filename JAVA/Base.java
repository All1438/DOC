package JAVA;
// pour utiliser les tableaux
// Très util pour intéragir avec les utilisateur
import java.util.*; // permet d'importer tous les classes et interface du package 'java.util'

public class Base {
    /**
     * @param args
     */
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in); // il faut déclarer une seul fois Scanner
        // Objets créer apartir de classes en utilisant le mot clé 'new'

        System.out.println("Hello World"); // System.out.println() = affichage message
        int age; // déclaration variable
        // int: 32bits. Entier
        // float: 64bits, à virgule flottante. Décimaux
        // char: 16bits, représentant un caractère Unicode. Caractère
        // boolean: représentant une valeur de vérité, true ou false
        // String: représente une chaine de caractères
            // Tableau
        // int[]: c'est un tableau de type entier
        // String[]: C'est un tableau de chaine de caractère

        int nbr = scanner.nextInt(); // permet d' entrer à l'utilisateur une variable de type int
        // .nextInt() = Permet de lire un int à partir de l'entrer utilisateur
        // .nextFloat() = Permet de lire un float
        // .next() = Permet de lire un mot. Cette méthode lit et retourne la prochaine chaîne de caractères jusqu'à rencontrer un espace ou une fin de ligne
        // .nextLine() = permet de lire une ligne de texte. lit et retourne la prochaine ligne de texte jusqu'à rencontrer une fin de ligne.
        // .nextBoolean() = permet de retourner true si le prochain token est "true", sinon "false"
        
            // CONDITION
    if(nbr > 10){
        // instruction
    } else if(nbr > 20){
        // instruction
    } else {
        // instruction
    }
            // BOUCLE
    while(nbr > 0){
        // instruction
    }
    for(int i = 0; nbr < i; i++){
        // instruction
    }

            // Opération logiques
        // ET(&&), OU(||), NON(!)
            // Opération d'incrémentation
        // Incrémentation(++x, x++), Décrémentation(--x, x--)
            // Opération sur les Chaines de caractères
        // Concaténation de chaîne(+)
        String maChaine = "RAKOTOARINIVO";
        int longueur = maChaine.length(); // renvoye le nombre de caractère dans une chaîne
        char caractere = maChaine.charAt(2); // renvoie le caractère à la position spécifié dans une chaine
        String sousChaine = maChaine.substring(5, 12); // permet d'extraire une partie spécifique d'une chaine
        int index = maChaine.indexOf("RIN"); // renvoie l'index de la première occurence d'un caractère ou d'une sous chaîne dans une chaîne
        String nouvelleChaine = maChaine.replace("OTO", "ITI"); // remplace tout les occurences d'une caractère ou d'une sous-chaîne 
        String minuscule = maChaine.toLowerCase(); // convertit tout les caractères d'une chaîne en minuscule ou en majuscules
        String[] tokens = maChaine.split(","); // divise une chaîne en plusieurs sous-chaînes en fonction du délimiteur spécifié
        String newChaine = maChaine.trim(); // supprime tous les espaces en début et fin de chaîne
        boolean contains = maChaine.contains("le"); // Vérifie si la séquence spécifiée est contenue dans la chaine courante. Elle renvoye "true" si séquence est trouvé
        boolean startWith = maChaine.startsWith("RAK"); // return "true" si la chaîne de caractère commence par la sous-chaine spécifiée

                // Base TABLEAU
        //ont une taille fixe déterminée lors de leur création. Une fois créés, leur taille ne peut pas être modifiée. Ils sont donc plus adaptés aux situations où la taille de la collection est connue à l'avance et reste constante.
         int[] monTableau = {1, 2, 3, 4, 5}; // initialisé un tableau
            // accéder au élément d'un tableau
        int valeur = monTableau[3];
            // modifié un élément d'un tableau
        monTableau[2] = 10;
            // copier un tableau
        int[] copieTableau = Arrays.copyOf(monTableau, monTableau.length); // permet de créer une copie d'un tableau existant
            // recherche dans un tableau
        int indexx = Arrays.binarySearch(monTableau, 5); // (var, valeur) = permet de rechercher la présence d'une valeur spécifique et de renvoyer son index
            // Trier un tableau
        Arrays.sort(monTableau); // permet de trier les éléments d'un tableau dans un ordre spécifique
            // Convertir un tableau en chaine de caractères
        String chainee = Arrays.toString(monTableau); // permet de convertir un tableau en une chaîne de caractères pour l'affichage
            // Comparer deux tableaux
        boolean sontEgaux = Arrays.equals(monTableau, copieTableau); // permet de comparer les éléments de tableaux pour vérifié s'ils sont égaux

                // TABLEAU multidimensionnel
        // Un tableau multidimensionnel est un tableau contenant d'autre tableaux(ou matrice) en tant qu'élément.
            // Déclaration et initiation
        int[][] matrice = new int[3][3];
        matrice[0][0] = 1; // matrice[Horizontal][Vertical]
        matrice[0][1] = 2;
        matrice[0][2] = 3;
        // ...
            // Affichage
        for(int i = 0; i < matrice.length; i++){ // matrice.length = 3 (Affiche la longueur de la première ligne)
            for(int j = 0; j < matrice[i].length; j++){ // matrice[i].length = 3 (car il y a 3 différent valeur i)
                System.out.print(matrice[i][j] + " ");
            }
            System.out.println(); // Allez à la ligne après chaque ranger
        }


                // Base OBJETS (collection)
            // creation objets
        Personne personne = new Personne();
        
            // Transtypage (cast)
        // fait référence à la conversion d'une variable d'un type de données à un autres.
        double d = 2.14;
        int i = (int) d; // transtypage explicite de double à int
        System.out.println(i); // Affiche 3

        Chien monChien = new Chien();
        Animal monAnimal = (Animal) monChien;
        monAnimal.manger(); // Affiche "L'animal mange"
        // Comme monAnimal est transtypé en Animal, nous ne pouvons pas appelé la méthode aboyer()
        // monAnimal.aboyer(); // Cela provoque une erreur de compilation

            //Covarience des méthodes
        // fait référence à la capacité d'une sous-classe de redéfinir une méthode héritée pour retourner un type plus spécifique que le type retourné par la méthode dans la classe parente.
        Chien tonChien = new Chien();
        tonChien.cri(); // Appelle la méthode cri() de Chien

                // Class System
            // propriété du runtime Java
        // La méthode "currentTimeMillis()" retourne le nombre de millisecondes écoulées depuis le 1er Janvier 1970
        long currentTime = System.currentTimeMillis();
            // methodes de terminaison de programme
        System.exit(0); // permet de terminer immediatement le programme avec un code de sortie spécifié

                // Class conteneur(wrapper classes)
        // Integer, Long, Short, Character, Float, String, Double, Boolean
            // utilisation avec les collections
        List<Integer> listee = new ArrayList<>();
        listee.add(10);
            // Autoboxing et unboxing
        // l'autoboxing convertit auto un type primitf en objet conteneur lorsque cela est nécessaire.
        // l'unboxing convertit auto un objet conteneur en type primitif lorsque cela est nécessaire
        Integer x = 10;
        int y = x;
            // manipulation de valeur nulles:
        Integer z = null;

                // List
        //  les listes en Java sont utilisées pour stocker une collection ordonnée d'éléments où chaque élément peut être accessible par un indice unique. Elles offrent une flexibilité et une facilité d'utilisation pour manipuler des collections de données dynamiques dans vos programmes Java.
            // Declaration liste:
        List<String> liste = new ArrayList<>();
            // Ajout et suppression d'éléments
        liste.add("element");
        liste.remove(0); // suppression du première élément
            // Accés aux éléments
        String premierElement = liste.get(0);
            // parcours de la liste
        for(String element : liste) {
            System.out.println(element);
        }
            // taille de la liste
        int taille = liste.size();

                // Convertion de type
            // convertion implicite(widening)
        int number = 10;
        double value = number; // sans perte de données
            // convertion explicite(narrowing)
        double valeurs = 10.5;
        int nombre = (int) valeur; // Cela peut entraîner une perte de données ou une perte de précision

                // enum (enumération)
        // Il est utilisé pour représenter des ensembles finis de valeur dans divers contextes, ce qui rend le code plus sûr, plus lisible et plus maintenable
            // Representation de constantes;
        // Les énumérations sont souvent utilisées pour représenter des ensembles de constantes qui ont une signification logique ou fonctionnelle.
        // enum Jour { Lundi, Mardi, Mercredi, Jeudi, Vendredi, Samedi, Dimanche }
            // Paramètre de méthode
        //void afficherJour(Jour jour) {
          //  System.out.println("Aujourd'hui c'est " +jour);
        //}
            // Utilisation dans les collections:
        // List<Jour> jourOuvrables = new ArrayList<>();
        // joursOuvrables.add(Jour.Lundi);
        // joursOuvrables.add(Jour.Mardi);

                // Class Math
        int absValue = Math.abs(-10); // retourne une valeur absolu d'un nombre
        int minNumber = Math.min(5, 10); // retourne le plus petit des deux nombres
        int maxNumber = Math.max(5, 10); // retourne le plus grand des deux nombres
        double xo = 3.7;
        double result = Math.floor(x); // renvoye la plus grande valeur entière qui est inférieur ou égale au nombre donné
        double result2 = Math.ceil(x); // renvoye le plus petit valeur entière qui est suppérieur ou égale au nombre donné 
        double xx = 3.5;
        long results = Math.round(xx); // arrondit un nombre à l'entier le plus proche, en cas d'égalité parfaite entre 2 entier,elle est arrondie à l'entier pair le plus proche
        // result vaut 4
        double resultss = Math.rint(xx); // arrondit un nombre à l'entier le plus proche, en cas d'égalité parfaite entre 2 entier,  le résultat est arrondi à l'entier le plus proche en utilisant la règle de l'arrondi mathématique,
        // resultat vaut 4.0

                // ellipse ('...') ou varrargs
        // une fonctionnalité de Java qui permet à une méthode de prendre un nombre variable d'arguments du même type.
        // ils sont souvent utilisés lorsque le nombre exact d'argument n'est pas connu à l'avance ou peut varier d'un appel de méthode à un autre.
            // declaration de méthode avec varargs:
        public void printNubers(int... numbers){
            for(int : numbers){
                System.out.println(num);
            }
        }
        // cette function signifie que nous pouvons appelé cette méthode avec un nombre quelconque d'entiers en tant qu'arguments, et ces entiers seront traités comme un tableau à l'intérieur de la méthode

                // Method main
        // C'est un point d'entrée d'un programme. C'est là ou l'exécution du programme commence.
        // doit être définis comme suite:
            // public static  void main(String[] args)

                // Collection
        // C'est une cadre de programmation qui fournit une structure de données pour stocker et manipuler un groupe d'objets
        // Collection en Java: List, Set, Map, Queue, Deque

               // List
        //  les listes en Java sont utilisées pour stocker une collection ordonnée d'éléments où chaque élément peut être accessible par un indice unique. Elles offrent une flexibilité et une facilité d'utilisation pour manipuler des collections de données dynamiques dans vos programmes Java.
        // Représente une collection ordonnée d'éléments pouvant contenir des doublons. Les Listes permettent un accées aux éléments et permettant d'ajouter, supprimer, rechercher des éléments par index
            // Declaration liste:
            List<String> liste = new ArrayList<>();
            List<Integer> listra = new ArrayList<>(List.of(3, 1, 5, 2, 4)); // introduit dans Java9 qui permet de créer une liste non modifiable contenant les éléments spécifés
            // Ajout et suppression d'éléments
        liste.add("element");
        liste.add(1, "ennuye"); // pour spécifier l'index ou l'élément doit être inséré
        liste.remove(0); // suppression du première élément
            // Accés aux éléments
        String premierElement = liste.get(0);
            // parcours de la liste
        for(String element : liste) { // foreach: permet de parcourir les éléments d'une collection en Java
            System.out.println(element);
        }
            // taille de la liste
        int taille = liste.size();
            // modification d'élément
        liste.set(1, "Fort");
            // vérifié la présence de l'élément
        boolean contientB = liste.contains("B");
            // vérifie si la taille de la liste est vide
        boolean listevide = liste.isEmpty();

                // Set
        // Représente une collection d'élément uniques, c-a-d qu'aucun doublon n'est autorisé. Les ensembles ne garantissent pas l'ordre des éléments.
            // declaration Set
        Set<String> ensemble = new HashSet<>();
            // ajout d'éléments à l'ensemble
        ensemble.add("A");
        ensemble.add("B");
            // suppréssion d'élément
        ensemble.remove("B");
            // suppression de tous les éléments
        ensemble.clear();
            // vérification de la présence de l'élément "B" dans l'ensemble
        boolean contientB = ensemble.contains("B");
        if(contientB){
            System.out.println("L'ensemble contient l'élément");
        } else {
            System.out.println("L'ensemble ne contient pas l'élément");
        }
            // la taille de l'ensemble
        int taille = ensemble.size();

                // Map
        // Représente une collection d'association clé-valeur, ou chaque élément est une paire clé-valeur. Les clés sont uniques dans une carte, mais les valeurs peuvent être dupliquées.
            // Declaration et initiation de  Map
        Map<String, Integer> map = new HashMap<>(); // Declaration avec des clé de type String et des valeur de type Integer
            // ajout élément à la Map
        map.put("a", 1); // dans la clé "a" se trouve la valeur 1
        map.put("b", 2);
            // récupération de la valeur associé à un clé
        int valleur = map.get("b"); // valleur contiendra 2
            // vérification de la présence d'un clé
        boolean existe = map.containsKey("a");
            // vérification de la présence d'un valeur
        boolean contientValeur = map.containsValue(3);
            // suppression d'un élément par clé
        map.remove("a");
            // obtenir la taille
        int taille = map.size(); // taille contiendra le nombre d'éléments dans la Map
            // effacement de tout les éléments
        map.clear();
        
                // Class Collections
        // La Collection fournit un ensemble de méthodes utilitaires pour effectuer des opérations courantes sur les collections en Java
        List<Integer> lista = new ArrayList<>(List.of(7, 5, 5, 4, 9));
            // Tri de collections
        Collections.sort(lista); // permet de trier une liste dans l'ordre naturel de ses éléments
            // Recherche binaire
        int index = Collections.binarySearch(liste, 3); // permet de rechercher l'index d'un élément dans une liste trié en utilisant l'algorithme de recherche binaire.
            // Mélange aléatoire
        Collections.shuffle(liste); // permet de mélanger aléatoirement les éléments d'une liste
            // Inversion d'ordre
        Collections.reverse(liste); // permet d'inverser l'ordre des éléments dans une liste
            // Creation d'une liste immuable
        List<Integer> listeImmu = Collection.unmodifiableList(liste); // permet de créer une vue non modifiable d'un ensemble existant

                // Collection ordonnées
        // 'SortedSet' et 'SortedMap' sont utiles lorsqu'on a besoin de stocker des éléments dans un ordre spécifique déterminé par leur nature
        // Elle offrent un accées rapide aux éléments triés sans nécessiter de tri supplémentaire
            // SortedSet
        SortedSet<String> sortedSet = new TreeSet<>();
        sortedSet.add("banana");
        sortedSet.add("apple");
        sortedSet.add("orange");
        System.out.println(sortedSet); // affiche: [apple, banana, orange]
            // SortedMap
        SortedMap<Integer, String> sortedMap = new TreeMap<>();
        sortedMap.add(2, "two");
        sortedMap.add(3, "three");
        sortedMap.add(1, "one");
        System.out.println(sortedMap); // affiche: [1=one, 2=two, 3=three]

                // Class Exception
        // Les exceptions sont généralement utilisé pour signaler des erreurs ou des conditions exceptionnelles qui se produisent pendant l'exécution d'un programme
            // try-catch
        try{
            int result = divide(10, 0);
            System.out.println("Le résultat de la division est: " + result);
        } catch (ArithmeticException e){ // si une erreur 'ArithmeticException' est levé, elle est attrapée par le bloc 'catch'
            System.out.println("Une exception s'est produite: Division par zéro !");
        }
            // throws
        // est utilisé pour déclarer que la méthode peut lancer une exception particulire. signifie que la méthode ne gère pas l'exception elle-même, mais plutôt qu'elle la propage à l'appelant
        // public static void main(String[] args) throws InterruptedException {
            System.out.println("Début du programme");
            Thread.sleep(1000); // Utilisation de Thread.sleep qui peut lancer une InterruptedException
            System.out.println("Fin du programme");
        // }
            
            // finally
        // Elle est utilisé en conjonction avec les blocs 'try-catch'.Le bloc 'finally' est généralement utilisé pour effectuer des opérations de nettoyage ou de libération des ressources, telles que la fermeture des fichiers ou la libération de la mémoire, afin de garantir que ces opérations sont toujours exécutées, même en cas d'exception.
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("file.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Une erreur s'est produite lors de la lecture du fichier !");
        } finally {
            try {
                if (reader != null) {
                    reader.close(); // Fermeture du lecteur de fichier
                }
            } catch (IOException e) {
                System.out.println("Une erreur s'est produite lors de la fermeture du fichier !");
            }
        }
            // cas d'exceptation multiple
        try {
            // Tentative de connexion à une base de données
            connectToDatabase();
            // Tentative de lecture d'un fichier
            readFile();
        } catch (DatabaseConnectionException | SQLException e) { // utiliser le caractère pipe('|') pour séparer les types d'exceptions à attraper
            System.out.println("Erreur de connexion à la base de données : " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("Fichier introuvable : " + e.getMessage());
        }

                // RuntimeException et Error: Les exceptions de type "Unchecked"
        // Les exceptions vérifiées sont celles qui doivent être soit capturées (avec un bloc try-catch) soit déclarées dans la signature de la méthode à l'aide du mot-clé throws. 
        // les exceptions non vérifiées sont celles qui ne nécessitent pas d'être capturées ou déclarées. Elles sont généralement des erreurs qui surviennent pendant l'exécution du programme en raison de bugs ou d'erreurs de logique, et elles sont généralement des sous-classes de RuntimeException. 

                // Mot-clé Final
        // le mot-clé final peut être appliqué à des variables et des classes pour indiquer qu'ils sont imodifiables ou é tendus, selon le contexte.
            // variable Final
        // lorsqu'un variable est déclaré 'final', son contenu ne peut être modifié une fois qu'il a été initialisé
        final String message = "Hello";
            // Méthodes Final
        // lorsqu'une méthode est déclarée 'final', elle ne peut pas être redéfinie ou modifiée par les classes dérivées(sous-classes). Cela permet de garantir que le comportement de la méthode ne change pas dans les sous-classes
    }
}
        class Parent{
            public final void display(){
                System.out.println("Parent Class");
            }
        }
        class Child extends Parent{
            // Erreur: On ne peut pas redéfinir une méthode finale
            public void display(){
                System.out.println("Child Class");
            }
        }
            // Classes Final
        // lorsqu'une classe est déclaré 'final', elle ne peut pas être étendue, c'est a dire qu'aucune classe ne peut pas hériter de cette classe finale
        final class FinalClass {
            
        }
        // Errreur: On ne peut pas étendre une classe final
        class SubClass extends FinalClass{

        }


class Animal {
    public void manger() {
        System.out.println("L'animal mange");
    }
    public Animal cri(){
        System.out.println("Cri de l'animal");
        return this;
    }
}
class Chien extends Animal {
    public void aboyer() {
        System.out.println("Le chien aboie");
    }
    public Chien cri(){
        System.out.println("Wouaf!");
        return this;
    }
}
