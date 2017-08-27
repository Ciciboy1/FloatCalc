package com.ciciboy.exceptions;

public class ValueOutOfBoundsException extends ArithmeticException {

    public ValueOutOfBoundsException(){
        super("entered value out of expected bounds");
    }

    public ValueOutOfBoundsException(String s){
        super(s);
    }

}
