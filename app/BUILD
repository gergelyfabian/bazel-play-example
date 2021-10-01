load("@io_bazel_rules_scala//scala:scala.bzl", "scala_binary", "scala_library", "scala_macro_library", "scala_test")
load("@io_bazel_rules_scala//scala:scala_import.bzl", "scala_import")
load("@io_bazel_rules_twirl//twirl:twirl.bzl", "twirl_templates")

SCALA_VERSION = "2_13"

DEPS = [
    "@maven//:org_slf4j_slf4j_api_1_7_30",
    "@maven//:ch_qos_logback_logback_classic_1_2_3",
    "@maven//:com_typesafe_play_play_%s" % SCALA_VERSION,
    "@maven//:com_typesafe_play_play_json_%s" % SCALA_VERSION,
    "@maven//:com_typesafe_play_play_streams_%s" % SCALA_VERSION,
    "@maven//:com_typesafe_play_play_functional_%s" % SCALA_VERSION,
    "@maven//:com_typesafe_play_twirl_api_%s" % SCALA_VERSION,
    "@maven//:com_typesafe_akka_akka_http_core_%s" % SCALA_VERSION,
    "@maven//:com_typesafe_akka_akka_actor_%s" % SCALA_VERSION,
    "@maven//:com_typesafe_akka_akka_stream_%s" % SCALA_VERSION,
    "@maven//:javax_inject_javax_inject",
    "@maven//:com_fasterxml_jackson_core_jackson_databind",
    "@maven//:com_fasterxml_jackson_core_jackson_core",
    "@maven//:org_scala_lang_modules_scala_xml_%s" % SCALA_VERSION,
]

scala_binary(
    name = "service",
    srcs = glob([
        "controllers/**/*.scala",
    ]) + ["//conf:play-routes"] + [":twirl-templates"],
    classpath_resources = [
        "//conf:application.conf",
    ],
    jvm_flags = [
        "-Dhttp.port=9000",
        "-Dapplication.name=bazel-play-example",
    ],
    main_class = "play.core.server.ProdServerStart",
    resources = [
        "//public",
        "//public:unpack_webjar",
    ],
    visibility = ["//visibility:public"],
    deps = DEPS + [
        "@maven//:com_typesafe_play_play_server_%s" % SCALA_VERSION,
        "@maven//:com_typesafe_play_play_guice_%s" % SCALA_VERSION,
        "@maven//:com_typesafe_play_play_akka_http_server_%s" % SCALA_VERSION,
        ":domain",
    ],
)

scala_library(
    name = "domain",
    srcs = glob([
        "domain/**/*.scala",
    ]),
    visibility = ["//visibility:public"],
)

twirl_templates(
    name = "twirl-templates",
    srcs = glob(["**/*.scala.html"]),
    include_play_imports = True,
    source_directory = ".",
)
