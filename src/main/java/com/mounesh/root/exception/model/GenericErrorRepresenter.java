package com.mounesh.root.exception.model;

public class GenericErrorRepresenter {
    private String error;
    private int status;
    private String linkToDoc;


    public GenericErrorRepresenter(){}

    public GenericErrorRepresenter(String error, int status, String link){
        this.error = error;
        this.status = status;
        this.linkToDoc = link;
    }
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getLinkToDoc() {
        return linkToDoc;
    }

    public void setLinkToDoc(String linkToDoc) {
        this.linkToDoc = linkToDoc;
    }
}
