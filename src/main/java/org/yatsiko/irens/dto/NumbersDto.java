package org.yatsiko.irens.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Positive;

public class NumbersDto {

    @DecimalMin(value = "0")
    private String number;

    @Positive
    private int range;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }
}
