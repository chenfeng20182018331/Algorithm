package net.lzzy.algorithm.algorlib;

/**
 * Created by lzzy_gxy on 2019/6/20.
 * Description:
 */
public class InsertSort <T extends Comparable<? super T>>extends BaseSort {
    InsertSort(T[]items){
        super(items);
    }


    @Override
    public void sort() {
        for (int i=0;i<items.length;i++){
            int j = i-1;
            if (bigger(items[i],items[j])){
                continue;
            }
            T tun= (T) items[i];
            while (j>=0&&bigger(items[j],tun)){
                items[j+1]=items[j];
                movestep++;
                j--;
            }
            items[j+1]=tun;
        }
    }
}
//