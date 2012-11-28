SUMMARY = "OpenvSwitch"
DESCRIPTION = "Open vSwitch is a production quality, multilayer virtual switch licensed under the open source Apache 2.0 license. It is designed to enable massive network automation through programmatic extension, while still supporting standard management interfaces and protocols (e.g. NetFlow, sFlow, SPAN, RSPAN, CLI, LACP, 802.1ag)"
HOMEPAGE = "http://openvswitch.org/"
SECTION = "networking"
LICENSE = "Apache-2"

DEPENDS = "bridge-utils openssl"
RDEPENDS = "util-linux-uuidgen util-linux-libuuid"
RDEPENDS_${PN}-controller = "lsb"

RRECOMMENDS = "${PN}-controller ${PN}-switch ${PN}-brcompat"

PR = "r0"

SRC_URI = "http://openvswitch.org/releases/openvswitch-1.4.3.tar.gz \
	file://openvswitch-switch \
	file://openvswitch-switch-setup \
	file://openvswitch-controller \
	file://openvswitch-controller-setup \		
	"

SRC_URI[md5sum] = "66df8e84f579e734aa4a43bc502baffd"
SRC_URI[sha256sum] = "be1ae1ecff0ff095d24f552c148dd4d2931d187bbb35b3d9205416a0aca746a8"
LIC_FILES_CHKSUM = "file://COPYING;md5=49eeb5acb1f5e510f12c44f176c42253"

# Don't compile kernel modules by default since it heavily depends on 
# kernel version. Use the in-kernel module for now.
# distro layers can enable with EXTRA_OECONF_pn_openvswitch += ""
# EXTRA_OECONF = "--with-linux=${STAGING_KERNEL_DIR} KARCH=${TARGET_ARCH}"

S = "${WORKDIR}/${PN}-${PV}"

PACKAGES =+ "${PN}-controller ${PN}-switch ${PN}-brcompat"

FILES_${PN}-controller = "${sysconfdir}/init.d/openvswitch-controller \
	${sysconfdir}/default/openvswitch-controller \
	${bindir}/ovs-controller"

FILES_${PN}-brcompat = "${sbindir}/ovs-brcompatd"

FILES_${PN}-switch = "${sysconfdir}/init.d/openvswitch-switch \
		   ${sysconfdir}/default/openvswitch-switch \
		   "

inherit autotools update-rc.d

INITSCRIPT_PACKAGES = "${PN}-switch"
INITSCRIPT_NAME_${PN}-switch = "openvswitch-switch"
INITSCRIPT_PARAMS_${PN}-switch = "defaults 72"

INITSCRIPT_PACKAGES = "${PN}-controller"
INITSCRIPT_NAME_${PN}-controller = "openvswitch-controller"
INITSCRIPT_PARAMS_${PN}-controller = "defaults 72"

do_install_append() {
	install -d ${D}/${sysconfdir}/default/
	install -m 660 ${WORKDIR}/openvswitch-switch-setup ${D}/${sysconfdir}/default/openvswitch-switch
	install -d ${D}/${sysconfdir}/openvswitch-controller
	install -m 660 ${WORKDIR}/openvswitch-controller-setup ${D}/${sysconfdir}/default/openvswitch-controller
	
	install -d ${D}/${sysconfdir}/init.d/
	install -m 755 ${WORKDIR}/openvswitch-controller ${D}/${sysconfdir}/init.d/openvswitch-controller
	install -m 755 ${WORKDIR}/openvswitch-switch ${D}/${sysconfdir}/init.d/openvswitch-switch

}