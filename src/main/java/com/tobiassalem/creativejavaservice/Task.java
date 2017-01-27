package com.tobiassalem.creativejavaservice;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Tobias on 2017-01-27.
 */
public class Task {

    private long id;

    private String content;

    public Task() {
        // Jackson deserialization
    }

    public Task(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}
