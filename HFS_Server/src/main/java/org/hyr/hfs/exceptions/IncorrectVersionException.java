package org.hyr.hfs.exceptions;

import org.hyr.hfs.common.HFSConstant;

import java.io.IOException;

public class IncorrectVersionException extends IOException {

    public IncorrectVersionException(int versionReported, String ofWhat) {
        this(versionReported, ofWhat, HFSConstant.LAYOUT_VERSION);
    }

    public IncorrectVersionException(int versionReported,
                                     String ofWhat,
                                     int versionExpected) {
        super("Unexpected version "
                + (ofWhat == null ? "" : "of " + ofWhat) + ". Reported: "
                + versionReported + ". Expecting = " + versionExpected + ".");
    }

}