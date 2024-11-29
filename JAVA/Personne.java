package JAVA; // signifie que les class de type default dans ce dossier est accessible
package 

import java.util.Objects;

// Declare une classe
public class Personne {
    // Attributs
    private String nom;
    private int age;

    // Constructeur
    public Personne(String nom, int age){ // ce que les valeurs qu'on doit entrer dans l'instance
        this.nom = nom;
        this.age = age;
    }
    // Getter pour l'attribut nom (pour l'affichage)
    public String getNom() {
        return nom;
    }
    // setteur pour l'attribut nom ()
    public void setNom(String nom){

    }
    // Method (qui caractérise la classe)
    public void parler() { // void = ne retourne aucun résultat
        System.out.println("Bonjour, je m'appelle " + nom + " et j'ai " + age + " ans");
    }
}

    // Creation d'instance de classe
// permet de créer de nouveaux objets à partir de la classe définie
// Personne bohneur = new Personne("Ashley", 18);

    // encapsulation:
// consiste à encapsuler les attributs d'une classe en les déclarant comme privés et en fournissant des méthodes publiques pour accéder et modifier ces attributs.
// bohneur.setAge(1);
// bohneur.age = 1; si age n'est pas private
// System.out.println(bohneur.getAge());
// System.out.println(bohneur.age); // affiche si age n'est pas private

    // Heritage d'une classe parente:
// permet à une classe d'acquérir les attributs et les méthodes d'une autre classe (la classe parente)
class Employe extends Personne {
    // Attributs supplémentaires
    private double salaire;
    // Constructeur
    
    public Employe(String nom, int age, double salaire){
        super(nom, age);
        this.salaire = salaire;
    }
    // Méthod supplémentaire
    public void travailleur(){
        System.out.println("Je travaille");
    }
}

    // Private
// Lorsqu'un membre (attribut ou méthode) est déclaré "private", il est accessible uniquement à l'intérieur de la classe ou il n'est pas accessible à partir de l'extérieur de la classe, même par des instances.
// Les méthodes getter et setter (ou accesseurs et mutateurs) sont souvent utilisées pour accéder et modifier les attributs privés depuis l'extérieur de la classe de manière contrôlée.
    // Public
// Lorsqu'un membre est déclaré "public", il est accessible de n'importe ou dans le programme, à condition que le package (paquetage) dans lequel la classe est définie soit visible(importer).
// toute autre classe, qu'elle soit dans le même package ou non, peut y accéder en toute simplicité
    // Protected
// Lorsqu'un membre est déclaré "protected", il est accessible à partir de la classe elle-même, des classes dérivées(sous classe) et des autre classes dans le même paquetage(package: regroupement logique de classe).
// Contrairement à private, les membres protected peuvent être accessibles aux sous-classes, ce qui permet la réutilisation du code et la mise en œuvre du concept d'héritage.
    // Default
// Si aucun des mots-clés (private, public, protected) n'est utilisé, alors le membre est défini avec le niveau d'accès par défaut. Cela signifie qu'il est accessible uniquement à partir des autres classes dans le même paquetage.
// accessible uniquement à partir des autres classes dans le même package. Il n'est pas accessible à partir des classes dans d'autres packages(package c'est le script qui est définie en haut).

        // Interface
// Elle permettent de déclarer un ensemble de méthodes que les classes qui implémentent cette interface doivent fournir(suivre).
    // déclaration d'une interface
 // une ensemble de méthodes sans implémentation que les classes qui implémentent cette interface doivent fournir.
interface Vehicule {
    void demarrer();
    void arreter();
}
    // implémentation d'une interface
// une classe peut implémenter une ou plusieurs interface
class Voiture implements Vehicule { 
    public void demarrer() {
        System.out.println("Démarrage de la voiture");
    }
    public void arreter() {
        System.out.println("Arrêt de la voiture");
    }
}
    // héritage d'interface
// une interface peut étendre une ou plusieurs autre interface. cela signifie que l'interface fille héritera des méthodes déclarées dans les interfaces parentes.
interface VehiculeElectrique extends Vehicule {
    void recharger();
}
    // implémentation multiple d'interface
class VoitureElectrique implements Vehicule, VehiculeElectrique {
    // sans les implémentation de méthod il y a erreur .
}

        // Instanceof
