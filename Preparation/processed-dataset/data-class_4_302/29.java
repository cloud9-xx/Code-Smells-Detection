// getRecognizedFeatures():String[]  
/**
     * Sets the state of a feature. This method is called by the component
     * manager any time after reset when a feature changes state.
     * <p>
     * <strong>Note:</strong> Components should silently ignore features
     * that do not affect the operation of the component.
     *
     * @param featureId The feature identifier.
     * @param state     The state of the feature.
     *
     * @throws SAXNotRecognizedException The component should not throw
     *                                   this exception.
     * @throws SAXNotSupportedException The component should not throw
     *                                  this exception.
     */
public void setFeature(String featureId, boolean state) throws XMLConfigurationException {
    // xerces features  
    if (featureId.startsWith(Constants.XERCES_FEATURE_PREFIX)) {
        final int suffixLength = featureId.length() - Constants.XERCES_FEATURE_PREFIX.length();
        if (suffixLength == Constants.ALLOW_JAVA_ENCODINGS_FEATURE.length() && featureId.endsWith(Constants.ALLOW_JAVA_ENCODINGS_FEATURE)) {
            fAllowJavaEncodings = state;
        }
    }
}
