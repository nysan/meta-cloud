SUMMARY = "DMTCP"
DESCRIPTION = "DMTCP is a tool to transparently checkpoint the state of multiple simultaneous applications, including multi-threaded and distributed applications. It operates directly on the user binary executable, without any Linux kernel modules or other kernel modifications"
HOMEPAGE = "http://dmtcp.sourceforge.net/"
SECTION = "console/utils"
LICENSE = "LGPLv1"

LIC_FILES_CHKSUM = "file://COPYING;md5=c0411eef53a349b26014aaef2944ea04"
#DEPENDS = "python"

PR = "r0"
inherit  autotools

SRC_URI = "http://heanet.dl.sourceforge.net/sourceforge/dmtcp/dmtcp-${PV}.tar.gz \
	file://automake_fix.patch \
	file://automake_fix2.patch \
	"
SRC_URI[md5sum] = "c433f7f08ca777cd8ab49967e69b4601"
SRC_URI[sha256sum] = "ede0ef3544f08befe2b3df45d9087b4bfa02d52074cf805181c857f5de9fbfca"

S = "${WORKDIR}/${PN}-${PV}"




