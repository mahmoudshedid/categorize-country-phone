package com.shedid.phone.Customer.Request;

import javax.validation.Valid;
import javax.validation.constraints.*;

public class CustomerRequest {

    @Valid
    @NotNull(message = "Code cannot be null")
    @Size(min = 2, max = 100, message = "Code must be between 2 and 100 number")
    @Pattern(regexp="^[0-9]*$", message = "Invalid code numbers.")
    private String code;

    @Valid
    @NotNull(message = "Country cannot be null")
    @Size(min = 2, max = 100, message = "Country must be between 2 and 100 characters")
    @Pattern(regexp="^[A-Za-z]*$", message = "Invalid country characters.")
    private String country;

    @Valid
    @Max(value = 100000, message = "Page must not more than 100000.")
    @Min(value = 0, message = "Page must not less than 0.")
    private int page;

    @Valid
    @Max(value = 20, message = "Size must not more than 20.")
    @Min(value = 5, message = "Size must not less than 5.")
    private int size;

    @Valid
    @NotNull(message = "Sort Dir cannot be null")
    @Size(min = 2, max = 5, message = "Sort Dir must be between 2 and 4 characters")
    @Pattern(regexp = "^asc|desc$", message = "Please select asc or desc.")
    private String sortDir;

    @Valid
    @NotNull(message = "Sort cannot be null")
    @Size(min = 2, max = 100, message = "Sort must be between 2 and 100 characters")
    @Pattern(regexp="^[A-Za-z]*$", message = "Invalid sort characters.")
    private String sort;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSortDir() {
        return sortDir;
    }

    public void setSortDir(String sortDir) {
        this.sortDir = sortDir;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
