import java.nio.file.*;

public class UtilityAPIs {
    public static void main(String[] args) throws Exception {
        var config = java.util.Map.of("input", "input.txt", "output", "output.txt");

        var input = config.get("input");
        var output = config.get("output");

        var content = Files.readString(Path.of(input));
        var lines = content.lines().toList();

        var report = new StringBuilder();
        for (int i = 0; i < lines.size(); i++) {
            var line = lines.get(i);
            if (line.isBlank()) continue;
            var wordCount = line.strip().split("\\s+").length;
            report.append("Line ").append(i + 1).append(": ").append(wordCount).append(" words\n");
        }

        Files.writeString(Path.of(output), report.toString());
    }
}
