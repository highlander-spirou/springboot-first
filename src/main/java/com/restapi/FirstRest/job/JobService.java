package com.restapi.FirstRest.job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createJob(String name);
    Job findJobById(Long id);
}

