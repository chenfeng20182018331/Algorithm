package net.lzzy.algorithm.algorlib;

/**
 * Created by lzzy_gxy on 2019/6/20.
 * Description:
 */
public abstract class BaseSort <T extends Comparable<? super T>> {

    T[] items;
    long duration;//时间间隔
    private int comparecount;//比较次数
    private int swacount;
    int movestep;
//
    BaseSort(T[] items){
        this.items=items;
        comparecount=0;
        swacount=0;
        movestep=0;
    }
    boolean bigger(T a,T b){
        comparecount++;
        return a.compareTo(b)>0;
    }
    void swap(int i, int j){
        swacount++;
        T num=items[i];
        items[i]=items[j];
        items[j]=num;


    }

    public String getResult(){
        String display="";
        for (T i:items){
            display=display.concat(i+",");
        }
        return display.substring(0,display.length()-1);
    }

    abstract void sort();

    public T[]Return(){
        return items;
    }
    public int getComparecount(){
        return comparecount;
    }

    public long getDuration(){
        long start=System.currentTimeMillis();
        sort();
        duration=System.currentTimeMillis();
        return duration;
    }

    public int getMovestep(){

        return movestep;
    }

    public int getSwacount(){

        return swacount;
    }


}
