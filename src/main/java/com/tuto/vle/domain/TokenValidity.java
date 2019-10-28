package com.tuto.vle.domain;

public class TokenValidity {
  private int userId;
  private int tokenId;
  private String tokanHash;


  public TokenValidity(int userId, int tokenId, String tokanHash) {
    super();
    this.userId = userId;
    this.tokenId = tokenId;
    this.tokanHash = tokanHash;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public int getTokenId() {
    return tokenId;
  }

  public void setTokenId(int tokenId) {
    this.tokenId = tokenId;
  }

  public String getTokanHash() {
    return tokanHash;
  }

  public void setTokanHash(String tokanHash) {
    this.tokanHash = tokanHash;
  }



}
