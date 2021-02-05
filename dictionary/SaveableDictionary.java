package dictionary;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SaveableDictionary {
    private final HashMap<String, String> tempDictionary = new HashMap<>();
    private String file;

    public SaveableDictionary() {
    }

    public SaveableDictionary(String file) {
        this.file = file;
    }

    public boolean load() {
        try (Scanner scanner = new Scanner(Paths.get(this.file))) {
            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();
                String[] rowSplit = row.split(":");
                this.tempDictionary.put(rowSplit[0], rowSplit[1]);
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public boolean save() {
        try {
            PrintWriter writer = new PrintWriter(file);
            for (Map.Entry<String, String> entry : this.tempDictionary.entrySet()) {
                writer.println(entry.getKey() + ":" + entry.getValue());
            }
            writer.close();
            return true;
        } catch (IOException e) {
            System.out.println("error: " + e.getMessage());
            return false;
        }
    }

    public void add(String words, String translations) {
        if (this.tempDictionary.containsKey(words) || this.tempDictionary.containsValue(words)) {
            System.out.println("Word/translation pair already exists");
        } else {
            this.tempDictionary.put(words, translations);
        }
    }

    public String translate(String word) {
        if (this.tempDictionary.get(word) != null) {
            return this.tempDictionary.get(word);
        } else {
            String translation = null;
            for (Map.Entry<String, String> entry : this.tempDictionary.entrySet()) {
                if (entry.getValue().equals(word)) {
                    translation = entry.getKey();
                }
            }
            return translation;
        }
    }

    public void delete(String word) {
        if (this.tempDictionary.remove(word) == null) {
            this.tempDictionary.values().removeIf(x -> x.contains(word));
        }
    }
}
