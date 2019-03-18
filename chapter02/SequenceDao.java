package chapter2.sub1;

public interface SequenceDao {
    public Sequence getSequense(String sequenceId);
    public int getNextValue(String sequenceId);
}
