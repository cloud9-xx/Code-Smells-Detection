/**
     * Process the xmlfile named <code>fileName</code> with the given system
     * ID.
     * 
     * @param stream
     *          an input stream containing the xml content.
     * @param systemId
     *          system ID.
     */
public void processStreamAndScheduleJobs(InputStream stream, String systemId, Scheduler sched) throws ValidationException, ParserConfigurationException, SAXException, XPathException, IOException, SchedulerException, ClassNotFoundException, ParseException {
    prepForProcessing();
    log.info("Parsing XML from stream with systemId: " + systemId);
    InputSource is = new InputSource(stream);
    is.setSystemId(systemId);
    process(is);
    executePreProcessCommands(sched);
    scheduleJobs(sched);
    maybeThrowValidationException();
}
