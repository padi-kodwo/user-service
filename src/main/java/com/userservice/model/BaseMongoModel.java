package com.userservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class BaseMongoModel {

  @Id
  @Field("_id")
  @Indexed
  @JsonProperty("id")
  protected ObjectId id;

  @Version protected Long version;

  @CreatedDate
  @Field("_created")
  @Indexed
  protected Date created;

  @LastModifiedDate
  @Field("_modified")
  @Indexed
  protected Date modified;

  @JsonProperty("idString")
  public String getIdString() {
    return (id != null) ? id.toHexString() : null;
  }

  public void setIdString(ObjectId id) {
    this.id = id;
  }

  public Date getCreated() {
    return created;
  }

  public Date getModified() {
    return modified;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }
}
