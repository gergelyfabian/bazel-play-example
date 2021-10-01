load("@io_bazel_rules_play_routes//play-routes:play-routes.bzl", "play_routes")

exports_files([
    "application.conf",
])

play_routes(
    name = "play-routes",
    srcs = ["routes"],
    generate_reverse_router = True,
    include_play_imports = True,
    routes_imports = [],
    visibility = ["//visibility:public"],
)
