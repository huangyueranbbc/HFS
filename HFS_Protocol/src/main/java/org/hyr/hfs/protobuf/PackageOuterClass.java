// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Package.proto

package org.hyr.hfs.protobuf;

public final class PackageOuterClass {
  private PackageOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_org_hyr_hfs_protobuf_Package_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_org_hyr_hfs_protobuf_Package_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_org_hyr_hfs_protobuf_Record_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_org_hyr_hfs_protobuf_Record_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rPackage.proto\022\024org.hyr.hfs.protobuf\"i\n" +
      "\007Package\022-\n\007records\030\001 \003(\0132\034.org.hyr.hfs." +
      "protobuf.Record\022\021\n\ttimestamp\030\002 \001(\004\022\r\n\005to" +
      "tal\030\003 \001(\r\022\r\n\005index\030\004 \001(\r\"\026\n\006Record\022\014\n\004da" +
      "ta\030\001 \001(\014B\030\n\024org.hyr.hfs.protobufP\001b\006prot" +
      "o3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_org_hyr_hfs_protobuf_Package_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_org_hyr_hfs_protobuf_Package_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_org_hyr_hfs_protobuf_Package_descriptor,
        new java.lang.String[] { "Records", "Timestamp", "Total", "Index", });
    internal_static_org_hyr_hfs_protobuf_Record_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_org_hyr_hfs_protobuf_Record_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_org_hyr_hfs_protobuf_Record_descriptor,
        new java.lang.String[] { "Data", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
