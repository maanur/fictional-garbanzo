package com.example.domain.model;

public class Version {
    private String version;
    private String host;
    private int port;

    public String getVersion() {
        return version;
    }

    public Version setVersion(String version) {
        this.version = version;
        return this;
    }

    public String getHost() {
        return host;
    }

    public Version setHost(String host) {
        this.host = host;
        return this;
    }

    public int getPort() {
        return port;
    }

    public Version setPort(int port) {
        this.port = port;
        return this;
    }
}
