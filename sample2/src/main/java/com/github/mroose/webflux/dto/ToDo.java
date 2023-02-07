package com.github.mroose.webflux.dto;

public record ToDo(Integer userId, Integer id, String title, Boolean completed) {}