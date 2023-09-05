## Be Proud API

This is a relatively simple API wrapper for the [be proud](https://modrinth.com/mod/be-proud) mod. You can install this alongside be proud, and use it to add your own custom flags using the foundations they put in place!

Please do not put issues relating to the original mod on this github page - I am not the original author of be proud.

This mod requires be proud installed to work.

## Developer Documentation

Add the mod to build.gradle:

```gradle
repositories { // Add modrinth's maven
    exclusiveContent {
        forRepository {
            maven {
                name = "Modrinth"
                url = "https://api.modrinth.com/maven"
            }
        }
        filter {
            includeGroup "maven.modrinth"
        }
    }
}

dependencies { // Add the mod as a dependency
    modImplementation "maven.modrinth:be-proud-api:DYeuzHlr" // Make sure to change the version to the one you want!
    modImplementation "maven.modrinth:be-proud:xOU4yztG" // Add be proud too
}
```

Now to add your custom flags, simply add this line of code

```java
public static final Flag TEST_FLAG = createFlag("test", false);
```

This will create a new flag, with the id "test" - The flag is not an LGBT flag so it is not added to the book (the bool value)

To finish off - you need some json files.

```java
resources/data/beproud/recipes/printer/test/large.json // Recipes, example from the mod author - https://github.com/Duqueeee/be-proud/tree/1.20.1/src/main/resources/data/beproud/recipes/printer/lesbian
resources/data/beproud/recipes/printer/test/standard.json
resources/data/beproud/recipes/printer/test/small.json
```
Now you have your flag! To add textures, they should go in:

```java
resources/assets/beproud/textures/block/flag/test/large.json // Textures, example from the mod author - https://github.com/Duqueeee/be-proud/tree/1.20.1/src/main/resources/assets/beproud/textures/block/flag/trans
resources/assets/beproud/textures/block/flag/test/standard.json
resources/assets/beproud/textures/block/flag/test/small.json
```
