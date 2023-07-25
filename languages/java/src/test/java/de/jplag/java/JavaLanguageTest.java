package de.jplag.java;

import static de.jplag.java.JavaTokenType.*;

import de.jplag.testutils.LanguageModuleTest;
import de.jplag.testutils.datacollector.TestDataCollector;
import de.jplag.testutils.datacollector.TestSourceIgnoredLinesCollector;

public class JavaLanguageTest extends LanguageModuleTest {
    public JavaLanguageTest() {
        super(new JavaLanguage(), JavaTokenType.class);
    }

    @Override
    protected void collectTestData(TestDataCollector collector) {
        collector.testFile("IfElse.java", "IfIf.java", "IfElseIf.java").testSourceCoverage().testTokenSequence(J_IMPORT, J_CLASS_BEGIN,
                J_METHOD_BEGIN, J_VARDEF, J_IF_BEGIN, J_THROW, J_NEWCLASS, J_IF_END, J_IF_BEGIN, J_APPLY, J_APPLY, J_IF_END, J_METHOD_END,
                J_CLASS_END);
        collector.testFile("IfWithBraces.java", "IfWithoutBraces.java").testSourceCoverage().testTokenSequence(J_PACKAGE, J_IMPORT, J_CLASS_BEGIN,
                J_METHOD_BEGIN, J_VARDEF, J_IF_BEGIN, J_THROW, J_NEWCLASS, J_IF_END, J_IF_BEGIN, J_APPLY, J_APPLY, J_IF_END, J_IF_BEGIN, J_APPLY,
                J_IF_END, J_METHOD_END, J_CLASS_END);
        collector.testFile("Verbose.java", "Compact.java").testSourceCoverage().testTokenSequence(J_PACKAGE, J_IMPORT, J_CLASS_BEGIN, J_METHOD_BEGIN,
                J_VARDEF, J_VARDEF, J_IF_BEGIN, J_APPLY, J_RETURN, J_IF_END, J_VARDEF, J_FOR_BEGIN, J_VARDEF, J_APPLY, J_ASSIGN, J_IF_BEGIN, J_APPLY,
                J_APPLY, J_ASSIGN, J_IF_END, J_FOR_END, J_IF_BEGIN, J_APPLY, J_ASSIGN, J_IF_END, J_IF_BEGIN, J_APPLY, J_APPLY, J_ASSIGN, J_IF_END,
                J_RETURN, J_METHOD_END, J_CLASS_END);
        collector.testFile("Try.java", "TryWithResource.java").testSourceCoverage().testTokenSequence(J_PACKAGE, J_IMPORT, J_IMPORT, J_IMPORT,
                J_CLASS_BEGIN, J_METHOD_BEGIN, J_VARDEF, J_APPLY, J_NEWCLASS, J_METHOD_END, J_METHOD_BEGIN, J_VARDEF, J_VARDEF, J_TRY_BEGIN, J_VARDEF,
                J_ASSIGN, J_NEWCLASS, J_NEWCLASS, J_WHILE_BEGIN, J_APPLY, J_APPLY, J_APPLY, J_WHILE_END, J_CATCH_BEGIN, J_VARDEF, J_APPLY,
                J_CATCH_END, J_FINALLY_BEGIN, J_IF_BEGIN, J_APPLY, J_IF_END, J_FINALLY_END, J_TRY_END, J_METHOD_END, J_CLASS_END);

        collector.testFile("CLI.java").testSourceCoverage().testContainedTokens(J_TRY_END, J_IMPORT, J_VARDEF, J_FOR_BEGIN, J_ARRAY_INIT_BEGIN,
                J_IF_BEGIN, J_CATCH_END, J_COND, J_ARRAY_INIT_END, J_METHOD_BEGIN, J_TRY_BEGIN, J_CLASS_END, J_RETURN, J_ASSIGN, J_METHOD_END,
                J_IF_END, J_CLASS_BEGIN, J_NEWARRAY, J_PACKAGE, J_APPLY, J_FOR_END, J_THROW, J_NEWCLASS, J_CATCH_BEGIN);
    }

    @Override
    protected void configureIgnoredLines(TestSourceIgnoredLinesCollector collector) {
        collector.ignoreLinesByPrefix("//");
        collector.ignoreMultipleLines("/*", "*/");
        collector.ignoreLinesByPrefix("})");
        collector.ignoreByCondition(line -> line.contains("else") && !line.contains("if"));
    }
}
