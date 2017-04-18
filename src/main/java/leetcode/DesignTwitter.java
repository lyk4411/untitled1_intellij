package leetcode;

import java.util.*;

/**
 * Created by lyk on 2017/4/18.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class DesignTwitter {
    public static void main(String[] args) {
        DesignTwitter dt = new DesignTwitter();

    }
    public class Twitter {
        Map<Integer, Set<Integer>> userMap = new HashMap<>();
        Map<Integer, LinkedList<Tweet>> tweets = new HashMap<>();
        int timestamp = 0;

        class Tweet {
            int time;
            int id;

            Tweet(int time, int id) {
                this.time = time;
                this.id = id;
            }
        }

        public void postTweet(int userId, int tweetId) {
            if (!userMap.containsKey(userId)) userMap.put(userId, new HashSet<>());
            userMap.get(userId).add(userId);
            if (!tweets.containsKey(userId)) tweets.put(userId, new LinkedList<>());
            tweets.get(userId).addFirst(new Tweet(timestamp++, tweetId));
        }

        public List<Integer> getNewsFeed(int userId) {
            if (!userMap.containsKey(userId)) return new LinkedList<>();
            PriorityQueue<Tweet> feed = new PriorityQueue<>((t1, t2) -> t2.time - t1.time);
            userMap.get(userId).stream().filter(f -> tweets.containsKey(f))
                    .forEach(f -> tweets.get(f).forEach(feed::add));
            List<Integer> res = new LinkedList<>();
            while (feed.size() > 0 && res.size() < 10) res.add(feed.poll().id);
            return res;
        }

        public void follow(int followerId, int followeeId) {
            if (!userMap.containsKey(followerId)) userMap.put(followerId, new HashSet<>());
            userMap.get(followerId).add(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            if (userMap.containsKey(followerId) && followeeId != followerId)
                userMap.get(followerId).remove(followeeId);
        }
    }
}
