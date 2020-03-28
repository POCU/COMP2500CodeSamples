package academy.pocu.comp2500samples.w07.createentity;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        GameObject batman = loadGameObjectOrNull("Batman");
        batman.update();

        System.out.println();

        GameObject tree = loadGameObjectOrNull("Tree");
        tree.update();

        System.out.println();

        GameObject scaryVampire = loadGameObjectOrNull("ScaryVampire");
        scaryVampire.update();
    }

    private static GameObject loadGameObjectOrNull(String name) {
        String filename = String.format("%s.txt", name);
        Path playerFilePath = Paths.get(getClassPath(), filename);
        File playerFile = new File(playerFilePath.toString());

        if (!playerFile.isFile()) {
            return null;
        }

        List<String> lines;

        try
        {
            lines = Files.readAllLines(
                    playerFilePath,
                    StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        assert (lines.size() == 1) : "Player setting file is not in correct format!";

        String[] components = lines.get(0).split(",", -1);

        assert (components.length > 0) : String.format("No components found in %s", filename);

        GameObject obj = new GameObject(name);

        for (String c : components) {
            switch (c) {
                case "Ai":
                    obj.addComponent(new AiComponent());
                    break;

                case "Controllable":
                    obj.addComponent(new ControllableComponent());
                    break;

                case "Physics":
                    obj.addComponent(new PhysicsComponent());
                    break;

                case "Entity":
                    obj.addComponent(new EntityComponent());
                    break;

                default:
                    throw new IllegalArgumentException(String.format(
                            "Unrecognized component: %s",
                            c));
            }
        }

        return obj;
    }

    private static String getClassPath() {
        File f = new File(Program.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        String packageName = Program.class.getPackageName();
        packageName = packageName.replace('.', '/');

        Path p = Paths.get(f.getPath(), packageName);

        return p.toAbsolutePath().normalize().toString();
    }
}
