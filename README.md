# Bazel Play example

## Bazel setup

### Install Bazelisk

Download latest Bazelisk release: https://github.com/bazelbuild/bazelisk/releases.
Install it locally as "bazel" e.g. in `~/bin/bazel` and ensure it's executable.

It will automatically download and start the bazel version specified in `.bazelversion`.

### Basic commands

* `bazel build //...` - builds all targets
* `bazel test //...` - tests all targets
* `bazel coverage //...` - runs tests with coverage support for all targets
* `bazel run //app:service` - runs the Play service

### Dependencies

See the rules_jvm_external README for info on how to use the dependencies.

You will want to regenerate maven-install.json after changing dependencies with:

```bash
bazel run @unpinned_maven//:pin
```

### What's left

* Fix Play static asset routing: CSS, JS, images
* Fix stuff that Play includes magically with its sbt plugin. E.g. static assets that are not part
  of the repo even, like jQuery js.
