package net.lzzy.algorithm.algorlib;

import android.content.ClipData;
import android.util.Pair;

import java.security.Key;

/**
 * Created by lzzy_gxy on 2019/6/27.
 * Description:
 */
public class BinaryTree<T extends Comparable<? super T>> extends BaseSearch<T>{
private Pair<Integer,T> root;
private BinaryTree<T> left,right;
    BinaryTree(T[] items) {
        super(items);
      root=new Pair<>(0,items[0]);
      for(int i=1;i<items.length;i++){
          addNode(new Pair<>(i,items[i]));

      }
    }
 private  BinaryTree(Pair<Integer,T>node){
        root=node;
 }


private  void addNode(Pair<Integer,T>node){
int comp=compare(node.second,root.second);
if (comp>0){
    if (right==null){
right=new BinaryTree<>(node);
    }else {
        right.addNode(node);
    }

}
if (comp<0){
    if (left==null){
        left=new BinaryTree<>(node);

    }else {
        left.addNode(node);
    }
}
}

    @Override
    public int search(T key) {
        return 0;
    }

}
// 二叉排序树