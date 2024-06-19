package com.restapi.FirstRest.job.impl;

import com.restapi.FirstRest.job.Job;
import com.restapi.FirstRest.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private final List<Job> jobs = new ArrayList<>();
    Long auto_id = 0L;

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(String name) {
        auto_id++;
        Job newJob = new Job(auto_id, name);
        jobs.add(newJob);
    }

    @Override
    public Job findJobById(Long id) {
        return jobs.stream().filter(job -> job.getId().equals(id)).findFirst().orElse(null);
    }
}
