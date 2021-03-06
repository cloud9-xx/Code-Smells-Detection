private void replaceColumnIndexInOrderBy(Expression orderBy) {
    Expression e = orderBy.getLeftNode();
    if (e.getType() != OpTypes.VALUE) {
        return;
    }
    if (e.getDataType().typeCode == Types.SQL_INTEGER) {
        int i = ((Integer) e.getValue(null)).intValue();
        if (0 < i && i <= indexLimitVisible) {
            orderBy.setLeftNode(exprColumns[i - 1]);
            return;
        }
    }
    throw Error.error(ErrorCode.X_42576);
}
