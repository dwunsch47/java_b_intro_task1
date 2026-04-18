import java.io.*;

public class Main {
    public static void main(String[] args) {
        StringBuilder log = new StringBuilder(); // could be global, but might be a bit ambiguous

       File basePath = new File("D:\\Games");
       dirCreator(basePath, log);

       //src
        File srcPath = new File(basePath, "src");
        dirCreator(srcPath, log);

       File testPath = new File(srcPath, "test");
       dirCreator(testPath, log);

       File mainPath = new File(srcPath, "main");
       dirCreator(mainPath, log);

       // src/main
       File mainFilePath = new File(mainPath, "Main.java");
       fileCreator(mainFilePath, log);

       File utilsFilePath = new File(mainPath, "Utils.java");
       fileCreator(utilsFilePath, log);

       // savegames
        File saveGamesPath = new File(basePath, "savegames");
        dirCreator(saveGamesPath, log);

        // res
        File resPath = new File(basePath, "res");
        dirCreator(resPath, log);

        File drawablesPath = new File(resPath, "drawables");
        dirCreator(drawablesPath, log);

        File vectorsPath = new File(resPath, "vectors");
        dirCreator(vectorsPath, log);

        File iconsPath = new File(resPath, "icons");
        dirCreator(iconsPath, log);

        File tmpPath = new File(basePath, "temp");
        dirCreator(tmpPath, log);
        File tmpFilePath = new File(tmpPath, "temp.txt");
        fileCreator(tmpFilePath, log);
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(tmpFilePath))) {
            bw.write(log.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void logger(File file, boolean status, StringBuilder builder) {
        builder.append("\"").append(file.getAbsoluteFile()).append(status ? "\" was created successfully" : " wasn't created");
        builder.append('\n');
    }

    public static void dirCreator(File toCreate, StringBuilder log) {
        logger(toCreate, toCreate.mkdir(), log);
    }

    public static void fileCreator(File toCreate, StringBuilder log) {
        try {
            logger(toCreate, toCreate.createNewFile(), log);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}