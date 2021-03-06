/**
   * Updates any caching information, if necessary.
   */
protected void updateCache() throws MessagingException {
    if (isConnected()) {
        synchronizeCache();
    }
}
