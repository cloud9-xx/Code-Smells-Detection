/**
     * Report an internal entity declaration.
     *
     * <p>Only the effective (first) declaration for each entity
     * will be reported.</p>
     *
     * @param name The name of the entity.  If it is a parameter
     *        entity, the name will begin with '%'.
     * @param value The replacement text of the entity.
     * @exception SAXException The application may raise an exception.
     * @see #externalEntityDecl
     * @see org.xml.sax.DTDHandler#unparsedEntityDecl
     */
public void internalEntityDecl(String name, String value) throws SAXException {
    // Do not inline external DTD  
    if (m_inExternalDTD)
        return;
    try {
        DTDprolog();
        outputEntityDecl(name, value);
    } catch (IOException e) {
        throw new SAXException(e);
    }
}
