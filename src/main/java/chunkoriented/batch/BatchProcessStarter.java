package chunkoriented.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// Example of Chunk oriented Spring batch introducing ItemReader, ItemProcessor and ItemWriter

// http://www.javacodegeeks.com/2012/12/chunk-oriented-processing-in-spring-batch.html
/*
    commit-interval=2, so reader will be called twice and two User objects will be stored in memory
    processor processes these two User objects one by one
    Both User objects (list of User objects) are given to writer together
*/
public class BatchProcessStarter {

    public static Job chunkJob;
    public static JobLauncher jobLauncher;
    public static JobRepository jobRepository;

    public static void main(String args[]) {
        try {
            AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("simpleJob.xml");

            JobParametersBuilder builder = new JobParametersBuilder();
            //builder.addString("Date", "12/02/2011");
            jobLauncher.run(chunkJob, builder.toJobParameters());

            JobExecution jobExecution = jobRepository.getLastJobExecution(chunkJob.getName(), builder.toJobParameters());
            System.out.println(jobExecution.toString());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void setChunkJob(Job chunkJob) {
        this.chunkJob = chunkJob;
    }

    public void setJobLauncher(JobLauncher jobLauncher) {
        this.jobLauncher = jobLauncher;
    }

    public void setJobRepository(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }
}
