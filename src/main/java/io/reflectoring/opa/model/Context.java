package io.reflectoring.opa.model;

public class Context {
    private Identity identity;
    private SoftwareStack softwareStack;

    // Getters and Setters
    public Identity getIdentity() {
        return identity;
    }

    public void setIdentity(Identity identity) {
        this.identity = identity;
    }

    public SoftwareStack getSoftwareStack() {
        return softwareStack;
    }

    public void setSoftwareStack(SoftwareStack softwareStack) {
        this.softwareStack = softwareStack;
    }
}
