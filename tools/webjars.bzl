def unpack_webjar(name, webjar_target, play_prefix, jar_internal_path, files = []):
    outs = ["%s/%s" % (play_prefix, file) for file in files]
    jar_internal_paths = ["%s/%s" % (jar_internal_path, file) for file in files]
    copy_commands = ["cp %s/%s $(location %s/%s)" % (jar_internal_path, file, play_prefix, file) for file in files]
    native.genrule(
        name = name,
        srcs = [
            webjar_target,
        ],
        outs = outs,
        cmd = "unzip $(location %s) " % webjar_target +
              " ".join(jar_internal_paths) + " " +
              "-d . && " +
              " && ".join(copy_commands),
        visibility = ["//visibility:public"],
    )
