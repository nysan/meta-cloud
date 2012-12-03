IMAGE_FEATURES += "ssh-server-openssh package-management"
EXTRA_IMAGE_FEATURES = "tools-debug debug-tweaks"

IMAGE_INSTALL = "\
    ${CORE_IMAGE_BASE_INSTALL} \
    ${ROOTFS_PKGMANAGE_BOOTSTRAP} \
    packagegroup-core-basic \
    openvswitch \
    openvswitch-controller \
    openvswitch-switch \
    openvswitch-brcompat \
    libvirt \
    libvirt-libvirtd \
    libvirt-python \
    libvirt-virsh \    
    openflow \
    qemu \   
    kernel-modules \
    tcpdump \
    mysql5 \
    dhcp-client \
    grub \
    "

inherit core-image
inherit image-vmdk

IMAGE_FSTYPES += "vmdk tar.gz"
