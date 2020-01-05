package com.sai.test.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "A")
public class A {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @JsonProperty("A1")
    private String a1;
    @JsonProperty("A2")
    private String a2;
    @JsonProperty("A3")
    private String a3;



    @Transient
    @JsonProperty("A4")
    private String a4;

    @ManyToOne(targetEntity= A4List.class)
    private A4List list;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getA1() {
        return a1;
    }

    public void setA1(String a1) {
        this.a1 = a1;
    }

    public String getA2() {
        return a2;
    }

    public void setA2(String a2) {
        this.a2 = a2;
    }

    public String isA3() {
        return a3;
    }

    public void setA3(String a3) {
        this.a3 = a3;
    }

    public A4List getBook() {
        return list;
    }

    public void setBook(A4List list) {
        this.list = list;
    }

    public String getA4() {
        return a4;
    }

    public void setA4(String a4) {
        this.a4 = a4;
    }

}
