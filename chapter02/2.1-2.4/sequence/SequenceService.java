package com.apress.springrecipes.sequence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component //컴포넌트가 붙었기때문에 스프링 빈으로 등록됨
@Service
public class SequenceService {

    private final SequenceDao sequenceDao;

    @Autowired
    public SequenceService(SequenceDao sequenceDao) {
        this.sequenceDao = sequenceDao;
    }

    public String generator(String sequenceId) {
        Sequence sequence = sequenceDao.getSequence(sequenceId);
        int value = sequenceDao.getNextValue(sequenceId);
        return sequence.getPrefix() + value + sequence.getSuffix();
    }
}
