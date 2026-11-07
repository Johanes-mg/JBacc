<div align="center">
  <img src="logo.png" alt="JBacc Logo" width="120">

  <h1 align="center">JBacc</h1>

  <h3 align="center">Revision Bac Madagascar</h3>

  <p><strong>Application Android de revision pour les eleves de Terminale a Madagascar : sujets d'examen et corriges du Bac, organises par parcours, serie et matiere.</strong></p>

  <p>
    <img src="https://img.shields.io/badge/Built%20with-Kotlin-purple?logo=kotlin" alt="Kotlin">
    <img src="https://img.shields.io/badge/UI-Material%20Components-green?logo=materialdesign" alt="Material Components">
    <img src="https://img.shields.io/badge/Platform-Android-lightgrey?logo=android" alt="Android">
    <img src="https://img.shields.io/badge/Min%20SDK-21-blue" alt="Min SDK 21">
    <img src="https://img.shields.io/badge/Version-1.3-brightgreen" alt="Version 1.3">
  </p>
</div>

---

## Fonctionnalites

- **Sujets d'examen** : annales officielles du Bac malgache de 1999 a 2023.
- **Corriges** : disponibles pour plusieurs matieres et series.
- **Organisation claire** : navigation par parcours, serie, matiere, puis document.
- **Tri automatique** : les sujets apparaissent avant les corriges.
- **Visualisation externe** : ouverture des PDF, images et presentations via l'application de votre choix.
- **Partage facile** : envoi d'un document vers une autre application.

---

## Apercu

### Ecran d'accueil

<img src="captures/jbacckotlin_2.jpg" width="320" alt="Accueil"/>

### Choix de la serie

<p>
<img src="captures/jbacckotlin_3.jpg" width="320" alt="Serie A1/A2"/>
<img src="captures/jbacckotlin_4.jpg" width="320" alt="Serie C/D"/>
</p>

### Liste des matieres

<img src="captures/jbacckotlin_5.jpg" width="320" alt="Matieres"/>

### Sujets et corriges

<p>
<img src="captures/jbacckotlin_6.jpg" width="320" alt="Sujets"/>
<img src="captures/jbacckotlin_7.jpg" width="320" alt="Corriges"/>
</p>

### Ouverture d'un document

<img src="captures/jbacckotlin_8.jpg" width="320" alt="PDF"/>

---

## Matieres couvertes

- Mathematiques
- Physique-Chimie
- Sciences de la Vie et de la Terre (SVT)
- Histoire-Geographie
- Malagasy
- Philosophie
- Anglais
- Francais

---

## Series disponibles

- Serie C
- Serie D
- Serie A1
- Serie A2

---

## Telechargement

| Fichier | Version | Taille |
|---------|---------|--------|
| JBacc-1.3-release.apk | 1.3 | ~120 Mo |

---

## Prerequis

- Android 7.0 (API 24) ou superieur.
- Un lecteur PDF installe (Google Drive, Adobe Acrobat, MuPDF, etc.).

---

## Installation

1. Telechargez le fichier `JBacc-1.3-release.apk`.
2. Activez « Sources inconnues » dans Parametres > Securite.
3. Ouvrez le fichier APK et appuyez sur « Installer ».
4. Lancez l'application JBacc.

Remarque : si une version anterieure de JBacc est installee avec une signature differente, desinstallez-la avant d'installer la nouvelle version.

---

## Contenu disponible

### Sujets par serie et par matiere

| Matiere | Serie A | Serie C | Serie D |
|---------|---------|---------|---------|
| Mathematiques | 1999-2023 | 2000-2023 | 1998-2023 |
| Physique-Chimie | 2014-2023 | 2005-2023 | 1999-2023 |
| SVT | 2014-2023 | 2013-2023 | 2000-2023 |
| Histoire-Geographie | commun A/C/D : 1999-2023 | | |
| Malagasy | 2013-2023 | commun C/D : 2013-2023 | |
| Philosophie | 2013-2022 | commun C/D : 2013-2023 | |
| Anglais | 2015-2022 | commun C/D : 2015-2023 | |
| Francais | 2013-2023 | commun C/D : 2013-2023 | |

### Corriges

Les corriges sont fournis pour les matieres suivantes, lorsque disponibles :
- Mathematiques (series A et D)
- Physique-Chimie (series A, C et D)
- SVT (series A et D)

---

## Notes de version

### Version 1.3

- Refonte complete de l'interface : theme Material, couleurs harmonisees, boutons arrondis.
- Suppression du module Lecons : l'application se concentre sur les sujets et corriges.
- Ajout de la matiere Francais.
- Extension des series couvertes (A1, A2, C, D) pour toutes les matieres.
- Tri automatique : sujets avant corriges dans chaque liste.
- Compression des PDF : reduction d'environ 27 % de la taille des assets (150 Mo -> 111 Mo).
- Optimisation memoire : cache des listes d'assets, recyclage des vues via RecyclerView.
- Configuration R8 full mode, resource shrinking et baseline profile pour des performances optimales.
- Correction du theme : passage a Theme.MaterialComponents pour eviter le plantage au demarrage.

### Version 1.2

- Version initiale stable.
- Navigation par parcours et serie.
- Visualisation des PDF.

---

## Auteur

Johanes Falitiana

## Licence

MIT

---

## Remerciements

Les contenus pedagogiques (sujets et corriges) proviennent de :

- CNTEMAD
- Lycee Presentation de Marie
- Autres etablissements scolaires ayant contribue a la diffusion des ressources educatives.

Les sources ne sont pas produites par l'auteur du projet. Elles sont citees dans les documents respectifs.

---

*« Le succes n'est pas un hasard, mais le resultat de la perseverance et du travail. »*
