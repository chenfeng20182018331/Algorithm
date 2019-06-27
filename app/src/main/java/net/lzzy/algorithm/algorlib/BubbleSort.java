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
                }
            }
        }
        duration=System.currentTimeMillis()-start;
    }



}
