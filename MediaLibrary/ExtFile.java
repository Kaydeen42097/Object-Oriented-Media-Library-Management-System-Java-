package block.projects.MediaLibrary;
import java.io.*;

    public abstract class ExtFile {
        /**
         * Reads text from a file and returns the entire text as a String.
         * @param path The package path from the project root.
         * @param filename The name of the file (including the file extension).
         * @return The contents of the file as a String.
         */
        public static String readFile(String path, String filename) { return readFile(path, filename, false); }

        /**
         * Reads text from a file and returns the entire text as a String.
         * @param path The package path from the project root.
         * @param filename The name of the file (including the file extension).
         * @param suppress Allows you to suppress the exceptions raised by the method.
         * @return The contents of the file as a String.
         */
        public static String readFile(String path, String filename, boolean suppress) {
            String cwd = System.getProperty("user.dir");
            String filepath = cwd + "\\" + path + "\\" + filename;

            try {
                FileInputStream fileStream = new FileInputStream(filepath);
                InputStreamReader readerStream = new InputStreamReader(fileStream);
                BufferedReader reader = new BufferedReader(readerStream);

                String line;
                StringBuilder sb = new StringBuilder();

                try {
                    while ((line = reader.readLine()) != null) sb.append(line).append("\n");
                    reader.close();
                } catch (IOException e) {
                    if (!suppress) System.out.println("[ERROR] " + e.getMessage());
                }

                return sb.toString();
            } catch (FileNotFoundException e) {
                if (!suppress) System.out.println("[ERROR] File " + filename + " not found in path " + filepath);
            }
            return null;
        }

        /**
         * Writes a given String to a file. The current text of the file will be overwritten.
         * @param path The package path from the project root.
         * @param filename The name of the file (including the file extension).
         * @param str The String to be written to the file.
         */
        public static void writeFile(String path, String filename, String str) {
            String cwd = System.getProperty("user.dir");
            String filepath = cwd + "\\" + path + "\\" + filename;

            try {
                FileWriter writer = new FileWriter(filepath, false);
                writer.write(str);
                writer.close();
            } catch (IOException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }

        /**
         * Writes a given String to a file. The text will be appended to the file.
         * @param path The package path from the project root.
         * @param filename The name of the file (including the file extension).
         * @param str The String to be written to the file.
         */
        public static void appendFile(String path, String filename, String str) {
            String cwd = System.getProperty("user.dir");
            String filepath = cwd + "\\" + path + "\\" + filename;

            try {
                FileWriter writer = new FileWriter(filepath, true);
                writer.write(str);
                writer.close();
            } catch (IOException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

