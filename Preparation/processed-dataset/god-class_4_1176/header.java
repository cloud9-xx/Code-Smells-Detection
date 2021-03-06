void method0() { 
private static final String COMMENT_BEGIN = "<!--";
private static final String COMMENT_END = "-->";
/** Stack to keep track of disabling output escaping. */
protected BoolStack m_disableOutputEscapingStates = new BoolStack();
/**
     * The encoding information associated with this serializer.
     * Although initially there is no encoding,
     * there is a dummy EncodingInfo object that will say
     * that every character is in the encoding. This is useful
     * for a serializer that is in temporary output state and has
     * no associated encoding. A serializer in final output state
     * will have an encoding, and will worry about whether 
     * single chars or surrogate pairs of high/low chars form
     * characters in the output encoding. 
     */
EncodingInfo m_encodingInfo = new EncodingInfo(null, null, ' ');
/**
     * Stack to keep track of whether or not we need to
     * preserve whitespace.
     * 
     * Used to push/pop values used for the field m_ispreserve, but
     * m_ispreserve is only relevant if m_doIndent is true.
     * If m_doIndent is false this field has no impact.
     * 
     */
protected BoolStack m_preserves = new BoolStack();
/**
     * State flag to tell if preservation of whitespace
     * is important. 
     * 
     * Used only in shouldIndent() but only if m_doIndent is true.
     * If m_doIndent is false this flag has no impact.
     * 
     */
protected boolean m_ispreserve = false;
/**
     * State flag that tells if the previous node processed
     * was text, so we can tell if we should preserve whitespace.
     * 
     * Used in endDocument() and shouldIndent() but
     * only if m_doIndent is true. 
     * If m_doIndent is false this flag has no impact.
     */
protected boolean m_isprevtext = false;
private static final char[] s_systemLineSep;
/**
     * The system line separator for writing out line breaks.
     * The default value is from the system property,
     * but this value can be set through the xsl:output
     * extension attribute xalan:line-separator.
     */
protected char[] m_lineSep = s_systemLineSep;
/**
     * True if the the system line separator is to be used.
     */
protected boolean m_lineSepUse = true;
/**
     * The length of the line seperator, since the write is done
     * one character at a time.
     */
protected int m_lineSepLen = m_lineSep.length;
/**
     * Map that tells which characters should have special treatment, and it
     *  provides character to entity name lookup.
     */
protected CharInfo m_charInfo;
/** True if we control the buffer, and we should flush the output on endDocument. */
boolean m_shouldFlush = true;
/**
     * Add space before '/>' for XHTML.
     */
protected boolean m_spaceBeforeClose = false;
/**
     * Flag to signal that a newline should be added.
     * 
     * Used only in indent() which is called only if m_doIndent is true.
     * If m_doIndent is false this flag has no impact.
     */
boolean m_startNewLine;
/**
     * Tells if we're in an internal document type subset.
     */
protected boolean m_inDoctype = false;
/**
       * Flag to quickly tell if the encoding is UTF8.
       */
boolean m_isUTF8 = false;
/**
     * remembers if we are in between the startCDATA() and endCDATA() callbacks
     */
protected boolean m_cdataStartCalled = false;
/**
     * If this flag is true DTD entity references are not left as-is,
     * which is exiting older behavior.
     */
private boolean m_expandDTDEntities = true;
/**
     * Taken from XSLTC 
     */
protected boolean m_escaping = true;
OutputStream m_outputStream;
private boolean m_writer_set_by_user;
}
