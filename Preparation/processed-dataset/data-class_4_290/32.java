/**
     * Responsible for handling check constraints section of CREATE TABLE ...
     *
     * @param c check constraint
     */
void readCheckConstraintCondition(Constraint c) {
    readThis(Tokens.OPENBRACKET);
    startRecording();
    isCheckOrTriggerCondition = true;
    Expression condition = XreadBooleanValueExpression();
    isCheckOrTriggerCondition = false;
    Token[] tokens = getRecordedStatement();
    readThis(Tokens.CLOSEBRACKET);
    c.check = condition;
}
