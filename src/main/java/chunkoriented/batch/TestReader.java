package chunkoriented.batch;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;


/**
 * Created by chokst on 1/22/15.
 */
public class TestReader implements ItemReader<User> {
    private int index;
    private int maxIndex;
    private String namePrefix;
    private String surnamePrefix;

    public User read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        User user = new User();
        user.setName(getNamePrefix() + '_' + index);
        user.setSurname(getSurnamePrefix() + '_' + index);
        if(index > getMaxIndex()) {
            return null;
        }
        incrementIndex();
        return user;
    }
    private int incrementIndex() {
        return index++;
    }
    public int getMaxIndex() {
        return maxIndex;
    }
    public void setMaxIndex(int maxIndex) {
        this.maxIndex = maxIndex;
    }
    public String getNamePrefix() {
        return namePrefix;
    }
    public void setNamePrefix(String namePrefix) {
        this.namePrefix = namePrefix;
    }
    public String getSurnamePrefix() {
        return surnamePrefix;
    }
    public void setSurnamePrefix(String surnamePrefix) {
        this.surnamePrefix = surnamePrefix;
    }
}

