package org.clarksnut.models;

import org.clarksnut.files.FileModel;

import java.util.List;

public interface SpaceRequestProvider {

    SpaceRequestModel addRequest(SpaceModel space,
                                 UserModel user,
                                 FileModel userPhotograph,
                                 String message,
                                 RequestAccessScope type);

    SpaceRequestModel getRequest(String id);

    List<SpaceRequestModel> getRequests(SpaceModel space);

    List<SpaceRequestModel> getRequests(SpaceModel space, int offset, int limit);

}
