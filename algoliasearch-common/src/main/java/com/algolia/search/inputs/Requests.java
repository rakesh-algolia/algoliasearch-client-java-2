package com.algolia.search.inputs;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Requests {

  private final List<Request> requests;

  public Requests(List<Request> requests) {
    this.requests = requests;
  }

  @SuppressWarnings("unused")
  public List<Request> getRequests() {
    return requests;
  }

  public static class Request {

    private String indexName;
    private String objectID;

    @SuppressWarnings("unused")
    public String getIndexName() {
      return indexName;
    }

    @SuppressWarnings("unused")
    public Request setIndexName(String indexName) {
      this.indexName = indexName;
      return this;
    }

    @SuppressWarnings("unused")
    public String getObjectID() {
      return objectID;
    }

    @SuppressWarnings("unused")
    public Request setObjectID(String objectID) {
      this.objectID = objectID;
      return this;
    }
  }

}
