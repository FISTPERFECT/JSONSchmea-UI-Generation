package com.sai.test.service;

import com.sai.test.Repository.ARepository;
import com.sai.test.Repository.A4Repository;
import com.sai.test.model.A;
import com.sai.test.model.A4List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AserviceImpl implements AService {

    @Autowired
    private A4Repository repo;
    @Autowired
    private ARepository aRepo;

    @Override
    public A saveA(A a) {
        System.out.println(a.getA4());
        A4List a4ListList = repo.findByName(a.getA4());
        System.out.println(  a4ListList.getId());
        a.setBook(a4ListList);
        aRepo.save(a);
        return a;
    }

    @Override
    public A findAById(Integer id) {
        return null;
    }
}
