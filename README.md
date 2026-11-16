# Hydromel

Mod Minecraft **Forge 1.20.1** : hydromel, distillerie, boissons et effet "Drunk".

À l'origine créé avec MCreator, puis repris en Java classique (sources retrouvées par décompilation de la v1.0.4).

## Prérequis

- JDK 17 (Gradle le détecte via `JAVA_HOME` ou le télécharge automatiquement avec la toolchain)

## Commandes

```bash
./gradlew renameJar     # build -> build/libs/hydromel-<version>.jar (jar à mettre dans mods/)
./gradlew runClient     # lance un client de dev
./gradlew runServer     # lance un serveur de dev
```

`build/libs/hydromel-<version>-unobfuscated.jar` est la version avec noms Mojang, elle ne se lance pas en production.

## Stack

- Forge 47.4.29 / ForgeGradle 7 + plugin Renamer
- Mappings Parchment `2023.09.03-1.20.1`
