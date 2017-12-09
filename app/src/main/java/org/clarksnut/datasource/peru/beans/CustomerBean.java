package org.clarksnut.datasource.peru.beans;

public class CustomerBean {

    private String customerName;
    private String customerAssignedId;
    private String customerDocumentType;
    private PostalAddressBean postalAddress;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAssignedId() {
        return customerAssignedId;
    }

    public void setCustomerAssignedId(String customerAssignedId) {
        this.customerAssignedId = customerAssignedId;
    }


    public PostalAddressBean getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(PostalAddressBean postalAddress) {
        this.postalAddress = postalAddress;
    }

    public String getCustomerDocumentType() {
        return customerDocumentType;
    }

    public void setCustomerDocumentType(String customerDocumentType) {
        this.customerDocumentType = customerDocumentType;
    }
}
