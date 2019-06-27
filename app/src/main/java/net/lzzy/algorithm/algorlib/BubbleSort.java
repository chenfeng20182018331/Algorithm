package net.lzzy.algorithm.algorlib;

/**
 * Created by lzzy_gxy on 2019/6/22.
 * Description:
 */
//
public  abstract  class BubbleSort <T extends Comparable<? super T>> extends BaseSort<T> {

    BubbleSort(T[] items) {
        super(items);
    }

    @Override
    public void sort() {
        long start=System.currentTimeMillis();
        for (int i=0;i<items.length-1;i++){
            int minpos=i;
            for (int j=i+1;j<items.length;j++){
                if (bigger(items[minpos],items[j+1])){
                    swap(minpos,i);
                    //比较相邻的元素。如果第一个比第二个大，就交换他们两个。
                    //对每一对相邻元素做同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
                    //针对所有的元素重复以上的步骤，除了最后一个。
                    //持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比
                }
            }
        }
        duration=System.currentTimeMillis()-start;
    }



}
