package com.kinds;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AppleFilter {

    public <T> List<T>  filter(List<T> list,AppleFormate<T> appleFormate){
        List<T> result = new ArrayList<>();
        for(T a: list){
            if(appleFormate.accept(a)){
                result.add(a);
            }
        }
        return result;
    }


}
