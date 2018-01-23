package com.algolia.search;

import com.algolia.search.exceptions.AlgoliaException;
import com.algolia.search.inputs.partial_update.PartialUpdateOperation;
import com.algolia.search.objects.RequestOptions;
import com.algolia.search.objects.tasks.sync.TaskSingleIndex;
import java.util.List;
import javax.annotation.Nonnull;

public interface SyncPartialUpdate<T> extends SyncBaseIndex<T> {

  /**
   * Partially update an object
   *
   * @param objectID the ID of object to update
   * @param object the object to update
   * @return the associated task
   * @throws AlgoliaException
   * @see PartialUpdateOperation & subclasses
   */
  default TaskSingleIndex partialUpdateObject(@Nonnull String objectID, @Nonnull Object object)
      throws AlgoliaException {
    return partialUpdateObject(objectID, object, RequestOptions.empty);
  }

  /**
   * Partially update an object
   *
   * @param objectID the ID of object to update
   * @param object the object to update
   * @param requestOptions Options to pass to this request
   * @return the associated task
   * @throws AlgoliaException
   * @see PartialUpdateOperation & subclasses
   */
  default TaskSingleIndex partialUpdateObject(
      @Nonnull String objectID, @Nonnull Object object, @Nonnull RequestOptions requestOptions)
      throws AlgoliaException {
    return getApiClient().partialUpdateObject(getName(), objectID, object, requestOptions);
  }

  /**
   * Partially update a objects
   *
   * @param objects the list of objects to update (with an objectID)
   * @return the associated task
   * @throws AlgoliaException
   */
  default TaskSingleIndex partialUpdateObjects(@Nonnull List<Object> objects)
      throws AlgoliaException {
    return partialUpdateObjects(objects, RequestOptions.empty);
  }

  /**
   * Partially update a objects
   *
   * @param objects the list of objects to update (with an objectID)
   * @param requestOptions Options to pass to this request
   * @return the associated task
   * @throws AlgoliaException
   */
  default TaskSingleIndex partialUpdateObjects(
      @Nonnull List<Object> objects, @Nonnull RequestOptions requestOptions)
      throws AlgoliaException {
    return partialUpdateObjects(objects, true, requestOptions);
  }

  /**
   * Partially update a objects
   *
   * @param objects the list of objects to update (with an objectID)
   * @param requestOptions Options to pass to this request
   * @param createIfNotExists Value that indicates the object is created if the objectID doesn't
   *     exists
   * @return the associated task
   * @throws AlgoliaException
   */
  default TaskSingleIndex partialUpdateObjects(
      @Nonnull List<Object> objects,
      boolean createIfNotExists,
      @Nonnull RequestOptions requestOptions)
      throws AlgoliaException {
    return getApiClient()
        .partialUpdateObjects(getName(), objects, requestOptions, createIfNotExists);
  }

  /**
   * Partially update an object, create the object if it does not exist
   *
   * @param operation the operation to perform on this object
   * @return the associated task
   * @throws AlgoliaException
   * @see PartialUpdateOperation & subclasses
   */
  default TaskSingleIndex partialUpdateObject(@Nonnull PartialUpdateOperation operation)
      throws AlgoliaException {
    return partialUpdateObject(operation, true);
  }

  /**
   * Partially update an object, create the object if it does not exist
   *
   * @param operation the operation to perform on this object
   * @param requestOptions Options to pass to this request
   * @return the associated task
   * @throws AlgoliaException
   * @see PartialUpdateOperation & subclasses
   */
  default TaskSingleIndex partialUpdateObject(
      @Nonnull PartialUpdateOperation operation, @Nonnull RequestOptions requestOptions)
      throws AlgoliaException {
    return partialUpdateObject(operation, true, requestOptions);
  }

  /**
   * Partially update an object
   *
   * @param operation the operation to perform on this object
   * @param createIfNotExists should the object be created or not
   * @return the associated task
   * @throws AlgoliaException
   * @see PartialUpdateOperation & subclasses
   */
  default TaskSingleIndex partialUpdateObject(
      @Nonnull PartialUpdateOperation operation, boolean createIfNotExists)
      throws AlgoliaException {
    return partialUpdateObject(operation, createIfNotExists, RequestOptions.empty);
  }

  /**
   * Partially update an object
   *
   * @param operation the operation to perform on this object
   * @param createIfNotExists should the object be created or not
   * @param requestOptions Options to pass to this request
   * @return the associated task
   * @throws AlgoliaException
   * @see PartialUpdateOperation & subclasses
   */
  default TaskSingleIndex partialUpdateObject(
      @Nonnull PartialUpdateOperation operation,
      boolean createIfNotExists,
      @Nonnull RequestOptions requestOptions)
      throws AlgoliaException {
    return getApiClient()
        .partialUpdateObject(getName(), operation, createIfNotExists, requestOptions);
  }
}
