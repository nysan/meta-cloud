inherit python-dir

# Enable the Python tool support
EXTRA_OECONF += "--with-python=yes"

SRC_URI += " file://0001-Rebased-patch-for-python-env.patch"

DEPENDS  += "python python-native"
RDEPENDS_${PN}-python += "python"

PACKAGES += "${PN}-python-dbg ${PN}-python"
FILES_${PN}-python-dbg += "${libdir}/${PYTHON_DIR}/site-packages/.debug"
FILES_${PN}-python += "${libdir}/${PYTHON_DIR}/site-packages"
FILES_${PN}-python-dbg += "${libdir}/${PYTHON_DIR}/dist-packages/.debug"
FILES_${PN}-python += "${libdir}/${PYTHON_DIR}/dist-packages"
