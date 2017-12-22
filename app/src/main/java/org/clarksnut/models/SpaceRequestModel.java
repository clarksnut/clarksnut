package org.clarksnut.models;

import java.util.Date;
import java.util.List;

public interface SpaceRequestModel {

    String getId();

    String getMessage();

    RequestType getType();

    RequestStatusType getStatus();

    void setStatus(RequestStatusType status);

    String getFileId();

    String getFileProvider();

    Date getCreatedAt();

    Date getUpdatedAt();

    SpaceModel getSpace();
}
