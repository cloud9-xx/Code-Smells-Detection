protected final void mFloatSuffix(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
    int _ttype;
    Token _token = null;
    int _begin = text.length();
    _ttype = FloatSuffix;
    int _saveIndex;
    switch(LA(1)) {
        case 'f':
            {
                match('f');
                break;
            }
        case 'F':
            {
                match('F');
                break;
            }
        default:
            {
                throw new NoViableAltForCharException((char) LA(1), getFilename(), getLine(), getColumn());
            }
    }
    if (_createToken && _token == null && _ttype != Token.SKIP) {
        _token = makeToken(_ttype);
        _token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
    }
    _returnToken = _token;
}
