CREATE TABLE IF NOT EXISTS recipes( --CREATE TABLE nomTable(titre typeVar(taille)) = permet de créer un table
    -- IF NOT EXISTS = execute la creation de la table si la table recipes n'existe pas encore
    id INTEGER PRIMARY KEY AUTO_INCREMENT, -- PRIMARY KEY: type de clé primaire, AUTO_INCREMENT = augmenter a chaque insert d'un nouveau tableau
    title VARCHAR(150), -- titre suivi du type de variable
    slug VARCHAR(50) UNIQUE, 
                -- UNIQUE = la valeur défini sera unique
    content TEXT,
    duration SMALLINT DEFAULT 10, -- SMALLINT = integer de petite taille
                -- DEFAULT 10 = tout les valeur par défaut de duration sera 10
    online BOOLEAN,
    created_at DATETIME, -- de type date
    NOT NULL (slug, duration) -- autre façon de definir les variables si deux attributs qui se suivent
    -- NOT NULL = doit être défini pendant INSERT
);

ALTER TABLE recipes DROP slug; --ALTER TABLE nomTable DROP colonne; = permet de supprimer un colonne dans un TABLE
ALTER TABLE recipes ADD online BOOLEAN; --ALTER TABLE nomTable ADD colonne typeVar; = permet d'ajouter un colonne dans le TABLE
ALTER TABLE recipes ADD id INTEGER PRIMARY KEY AUTO_INCREMENT;
ALTER TABLE recipes RENAME TO post; -- permet de renomer le nom de la table recipes en post
ALTER TABLE post RENAME slug TO tag;
DROP TABLE IF EXISTS post; --permet de supprimer définitivement la table
INSERT INTO recipes( -- permet de modifié ou insérer les contenues dans la table
    title, slug, content, duration, online -- les valeurs modifié ou insérer sont de même ordre que le colonne
    ) VALUE (
        'pomme de fruit',
        'pomme de fruit',
        'Contenue de test',
        10,
        FALSE
    ), -- insertion plusieurs élément les un dérière les autres
    (
        'salade de fruit',
        'salade de fruit',
        'Contenue de test',
        10,
        TRUE
    );

SELECT title, online -- permet de retourner seulement les titre et ces contenues depuis(FROM) la TABLE
FROM recipes; -- nom de la table
SELECT * --* = permet de retourner tout les information depuis la table recipes
FROM recipes
WHERE duration < 20; -- WHERE = sous forme de CONDITION
-- retourner seulement tout les contenue de ce qui a duration < 20
SELECT *
FROM recipes
WHERE slug = 'pomme de fruit';
-- = condition d'égalisation
-- < inférieur
-- <= inférieur ou égal
-- != différent
-- AND et 
-- OR ou
-- IS comparaison de null (utilisé pour vérifié si une valeur est NULL)

SELECT *
FROM recipes
WHERE duration BETWEEN 0 AND 100; -- affiche si duration est entre 1 et 10
SELECT *
FROM recipes
WHERE slug IN ('pomme de fruit', 'salade de fruit'); -- affiche si il y a un de ces éléments dans son slug
SELECT *
FROM recipes
WHERE slug LIKE '%de%'; -- recupère tout les contenue contient 'de' dans slug, toujours mettre dans % % (mini-recherche)
SELECT *
FROM recipes
WHERE (slug = 'pomme de fruit' OR duration > 20) AND online = TRUE; --par défaut AND est prioritaire mais le () est ordre de l'operation



DELETE FROM recipes; -- permet de supprimer tout les enregistrement mais pas la table
DELETE FROM recipes ---permet de supprimé les contenu a partir d'un condition
WHERE id = 2; 

UPDATE recipes
SET title = 'Soupe de légume'; -- permet de mettre a jour tout les title en 'Soupe de légume'
UPDATE recipes
SET title = 'Soupe de légume'
WHERE title = 'pomme de fruit';-- mettre a jour tout les title = pomme de fruit en Soupe de légume

UPDATE recipes
SET content = NULL; -- permet de définir tout les contenues en NULL
CREATE UNIQUE INDEX idx_slug -- permet de dire que slug doit être une valeur unique sous forme index
ON recipes (slug); 

DROP INDEX idx_slug; -- permet de supprimer la valeur unique de slug, alors il peut avoir de même valeur


--EXEMPLE
DROP TABLE IF EXISTS categories;
CREATE TABLE IF NOT EXISTS recipes(
    id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
    title VARCHAR(100) NOT NULL,
    slug VARCHAR(100) NOT NULL UNIQUE,
    content TEXT,
    category_id INTEGER
);
INSERT INTO recipes(title, slug, category_id)
VALUES
    ('Creme anglaise', 'Creme anglaise', 2), -- un parenthèse égale un tableau
    ('Soupe', 'Soupe', 1),
    ('Salade de fruit', 'Salade de fruit', 2);
