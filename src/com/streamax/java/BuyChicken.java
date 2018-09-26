package com.streamax.java;

/**
 * 深圳锐明，宣讲会笔试
 * 百元百鸡：公鸡5元一只，母鸡3元，小鸡1元3只，100元买100只鸡(钱可以不用完)
 */
public class BuyChicken {
    private static int buyChecken() {
        int count = 0;
        for (int cock = 0; cock <= 20; cock++) {
            for (int hen = 0; hen <= 33; hen++) {
                int chick = 100 - cock - hen;
                if (chick % 3 == 0) {
                    if (cock * 5 + hen * 3 + chick / 3 <= 100) {
                        count++;
                        System.out.println("公鸡:" + cock + " 母鸡:" + hen + " 小鸡:" + chick);
                    }
                }
            }
        }
        //一只鸡也不买
        count++;
        return count;
    }

    public static void main(String args[]) {
        int count = buyChecken();
        System.out.println(count);
    }
}
