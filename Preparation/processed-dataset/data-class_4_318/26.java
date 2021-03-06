// textDecl(String,String)  
/**
     * A comment.
     *
     * @param text The text in the comment.
     * @param augs     Additional information that may include infoset augmentations
     *
     * @throws XNIException Thrown by application to signal an error.
     */
public void comment(XMLString text, Augmentations augs) throws XNIException {
    // call handlers  
    if (fDocumentHandler != null) {
        fDocumentHandler.comment(text, augs);
    }
}
