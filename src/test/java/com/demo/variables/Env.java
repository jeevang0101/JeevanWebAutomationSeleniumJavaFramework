package com.demo.variables;

public enum Env {
    PROD("prod"),
    STAGE("stage");

    public final String env;

    Env(String env) {
        this.env = env;
    }
}
