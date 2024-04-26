public class MorseTester {
    public static void main(String[] args) {
        MorseTree morseTree = new MorseTree();
        TreeNode<Character> root = new TreeNode<>(null);
        populateTree(root);

        
        System.out.println("Preorder tree contents: " + morseTree.pre_Order(root));

       
        System.out.println("Postorder tree contents: " + morseTree.post_Order(root));

     
        String englishText = "The quick fox";
        String morseCode = morseTree.englishToMorse(englishText);
        System.out.println("English to Morse: " + morseCode);

     
        String translatedText = morseTree.morseToEnglish(morseCode);
        System.out.println("Morse to English: " + translatedText);
    }

    //populate the MorseTree with Morse code alphabet
    static void populateTree(TreeNode<Character> root) {
        String[] morseAlphabet = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", "|" };
        char[] characters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' '};

        
        for (int i = 0; i < morseAlphabet.length; i++) {
            TreeNode<Character> current = root;
            String morseSymbol = morseAlphabet[i];
            char character = characters[i];

            
            for (int j = 0; j < morseSymbol.length(); j++) {
                char symbol = morseSymbol.charAt(j);
                if (symbol == '.') {
                    if (current.getLeft() == null) {
                        current.setLeft(new TreeNode<>(null)); 
                    }
                    current = current.getLeft(); 
                } else if (symbol == '-') {
                    if (current.getRight() == null) {
                        current.setRight(new TreeNode<>(null)); 
                    }
                    current = current.getRight(); 
                }
            }
           
            current.setElement(character);
        }
    }
}

