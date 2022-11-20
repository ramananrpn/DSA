package repo;

import java.util.HashMap;
import java.util.List;

public class DbService {
    HashMap<Integer, List<String>> entities = new HashMap<>();
    TrieNode root = new TrieNode();

    private static final DbService instance = new DbService();


    private DbService() {
        // private constructor
    }

    public static DbService getInstance(){
        return instance;
    }

    public boolean isEntityPresent(int id) {
        return entities.containsKey(id);
    }

    public void saveEntity(int id, List<String> tags) {
        entities.put(id, tags);
        root.insert(tags);
    }

    public int fetchCount(List<String> tags) {
        TrieNode runner = root;
        int count = 0;
        for (String tag : tags) {
            if (runner.child.containsKey(tag)) {
                runner = runner.child.get(tag);
                count = runner.count;
            }
            else {
                return 0;
            }
        }
        return count;
    }

    public void deleteEntity(int id) {
        root.delete(entities.get(id));
        entities.remove(id);
    }


    class TrieNode {
        int count;
        HashMap<String, TrieNode> child = new HashMap<>();

        public void insert(List<String> tags) {
            TrieNode runner = root;

            for (String tag : tags) {
                TrieNode node;
                if (runner.child.containsKey(tag)) {
                    node = runner.child.get(tag);
                    node.count += 1;
                }
                else {
                    node = new TrieNode();
                    node.count = 1;
                    runner.child.put(tag, node);
                }
                runner = node;
            }
        }

        public void delete(List<String> tags) {
            TrieNode runner = root;

            for (String tag : tags) {
                if (runner.child.containsKey(tag)) {
                    TrieNode node = runner.child.get(tag);
                    node.count -= 1;
                    runner = node;
                }
                else {
                    return;
                }
            }
        }
    }
}