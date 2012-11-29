FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://kvm.cfg \
	    file://lxc.cfg \
	    file://vswitch.cfg \
	    file://ebtables.cfg \
	    " 
PR .= ".1"

