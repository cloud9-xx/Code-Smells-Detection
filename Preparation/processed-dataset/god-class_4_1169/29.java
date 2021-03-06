/**
   * Blocks until the interpreter is connected.  Returns {@code true} if the change was successfully passed to
   * the remote JVM.
   */
public boolean addProjectFilesClassPath(File f) {
    InterpreterJVMRemoteI remote = _state.value().interpreter(false);
    if (remote == null) {
        return false;
    }
    try {
        remote.addProjectFilesClassPath(f);
        return true;
    } catch (RemoteException e) {
        _handleRemoteException(e);
        return false;
    }
}
