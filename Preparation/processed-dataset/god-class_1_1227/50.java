public final void mComment(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
    int _ttype;
    Token _token = null;
    int _begin = text.length();
    _ttype = Comment;
    int _saveIndex;
    match("/*");
    {
        _loop529: do {
            if (((LA(1) == '*') && ((LA(2) >= ' ' && LA(2) <= 'ÿ')) && ((LA(3) >= ' ' && LA(3) <= 'ÿ'))) && (LA(2) != '/')) {
                match('*');
            } else if ((LA(1) == '\n' || LA(1) == '\r')) {
                mEndOfLine(false);
                if (inputState.guessing == 0) {
                    newline();
                }
            } else if ((_tokenSet_1.member(LA(1)))) {
                {
                    match(_tokenSet_1);
                }
            } else {
                break _loop529;
            }
        } while (true);
    }
    match("*/");
    if (inputState.guessing == 0) {
        _ttype = Token.SKIP;
    }
    if (_createToken && _token == null && _ttype != Token.SKIP) {
        _token = makeToken(_ttype);
        _token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
    }
    _returnToken = _token;
}