CREATE TABLE IF NOT EXISTS categories(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(50),
    description TEXT
);
INSERT INTO categories(title)
VALUES ('Plat'),
        ('Dessert');
ALTER TABLE recipes ADD FOREIGN KEY (category_id) REFERENCES categories (id) ON DELETE CASCADE; -- permet de lier les deux tableau a partir du variable category_id dans recipes et id dans category (ON DELETE NO ACTION par defaut)
-- ON DELETE NO ACTION = affiche encore la valeur si on affiche ensemble la table
-- ON DELETE CASCADE = si on supprime le champ categories du id alors le champ qui le lie aussi dans recipes sera supprimer aussi
-- ON DELETE SET NULL = si on supprime le champ alors affiche null si on affiche ensemble la table
SELECT *
FROM recipes r -- r = est une allias permet de abrevier le nom de la table
INNER JOIN categories c ON r.category_id = c.id -- permet d'afficher ces liaison entre le TABLE recipes et categories a partir du champ category_id et id (INNER JOIN est équivalent à JOIN)
WHERE c.title = 'Dessert'; -- l'ordre de l'écriture
SELECT r.id, r.title, c.title AS category -- affiche les champs a partir des allias
-- AS category = Permet de changer le nom du champ c.title en tant que category pendant l'affichage
FROM recipes r
LEFT JOIN categories c ON c.id = r.category_id; -- LEFT JOIN = affiche aussi même si son category_id dans recipes est NULL

--EXEMPLE:
CREATE TABLE IF NOT EXISTS recipes(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(50),
    slug VARCHAR(50) NOT NULL UNIQUE,
    duration SMALLINT,
    date DATETIME,
    user_id INTEGER,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS users(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE
);
CREATE TABLE IF NOT EXISTS categories(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100)
);
CREATE TABLE IF NOT EXISTS ingredients(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL
);
CREATE TABLE categories_recipes(
    recipe_id INTEGER NOT NULL,
    category_id INTEGER NOT NULL,
    FOREIGN KEY (recipe_id) REFERENCES recipes (id) ON DELETE CASCADE,
    FOREIGN KEY (category_id) REFERENCES categories (id),
    PRIMARY KEY (recipe_id, category_id),
    UNIQUE (recipe_id, category_id)
);
CREATE TABLE ingredients(
    id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name VARCHAR(50) NOT NULL
);
CREATE TABLE ingredients_recipes(
    recipe_id INTEGER,
    ingredient_id INTEGER,
    quantity INTEGER,
    unit VARCHAR(20),
    FOREIGN KEY (recipe_id) REFERENCES recipes (id) ON DELETE CASCADE,
    FOREIGN KEY (ingredient_id) REFERENCES ingredients (id) ON DELETE CASCADE,
    PRIMARY KEY(recipe_id, ingredient_id),
    UNIQUE(recipe_id, ingredient_id)
);
ALTER TABLE recipes ADD user_id INTEGER;
ALTER TABLE recipes ADD FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE;
ALTER TABLE recipes ADD duration SMALLINT DEFAULT 0 NOT NULL;
ALTER TABLE recipes DROP duration;
DROP TABLE IF EXISTS categories_recipes;
DROP TABLE IF EXISTS ingredients_recipes;
INSERT INTO users(username, email)VALUES
    ('Ali Nando', 'suprenando12@gmail.com');
INSERT INTO categories (title)VALUES
    ('Plat'),
    ('Desert'),
    ('Gateaux');
INSERT INTO recipes (title, slug, duration, user_id)VALUES
    ('Soupe', 'soupe', 10, 1),
    ('Madeleine', 'madeleine', 30, 1);
INSERT INTO categories_recipes (recipe_id, category_id)VALUES
    (1, 1),
    (2, 2),
    (2, 3);
INSERT INTO ingredients(name) VALUES
    ('Sucre'),
    ('Farice'),
    ('Levure chimique'),
    ('Beurre'),
    ('Lait'),
    ('Oeuf');
INSERT INTO ingredients_recipes(recipe_id, ingredient_id, quantity, unit) VALUES
    (2, 1, 150, 'g'),
    (2, 2, 200, 'g'),
    (2, 3, 8, 'g'),
    (2, 4, 100, 'g'),
    (2, 5, 1, 'l'),
    (2, 6, 3, NULL);
