package ufes.models;

import java.util.List;

public class MultipleExceptions extends Exception {
    private final List<Exception> exceptions;
    
    public MultipleExceptions(List<Exception> exceptions){
        this.exceptions = exceptions;
    }
    
    public List<Exception> getExceptions(){
        return this.exceptions;
    }
}