// C'est un opérateur en Java qui est utilisé pour vérifier si un objet(class) et une instance d'un classe particulière, d'une sous-classe ou d'une classe qui implémente une interface spécifique.
    // utilisation (objet instanceof classe)

        // Abstract
// C'est un class qui ne peut pas être instanciée, c-a-d qu'on ne peut pas créer d'objets à partir d'une classe abstrait en utilisant l'opération "new".
// Une classe abstraite peut contenir des méthodes abstraites, qui sont des méthodes déclarées sans implémentation. Les méthodes abstraites sont marquées avec le mot-clé abstract.
// une classe abstraite peut également contenir des méthodes concrètes (avec une implémentation).
// Les classes abstraites sont souvent utilisées pour fournir une structure commune et du code partagé entre plusieurs classes filles.
    // exemple:
abstract class Forme {
    // Méthode abstraite pour calculer l'aire
    abstract double calculerAire();
    // Methode concrète pour afficher un message
    void afficherMessage() {
        System.out.println("Ceci est une forme");
    }
}
    // instantiation
// on ne peut pas instancier une classe abstraite. Cependant, on peut utilisé une classe abstraite comme type de référence:
// Forme forme; // Déclaration d'une référence de type Forme
    // implémentation:
class Cercle extends Forme {
    double rayon;
    Cercle(double rayon) {
        this.rayon = rayon;
    }
    // Implémentation de la méthode abstraite calculerAire pour un cercle
    double calculerAire() {
        return Math.PI * rayon * rayon;
    }
}

        // static
    // Champs statiques:
// Ils sont partagés entre toutes les instances de la classe. Ils sont généralement utilisés pour stocker des données qui doivent être partagées entre toutes les instances de la classe.
public class Exemplee{
    static int compteur;
    public Exemplee() {
        compteur++;
    }
}

    // Method statiques:
// Ce sont des méthodes qui peuvent être appelées sans avoir besoin de créer une instance de la classe. Elle sont souvent utilisés pour fournir des fonctionnalités unitaire qui ne dépendent pas de l'état spécifique de l'objet.
class MathUtil {
    public static int max(int a, int b){
        return (a > b) ? a : b;
    }
}
class Personnee {
    public static void main(String[] args){
        int result = MathUtil.max(10, 5);
        System.out.println("Le plus grand nombre est: " + result);
    }
}
    // import static
// permet d'accéder aux membre static directement par leur nom dans le code
// package utils;
public class MathUtil {
    public static int max(int a, int b){
        return (a > b) ? a : b;
    }
}
// import static utils.MathUtil.max;
public class Main{
    public static void main(String[] args){
        int result = max(10, 20); // Utilisation directe de la méthode max
        System.out.println("Le plus grand nombre est: "+ result);
    }
}


            // Comparaison
    //equals(Object obj) = cette méthode détermine si un objet est "équivalent" à un autre.
    // hashCode() = cette méthode retourne un entier (hash code) qui est utilisé pour déterminer l'emplacement de l'objet dans un structure de données qui utilise le hachage, comme "HashSet" ou "HashMap"
class Person {
    String name;
    int age;

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    @Override // @Override garantit qu'on nous ne faites pas simplement ajouter une nouvelle méthode qui n'a aucun rapport avec la méthode de la classe de base ou de l'interface qu'on pensent surcharger ou implémenter. mais indique que cette méthode remplace la méthode equals
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return age == person.age && Objects.equals(name, person.name);
    }
    @Override
    public int hashCode(){
        return Objects.hash(name, age);
    }

}

            // Notion de package d'import
// Si la classe n'est pas déclarée publique, elle ne peut pas être importée et utilisée dans d'autres packages.
// Fichier: Rectangle.java
// package.geometry; // la class sera dans le package geometry
public class Rectangle {
    private double width;
    private double height;
}
// Fichier: Circle.java
// package.geometry;
public class Circle {
    private double radius;
}
// Fichier: Main.java
// import geometry.Rectangle;
// import geometry.circle;
public class Main{
    public static void main(String[] args){
        Rectangle rectangle = new Rectangle(5, 10);
        Circle circle = new Circle(3.5);
    }
}
