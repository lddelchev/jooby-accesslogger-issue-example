FROM gradle:jdk17

COPY . .
RUN gradle installDist

EXPOSE 8080

ENTRYPOINT ["./build/install/jooby-accesslogger-issue-example/bin/jooby-accesslogger-issue-example"]
