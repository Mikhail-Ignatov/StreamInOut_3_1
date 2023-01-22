import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        StringBuilder log = new StringBuilder();

        List<File> dir = Arrays.asList(
                new File("C://Games/src"),
                new File("C://Games/res"),
                new File("C://Games/savegames"),
                new File("C://Games/temp"),
                new File("C://Games/src/main"),
                new File("C://Games/src/test"),
                new File("C://Games/res/drawables"),
                new File("C://Games/res/vectors"),
                new File("C://Games/res/icons")
        );

        List<File> file = Arrays.asList(
                new File("C://Games/src/main", "Main.java"),
                new File("C://Games/src/main", "Utils.java"),
                new File("C://Games/temp", "temp.txt")
        );


        dir.forEach(currentDir -> {
                    if (currentDir.mkdir()) {
                        System.out.println("Папка - " + currentDir + " - создана");
                        log.append("Папка - " + currentDir + " - создана" + "\n");
                    } else {
                        System.out.println("Папка - " + currentDir + " - уже существует");
                        log.append("Папка - " + currentDir + " - уже существует" + "\n");
                    }
                }
        );

        file.forEach(currentFile -> {
                    try {
                        if (currentFile.createNewFile()) {
                            System.out.println("Файл - " + currentFile + " - создан");
                            log.append("Файл - " + currentFile + " - создан" + "\n");
                        } else {
                            System.out.println("Файл - " + currentFile + " - уже существует");
                            log.append("Файл - " + currentFile + " - уже существует" + "\n");
                        }
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage() + " - " + currentFile);
                        log.append(ex.getMessage() + " - " + currentFile + "\n");
                    }
                }
        );

        try (FileWriter writer = new FileWriter("C://Games/temp/temp.txt", true)) {
            writer.write(log + "\n");
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}