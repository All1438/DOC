# permet de faire un commentaire
pwd = Print Working Directory (Affiche le dossier de travail)

cd nom_dossier = Change Directory (Changer de dossier) pour entrer dans le dossier
cd ../.. = pour remonter sur l'ancien dossier
cd nom_dossier/nom_dossier = pour entrer directement dans le second dossier

ls = pour voir ce qui est a l'intérieur du dossier
ls -a = affiche les fichiers cachés 
ls -l = affiche les fichiers sous forme de liste longue (date, nombre_dossier)
ls -la = qui combine l'affichage -a et -l (affiche tout)
ls -R = permet de voir la liste et a la fois les dossier et fichier contenu dans le dossier
ls -t = permet de trier les éléments de plus récent au plus ancien
ls -tl
ls nom_dossier = affiche ce qui contient le dossier enfant
ls <chemain> = affiche ce qui contient les dossiers ou fichiers dans ce lien
man ls = permet d'afficher le manuel du terminal

clear = pour effacer tout les lignes dans le terminal

mkdir nom_dossier = permet de créer un dossier
mkdir ../nom_dossier = permet de créer un dossier parent
mkdir nom_dossier/dossier_a_creer = permet de créer un dossier dans le nom_dossier
mkdir nom_dossier nom_dossier = permet de créer 2 dossier a la fois
mkdir nom_dossier/{css,js} = permet de créer 2 dossier dans le nom_dossier
mkdir -p nom_dossier/css/js = permet de créer un dossier js qui est dans css et qui est dans nom_dossier

touch nom_fichier = permet de créer un fichier 
touch nom_fichier nom_fichier = permet de créer 2 fichiers a la fois
touch 'nom ficher' = permet de créer un fichier qui a une nom avec une espace
echo text > nom_fichier = permet d'ecrire un text dans un fichier

tab = auto completion du nom de dossier

rm -r nom_dossier = pour le supprimer un nom_dossier
rm nom_fichier = pour supprimer un nom_fichier
rm -rf nom_dossier_cacher = pour supprimer un dossier caché
rm nom_fichier nom_fichier = pour supprimer plusieur fichier a la fois

git --version = permet de voir la version de git
git init = permet d'initialiser un projet git

# Configuration de GIT
git config = permet de voir et de modifier les variables de configuration de git
git config --global user.name "nom" = permet de créer un nom d'utilisateur de git
git config --global user.email Email = permet de mettre un Email a l'utilistateur
git config --global core.editor "code --wait" = permet d'ouvrir la visual code pour les éditeur
git config --global -e = permet d'ouvrir la paramètre(.gitconfig)
git config --global core.autocrlf true
git config --global --list = affiche nom et mail

git status = permet de voir les status de mon projet(modification, des fichier qui ne sont pas traquer)
git ls-files <path/fichier> = permet de vérifier si le fichier est tracé par git. il affiche quelque chose si oui.

git add nom_fichier = permet d'ajouter le fichier dans le commit
git add --all = permet d'ajouter tout les fichier modifier
git add *.txt = ajoute tout fichier qui est .txt
git commit -m"message" = permt de faire une sauvegarde et -m pour faire une petite message
git commit -am"message" = permet de faire une ajout a tout les fichiers et commit a la fois

git log = permet de voir les différente commit déja fait avant(with detail) et voir les sha
git log = permet de voir tout les commit (sauvegarde)
git log --pretty=oneline = permet de voir tout les commit en une seul ligne
git log --all --decorate --oneline --graph = permet d'afficher le graph

git log -p || git show sha = permet de voir les contenues du commit et le compare avec le plus récent
    les couleurs rouges indique que c'est supprimer
    les couleurs verts indique que c'est ajouter
    "@@ -2,7 +2,14 @@" indique que les modifications commencent à la ligne 2, colonne 7 du contenu original et se terminent à la ligne 2, colonne 14 du contenu modifié.

git diff = permet de voire la différence du changement
git diff nom_fichier = permet de voire seulement la modification dans ce fichier
git diff sha2 sha1 = permet de comparer 2 commit différente
git diff sha2 sha1 nom_fichier = permet de comparer 2 seulement sur le fichier indiquer
git diff <nom_branch> <nom_branch> = permet de comparer 2 branches

git checkout -b <nom_branch> = permet de créer une nouvelle branche et switcher vers ce branche
git checkout <sha> = permet de revenir dans le commit de l'identifiant sha(3c22163). après cela on n'est pas dans notre branche defini
git checkout -b <nom_branch> <sha> = permet de merger cette commit dans la nouvelle branch

git checkout <nom_branch> = permet de naviguer dans le nom_branch

