package chunkoriented.batch;

import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class TestWriter implements ItemWriter<User> {

    public void write(List<? extends User> userList) throws Exception {
        for (User user : userList) {
            System.out.println(user.getName());
        }
    }
}