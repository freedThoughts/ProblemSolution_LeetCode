/*
package outfittery;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test2 {
    public static void main(String[] arg) {

        int[] arr = {0, 1, 2};

        Arrays.stream(arr)
                .collect(Collectors.toList());

        Arrays.asList(arr);
        Collection<Integer> set = new HashSet<>();
        Collections.addAll(set, arr);


        List<List<Integer>> arraysList = Arrays.asList(Arrays.asList(2, 3, 5),
                Arrays.asList(7, 11, 13),
                Arrays.asList(17, 19, 23));


        long count = arraysList.stream()
                .flatMap(list -> list.stream())
                .count();

        //System.out.println(count);


        List<String> names = Arrays.asList("Prakash", "Aashish", "Manish");
        String reducedString = names.stream()
                .reduce((a, b) -> a + " # " + b).get();

        //System.out.println(reducedString);


        Consumer consumer = (comment) -> System.out.println(comment);

        names.stream()
                .forEach(consumer);



    }




    public boolean doMerge(Date lastPushTime, List<Comment> comments) {

        Map<String, Comment> map = comments.stream()
                .filter(comment -> comment.type == Type.APPRIVAL)
                .filter(comment -> comment.timestamp.after(lastPushTime))
                //.collect(Collectors.toMap(comment -> comments.userId, comment -> comment.userId));
                .collect(Collectors.toMap(comment -> comment.userId, Function.identity()));


        Map<String, List<Comment>> map2 = comments.stream()
                .filter(comment -> comment.type == Type.APPRIVAL)
                .filter(comment -> comment.timestamp.after(lastPushTime))
                .collect(Collectors.groupingBy(Comment::getUserId));

        return map.size() >= 2;

    }





    class Comment {
        private String userId;
        private Date timestamp;
        private Type type;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public Date getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Date timestamp) {
            this.timestamp = timestamp;
        }

        public Type getType() {
            return type;
        }

        public void setType(Type type) {
            this.type = type;
        }
    }

    enum Type {
        COMMENT, APPRIVAL;
    }
}
*/
