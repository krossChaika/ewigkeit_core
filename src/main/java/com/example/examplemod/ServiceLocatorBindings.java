package com.example.examplemod;

import java.util.Dictionary;
import java.util.function.Supplier;

public class ServiceLocatorBindings {
    public Dictionary<Class<?>, Supplier<?>> Data;
    
    public ServiceLocatorBindings(Dictionary<Class<?>, Supplier<?>> data) {
        Data = data;
    }
}
