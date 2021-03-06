@Before
public void setUp() {
    addRule("basic", "AvoidDecimalLiteralsInBigDecimalConstructor");
    addRule("basic", "AvoidMultipleUnaryOperators");
    addRule("basic", "AvoidThreadGroup");
    addRule("basic", "AvoidUsingHardCodedIP");
    //        addRule("basic", "AvoidUsingHardCodedURL"); 
    addRule("basic", "AvoidUsingOctalValues");
    addRule("basic", "BigIntegerInstantiation");
    addRule("basic", "BooleanInstantiation");
    addRule("basic", "BrokenNullCheck");
    addRule("basic", "CheckResultSet");
    addRule("basic", "ClassCastExceptionWithToArray");
    addRule("basic", "CollapsibleIfStatements");
    addRule("basic", "DoubleCheckedLocking");
    addRule("basic", "EmptyCatchBlock");
    addRule("basic", "EmptyFinallyBlock");
    addRule("basic", "EmptyIfStmt");
    addRule("basic", "EmptyInitializer");
    addRule("basic", "EmptyStatementNotInLoop");
    addRule("basic", "EmptyStaticInitializer");
    addRule("basic", "EmptySwitchStatements");
    addRule("basic", "EmptySynchronizedBlock");
    addRule("basic", "EmptyTryBlock");
    addRule("basic", "EmptyWhileStmt");
    addRule("basic", "ForLoopShouldBeWhileLoop");
    addRule("basic", "JumbledIncrementer");
    addRule("basic", "MisplacedNullCheck");
    addRule("basic", "OverrideBothEqualsAndHashcode");
    addRule("basic", "ReturnFromFinallyBlock");
    addRule("basic", "UnconditionalIfStatement");
    addRule("basic", "UnnecessaryFinalModifier");
    addRule("basic", "UnnecessaryReturn");
    addRule("basic", "UnnecessaryConversionTemporary");
    addRule("basic", "UselessOperationOnImmutable");
    addRule("basic", "UselessOverridingMethod");
}
