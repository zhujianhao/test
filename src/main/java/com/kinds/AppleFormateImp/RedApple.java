package com.kinds.AppleFormateImp;

import com.kinds.Apple;
import com.kinds.AppleFormate;
import com.kinds.Friut;

public class RedApple implements AppleFormate{

    @Override
    public Boolean accept(Object o) {
        if(o instanceof Apple){
            Apple a=(Apple)o;
            if(a.getColor().equals("red")){
            return true;
            }
        }
        return false;
    }


}
