# meta-dise-player

`meta-dise-player` is a Yocto layer for distributing and integrating the
proprietary Dise Player prebuilt package.

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

The package installs the contents of its release archive beneath
`/opt/mqcef`.

The `/opt/mqcef` directory is the package's installation location and is
available to applications after the image has booted.

