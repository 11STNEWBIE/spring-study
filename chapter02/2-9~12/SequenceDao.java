package chapter2.sub9;

public interface SequenceDao {
    public Sequence getSequense(String sequenceId);
    public int getNextValue(String sequenceId);
}
