package com.example.ch2.p3;

import com.example.ch2.p1.Sequence;
import com.example.ch2.p1.SequenceDao;
import org.springframework.beans.factory.annotation.Autowired;

public class SequenceService {
    @Autowired
    private SequenceDao sequenceDao;

    public void setSequenceDao(SequenceDao sequenceDao) {
        this.sequenceDao = sequenceDao;
    }
    public String generate(String sequenceId) {
        Sequence sequence = sequenceDao.getSequence(sequenceId);
        int value = sequenceDao.getNextValue(sequenceId);
        return sequence.getPrefix() + value + sequence.getSuffix();
    }
}
