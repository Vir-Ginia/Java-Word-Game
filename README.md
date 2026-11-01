# Java Word Game

A console word game using a dictionary file, random starting words and validation of player input.

## Included work

- `src/main/java/Main.java`: original game implementation.
- `dictionary.txt`: the supplied word dictionary.
- `pom.xml`: Maven project configuration targeting Java 11.

The game checks dictionary membership, validates words, tracks previous entries and handles empty input and game termination.

## Run

With Java 11 or later installed, run these commands from the repository root so the relative dictionary path resolves:

```bash
javac -d out src/main/java/Main.java
java -cp out Main
```

The source reads `dictionary.txt` from the current working directory. The original implementation is retained; generated `.class` files and Maven build outputs are excluded. A Java compiler was unavailable in the upload environment, so the game was not rebuilt or played here.

Virginia Eduwa — academic Java project.
