# SaveableDictionary-Exercise
In this exercise we will extend the dictionary, so that it can read words from a file and write words to a file. The dictionary must also be able to translate both from Finnish to another language and from another language to Finnish (in this exercise we ignore the fact that some words might be written the same in Finnish and in other languages). Your mission is to create a dictionary in the class SaveableDictionary. Implement the class in the package dictionary.

Part 1: The basic functionality
 - For the dictionary, implement a constructor which takes no parameters, and the following methods:

     - public void add(String words, String translation) adds a word to the dictionary. Every word has just one translation, and if the same word is added for the second time, nothing happens.
     - public String translate(String word) returns the translation for the given word. If the word is not in the dictionary, returns null.

Part 2: Deleting words
 - Add the dictionary method public void delete(String word) which deletes the given word and its translation from the dictionary.
 - Deleting also works both ways: Both the word and its translation are removed if either the word or the translation are deleted.
 
 Part 3: Reading from file
 - Make a constructor public SaveableDictionary(String file) and method public boolean load(), which loads the dictionary from the file given to the constructor as a parameter. If the program is unable to open the file or read from it, the method returns false, otherwise it returns true.
 - In the dictionary file, one line contains a word and its translation separated by ":". 
 
 Part 4: Saving to a file
  - Create the method public boolean save(), which saves the dictionary to the file given to the dictionary as a parameter to the constructor. If the program cannot save to the file, the method returns false. Otherwise it returns true. The dictionary files have to be saved in the form described above, so the program can read the files it has written.
  
-From MOOC.fi