SELECT r.title, c.title as category
FROM recipes r
INNER JOIN categories_recipes cr ON cr.recipe_id = r.id
INNER JOIN categories c ON cr.category_id = c.id;
SELECT r.title
FROM ingredients i
JOIN ingredients_recipes ir ON ir.ingredient_id = i.id
JOIN recipes r ON r.id = ir.recipe_id 
WHERE i.name = 'Oeuf'; -- recupère le titre qui contient le Oeuf
SELECT *
FROM recipes r
LEFT JOIN ingredients_recipes ir ON ir.recipe_id = r.id
WHERE ir.recipe_id IS NULL; -- Affiche qui contient les recipe_id = NULL
SELECT r.title, ir.quantity, ir.unit, i.name as ingredient
FROM recipes r
JOIN ingredients_recipes ir ON ir.recipe_id = r.id
JOIN ingredients i ON i.id = ir.ingredient_id
ORDER BY quantity DESC -- ORDER BY...DESC = permet de trier par ordre decroissant si c'est un nombre et par ordre desalphabetique si c'est une STRING
-- ORDER BY quantity ASC = contraire de DESC
LIMIT 3; -- recupère que le première enregistrement
SELECT recipe_id, COUNT(*) -- COUNT(*) = permet de compter le nombre de ligne pour chaque groupe
FROM ingredients_recipes
GROUP BY recipe_id; -- GROUP BY = permet de regrouper les resultats en fonction de la colonne recipe_id
UPDATE ingredients_recipes
SET quantity = 10
WHERE recipe_id = 2 AND ingredient_id = 3;

SET BLOBAL local_infile = 'ON'; -- active le chargement de données locales sur le serveur:

LOAD DATA LOCAL INFILE ''

CREATE TABLE IF NOT EXISTS recipes(
    title VARCHAR(20),
    slug VARCHAR(50) UNIQUE,
    date_ DATETIME,
    duration SMALLINT DEFAULT 10
);

LOAD DATA LOCAL INFILE '/home/patrick/Ali Nando/SQL_extracteur/exemple2.csv' -- permet de loader un fichier dans le local
INTO TABLE extraction
FIELDS TERMINATED BY ';' ENCLOSED BY '"' -- Champ terminé
LINES TERMINATED BY '\n' -- line terminé
IGNORE 1 ROWS; -- ignorer la première ligne


 SELECT default_character_set_name, default_collation_name FROM information_schema.SCHEMATA WHERE schema_name = 'analyse_vde'; -- Permet de vérifier la collation de la base de données (ex: utf8mb4_0900_ai_ci)

-- CONFIGURATION MYSQL SUR SERVER
 CREATE DATABASE <nom_dataBase> --creation de la base de données
 CREATE USER '<nom_utilisateur>'@'<host>:<port>' IDENTIFIED BY '<password>' -- Creation de l'utilisateur et définition du mot de passe
 -- le port est par défaut 3306 et host doit être défini 'localhost'
 GRANT ALL PRIVILEGES ON <name_of_dataBase>.* TO '<nom_utilisateur>'@'localhost'; --Attribution des privilèges à l'utilisateur sur la base de données créer


-- SE CONNECTÉ A LA BASE DE DONNÉES
mysql -u <nom_utilisateur> -p <nom_DB> --permet de connecté à la base de données;

SELECT User, Host FROM mysql.user; -- permet de lister tout les utilisateur
SHOW DATABASES; -- permet de lister tout les dataBase existant
SHOW TABLES; -- permet de lister tout les tables dans la base de données
SHOW COLUMNS FROM <nom_table>; --permet d'afficher le nom de chaque colonne dans un table spécifique


SELECT agentExtracteur, COUNT(*) AS mauvais_CV 
FROM Sourcings 
WHERE agentExtracteur IN ('M', 'H', 'Mi', 'O', 'F', 'R') 
AND (LOWER(remarque) LIKE '%alternance%' OR LOWER(remarque) LIKE '%stage%' OR LOWER(remarque) IN ('pas de numéro', 'trop loin', 'critère d\'age', 'pas mobile idf/p')) 
GROUP BY agentExtracteur;


SELECT agentExtracteur, remarque, COUNT(*) AS nombre_de_donnees
FROM Sourcings
WHERE agentExtracteur IN ('F', 'M', 'Mi', 'O', 'R')
AND (LOWER(remarque) LIKE '%alternance%' OR LOWER(remarque) LIKE '%stage%' OR LOWER(remarque) IN ('pas de numéro', 'trop loin', 'critère d\'age', 'pas mobile idf/p'))
GROUP BY agentExtracteur, remarque
WITH ROLLUP;


SELECT agentExtracteur, remarque, COUNT(*) AS nombre_de_donnees
FROM Sourcings
WHERE agentExtracteur IN ('F', 'M', 'Mi', 'O', 'R')
AND (LOWER(remarque) LIKE ('%alternance%')
OR 
)
GROUP BY agentExtracteur, remarque
WITH ROLLUP;
