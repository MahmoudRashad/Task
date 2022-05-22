package com.rashad.domain.authentication.common

enum class ResourceType {
  LOADING,
  SUCCESS,
  ERROR,
  VALIDATION_ERROR,
  CONNECTION_ERROR,
  UNKNOWN_ERROR,
  SERVER_ERROR,
  FORBIDDEN_ERROR,
  NOT_FOUND,
  NOT_AUTHORIZE,
  LOGIN_ERRORS,
  BAD_REQUEST
}