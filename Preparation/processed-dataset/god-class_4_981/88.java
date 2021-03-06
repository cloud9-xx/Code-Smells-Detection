protected Calendar retrieveCalendar(Connection conn, SchedulingContext ctxt, String calName) throws JobPersistenceException {
    // all calendars are persistent, but we can lazy-cache them during run 
    // time as long as we aren't running clustered. 
    Calendar cal = (isClustered) ? null : (Calendar) calendarCache.get(calName);
    if (cal != null) {
        return cal;
    }
    try {
        cal = getDelegate().selectCalendar(conn, calName);
        if (isClustered == false) {
            calendarCache.put(calName, cal);
        }
        return cal;
    } catch (ClassNotFoundException e) {
        throw new JobPersistenceException("Couldn't retrieve calendar because a required class was not found: " + e.getMessage(), e);
    } catch (IOException e) {
        throw new JobPersistenceException("Couldn't retrieve calendar because the BLOB couldn't be deserialized: " + e.getMessage(), e);
    } catch (SQLException e) {
        throw new JobPersistenceException("Couldn't retrieve calendar: " + e.getMessage(), e);
    }
}
