package DateizugriffeV1;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileUtility {
    public static boolean fileExists(String path) {
        Path p = Path.of(path);
        if (Files.exists(p))
            return true;
        else
            return false;
    }

    public static List<Path> fileList(String path) {
        Path p = Path.of(path);
        try (var files = Files.list(p)) {
            System.out.println(files);
            return files.toList();
        } catch (Exception e) {
            System.out.println("Directory doesn't exist or other error");
            e.printStackTrace();
            return null;
        }
    }

    public static void recFileStructure(String path) {
        Path p = Path.of(path);
        System.out.println(p.getFileName());
        recFileStructure(p, 1);
    }

    public static void recFileStructure(Path p, int depth) {

        try (var files = Files.list(p)) {
            files.forEach((f) -> {
                System.out.println("--".repeat(depth) + " " + f.getFileName());
                if (Files.isDirectory(f.toAbsolutePath())) {
                    recFileStructure(f.toAbsolutePath(), depth + 1);
                }
            });
        } catch (Exception e) {
            System.out.println("Directory " + p + " doesn't exist or other error");
            e.printStackTrace();
        }
    }

    public static List<String> readFileLineByLine(String path) {
        if (fileExists(path)) {
            Path p = Path.of(path);

            try {
                List<String> lines = Files.readAllLines(p);
                return lines;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error reading file");
                return null;
            }
        } else {
            return null;
        }
    }

    public static boolean writeLineByLine(String path, String[] lines, boolean append) {
//        if (fileExists(path)) {
        ArrayList<String> al = new ArrayList<>();
        Path p = Path.of(path);

        try {
            String all = "";
            for (String line : lines) {
                all += line + "\n";
            }
            if (append)
                System.out.println(Files.writeString(p, all, StandardOpenOption.APPEND));
            else
                System.out.println(Files.writeString(p, all));

            return true;
        }
        catch (
                Exception e) {
            e.printStackTrace();
            System.out.println("Error reading file");
            return false;
        }
    }
//        else {
//            return false;
//        }
//    }
}
