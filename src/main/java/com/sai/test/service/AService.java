package com.sai.test.service;

import com.sai.test.model.A;
import org.springframework.stereotype.Service;

@Service
public interface  AService {
    public A saveA(A a);
    public A findAById(Integer id);
}
