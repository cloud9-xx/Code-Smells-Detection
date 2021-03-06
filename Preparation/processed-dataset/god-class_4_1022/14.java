/**
   * Handles the threading of doing an openAllFolders.
   */
private void doOpenFolders(FolderInfo fi, int mode) {
    if (Pooka.getProperty("Pooka.openFoldersInBackground", "false").equalsIgnoreCase("true")) {
        final FolderInfo current = fi;
        final int finalMode = mode;
        javax.swing.AbstractAction openFoldersAction = new javax.swing.AbstractAction() {

            public void actionPerformed(java.awt.event.ActionEvent e) {
                current.openAllFolders(finalMode);
            }
        };
        openFoldersAction.putValue(javax.swing.Action.NAME, "file-open");
        openFoldersAction.putValue(javax.swing.Action.SHORT_DESCRIPTION, "file-open on folder " + fi.getFolderID());
        getFolderThread().addToQueue(openFoldersAction, new java.awt.event.ActionEvent(this, 0, "open-all"), ActionThread.PRIORITY_LOW);
    } else {
        fi.openAllFolders(mode);
    }
}
