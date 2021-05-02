package com.toyproject.simplecrudapp.domains;

public interface IDto<T> {
  T toEntity();
}
