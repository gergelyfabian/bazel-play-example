workspace(name = "bazel-play-example")

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")
load("//tools/jdk:jdks.bzl", "jdk_repositories")

jdk_repositories()

skylib_version = "1.0.3"

http_archive(
    name = "bazel_skylib",
    sha256 = "1c531376ac7e5a180e0237938a2536de0c54d93f5c278634818e0efc952dd56c",
    type = "tar.gz",
    url = "https://mirror.bazel.build/github.com/bazelbuild/bazel-skylib/releases/download/{}/bazel-skylib-{}.tar.gz".format(skylib_version, skylib_version),
)

rules_scala_version = "e7a948ad1948058a7a5ddfbd9d1629d6db839933"

RULES_SCALA_SHA = "76e1abb8a54f61ada974e6e9af689c59fd9f0518b49be6be7a631ce9fa45f236"

http_archive(
    name = "io_bazel_rules_scala",
    sha256 = RULES_SCALA_SHA,
    strip_prefix = "rules_scala-%s" % rules_scala_version,
    type = "zip",
    url = "https://github.com/bazelbuild/rules_scala/archive/%s.zip" % rules_scala_version,
)

load("@io_bazel_rules_scala//:scala_config.bzl", "scala_config")

scala_config(scala_version = "2.13.2")

load("@io_bazel_rules_scala//scala:scala.bzl", "scala_repositories")

scala_repositories()

load("@rules_proto//proto:repositories.bzl", "rules_proto_dependencies", "rules_proto_toolchains")

rules_proto_dependencies()

rules_proto_toolchains()

load("@io_bazel_rules_scala//scala:toolchains.bzl", "scala_register_toolchains")

scala_register_toolchains()

# optional: setup ScalaTest toolchain and dependencies
load("@io_bazel_rules_scala//testing:scalatest.bzl", "scalatest_repositories", "scalatest_toolchain")

scalatest_repositories()

scalatest_toolchain()

protobuf_version = "3.11.3"

protobuf_version_sha256 = "cf754718b0aa945b00550ed7962ddc167167bd922b842199eeb6505e6f344852"

http_archive(
    name = "com_google_protobuf",
    sha256 = protobuf_version_sha256,
    strip_prefix = "protobuf-%s" % protobuf_version,
    url = "https://github.com/protocolbuffers/protobuf/archive/v%s.tar.gz" % protobuf_version,
)

RULES_JVM_EXTERNAL_TAG = "4.1"

RULES_JVM_EXTERNAL_SHA = "f36441aa876c4f6427bfb2d1f2d723b48e9d930b62662bf723ddfb8fc80f0140"

http_archive(
    name = "rules_jvm_external",
    sha256 = RULES_JVM_EXTERNAL_SHA,
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % RULES_JVM_EXTERNAL_TAG,
)

load("@rules_jvm_external//:defs.bzl", "maven_install")
load("@rules_jvm_external//:specs.bzl", "maven")

SCALA_VERSION = "2.13"

maven_install(
    artifacts = [
        "org.slf4j:slf4j-api:1.7.26",
        "ch.qos.logback:logback-classic:1.2.3",
        "com.typesafe.play:play_%s:2.8.1" % SCALA_VERSION,
        "com.typesafe.play:routes-compiler_%s:2.8.1" % SCALA_VERSION,
        "com.typesafe.play:filters-helpers_%s:2.8.1" % SCALA_VERSION,
        "com.typesafe.play:play-guice_%s:2.8.1" % SCALA_VERSION,
        "com.typesafe.play:play-akka-http-server_%s:2.8.1" % SCALA_VERSION,
        "org.webjars:bootstrap:3.4.1",
        maven.artifact(
            "org.scalatest",
            "scalatest_%s" % SCALA_VERSION,
            "3.0.8",
            testonly = True,
        ),
    ],
    # Some useful options that you may want to try:
    fetch_sources = True,
    maven_install_json = "//:maven_install.json",
    repositories = [
        "https://jcenter.bintray.com/",
        "https://repo.maven.apache.org/maven2",
    ],
    resolve_timeout = 1200,
    # If you have a lot of dependencies, then you may want to try caching:
    use_unsafe_shared_cache = True,
)

load("@maven//:defs.bzl", "pinned_maven_install")

pinned_maven_install()

# update version as needed
rules_twirl_version = "9ac789845e3a481fe520af57bd47a4261edb684f"

http_archive(
    name = "io_bazel_rules_twirl",
    sha256 = "b1698a2a59b76dc9df233314c2a1ca8cee4a0477665cff5eafd36f92057b2044",
    strip_prefix = "rules_twirl-{}".format(rules_twirl_version),
    type = "zip",
    url = "https://github.com/lucidsoftware/rules_twirl/archive/{}.zip".format(rules_twirl_version),
)

load("@io_bazel_rules_twirl//:workspace.bzl", "twirl_repositories")

twirl_repositories()

load("@twirl//:defs.bzl", twirl_pinned_maven_install = "pinned_maven_install")

twirl_pinned_maven_install()

skydoc_version = "0.3.0"  # update this as needed

http_archive(
    name = "io_bazel_skydoc",
    sha256 = "8762a212cff5f81505a1632630edcfe9adce381479a50a03c968bd2fc217972d",
    strip_prefix = "skydoc-{}".format(skydoc_version),
    type = "zip",
    url = "https://github.com/bazelbuild/skydoc/archive/{}.zip".format(skydoc_version),
)

load("@io_bazel_skydoc//skylark:skylark.bzl", "skydoc_repositories")

skydoc_repositories()

rules_play_routes_version = "974206fcc188bb6ab44dfeddc6a63b2ba9da5ee5"

http_archive(
    name = "io_bazel_rules_play_routes",
    sha256 = "29b1c10bbeebced6ce450e661a02fa0345d28daf4485792ace745fa830c962c6",
    strip_prefix = "rules_play_routes-{}".format(rules_play_routes_version),
    type = "zip",
    url = "https://github.com/lucidsoftware/rules_play_routes/archive/{}.zip".format(rules_play_routes_version),
)

load("@io_bazel_rules_play_routes//:workspace.bzl", "play_routes_repositories")

play_routes_repositories("2.8")

load("@play_routes//:defs.bzl", play_routes_pinned_maven_install = "pinned_maven_install")

play_routes_pinned_maven_install()

bind(
    name = "default-play-routes-compiler-cli",
    actual = "@io_bazel_rules_play_routes//default-compiler-clis:scala_%s_play_2_8" % SCALA_VERSION.replace(".", "_"),
)
