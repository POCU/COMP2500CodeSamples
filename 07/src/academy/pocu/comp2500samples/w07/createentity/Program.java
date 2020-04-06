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
        String directory = getClassPath();
        String filename = String.format("%s.txt", name);
        Path playerFilePath = Paths.get(directory, filename);
        File playerFile = new File(playerFilePath.toString());

        if (!playerFile.isFile()) {
            return null;
        }

        List<String> lines;

        try {
            lines = Files.readAllLines(playerFilePath,
                    StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        assert (lines.size() == 1) : "Player setting file is not in correct format!";

        String[] components = lines.get(0).split(",", -1);

        GameObject obj = new GameObject(name);

        for (String c : components) {
            ComponentType type;

            try {
                type = ComponentType.valueOf(c.toUpperCase());
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                return null;
            }

            switch (type) {
                case AI:
                    obj.addComponent(new AiComponent());
                    break;

                case CONTROLLABLE:
                    obj.addComponent(new ControllableComponent());
                    break;

                case PHYSICS:
                    obj.addComponent(new PhysicsComponent());
                    break;

                case ENTITY:
                    obj.addComponent(new EntityComponent());
                    break;

                default:
                    return null;
            }
        }

        return obj;
    }

    private static String getClassPath() {
        File file = new File(Program.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        String packageName = Program.class.getPackageName();
        packageName = packageName.replace('.', '/');

        Path path = Paths.get(file.getPath(), packageName);

        return path.toAbsolutePath().normalize().toString();
    }
}
