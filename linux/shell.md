    // comparaison
=, !=, <, >, <=, >= // est utilisé pour comparé des chaine de caractère
-eq, -ne, -lt, -gt, -le, -ge // est utilisé pour comparé des nombres

=~ // comparaison égal pour les motif régulier(utilisé dans le domaine de recherche)
ex: [[ "$note" =~ ^[0-9]+$ ]]

    // motif régulier
^[0-9]+$
    ^: Indique le début de la chaine
    [0-9]: signifie n'importe quel chiffre de 0 à 9
    +: signifie qu'il y a au moins un chiffre
    $: indique la fin de la chaine

    // effectuer un opération arithmétique
variable = $((...)) // opération arithmétique normal
variable = $(echo "..." | ...) // une commande composé de 2 parties avec un pipeline(|) qui redirige la sortie de 'echo' vers 'bc' par exemple (stockée les valeur dans un chaine de caractère)
variable = ($()) // une commande composé de 2 parties avec un pipeline(|) qui redirige la sortie de 'echo' vers 'bc' par exemple (stocké les valeurs dans un tableau)