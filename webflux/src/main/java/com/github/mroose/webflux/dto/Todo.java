package com.github.mroose.webflux.dto;

public record Todo(Integer userId, Integer id, String title, Boolean completed) {}