package vn.edu.iuh.fit.Back_End.enums;

import java.io.Serializable;

public enum ProductStatus implements Serializable {
    ACTIVE(1),
    IN_ACTIVE(0),
    TEMINATED(-1);
    private int values;

    ProductStatus(int values){
        this.values = values;
    }
    private int getValues(){
        return values;
    }
}
