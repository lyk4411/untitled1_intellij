package leetcode;

import java.util.*;

/**
 * Created by lyk on 2017/7/5.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class WordLadderII {
    public static void main(String[] args) {
        WordLadderII wlii = new WordLadderII();
        String start = new String("hit");
        String end = new String("cog");
        List<String> dict = new ArrayList<>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        dict.add("cog");
        System.out.println(wlii.findLadders(start,end,dict));
    }
//    public List<List<String>> findLadders(String start, String end, List<String> dict) {
//        List<List<String>> result = new ArrayList<List<String>>();
//
//        LinkedList<WordNode> queue = new LinkedList<WordNode>();
//        queue.add(new WordNode(start, 1, null));
//
//
//        int minStep = 0;
//
//        HashSet<String> visited = new HashSet<String>();
//        HashSet<String> unvisited = new HashSet<String>();
//        unvisited.addAll(dict);
//
//        int preNumSteps = 0;
//
//        while(!queue.isEmpty()){
//            WordNode top = queue.remove();
//            String word = top.word;
//            int currNumSteps = top.numSteps;
//
//            if(word.equals(end)){
//                if(minStep == 0){
//                    minStep = top.numSteps;
//                }
//
//                if(top.numSteps == minStep && minStep !=0){
//                    //nothing
//                    ArrayList<String> t = new ArrayList<String>();
//                    t.add(top.word);
//                    while(top.pre !=null){
//                        t.add(0, top.pre.word);
//                        top = top.pre;
//                    }
//                    result.add(t);
//                    continue;
//                }
//
//            }
//
//            if(preNumSteps < currNumSteps){
//                unvisited.removeAll(visited);
//            }
//
//            preNumSteps = currNumSteps;
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
//                    if(unvisited.contains(newWord)){
//                        queue.add(new WordNode(newWord, top.numSteps+1, top));
//                        visited.add(newWord);
//                    }
//
//                    arr[i]=temp;
//                }
//            }
//
//
//        }
//
//        return result;
//    }

    public List<List<String>> findLadders(String start, String end, List<String> wordList) {
        HashSet<String> dict = new HashSet<String>(wordList);
        List<List<String>> res = new ArrayList<List<String>>();
        HashMap<String, ArrayList<String>> nodeNeighbors = new HashMap<String, ArrayList<String>>();// Neighbors for every node
        HashMap<String, Integer> distance = new HashMap<String, Integer>();// Distance of every node from the start node
        ArrayList<String> solution = new ArrayList<String>();

        dict.add(start);
        bfs(start, end, dict, nodeNeighbors, distance);
        //dfs(start, end, dict, nodeNeighbors, distance, solution, res);
        return res;
    }

    // BFS: Trace every node's distance from the start node (level by level).
    private void bfs(String start, String end, Set<String> dict,
                     HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance) {
        for (String str : dict)
            nodeNeighbors.put(str, new ArrayList<String>());

        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        distance.put(start, 0);

        while (!queue.isEmpty()) {
            int count = queue.size();
            boolean foundEnd = false;
            for (int i = 0; i < count; i++) {
                String cur = queue.poll();
                int curDistance = distance.get(cur);
                ArrayList<String> neighbors = getNeighbors(cur, dict);

                for (String neighbor : neighbors) {
                    nodeNeighbors.get(cur).add(neighbor);
                    if (!distance.containsKey(neighbor)) {// Check if visited
                        distance.put(neighbor, curDistance + 1);
                        if (end.equals(neighbor))// Found the shortest path
                            foundEnd = true;
                        else
                            queue.offer(neighbor);
                    }
                }
            }

            if (foundEnd)
                break;
        }
    }
    // Find all next level nodes.
    private ArrayList<String> getNeighbors(String node, Set<String> dict) {
        ArrayList<String> res = new ArrayList<String>();
        char chs[] = node.toCharArray();

        for (char ch ='a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == ch) continue;
                char old_ch = chs[i];
                chs[i] = ch;
                if (dict.contains(String.valueOf(chs))) {
                    res.add(String.valueOf(chs));
                }
                chs[i] = old_ch;
            }

        }
        return res;
    }

}

class WordNode{
    String word;
    int numSteps;
    WordNode pre;

    public WordNode(String word, int numSteps, WordNode pre){
        this.word = word;
        this.numSteps = numSteps;
        this.pre = pre;
    }
}
