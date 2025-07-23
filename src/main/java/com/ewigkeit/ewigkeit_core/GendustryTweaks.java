package com.ewigkeit.ewigkeit_core;
import org.slf4j.Logger;
import sun.misc.Unsafe;
import thedarkcolour.gendustry.blockentity.IndustrialApiaryBlockEntity;

import java.lang.reflect.Field;

public class GendustryTweaks {
    private Logger logger;
    
    public GendustryTweaks(Logger logger) {
        this.logger = logger;
    }
    
    public void Run(){
        for (Field field : IndustrialApiaryBlockEntity.class.getFields()){
            if (!field.getName().equals("BASE_ENERGY")) continue;
            
            final Unsafe unsafe;
            //region Get Unsafe
            final Field unsafeField;
            try {
                unsafeField = Unsafe.class.getDeclaredField("theUnsafe");
            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);
            }
            unsafeField.setAccessible(true);
            try {
                unsafe = (Unsafe) unsafeField.get(null);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            //endregion

            final Object staticFieldBase = unsafe.staticFieldBase(field);
            final long staticFieldOffset = unsafe.staticFieldOffset(field);
            unsafe.putInt(staticFieldBase, staticFieldOffset, 100000);
        }
    }
}
