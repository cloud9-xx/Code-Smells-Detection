public final void mCharLiteral(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
    int _ttype;
    Token _token = null;
    int _begin = text.length();
    _ttype = CharLiteral;
    int _saveIndex;
    match('\'');
    {
        if ((LA(1) == '\\') && (_tokenSet_3.member(LA(2))) && (_tokenSet_4.member(LA(3)))) {
            mEscape(false);
        } else if ((_tokenSet_5.member(LA(1))) && (LA(2) == '\'') && (true)) {
            {
                match(_tokenSet_5);
            }
        } else {
            throw new NoViableAltForCharException((char) LA(1), getFilename(), getLine(), getColumn());
        }
    }
    match('\'');
    if (_createToken && _token == null && _ttype != Token.SKIP) {
        _token = makeToken(_ttype);
        _token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
    }
    _returnToken = _token;
}
