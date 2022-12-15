# Jooby AccessLogHandler issue example
A barebone project to reproduce `AccessLogHandler` issue when using [Jooby with Coroutines](https://jooby.io/#responses-nonblocking-kotlin-coroutines)
## How to build and run

### Local

```bash
gradle installDist
```
```bash
./build/install/jooby-accesslogger-issue-example/bin/jooby-accesslogger-issue-example
```

### Docker
```bash
docker build -t example .
```
```bash
docker run example
```

## Example request

```bash
curl -X GET --location "http://localhost:8080/status"
```

## Issue
Logs from `AccessLogHandler` miss the HTTP protocol and content length.

Expected:
`17:32:17.206 INFO  io.jooby.AccessLogHandler - 127.0.0.1 - - [14/Dec/2022:17:32:17 +0200] "GET /status HTTP/1.1" 200 2 1`

Actual:
`17:32:17.206 INFO  io.jooby.AccessLogHandler - 127.0.0.1 - - [14/Dec/2022:17:32:17 +0200] "GET /status null" 200 - 1`
