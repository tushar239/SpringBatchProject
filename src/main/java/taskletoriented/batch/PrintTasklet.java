package taskletoriented.batch;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

/**
 * Created by chokst on 1/22/15.
 */
public class PrintTasklet implements Tasklet {

    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        System.out.print(message);

        // without any exception or manual setting of ExitStatus, if everything goes well ExitStatus of the step is set to COMPLETED

        /*if("hello".equalsIgnoreCase(message)) {
            return RepeatStatus.CONTINUABLE; // This will call the same Tasklet again.
        }*/
        /*
        if("hello".equalsIgnoreCase(message)) {
            //throw new RuntimeException("some exception");// This will  set exitStatus=exitCode=COMPLETED, but it will still consider exitCode=FAILED
            stepContribution.setExitStatus(ExitStatus.FAILED); // This will  set exitStatus=exitCode=FAILED
        }
        */

        return RepeatStatus.FINISHED; // This means job of this tasklet is finished and continue to the next one.
    }
}