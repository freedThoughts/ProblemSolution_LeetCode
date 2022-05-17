package airBnB;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// "Fruit": 2.15,
// "Fries": 2.75,
// "Salad": 3.35,
// "Wings": 3.55,
// "Mozzarella": 4.20,
// "Plate": 5.80,

// 4.30 -> [["Fruit", "Fruit"]] 2.15 + 2.15 = 4.30
// 5.50 -> [["Fries", "Fries"], ["Fruit", "Salad"]] 2.75 + 2.75 = 5.50, 2.15 + 3.35 = 5.50
// 15.05 -> [?]

public class Inter1 {

    public static void main(String[] args) {

        Item a = new Item();
        a.name = "Fruit";
        a.val = new BigDecimal(2.15);

        Item b = new Item();
        b.name = "Fries";
        b.val = new BigDecimal(2.75);

        Item c = new Item();
        c.name = "Salad";
        c.val = new BigDecimal(3.35);

        Item d = new Item();
        d.name = "Wings";
        d.val = new BigDecimal(3.55);

        Item e = new Item();
        e.name = "Mozzarella";
        e.val = new BigDecimal(4.20);

        Item f = new Item();
        f.name = "Plate";
        f.val = new BigDecimal(5.80);

        Item[] items = new Item[6];
        items[0] = a;
        items[1] = b;
        items[2] = c;
        items[3] = d;
        items[4] = e;
        items[5] = f;



        List<List<String>> results = new ArrayList<>();
        BigDecimal sumReq = new BigDecimal(15.05);
        backTrack(results, new ArrayList<>(), 0, sumReq, items);

        System.out.print(results);

    }

    static void backTrack(List<List<String>> results, List<String> currentList, int index, BigDecimal sumReq, Item[] items){

        if (sumReq.compareTo(new BigDecimal(0.0)) < 0) return;
        if (sumReq.compareTo(new BigDecimal(0.0)) == 0) {
            results.add(new ArrayList<>(currentList));
            return;
        }

        //double d = new BigDecimal(0.0).doubleValue();
        for(int i = index; i < items.length; i++) {

            //System.out.println("sumReq: " + sumReq + " items[i].val : " + items[i].val);
            if (sumReq.compareTo(items[i].val) >= 0) {
                currentList.add(items[i].name);
                //System.out.println("currentList : " + currentList);
                backTrack(results, currentList, i, sumReq.subtract(items[i].val).setScale(2, BigDecimal.ROUND_HALF_UP), items);
                currentList.remove(currentList.size()-1);
            }
        }



    }

    static class Item {
        String name;
        BigDecimal val;

        Item(){}

        Item(String name, BigDecimal val){
            this.name = name;
            this.val = val;
        }
    }
}
