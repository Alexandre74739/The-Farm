# The Farm

Projet réalisé dans le cadre de la **Licence MIASHS Première année (L1)**.

## Description

The Farm est un jeu de simulation de ferme en mode texte, qui tourne entièrement dans le terminal. Le joueur gère un champ de 3 parcelles : il plante du maïs, attend qu'il pousse et le récolte pour gagner de l'argent.

### Règles du jeu

| Action | Détail |
|---|---|
| Planter | Coûte **10€**, choisir une parcelle vide |
| Pousser | Le maïs est prêt après **3 jours** |
| Récolter | Rapporte **25€**, la parcelle redevient vide |

Le joueur commence avec **100€**. Le jeu n'a pas de condition de fin imposée, on quitte quand on le souhaite.

### Exemple de partie

```
--- Jour 1 ---
Argent : 100€
Champs : [1: Vide] [2: Vide] [3: Vide]
1. Planter du maïs  (coût : 10€, pousse en 3 jours)
2. Récolter          (rapporte : 25€)
3. Passer au jour suivant
4. Quitter
Votre choix : 1
Dans quel champ planter ? (1 à 3) : 2
Maïs planté dans le champ 2.
```

---

## Prérequis

- **Java JDK 17 ou supérieur** — [télécharger sur oracle.com](https://www.oracle.com/java/technologies/downloads/)

Vérifier que Java est bien installé :
```bash
java -version
```

---

## Installation et lancement

### 1. Cloner le projet

```bash
git clone https://github.com/<votre-utilisateur>/The-Farm.git
cd The-Farm
```

### 2. Compiler

```bash
javac -d bin src/App.java
```

Le fichier compilé `App.class` sera généré dans le dossier `bin/`.

### 3. Lancer le jeu

```bash
java -cp bin App
```

---

## Structure du projet

```
The-Farm/
├── src/
│   └── App.java      ← code source
├── bin/
│   └── App.class     ← fichier compilé (généré automatiquement)
└── README.md
```