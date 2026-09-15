# meta-dise-player

`meta-dise-player` is a Yocto layer for distributing the proprietary Dise
Player prebuilt package. The layer fetches the versioned release, verifies its checksum,
and installs the same package contents under `/opt/mqcef`.

Copyright © 2026 Dise International AB. All rights reserved

## Supported Yocto release

The layer currently supports Yocto Project **Scarthgap** only. Compatibility
with other releases has not been established and is not claimed.

## Add the layer

From an initialized Yocto build environment, add the layer with:

```sh
bitbake-layers add-layer /path/to/meta-dise-player
```

The layer depends on the Yocto `core` layer.

## Include the Dise Player in an image

Add the package to the image's `IMAGE_INSTALL` in `conf/local.conf` or in the
appropriate image recipe:

```bitbake
IMAGE_INSTALL:append = " dise-player"
```

The package preserves the release layout beneath `/opt/mqcef`:

```text
/opt/mqcef/run.sh
/opt/mqcef/startup/
/opt/mqcef/mqcef/
```

The package does not select or install an image-specific startup service.
Integrate the launcher with the image's existing graphical session or init
system according to the target platform.

For a writable application data directory, launch the player with:

```sh
/opt/mqcef/run.sh --datapath=/data
```

The selected data path must be writable. If the target image uses a
read-only root filesystem, use a writable persistent or runtime-mounted path
such as `/data`.

The layer provides the package contents; the image remains responsible for
providing the graphical environment, device-specific configuration, writable
data storage, and the appropriate process/session integration.
