package net.lzzy.algorithm.algorlib;

import android.content.pm.FeatureGroupInfo;
import android.sax.StartElementListener;
import android.webkit.JavascriptInterface;

/**
 * Created by lzzy_gxy on 2019/6/13.
 * Description:
 */
public class DirectSort <T extends Comparable<? super T>> extends BaseSort<T>{


    public DirectSort(T[]items){
        super(items);
    }

    @Override
    public void sort() {
        long start=System.currentTimeMillis();
        for (int i=0;i<items.length-1;i++){
            int minpos=i;
            for (int j=i+1;j<items.length;j++){
                if (bigger(items[minpos],items[j])){
                    minpos=j;
                }swap(minpos,i);
            }
        }
        duration=System.currentTimeMillis()-start;
    }
}
