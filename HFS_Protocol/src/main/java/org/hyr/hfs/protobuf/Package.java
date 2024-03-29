// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Package.proto

package org.hyr.hfs.protobuf;

/**
 * Protobuf type {@code org.hyr.hfs.protobuf.Package}
 */
public  final class Package extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:org.hyr.hfs.protobuf.Package)
    PackageOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Package.newBuilder() to construct.
  private Package(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Package() {
    records_ = java.util.Collections.emptyList();
    timestamp_ = 0L;
    total_ = 0;
    index_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Package(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
              records_ = new java.util.ArrayList<org.hyr.hfs.protobuf.Record>();
              mutable_bitField0_ |= 0x00000001;
            }
            records_.add(
                input.readMessage(org.hyr.hfs.protobuf.Record.parser(), extensionRegistry));
            break;
          }
          case 16: {

            timestamp_ = input.readUInt64();
            break;
          }
          case 24: {

            total_ = input.readUInt32();
            break;
          }
          case 32: {

            index_ = input.readUInt32();
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
        records_ = java.util.Collections.unmodifiableList(records_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return org.hyr.hfs.protobuf.PackageOuterClass.internal_static_org_hyr_hfs_protobuf_Package_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.hyr.hfs.protobuf.PackageOuterClass.internal_static_org_hyr_hfs_protobuf_Package_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.hyr.hfs.protobuf.Package.class, org.hyr.hfs.protobuf.Package.Builder.class);
  }

  private int bitField0_;
  public static final int RECORDS_FIELD_NUMBER = 1;
  private java.util.List<org.hyr.hfs.protobuf.Record> records_;
  /**
   * <pre>
   *metric数据
   * </pre>
   *
   * <code>repeated .org.hyr.hfs.protobuf.Record records = 1;</code>
   */
  public java.util.List<org.hyr.hfs.protobuf.Record> getRecordsList() {
    return records_;
  }
  /**
   * <pre>
   *metric数据
   * </pre>
   *
   * <code>repeated .org.hyr.hfs.protobuf.Record records = 1;</code>
   */
  public java.util.List<? extends org.hyr.hfs.protobuf.RecordOrBuilder> 
      getRecordsOrBuilderList() {
    return records_;
  }
  /**
   * <pre>
   *metric数据
   * </pre>
   *
   * <code>repeated .org.hyr.hfs.protobuf.Record records = 1;</code>
   */
  public int getRecordsCount() {
    return records_.size();
  }
  /**
   * <pre>
   *metric数据
   * </pre>
   *
   * <code>repeated .org.hyr.hfs.protobuf.Record records = 1;</code>
   */
  public org.hyr.hfs.protobuf.Record getRecords(int index) {
    return records_.get(index);
  }
  /**
   * <pre>
   *metric数据
   * </pre>
   *
   * <code>repeated .org.hyr.hfs.protobuf.Record records = 1;</code>
   */
  public org.hyr.hfs.protobuf.RecordOrBuilder getRecordsOrBuilder(
      int index) {
    return records_.get(index);
  }

  public static final int TIMESTAMP_FIELD_NUMBER = 2;
  private long timestamp_;
  /**
   * <pre>
   *数据时间戳
   * </pre>
   *
   * <code>uint64 timestamp = 2;</code>
   */
  public long getTimestamp() {
    return timestamp_;
  }

  public static final int TOTAL_FIELD_NUMBER = 3;
  private int total_;
  /**
   * <pre>
   *该事件节点总包数
   * </pre>
   *
   * <code>uint32 total = 3;</code>
   */
  public int getTotal() {
    return total_;
  }

  public static final int INDEX_FIELD_NUMBER = 4;
  private int index_;
  /**
   * <pre>
   *该数据包的索引index
   * </pre>
   *
   * <code>uint32 index = 4;</code>
   */
  public int getIndex() {
    return index_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < records_.size(); i++) {
      output.writeMessage(1, records_.get(i));
    }
    if (timestamp_ != 0L) {
      output.writeUInt64(2, timestamp_);
    }
    if (total_ != 0) {
      output.writeUInt32(3, total_);
    }
    if (index_ != 0) {
      output.writeUInt32(4, index_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < records_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, records_.get(i));
    }
    if (timestamp_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(2, timestamp_);
    }
    if (total_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(3, total_);
    }
    if (index_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(4, index_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof org.hyr.hfs.protobuf.Package)) {
      return super.equals(obj);
    }
    org.hyr.hfs.protobuf.Package other = (org.hyr.hfs.protobuf.Package) obj;

    boolean result = true;
    result = result && getRecordsList()
        .equals(other.getRecordsList());
    result = result && (getTimestamp()
        == other.getTimestamp());
    result = result && (getTotal()
        == other.getTotal());
    result = result && (getIndex()
        == other.getIndex());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getRecordsCount() > 0) {
      hash = (37 * hash) + RECORDS_FIELD_NUMBER;
      hash = (53 * hash) + getRecordsList().hashCode();
    }
    hash = (37 * hash) + TIMESTAMP_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getTimestamp());
    hash = (37 * hash) + TOTAL_FIELD_NUMBER;
    hash = (53 * hash) + getTotal();
    hash = (37 * hash) + INDEX_FIELD_NUMBER;
    hash = (53 * hash) + getIndex();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.hyr.hfs.protobuf.Package parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.hyr.hfs.protobuf.Package parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.hyr.hfs.protobuf.Package parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.hyr.hfs.protobuf.Package parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.hyr.hfs.protobuf.Package parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.hyr.hfs.protobuf.Package parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.hyr.hfs.protobuf.Package parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.hyr.hfs.protobuf.Package parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.hyr.hfs.protobuf.Package parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.hyr.hfs.protobuf.Package parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.hyr.hfs.protobuf.Package parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.hyr.hfs.protobuf.Package parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(org.hyr.hfs.protobuf.Package prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code org.hyr.hfs.protobuf.Package}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:org.hyr.hfs.protobuf.Package)
      org.hyr.hfs.protobuf.PackageOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.hyr.hfs.protobuf.PackageOuterClass.internal_static_org_hyr_hfs_protobuf_Package_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.hyr.hfs.protobuf.PackageOuterClass.internal_static_org_hyr_hfs_protobuf_Package_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.hyr.hfs.protobuf.Package.class, org.hyr.hfs.protobuf.Package.Builder.class);
    }

    // Construct using org.hyr.hfs.protobuf.Package.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getRecordsFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (recordsBuilder_ == null) {
        records_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        recordsBuilder_.clear();
      }
      timestamp_ = 0L;

      total_ = 0;

      index_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.hyr.hfs.protobuf.PackageOuterClass.internal_static_org_hyr_hfs_protobuf_Package_descriptor;
    }

    @java.lang.Override
    public org.hyr.hfs.protobuf.Package getDefaultInstanceForType() {
      return org.hyr.hfs.protobuf.Package.getDefaultInstance();
    }

    @java.lang.Override
    public org.hyr.hfs.protobuf.Package build() {
      org.hyr.hfs.protobuf.Package result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.hyr.hfs.protobuf.Package buildPartial() {
      org.hyr.hfs.protobuf.Package result = new org.hyr.hfs.protobuf.Package(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (recordsBuilder_ == null) {
        if (((bitField0_ & 0x00000001) == 0x00000001)) {
          records_ = java.util.Collections.unmodifiableList(records_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.records_ = records_;
      } else {
        result.records_ = recordsBuilder_.build();
      }
      result.timestamp_ = timestamp_;
      result.total_ = total_;
      result.index_ = index_;
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof org.hyr.hfs.protobuf.Package) {
        return mergeFrom((org.hyr.hfs.protobuf.Package)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.hyr.hfs.protobuf.Package other) {
      if (other == org.hyr.hfs.protobuf.Package.getDefaultInstance()) return this;
      if (recordsBuilder_ == null) {
        if (!other.records_.isEmpty()) {
          if (records_.isEmpty()) {
            records_ = other.records_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureRecordsIsMutable();
            records_.addAll(other.records_);
          }
          onChanged();
        }
      } else {
        if (!other.records_.isEmpty()) {
          if (recordsBuilder_.isEmpty()) {
            recordsBuilder_.dispose();
            recordsBuilder_ = null;
            records_ = other.records_;
            bitField0_ = (bitField0_ & ~0x00000001);
            recordsBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getRecordsFieldBuilder() : null;
          } else {
            recordsBuilder_.addAllMessages(other.records_);
          }
        }
      }
      if (other.getTimestamp() != 0L) {
        setTimestamp(other.getTimestamp());
      }
      if (other.getTotal() != 0) {
        setTotal(other.getTotal());
      }
      if (other.getIndex() != 0) {
        setIndex(other.getIndex());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      org.hyr.hfs.protobuf.Package parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.hyr.hfs.protobuf.Package) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<org.hyr.hfs.protobuf.Record> records_ =
      java.util.Collections.emptyList();
    private void ensureRecordsIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        records_ = new java.util.ArrayList<org.hyr.hfs.protobuf.Record>(records_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        org.hyr.hfs.protobuf.Record, org.hyr.hfs.protobuf.Record.Builder, org.hyr.hfs.protobuf.RecordOrBuilder> recordsBuilder_;

    /**
     * <pre>
     *metric数据
     * </pre>
     *
     * <code>repeated .org.hyr.hfs.protobuf.Record records = 1;</code>
     */
    public java.util.List<org.hyr.hfs.protobuf.Record> getRecordsList() {
      if (recordsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(records_);
      } else {
        return recordsBuilder_.getMessageList();
      }
    }
    /**
     * <pre>
     *metric数据
     * </pre>
     *
     * <code>repeated .org.hyr.hfs.protobuf.Record records = 1;</code>
     */
    public int getRecordsCount() {
      if (recordsBuilder_ == null) {
        return records_.size();
      } else {
        return recordsBuilder_.getCount();
      }
    }
    /**
     * <pre>
     *metric数据
     * </pre>
     *
     * <code>repeated .org.hyr.hfs.protobuf.Record records = 1;</code>
     */
    public org.hyr.hfs.protobuf.Record getRecords(int index) {
      if (recordsBuilder_ == null) {
        return records_.get(index);
      } else {
        return recordsBuilder_.getMessage(index);
      }
    }
    /**
     * <pre>
     *metric数据
     * </pre>
     *
     * <code>repeated .org.hyr.hfs.protobuf.Record records = 1;</code>
     */
    public Builder setRecords(
        int index, org.hyr.hfs.protobuf.Record value) {
      if (recordsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureRecordsIsMutable();
        records_.set(index, value);
        onChanged();
      } else {
        recordsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <pre>
     *metric数据
     * </pre>
     *
     * <code>repeated .org.hyr.hfs.protobuf.Record records = 1;</code>
     */
    public Builder setRecords(
        int index, org.hyr.hfs.protobuf.Record.Builder builderForValue) {
      if (recordsBuilder_ == null) {
        ensureRecordsIsMutable();
        records_.set(index, builderForValue.build());
        onChanged();
      } else {
        recordsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     *metric数据
     * </pre>
     *
     * <code>repeated .org.hyr.hfs.protobuf.Record records = 1;</code>
     */
    public Builder addRecords(org.hyr.hfs.protobuf.Record value) {
      if (recordsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureRecordsIsMutable();
        records_.add(value);
        onChanged();
      } else {
        recordsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <pre>
     *metric数据
     * </pre>
     *
     * <code>repeated .org.hyr.hfs.protobuf.Record records = 1;</code>
     */
    public Builder addRecords(
        int index, org.hyr.hfs.protobuf.Record value) {
      if (recordsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureRecordsIsMutable();
        records_.add(index, value);
        onChanged();
      } else {
        recordsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <pre>
     *metric数据
     * </pre>
     *
     * <code>repeated .org.hyr.hfs.protobuf.Record records = 1;</code>
     */
    public Builder addRecords(
        org.hyr.hfs.protobuf.Record.Builder builderForValue) {
      if (recordsBuilder_ == null) {
        ensureRecordsIsMutable();
        records_.add(builderForValue.build());
        onChanged();
      } else {
        recordsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     *metric数据
     * </pre>
     *
     * <code>repeated .org.hyr.hfs.protobuf.Record records = 1;</code>
     */
    public Builder addRecords(
        int index, org.hyr.hfs.protobuf.Record.Builder builderForValue) {
      if (recordsBuilder_ == null) {
        ensureRecordsIsMutable();
        records_.add(index, builderForValue.build());
        onChanged();
      } else {
        recordsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     *metric数据
     * </pre>
     *
     * <code>repeated .org.hyr.hfs.protobuf.Record records = 1;</code>
     */
    public Builder addAllRecords(
        java.lang.Iterable<? extends org.hyr.hfs.protobuf.Record> values) {
      if (recordsBuilder_ == null) {
        ensureRecordsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, records_);
        onChanged();
      } else {
        recordsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <pre>
     *metric数据
     * </pre>
     *
     * <code>repeated .org.hyr.hfs.protobuf.Record records = 1;</code>
     */
    public Builder clearRecords() {
      if (recordsBuilder_ == null) {
        records_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        recordsBuilder_.clear();
      }
      return this;
    }
    /**
     * <pre>
     *metric数据
     * </pre>
     *
     * <code>repeated .org.hyr.hfs.protobuf.Record records = 1;</code>
     */
    public Builder removeRecords(int index) {
      if (recordsBuilder_ == null) {
        ensureRecordsIsMutable();
        records_.remove(index);
        onChanged();
      } else {
        recordsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <pre>
     *metric数据
     * </pre>
     *
     * <code>repeated .org.hyr.hfs.protobuf.Record records = 1;</code>
     */
    public org.hyr.hfs.protobuf.Record.Builder getRecordsBuilder(
        int index) {
      return getRecordsFieldBuilder().getBuilder(index);
    }
    /**
     * <pre>
     *metric数据
     * </pre>
     *
     * <code>repeated .org.hyr.hfs.protobuf.Record records = 1;</code>
     */
    public org.hyr.hfs.protobuf.RecordOrBuilder getRecordsOrBuilder(
        int index) {
      if (recordsBuilder_ == null) {
        return records_.get(index);  } else {
        return recordsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <pre>
     *metric数据
     * </pre>
     *
     * <code>repeated .org.hyr.hfs.protobuf.Record records = 1;</code>
     */
    public java.util.List<? extends org.hyr.hfs.protobuf.RecordOrBuilder> 
         getRecordsOrBuilderList() {
      if (recordsBuilder_ != null) {
        return recordsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(records_);
      }
    }
    /**
     * <pre>
     *metric数据
     * </pre>
     *
     * <code>repeated .org.hyr.hfs.protobuf.Record records = 1;</code>
     */
    public org.hyr.hfs.protobuf.Record.Builder addRecordsBuilder() {
      return getRecordsFieldBuilder().addBuilder(
          org.hyr.hfs.protobuf.Record.getDefaultInstance());
    }
    /**
     * <pre>
     *metric数据
     * </pre>
     *
     * <code>repeated .org.hyr.hfs.protobuf.Record records = 1;</code>
     */
    public org.hyr.hfs.protobuf.Record.Builder addRecordsBuilder(
        int index) {
      return getRecordsFieldBuilder().addBuilder(
          index, org.hyr.hfs.protobuf.Record.getDefaultInstance());
    }
    /**
     * <pre>
     *metric数据
     * </pre>
     *
     * <code>repeated .org.hyr.hfs.protobuf.Record records = 1;</code>
     */
    public java.util.List<org.hyr.hfs.protobuf.Record.Builder> 
         getRecordsBuilderList() {
      return getRecordsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        org.hyr.hfs.protobuf.Record, org.hyr.hfs.protobuf.Record.Builder, org.hyr.hfs.protobuf.RecordOrBuilder> 
        getRecordsFieldBuilder() {
      if (recordsBuilder_ == null) {
        recordsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            org.hyr.hfs.protobuf.Record, org.hyr.hfs.protobuf.Record.Builder, org.hyr.hfs.protobuf.RecordOrBuilder>(
                records_,
                ((bitField0_ & 0x00000001) == 0x00000001),
                getParentForChildren(),
                isClean());
        records_ = null;
      }
      return recordsBuilder_;
    }

    private long timestamp_ ;
    /**
     * <pre>
     *数据时间戳
     * </pre>
     *
     * <code>uint64 timestamp = 2;</code>
     */
    public long getTimestamp() {
      return timestamp_;
    }
    /**
     * <pre>
     *数据时间戳
     * </pre>
     *
     * <code>uint64 timestamp = 2;</code>
     */
    public Builder setTimestamp(long value) {
      
      timestamp_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *数据时间戳
     * </pre>
     *
     * <code>uint64 timestamp = 2;</code>
     */
    public Builder clearTimestamp() {
      
      timestamp_ = 0L;
      onChanged();
      return this;
    }

    private int total_ ;
    /**
     * <pre>
     *该事件节点总包数
     * </pre>
     *
     * <code>uint32 total = 3;</code>
     */
    public int getTotal() {
      return total_;
    }
    /**
     * <pre>
     *该事件节点总包数
     * </pre>
     *
     * <code>uint32 total = 3;</code>
     */
    public Builder setTotal(int value) {
      
      total_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *该事件节点总包数
     * </pre>
     *
     * <code>uint32 total = 3;</code>
     */
    public Builder clearTotal() {
      
      total_ = 0;
      onChanged();
      return this;
    }

    private int index_ ;
    /**
     * <pre>
     *该数据包的索引index
     * </pre>
     *
     * <code>uint32 index = 4;</code>
     */
    public int getIndex() {
      return index_;
    }
    /**
     * <pre>
     *该数据包的索引index
     * </pre>
     *
     * <code>uint32 index = 4;</code>
     */
    public Builder setIndex(int value) {
      
      index_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *该数据包的索引index
     * </pre>
     *
     * <code>uint32 index = 4;</code>
     */
    public Builder clearIndex() {
      
      index_ = 0;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:org.hyr.hfs.protobuf.Package)
  }

  // @@protoc_insertion_point(class_scope:org.hyr.hfs.protobuf.Package)
  private static final org.hyr.hfs.protobuf.Package DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.hyr.hfs.protobuf.Package();
  }

  public static org.hyr.hfs.protobuf.Package getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Package>
      PARSER = new com.google.protobuf.AbstractParser<Package>() {
    @java.lang.Override
    public Package parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Package(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Package> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Package> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.hyr.hfs.protobuf.Package getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

