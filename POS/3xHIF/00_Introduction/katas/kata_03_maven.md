# Kata 3: Maven

| Field | Value |
|-------|-------|
| Concepts | Maven build, multi-class project, dependencies |
| Difficulty | 3/5 |
| Duration | approx. 20 min |

### Task

Create a Maven Java project with the following structure:

1. A `main` class that reads a text file from the resources directory
2. A utility class `StringUtils` with a method `wordCount(String text)` that counts words
3. Use Google Guava as a dependency and use `com.google.common.base.CharMatcher` in your word count
4. Print the word count for the given resource file

### Extension

Add a second utility that finds the most frequent word in the text using streams.
