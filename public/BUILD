filegroup(
    name = "public",
    srcs = glob(["**/*"]),
    visibility = ["//visibility:public"],
)

genrule(
    name = "unpack_webjar",
    srcs = [
        "@maven//:org_webjars_bootstrap",
        "@maven//:org_webjars_jquery",
    ],
    outs = [
        "lib/bootstrap/css/bootstrap.css",
        "lib/bootstrap/css/bootstrap-theme.css",
        "lib/jquery/jquery.min.js",
    ],
    cmd =  # Ensure output dir for the first jar exists
        "mkdir -p lib/bootstrap/css && " +
        # Unzip the first jar.
        "unzip $(location @maven//:org_webjars_bootstrap) " +
        "META-INF/resources/webjars/bootstrap/3.4.1/css/bootstrap.css " +
        "META-INF/resources/webjars/bootstrap/3.4.1/css/bootstrap-theme.css " +
        "-d bootstrap && " +
        # Copy files from the first jar to the target.
        "cp bootstrap/META-INF/resources/webjars/bootstrap/3.4.1/css/bootstrap.css $(location lib/bootstrap/css/bootstrap.css) && " +
        "cp bootstrap/META-INF/resources/webjars/bootstrap/3.4.1/css/bootstrap-theme.css $(location lib/bootstrap/css/bootstrap-theme.css) && " +
        # Ensure output dir for second jar exists.
        "mkdir -p lib/jquery && " +
        # Unzip the second jar.
        "unzip $(location @maven//:org_webjars_jquery) " +
        "META-INF/resources/webjars/jquery/1.11.1/jquery.min.js " +
        "-d jquery &&  " +
        # Copy files from the second jar to the target.
        "cp jquery/META-INF/resources/webjars/jquery/1.11.1/jquery.min.js $(location lib/jquery/jquery.min.js)",
    visibility = ["//visibility:public"],
)
