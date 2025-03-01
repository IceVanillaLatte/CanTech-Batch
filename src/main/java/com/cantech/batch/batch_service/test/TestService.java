package com.cantech.batch.batch_service.test;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    private final TestRepository testRepository;

    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public List<TestEntity> getAllTests() {
        return testRepository.findAll();
    }
}