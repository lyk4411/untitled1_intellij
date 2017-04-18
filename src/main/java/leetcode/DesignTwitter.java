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
        dt.follow(1,2);
        dt.follow(1,3);
        dt.follow(2,1);
        dt.postTweet(1,21);
        dt.postTweet(1,22);
        dt.postTweet(1,23);
        dt.postTweet(1,24);
        dt.postTweet(1,25);
        dt.postTweet(1,26);
        dt.postTweet(1,27);
        dt.postTweet(1,28);
        dt.postTweet(1,29);
        dt.postTweet(1,30);
        dt.postTweet(2,1);
        dt.postTweet(2,2);
        dt.postTweet(2,3);
        dt.postTweet(2,4);
        dt.postTweet(2,5);
        dt.postTweet(2,6);
        dt.postTweet(2,7);
        dt.postTweet(2,8);
        dt.postTweet(2,9);
        dt.postTweet(2,10);
        dt.postTweet(2,11);
        dt.postTweet(3,111);
        dt.postTweet(3,112);

        dt.userMap.forEach((k,v)-> System.out.println(k + ":" + v));
        dt.tweets.forEach((k,v)-> System.out.println(k + ":" + v));

        System.out.println(dt.getNewsFeed(2));
        System.out.println(dt.getNewsFeed(1));
    }

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

            @Override
            public String toString() {
                return "time:" + time + " id:" + id ;
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
                    //.peek(f -> System.out.println("userid:" + f))
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

