/**
     * Process the xmlfile named <code>fileName</code> with the given system
     * ID.
     * 
     * @param fileName
     *          meta data file name.
     * @param systemId
     *          system ID.
     */
protected void processFile(String fileName, String systemId) throws ValidationException, ParserConfigurationException, SAXException, IOException, SchedulerException, ClassNotFoundException, ParseException, XPathException {
    prepForProcessing();
    log.info("Parsing XML file: " + fileName + " with systemId: " + systemId);
    InputSource is = new InputSource(getInputStream(fileName));
    is.setSystemId(systemId);
    process(is);
    maybeThrowValidationException();
}
