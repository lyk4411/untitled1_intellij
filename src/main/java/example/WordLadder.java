package example;

import java.util.*;

/**
 * Created by lyk on 2017/4/12.
 * Package name: example
 * Porject name: untitled1
 */
public class WordLadder {
    public static void main(String[] args) {
        WordLadder wl = new WordLadder();
        List<String> list = new ArrayList<String>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        //list.add("cog");
        System.out.println(wl.ladderLength("hit","cog",list));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<String> q = new LinkedList<String>();
        q.add(beginWord);
        Set<String> visited = new HashSet<String>();
        visited.add(beginWord);
        int level = 0;

        while (!q.isEmpty()) {
            int len = q.size();
            level++;
            for (int i = 0; i < len; i++) {
                String word = q.remove();
                for (int j = 0; j < word.length(); j++) {
                    char[] chars = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[j] = c;
                        String nextWord = new String(chars);
                        if (nextWord.equals(endWord)) {
                            return level + 1;
                        }
                        if (!visited.contains(nextWord) && wordList.contains(nextWord)) {
                            q.add(nextWord);
                            visited.add(nextWord);
                        }
                    }
                }
            }
        }

        return 0;
    }


//    class WordNode{
//        String word;
//        int numSteps;
//
//        public WordNode(String word, int numSteps){
//            this.word = word;
//            this.numSteps = numSteps;
//        }
//    }
//
//    public int ladderLength(String beginWord, String endWord, List<String> wordDict) {
//        LinkedList<WordNode> queue = new LinkedList<WordNode>();
//        queue.add(new WordNode(beginWord, 1));
//
//        while(!queue.isEmpty()){
//            WordNode top = queue.remove();
//            String word = top.word;
//            if(word.equals(endWord)){
//                return top.numSteps;
//            }
//
//            char[] arr = word.toCharArray();
//            for(int i=0; i<arr.length; i++){
//                for(char c='a'; c<='z'; c++){
//                    char temp = arr[i];
//                    if(arr[i]!=c){
//                        arr[i]=c;
//                    }
//
//                    String newWord = new String(arr);
//                    if(wordDict.contains(newWord)){
//                        queue.add(new WordNode(newWord, top.numSteps+1));
//                        wordDict.remove(newWord);
//                    }
//
//                    arr[i]=temp;
//                }
//            }
//        }
//        return 0;
//    }
}