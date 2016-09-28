package taskletoriented.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// http://www.techavalanche.com/2011/08/21/spring-batch-hello-world-in-memory/

// Example of tasklet oriented job is described here. It is used when both readers and writers are not required
// There can be chunk oriented job also, where you can have reader-processor-writer and commit-interval. After reading and processing the records as per commit-interval, records are written together using a writer.

public class BatchLauncher {

    public static Job job;
    public static JobLauncher jobLauncher;
    public static JobRepository jobRepository;

    public static void main(String args[]) {
        try {
            AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("simpleJob.xml");

            JobParametersBuilder builder = new JobParametersBuilder();
            builder.addString("Date", "12/02/2011");
            jobLauncher.run(job, builder.toJobParameters());

            JobExecution jobExecution = jobRepository.getLastJobExecution(job.getName(), builder.toJobParameters());
            System.out.println(jobExecution.toString());// JobExecution: id=0, version=2, startTime=Thu Mar 05 12:33:28 PST 2015, endTime=Thu Mar 05 12:33:29 PST 2015, lastUpdated=Thu Mar 05 12:33:29 PST 2015, status=COMPLETED, exitStatus=exitCode=COMPLETED;exitDescription=, job=[JobInstance: id=0, version=0, JobParameters=[{Date=12/02/2011}], Job=[mySimpleJob]]
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void setJobLauncher(JobLauncher jobLauncher) {
        this.jobLauncher = jobLauncher;
    }

    public void setJobRepository(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}