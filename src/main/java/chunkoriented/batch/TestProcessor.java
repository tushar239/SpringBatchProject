package chunkoriented.batch;

import org.springframework.batch.item.ItemProcessor;

import java.util.Locale;

public class TestProcessor implements ItemProcessor<User, User> {

    public User process(User user) throws Exception {
        user.setName(user.getName().toUpperCase(Locale.ENGLISH));
        user.setSurname(user.getSurname().toUpperCase(Locale.ENGLISH));
        return user;
    }
}
