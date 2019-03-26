package recipe2_1_1.sequence;

import java.util.concurrent.atomic.AtomicInteger;

public class SequenceGenerator {


        private String prefix;
        private String suffix;
        private int initial;

        private final AtomicInteger counter = new AtomicInteger();

        public SequenceGenerator() {
        }

        public void setPrefix(String prefix) {
            this.prefix = prefix;
        }

        public void setSuffix(String suffix) {
            this.suffix = suffix;
        }

        public void setInitial(int initial) {
            this.initial = initial;
        }

        public String getSequence() {
            StringBuilder builder = new StringBuilder();
            builder.append(prefix)
                    .append(initial)
                    .append(counter.getAndIncrement())
                    .append(suffix);
            return builder.toString();
        }


    }

