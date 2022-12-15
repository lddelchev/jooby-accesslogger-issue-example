package com.example

import io.jooby.AccessLogHandler
import io.jooby.Kooby

class Application : Kooby({
    decorator(AccessLogHandler())

    coroutine {
        get("/status") {
            "OK"
        }
    }
})
