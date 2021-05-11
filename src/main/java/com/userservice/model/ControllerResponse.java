package com.userservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ControllerResponse {

    private int code;
    private String message;
    private List<Object> data;
    private long total;
    private long duration;
    private String requestId;

    public ControllerResponse(
        int code, String message, List<Object> data, long total, long duration, String requestId) {
      this.code = code;
      this.message = message;
      this.data = data;
      this.total = total;
      this.duration = duration;
      this.requestId = requestId;
    }

    @Override
    public String toString() {
      return "ControllerResponse{"
          + "code="
          + code
          + ", message='"
          + message
          + '\''
          + ", data="
          + data
          + ", total="
          + total
          + ", duration="
          + duration
          + '}';
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      ControllerResponse that = (ControllerResponse) o;
      return code == that.code
          && total == that.total
          && duration == that.duration
          && Objects.equals(message, that.message)
          && Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
      return Objects.hash(code, message, data, total, duration);
    }
}
