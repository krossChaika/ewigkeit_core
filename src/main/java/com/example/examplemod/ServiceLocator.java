package com.example.examplemod;

import java.util.Dictionary;
import java.util.function.Supplier;

public class ServiceLocator {
    private ServiceLocatorBindings bindings;
    
    public ServiceLocator(ServiceLocatorBindings bindings) {
        this.bindings = bindings;
    }
    
    public <TService> TService resolve(Class<TService> abstractType) {
        return (TService)bindings.Data.get(abstractType).get();
    }
}

