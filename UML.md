# UM
UML est utilisé dans divers contextes du développement logiciel, notamment pour la modélisation des systèmes orientés objet
        
## Les relations
La multiplicité: permet de representer le nombre minimum et maximum d'instances, qui sont autorisé à participer à la relation

La dépendance: C'est une relation dans laquelle une classe tire parti d'une autre classe, de ce fait si un changement s'opère dans une classe cela pourrait affecter une autre classe
    // representation
        ----------------->
    // ex: Schedule ---> Meeting

L'héritage: C'est une relation dans laquelle une classe fille (ou sous classe) est la spécialisation d'une classe appelée classe mère (ou classe parent)
    // representation
        Une flèche fermée et un trait continue
    // ex : CheckingAccount ---> BankAccount <--- SavingAccount

L'association: est ma relation de communication entre deux classes. Ce qui induit qu'une classe A possède un attribut représentant le type de classe B.
    // representation
        Une flèche ouvert représentant le sens de la relation [unidirectionnel] elle peut également être bidirectionnelle
         1     0...*
        <___________>

L'agregation : C'est une type spécial d'association qui permet de définir une relation forte, mais pas obligatoire entre deux classes. si on supprime l'autre class l'autre ne sera pas supprimer même si il y a une dépendance.
    // representation (losange vide)
         1     0...*
        ¤___________
    // ex: Library <-- Livre

La composition: C'est un type spécial d'association qui permet de définir une relation forte et obligatoire entre deux classes. si on supprime la classe A alors l'autre classe ne peut plus exister.
    // representation (losange plein)

    // ex: Livre <-- Chapter <-- Page


        // interface
L'interface: permet de définir un ensemble de caractéristiques et d'obligations. Elle permet de spécifier un contrat avec la classe qui l'implémente

Les énumérations: C'est un type de données dont les valeurs sont énumérées dans le modèle en tant que littéraux d'énumérations définis par l'utilisateur
 Ne nécessite pas de flèche de liaison dans le diagramme de classe
ex:
    enum AccountType {
        ADMIN,
        USER,
        CLIENT,
        OWNER
    }
    class Account {
        private LocalDate creationDate;
        private String status;
        private AccountType accountType;
    }

Les notes: permettent d'annoter un élément spécifique sur le diagramme avec du texte normal ou du texte HTML
    // representation
    Representé par un rectangles avec un des sommets plié

Les "Derived attributes": sont des attributs qui sont calculés sur la base d'autres attributs de la classe
    // representation
    Ils sont représentées par un slash (/) précédent le nom de l'attribut (/age: int
    )
ex: Users under 16 years of age aren't allowed to sign up
    class User {
        private final String name;
        private final LocalDate dateOfBirth;
        private final int age;

        public User(String name, LocalDate dateOfBirth) {
            this.name = name;
            this.dateOfBirth = dateOfBirth;

            this.age = LocalDate.now().getYear() - dateOfBirth.getYear();
        }
    }