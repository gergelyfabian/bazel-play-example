load("//tools:webjars.bzl", "unpack_webjar")

filegroup(
    name = "public",
    srcs = glob(["**/*"]),
    visibility = ["//visibility:public"],
)

unpack_webjar(
    name = "unpack_webjar_bootstrap",
    files = [
        "css/bootstrap.css",
        "css/bootstrap.css.map",
        "css/bootstrap-theme.css",
        "css/bootstrap-theme.css.map",
    ],
    jar_internal_path = "META-INF/resources/webjars/bootstrap/3.4.1",
    play_prefix = "lib/bootstrap",
    webjar_target = "@maven//:org_webjars_bootstrap",
)

unpack_webjar(
    name = "unpack_webjar_jquery",
    files = [
        "jquery.min.js",
        "jquery.min.map",
    ],
    jar_internal_path = "META-INF/resources/webjars/jquery/1.11.1",
    play_prefix = "lib/jquery",
    webjar_target = "@maven//:org_webjars_jquery",
)
