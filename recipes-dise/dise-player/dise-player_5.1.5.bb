SUMMARY = "Proprietary Dise Player integration package"
DESCRIPTION = "Installs the prebuilt Dise Player integration package under /opt/mqcef."
HOMEPAGE = "https://github.com/diseinc/meta-dise-player"
LICENSE = "CLOSED"

PV = "5.1.5"

SRC_URI = "https://github.com/diseinc/meta-dise-player/releases/download/v5.1.5/dise-player-5.1.5.tar.gz;subdir=dise-player-package"
SRC_URI[sha256sum] = "eab32e9f82919be36639032d237287d63907bfa98ce1a912d6807441d3a05c5f"

S = "${WORKDIR}/dise-player-package"

do_install() {
    install -d ${D}/opt/mqcef
    cp -R --no-preserve=ownership ${S}/. ${D}/opt/mqcef/
}

FILES:${PN} = "/opt/mqcef"

RDEPENDS:${PN} = " \
    bash \
    libx11 \
    libxext \
    libxcb \
    nss \
    nspr \
    dbus-lib \
    libxkbcommon \
    libudev \
    alsa-lib \
    glib-2.0 \
    at-spi2-core \
    cairo \
    cups-lib \
    libxcomposite \
    libxdamage \
    libxfixes \
    libxrandr \
    libgbm \
    expat \
    gtk+3 \
    libxtst \
    libxscrnsaver \
    pango \
    libmosquitto1 \
"

# The release contains vendor-supplied pre-stripped binaries.
INSANE_SKIP:${PN} += "already-stripped"

# A future systemd integration can add the service file to SRC_URI and use
# do_install:append() plus inherit systemd without changing this package's
# installation root.
