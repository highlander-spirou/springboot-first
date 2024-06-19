package com.restapi.FirstRest.job;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<Job>> findAll() {
        List<Job> jobs = jobService.findAll();
        return new ResponseEntity<>(jobs, HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public ResponseEntity<String> createOne(@RequestBody Job job) {
        jobService.createJob(job.getName());
        return new ResponseEntity<>("Job add successfully", HttpStatusCode.valueOf(201));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> findOne (@PathVariable Long id) {
        Job jobFound = jobService.findJobById(id);
        if(jobFound != null) {
            return new ResponseEntity<>(jobFound, HttpStatusCode.valueOf(200));
        }
        return new ResponseEntity<>(HttpStatusCode.valueOf(400));
    }

}
