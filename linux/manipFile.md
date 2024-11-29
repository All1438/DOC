# PDF
sudo apt-get install pdftk // package permet de manipuler les pdf
## Découper le pdf
pdftk <fichier.pdf> cat <1-16> output <new_file.pdf> // permet de découper les pages de 1 jusqu'a 16 et l'enregistrer dans new_file.pdf
## Concatenation
pdftk <fichier1.pdf> <fichier2.pdf...> cat output <new_file.pdf>


# CSV
## Comparaison fichier CSV
diff <fichier1.csv> <fichier2.csv>