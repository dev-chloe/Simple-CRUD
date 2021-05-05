package com.toyproject.simplecrudapp.domains;

public interface IReqDto<T> {
  T toEntity();
}
