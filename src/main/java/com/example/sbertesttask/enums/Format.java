package com.example.sbertesttask.enums;

import com.fasterxml.jackson.annotation.JsonIgnore;

public enum Format {
    @JsonIgnore
    UNKNOWN,
    FULL,
    SERIES,
    SHORT
}
