Tiny Movie Picker

A minimal Java Swing application that demonstrates core concepts from chapters 11-14:
- Data structures: List, Set, Map-ish usage
- Streams and lambdas for filtering
- Exception handling with dialogs for risky operations
- Swing GUI with event listeners, inner class Timer, custom paint (small spinner)

How to compile and run (Windows PowerShell):

javac -d out -sourcepath src src\MoviePicker\Main.java src\MoviePicker\Movie.java
java -cp out MoviePicker.Main

Notes:
- Requires Java 8+ (JDK). No build tool required.
- The app is intentionally tiny and self-contained.
