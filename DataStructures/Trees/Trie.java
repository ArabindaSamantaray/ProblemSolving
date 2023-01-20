import java.util.HashMap;
import java.util.Map;

/**
 * This class is responsible for creating a trie and performing the folowing operations:
 * a) Creation of a trie
 * b) insertion of nodes into a trie
 * c) searching a string in a trie
 * d) deleting a string in a trie
 */
public class Trie {
    class TrieNode{
        Map<Character, TrieNode> storedCharachters;
        boolean isEndOfString;

        public TrieNode(){
            this.storedCharachters = new HashMap<>();
            isEndOfString = false;
        }
    }

    Trie(){
        this.root = new TrieNode();
    }

    public TrieNode root;

    private void insert(String word) {
        TrieNode currentNode = this.root;
        for(char charachter: word.toCharArray()){
           TrieNode trieNode = currentNode.storedCharachters.get(charachter);
           if(trieNode==null){
               trieNode=new TrieNode();
               currentNode.storedCharachters.put(charachter, trieNode);
           }
           currentNode=trieNode;
        }
        currentNode.isEndOfString=true;
    }

    private boolean search(String word){
        TrieNode currentNode = this.root;
        for(char charachter: word.toCharArray()){
            TrieNode node = currentNode.storedCharachters.get(charachter);
            if(node==null){
                return false;
            }
            currentNode = node;
        }
        return currentNode.isEndOfString;
    }


    // This code gave me the most trouble. Do revise it
    private TrieNode delete(TrieNode node, String word, int index){
        if(index==word.length()){
            if (node.isEndOfString){
                node.isEndOfString=false;
            }
            if(node.storedCharachters.size()==0){
                node=null;
                return node;
            }
            return node;
        }
        TrieNode nodeReturned = node.storedCharachters.get(word.charAt(index));
        if(nodeReturned==null){
            System.out.println("The word "+ word+ " does not exist in the trie");
            return node;
        }else{
            index++;
            if(delete(nodeReturned, word, index)==null){
                if(node.storedCharachters.size()==1){
                    node=null;
                    return node;
                }else {
                    node.storedCharachters.remove(word.charAt(index));
                    return node;
                }
            }else {
                return node;
            }
        }

    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] arrayOfStrings = {"call", "cat" , "caller", "cattle", "catnip", "car", "dog", "arabinda", "arabinka"};
        for (String word:arrayOfStrings) {
            trie.insert(word);
        }


        trie.delete(trie.root, "call", 0);
        trie.delete(trie.root, "catnip", 0);
        trie.delete(trie.root, "arabinda", 0);

        String[] checkForStringsInTrie = {"call", "caller", "carvana", "cattle", "car", "dog", "dogging", "arab", "arabinda", "catnip", "arabinka", "cat"};
        for(String word:checkForStringsInTrie){
            boolean doesWordExist = trie.search(word);
            System.out.println("The word "+ word+" exists in trie: "+ doesWordExist);
        }

    }


}
