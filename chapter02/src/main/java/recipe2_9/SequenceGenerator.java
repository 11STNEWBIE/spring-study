package recipe2_9;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Bean;

public class SequenceGenerator {

    private PrefixGenerator prefixGenerator;
    private String suffix;
    private int initial;
    private int counter;

        public SequenceGenerator(){}

        public SequenceGenerator(PrefixGenerator prefixGenerator, String suffix, int initial) {
            this.prefixGenerator = prefixGenerator;
            this.suffix = suffix;
            this.initial = initial;
        }

        @Required
        public void setPrefixGenerator(PrefixGenerator prefixGenerator) {
            this.prefixGenerator = prefixGenerator;
        }

        @Required
        public void setSuffix(String suffix) {
            this.suffix = suffix;
        }

        public void setInitial(int initial) {
            this.initial = initial;
        }

        public String getSequence() {
            StringBuilder builder = new StringBuilder();
            builder.append(prefixGenerator.getPrefix());
            builder.append(initial + counter++);
            builder.append(suffix);
            return builder.toString();
        }


    }

