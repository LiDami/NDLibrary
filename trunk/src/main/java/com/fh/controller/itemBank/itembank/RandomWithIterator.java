package com.fh.controller.itemBank.itembank;

import java.awt.*;
import java.awt.List;
import java.lang.reflect.Array;
import java.util.*;

/**
 * 类名称：com.fh.controller.itemBank.itembank
 * author:李景浩
 * time 2017/7/6
 * describe:
 */
public class RandomWithIterator {
    public static Set<Integer> getRandom(int getVal, int maxVal){
        Set<Integer> set=new HashSet<Integer>();
        int count=0;
        while(count<=getVal){
            int tmp=(int) (Math.random()*maxVal)+1;
            if(set.add(tmp))
                count++;
        }
        return set;
    }
    public static java.util.List<Integer> getID(Set<Integer> set, java.util.List<Integer> rank){
        Iterator<Integer> iter = set.iterator();
        java.util.List<Integer> list = new ArrayList<Integer> ();
        while (iter.hasNext()) {
            list.add(rank.get(iter.next())) ;
        }
        return list;
    }

    }


