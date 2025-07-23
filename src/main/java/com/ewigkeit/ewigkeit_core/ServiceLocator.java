package com.ewigkeit.ewigkeit_core;

public class ServiceLocator {
    private ServiceLocatorBindings bindings;
    
    public ServiceLocator(ServiceLocatorBindings bindings) {
        this.bindings = bindings;
    }
    
    public <TService> TService resolve(Class<TService> abstractType) {
        return (TService)bindings.Data.get(abstractType).get();
    }
}

