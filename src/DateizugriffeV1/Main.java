package DateizugriffeV1;

public class Main {
    public static void main(String[] args) {

        String path = "subtest.txt"; // just filename == in root of project
        System.out.println(FileUtility.fileExists(path));
        System.out.println(FileUtility.fileList(".."));
        FileUtility.recFileStructure("src");
        System.out.println(FileUtility.readFileLineByLine("test.txt"));
        System.out.println(FileUtility.writeLineByLine("../blubb.txt", new String[] {"niklas", "elisabeth", "alex"}, false));
    }
}
