package com.toyproject.simplecrudapp.domains.req;

public interface IReqDto<T> {
  T toEntity();
}
