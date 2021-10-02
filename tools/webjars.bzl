def unzip_files(name, zip_file, out_prefix, zip_prefix, files = []):
    outs = ["%s/%s" % (out_prefix, file) for file in files]
    zip_internal_paths = ["%s/%s" % (zip_prefix, file) for file in files]
    copy_commands = ["cp %s/%s $(location %s/%s)" % (zip_prefix, file, out_prefix, file) for file in files]
    native.genrule(
        name = name,
        srcs = [
            zip_file,
        ],
        outs = outs,
        cmd = "$(location @bazel_tools//tools/zip:zipper) x $(location %s) " % zip_file +
              " ".join(zip_internal_paths) + " " +
              "-d . && " +
              " && ".join(copy_commands),
        tools = ["@bazel_tools//tools/zip:zipper"],
        visibility = ["//visibility:public"],
    )
