package com.userservice.model;

public enum Interest {
    MANGA("manga", "manga-service"),
    NEWS("news", "news-service");

    private String interest;
    private String service;

    Interest(String interest, String service) {
      this.interest = interest;
      this.service = service;
    }

    public String getInterest() {
      return interest;
    }

    public void setInterest(String interest) {
      this.interest = interest;
    }

    public String getService() {
      return service;
    }

    public void setService(String service) {
      this.service = service;
    }

    @Override
    public String toString() {
      return "Interest{" + "interest='" + interest + '\'' + ", service='" + service + '\'' + '}';
    }
}
