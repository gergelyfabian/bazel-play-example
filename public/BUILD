load("@io_bazel_rules_play_utils//:unzip_files.bzl", "unzip_files")

filegroup(
    name = "public",
    srcs = glob(["**/*"]),
    visibility = ["//visibility:public"],
)

unzip_files(
    name = "unpack_webjar_bootstrap",
    files = [
        "css/bootstrap.css",
        "css/bootstrap.css.map",
        "css/bootstrap-theme.css",
        "css/bootstrap-theme.css.map",
    ],
    out_prefix = "lib/bootstrap",
    zip_file = "@maven//:org_webjars_bootstrap",
    zip_prefix = "META-INF/resources/webjars/bootstrap/3.4.1",
)

unzip_files(
    name = "unpack_webjar_jquery",
    files = [
        "jquery.min.js",
        "jquery.min.map",
    ],
    out_prefix = "lib/jquery",
    zip_file = "@maven//:org_webjars_jquery",
    zip_prefix = "META-INF/resources/webjars/jquery/1.11.1",
)
