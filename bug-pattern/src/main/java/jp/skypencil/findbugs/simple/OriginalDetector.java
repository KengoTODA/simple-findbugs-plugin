package jp.skypencil.findbugs.simple;

import edu.umd.cs.findbugs.BugInstance;
import edu.umd.cs.findbugs.BugReporter;
import edu.umd.cs.findbugs.bcel.OpcodeStackDetector;

public class OriginalDetector extends OpcodeStackDetector {
    private final BugReporter bugReporter;

    public OriginalDetector(BugReporter bugReporter) {
        this.bugReporter = bugReporter;
    }

    @Override
    public void sawOpcode(int opcode) {
        if (!isBug(opcode)) {
            return;
        }

        BugInstance bug = new BugInstance("SIMPLE_BUG", LOW_PRIORITY)
                .addClassAndMethod(this).addSourceLine(this);
        bugReporter.reportBug(bug);
    }

    boolean isBug(int opcode) {
        return opcode != NOP;
    }
}