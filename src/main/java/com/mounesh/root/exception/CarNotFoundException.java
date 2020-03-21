package com.mounesh.root.exception;

public class CarNotFoundException extends RuntimeException {
    public CarNotFoundException(){
    }

    public CarNotFoundException(String error){
        super(error);
    }
}
