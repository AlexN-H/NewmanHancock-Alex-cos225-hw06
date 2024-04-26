public class MorseTree {
    private TreeNode<Character> root;

    private final char[] englishCharacters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' '};
    private final String[] morseSymbols = {"o-", "-ooo", "-o-o", "-oo", "o", "oo-o", "--o", "oooo", "oo", "o---", "-o-", "o-oo", "--", "-o", "---", "o--o", "--o-", "o-o", "ooo", "-", "oo-", "ooo-", "o--", "-oo-", "-o--", "--oo", "|"};

    public MorseTree(){
        this.root = new TreeNode<>(' ');
    }

    public String pre_Order(TreeNode<Character> node) {
        if (node == null) {
            return "";
        }

        String result = node.getElement() + " "; 
        result += pre_Order(node.getLeft()); 
        result += pre_Order(node.getRight()); 

        return result;
    }

    public String post_Order(TreeNode<Character> node) {
        if (node == null) {
            return "";
        }

        String result = post_Order(node.getLeft()); 
        result += post_Order(node.getRight()); 
        result += node.getElement() + " "; 

        return result;
    }

    public String englishToMorse(String text) {
        StringBuilder morseCode = new StringBuilder();
        
        text = text.toLowerCase();
        
        for (char c : text.toCharArray()) {
            
            int index = findIndexOfCharacter(c);
            if (index != -1) {
                morseCode.append(morseSymbols[index]).append("|"); 
            }
        }
        return morseCode.toString();
    }


    public String morseToEnglish(String morse) {
        StringBuilder englishText = new StringBuilder();
     
        morse = morse.replace(" ", "");
      
        String[] symbols = morse.split("\\|");
        
        for (String symbol : symbols) {
            
            int index = findIndexOfMorseSymbol(symbol);
            if (index != -1) {
                englishText.append(englishCharacters[index]); 
            }
        }
        return englishText.toString();
    }

    private int findIndexOfCharacter(char c) {
        for (int i = 0; i < englishCharacters.length; i++) {
            if (englishCharacters[i] == c) {
                return i;
            }
        }
        return -1; 
    }

   
    private int findIndexOfMorseSymbol(String symbol) {
        for (int i = 0; i < morseSymbols.length; i++) {
            if (morseSymbols[i].equals(symbol)) {
                return i;
            }
        }
        return -1;
    }



}
