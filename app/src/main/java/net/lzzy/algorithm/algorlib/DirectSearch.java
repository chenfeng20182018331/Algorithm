package net.lzzy.algorithm.algorlib;

import android.graphics.YuvImage;
import android.net.Uri;
import android.sax.StartElementListener;
import android.util.Log;

/**
 * Created by lzzy_gxy on 2019/6/22.
 * Description:
 */
public class DirectSearch <T extends Comparable<? super T>> extends BaseSearch<T>{
    DirectSearch(T[] items){
        super(items);
    }

    @Override
  public   int search(T key) {
        long start=System.currentTimeMillis();
        int pos=0;
        for (T item:items){
            if (equal(item,key)) {
                return  pos;
            }
            setDuration(System.currentTimeMillis()-start);
            pos++;
            }
        setDuration(System.currentTimeMillis()-start);
        return -1;
        }

    }




