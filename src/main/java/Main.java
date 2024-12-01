import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        LocalDate date = LocalDate.now();
        Path dayPath = Paths.get("C:\\Users\\25404\\Desktop\\JavaWorkspace\\Leetcode\\src\\main\\java",
                "y" + date.getYear() % 100,
                "m" + date.getMonthValue(),
                "d" + date.getDayOfMonth());
        Files.createDirectories(dayPath);
        Integer maxP = Arrays.stream(Objects.requireNonNull(dayPath.toFile().listFiles(new FileFilter() {
                    @Override
                    public boolean accept(File pathname) {
                        return pathname.getName().startsWith("p");
                    }
                }))).map(e ->{
                    try {
                        return Integer.parseInt(e.getName().substring(e.getName().indexOf("p") + 1));
                    }catch (Exception ex){
                        return 0;
                    }
                })
                .max(Comparator.naturalOrder()).orElse(0);
        Path path = Paths.get(dayPath.toFile().getAbsolutePath().toString(), "p" + (maxP + 1));
        Files.createDirectories(path);
        String abPath = path.toAbsolutePath().toString();
        Path file = Files.createFile(Paths.get(abPath, "Solution.java"));
        String pack = abPath.substring(abPath.indexOf("java") + 5).replaceAll("\\\\", ".");
        try(BufferedWriter writer = Files.newBufferedWriter(file, StandardCharsets.UTF_8)) {
            writer.write("package "+pack+";\n\n");
        }
    }
}