git restore source=sha nom_fichier = permet de restaurer le fichier indiquer depuis la source sha 
git restore nom_fichier = permet de restaurer le fichier indiquer depuis la master

git reset sha = permet de supprimer le commit après le sha indiquer et garde les modification
git reset --hard sha = permet de supprimer les commit après le sha indiquer et ne garde aucun modification
git reset --hard HEAD = permet de revenir dans la dérnière commit et ne pas garder aucun modification

git branch nom_branch = permet de créer un branche mais reste dans le branch actuel
git branch = permet de voire les noms de branche déjà existant
git switch nom_branch = permet de se mettre sur le branche indiquer a partir du nom de la branche

git merge nom_branch -m"message" = permet de fusioner les 2 branches master et le 'nom_branche' avec une nouvelle commit suivant (il faut se deplacer dans la branches master pour le fusioner avec merge) #pull request
git merge --abort = permet d'anuler un merge
git rebase master = permet de rassembler les 2 branches en une seul ligne mais le (le master n'a pas la modification de l'autre branche) il faut être dans l'autre branche pour l'executer

git init --bare = permet d'initialiser un repo (dans le repo)
git remote add origin nom_remote lien-github.com = permet de créer un repo avec l'adresse indiquer (dans l'user)
git remote = permet de lister tout les remotes créer
git remote -v = pour vérifié rapidement les référenciels distants configurer pour le projet Git et les URL associé à ces référenciels
git remote rm origin = permet de supprimer un remote

git reset --hard HEAD = permet de revenir dans la dérnière commit

git push -u nom_remote master = faire un repo de la branche master dans le repo indiquer(nom_remote)

git clone lien-github.com . = permet de copier les contenue du repo dans l'espace de travail
git pull nom_remote nom_branche = récupère les modifications du dépot distant, puis les fusionne auto avec la branche de travail local.
git fetch nom_remote nom_branche = récupère les modifications du dépôt distant, mais ne les fusionne pas automatiquement avec votre branche locale.ne modifie pas la répertoire de travail ni la branche locale.
    usage fetch: souhaîte voir les modifications dans le dépôt distant, mais on n'est pas prêt à les fusionner dans la branche cible.

 git remote add origin https://github.com/All1438/Base-HTML.git

git tag <version> = permet de spécifier un numéro de version



 user name: madaetechnando-at-557817906902
 password: eQuv5TIMG86Jq3B6RPBb8RTNdRDS+Ov8lNqzBWZuRHI=

    //Alias (permet d'ajouter des racourcis)
 git config --global alias.co checkout // git co pour executer checkout
                    alias.br branch
                    alias.ci commit
                    alias.st status
                    alias.lo log --retty=oneline
Branche hotfix


    // .gitignore
fichier_a_ignorer.txt // ignorer un fichier spécifique
*.log //
dossier_a_ignorer/  // Ignorer les fichiers dans un répertoires spécifique
dossier_a_ignorer/* 

<!-- Puller une branche remote directement -->
git checkout -b <nom_branch>
git pull origin <nom_branch_remote>

# Revenir à un commit
<!-- Revenir à un commit en écrasant les modifications -->
git reset --hard <commit-hash>
<!-- Revenir à un commit sans écraser les modifications -->
git checkout <commit-hash>
git reset --soft <commit-hash> // conserver la modif dans ton espace de travail
git reset --soft HEAD~1 // désigne le commit juste avant le dernier commit

# branche
### Renommer une branche
git branch -m <nom_branch>

### supprimer la branche
git branch -d <nom_branch>

### Voir les branches remote
git branch -r
git branch -a <!--voir les branches remotes et local--> 

### Supprimer une branche remote
git push origin --delete <nom_branch>

# Changer la branche par défaut d'un dépôt local
git symbolic-ref refs/remotes/origin/HEAD refs/remotes/origin/master // Cela configure origin/HEAD pour qu'il pointe vers la branche master au lieu de la branche par défaut actuelle

# Git worktree
`Ajouter un Worktree`
git worktree add <path> <nom_branch>

` Lister les worktrees`
git worktree list

`Supprimer un worktree`
git worktree remove <path>

# Git Merge
git checkout <branche-cible> <!--Positionner sur la branche cible-->
git merge -s ours <branche-source> <!--Fusionner la branche source en écrasant les changements de la branche cible-->
git checkout <branche-source> -- . <!--Appliquez le contenu de la branche source-->
git add .
git commit -m "<message>" <!--Valider le changement-->

# nettoyer les modifications locales sans toucher à l'historique
git checkout -- .
git clean -fd

# use token avec gitHub
git config --global credential.helper store <!--Enregistre le token lors du prochain auth>

