/*
 * Copyright (C) 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.codegentest;

import android.annotation.NonNull;
import android.annotation.Nullable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.ArrayMap;
import android.util.SparseArray;
import android.util.SparseIntArray;

import com.android.internal.util.AnnotationValidations;
import com.android.internal.util.DataClass;

import java.util.List;
import java.util.Map;

/**
 * Additional test for various parcelling corner-cases.
 */
@DataClass(
        genBuilder = true,
        genAidl = false,
        genToString = true)
public class ParcelAllTheThingsDataClass implements Parcelable {

    @NonNull String[] mStringArray = null;
    @NonNull int[] mIntArray = null;
    @NonNull List<String> mStringList = null;

    @NonNull Map<String, SampleWithCustomBuilder> mMap = null;
    @NonNull Map<String, String> mStringMap = null;

    @NonNull SparseArray<SampleWithCustomBuilder> mSparseArray = null;
    @NonNull SparseIntArray mSparseIntArray = null;

    @SuppressWarnings({"WeakerAccess"})
    @Nullable Boolean mNullableBoolean = null;




    // Code below generated by codegen v1.0.15.
    //
    // DO NOT MODIFY!
    // CHECKSTYLE:OFF Generated code
    //
    // To regenerate run:
    // $ codegen $ANDROID_BUILD_TOP/frameworks/base/tests/Codegen/src/com/android/codegentest/ParcelAllTheThingsDataClass.java
    //
    // To exclude the generated code from IntelliJ auto-formatting enable (one-time):
    //   Settings > Editor > Code Style > Formatter Control
    //@formatter:off


    @DataClass.Generated.Member
    /* package-private */ ParcelAllTheThingsDataClass(
            @NonNull String[] stringArray,
            @NonNull int[] intArray,
            @NonNull List<String> stringList,
            @NonNull Map<String,SampleWithCustomBuilder> map,
            @NonNull Map<String,String> stringMap,
            @NonNull SparseArray<SampleWithCustomBuilder> sparseArray,
            @NonNull SparseIntArray sparseIntArray,
            @SuppressWarnings({ "WeakerAccess" }) @Nullable Boolean nullableBoolean) {
        this.mStringArray = stringArray;
        AnnotationValidations.validate(
                NonNull.class, null, mStringArray);
        this.mIntArray = intArray;
        AnnotationValidations.validate(
                NonNull.class, null, mIntArray);
        this.mStringList = stringList;
        AnnotationValidations.validate(
                NonNull.class, null, mStringList);
        this.mMap = map;
        AnnotationValidations.validate(
                NonNull.class, null, mMap);
        this.mStringMap = stringMap;
        AnnotationValidations.validate(
                NonNull.class, null, mStringMap);
        this.mSparseArray = sparseArray;
        AnnotationValidations.validate(
                NonNull.class, null, mSparseArray);
        this.mSparseIntArray = sparseIntArray;
        AnnotationValidations.validate(
                NonNull.class, null, mSparseIntArray);
        this.mNullableBoolean = nullableBoolean;

        // onConstructed(); // You can define this method to get a callback
    }

    @DataClass.Generated.Member
    public @NonNull String[] getStringArray() {
        return mStringArray;
    }

    @DataClass.Generated.Member
    public @NonNull int[] getIntArray() {
        return mIntArray;
    }

    @DataClass.Generated.Member
    public @NonNull List<String> getStringList() {
        return mStringList;
    }

    @DataClass.Generated.Member
    public @NonNull Map<String,SampleWithCustomBuilder> getMap() {
        return mMap;
    }

    @DataClass.Generated.Member
    public @NonNull Map<String,String> getStringMap() {
        return mStringMap;
    }

    @DataClass.Generated.Member
    public @NonNull SparseArray<SampleWithCustomBuilder> getSparseArray() {
        return mSparseArray;
    }

    @DataClass.Generated.Member
    public @NonNull SparseIntArray getSparseIntArray() {
        return mSparseIntArray;
    }

    @DataClass.Generated.Member
    public @SuppressWarnings({ "WeakerAccess" }) @Nullable Boolean getNullableBoolean() {
        return mNullableBoolean;
    }

    @Override
    @DataClass.Generated.Member
    public String toString() {
        // You can override field toString logic by defining methods like:
        // String fieldNameToString() { ... }

        return "ParcelAllTheThingsDataClass { " +
                "stringArray = " + java.util.Arrays.toString(mStringArray) + ", " +
                "intArray = " + java.util.Arrays.toString(mIntArray) + ", " +
                "stringList = " + mStringList + ", " +
                "map = " + mMap + ", " +
                "stringMap = " + mStringMap + ", " +
                "sparseArray = " + mSparseArray + ", " +
                "sparseIntArray = " + mSparseIntArray + ", " +
                "nullableBoolean = " + mNullableBoolean +
        " }";
    }

    @Override
    @DataClass.Generated.Member
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        // You can override field parcelling by defining methods like:
        // void parcelFieldName(Parcel dest, int flags) { ... }

        int flg = 0;
        if (mNullableBoolean != null) flg |= 0x80;
        dest.writeInt(flg);
        dest.writeStringArray(mStringArray);
        dest.writeIntArray(mIntArray);
        dest.writeStringList(mStringList);
        dest.writeMap(mMap);
        dest.writeMap(mStringMap);
        dest.writeSparseArray(mSparseArray);
        dest.writeSparseIntArray(mSparseIntArray);
        if (mNullableBoolean != null) dest.writeBoolean(mNullableBoolean);
    }

    @Override
    @DataClass.Generated.Member
    public int describeContents() { return 0; }

    /** @hide */
    @SuppressWarnings({"unchecked", "RedundantCast"})
    @DataClass.Generated.Member
    protected ParcelAllTheThingsDataClass(@NonNull Parcel in) {
        // You can override field unparcelling by defining methods like:
        // static FieldType unparcelFieldName(Parcel in) { ... }

        int flg = in.readInt();
        String[] stringArray = in.createStringArray();
        int[] intArray = in.createIntArray();
        List<String> stringList = new java.util.ArrayList<>();
        in.readStringList(stringList);
        Map<String,SampleWithCustomBuilder> map = new java.util.LinkedHashMap<>();
        in.readMap(map, SampleWithCustomBuilder.class.getClassLoader());
        Map<String,String> stringMap = new java.util.LinkedHashMap<>();
        in.readMap(stringMap, String.class.getClassLoader());
        SparseArray<SampleWithCustomBuilder> sparseArray = (SparseArray) in.readSparseArray(SampleWithCustomBuilder.class.getClassLoader());
        SparseIntArray sparseIntArray = (SparseIntArray) in.readSparseIntArray();
        Boolean nullableBoolean = (flg & 0x80) == 0 ? null : (Boolean) in.readBoolean();

        this.mStringArray = stringArray;
        AnnotationValidations.validate(
                NonNull.class, null, mStringArray);
        this.mIntArray = intArray;
        AnnotationValidations.validate(
                NonNull.class, null, mIntArray);
        this.mStringList = stringList;
        AnnotationValidations.validate(
                NonNull.class, null, mStringList);
        this.mMap = map;
        AnnotationValidations.validate(
                NonNull.class, null, mMap);
        this.mStringMap = stringMap;
        AnnotationValidations.validate(
                NonNull.class, null, mStringMap);
        this.mSparseArray = sparseArray;
        AnnotationValidations.validate(
                NonNull.class, null, mSparseArray);
        this.mSparseIntArray = sparseIntArray;
        AnnotationValidations.validate(
                NonNull.class, null, mSparseIntArray);
        this.mNullableBoolean = nullableBoolean;

        // onConstructed(); // You can define this method to get a callback
    }

    @DataClass.Generated.Member
    public static final @NonNull Parcelable.Creator<ParcelAllTheThingsDataClass> CREATOR
            = new Parcelable.Creator<ParcelAllTheThingsDataClass>() {
        @Override
        public ParcelAllTheThingsDataClass[] newArray(int size) {
            return new ParcelAllTheThingsDataClass[size];
        }

        @Override
        public ParcelAllTheThingsDataClass createFromParcel(@NonNull Parcel in) {
            return new ParcelAllTheThingsDataClass(in);
        }
    };

    /**
     * A builder for {@link ParcelAllTheThingsDataClass}
     */
    @SuppressWarnings("WeakerAccess")
    @DataClass.Generated.Member
    public static class Builder {

        private @NonNull String[] mStringArray;
        private @NonNull int[] mIntArray;
        private @NonNull List<String> mStringList;
        private @NonNull Map<String,SampleWithCustomBuilder> mMap;
        private @NonNull Map<String,String> mStringMap;
        private @NonNull SparseArray<SampleWithCustomBuilder> mSparseArray;
        private @NonNull SparseIntArray mSparseIntArray;
        private @SuppressWarnings({ "WeakerAccess" }) @Nullable Boolean mNullableBoolean;

        private long mBuilderFieldsSet = 0L;

        public Builder() {
        }

        @DataClass.Generated.Member
        public @NonNull Builder setStringArray(@NonNull String... value) {
            checkNotUsed();
            mBuilderFieldsSet |= 0x1;
            mStringArray = value;
            return this;
        }

        @DataClass.Generated.Member
        public @NonNull Builder setIntArray(@NonNull int... value) {
            checkNotUsed();
            mBuilderFieldsSet |= 0x2;
            mIntArray = value;
            return this;
        }

        @DataClass.Generated.Member
        public @NonNull Builder setStringList(@NonNull List<String> value) {
            checkNotUsed();
            mBuilderFieldsSet |= 0x4;
            mStringList = value;
            return this;
        }

        /** @see #setStringList */
        @DataClass.Generated.Member
        public @NonNull Builder addStringList(@NonNull String value) {
            // You can refine this method's name by providing item's singular name, e.g.:
            // @DataClass.PluralOf("item")) mItems = ...

            if (mStringList == null) setStringList(new java.util.ArrayList<>());
            mStringList.add(value);
            return this;
        }

        @DataClass.Generated.Member
        public @NonNull Builder setMap(@NonNull Map<String,SampleWithCustomBuilder> value) {
            checkNotUsed();
            mBuilderFieldsSet |= 0x8;
            mMap = value;
            return this;
        }

        /** @see #setMap */
        @DataClass.Generated.Member
        public @NonNull Builder addMap(@NonNull String key, @NonNull SampleWithCustomBuilder value) {
            // You can refine this method's name by providing item's singular name, e.g.:
            // @DataClass.PluralOf("item")) mItems = ...

            if (mMap == null) setMap(new java.util.LinkedHashMap());
            mMap.put(key, value);
            return this;
        }

        @DataClass.Generated.Member
        public @NonNull Builder setStringMap(@NonNull Map<String,String> value) {
            checkNotUsed();
            mBuilderFieldsSet |= 0x10;
            mStringMap = value;
            return this;
        }

        /** @see #setStringMap */
        @DataClass.Generated.Member
        public @NonNull Builder addStringMap(@NonNull String key, @NonNull String value) {
            // You can refine this method's name by providing item's singular name, e.g.:
            // @DataClass.PluralOf("item")) mItems = ...

            if (mStringMap == null) setStringMap(new java.util.LinkedHashMap());
            mStringMap.put(key, value);
            return this;
        }

        @DataClass.Generated.Member
        public @NonNull Builder setSparseArray(@NonNull SparseArray<SampleWithCustomBuilder> value) {
            checkNotUsed();
            mBuilderFieldsSet |= 0x20;
            mSparseArray = value;
            return this;
        }

        @DataClass.Generated.Member
        public @NonNull Builder setSparseIntArray(@NonNull SparseIntArray value) {
            checkNotUsed();
            mBuilderFieldsSet |= 0x40;
            mSparseIntArray = value;
            return this;
        }

        @DataClass.Generated.Member
        public @NonNull Builder setNullableBoolean(@SuppressWarnings({ "WeakerAccess" }) @NonNull Boolean value) {
            checkNotUsed();
            mBuilderFieldsSet |= 0x80;
            mNullableBoolean = value;
            return this;
        }

        /** Builds the instance. This builder should not be touched after calling this! */
        public @NonNull ParcelAllTheThingsDataClass build() {
            checkNotUsed();
            mBuilderFieldsSet |= 0x100; // Mark builder used

            if ((mBuilderFieldsSet & 0x1) == 0) {
                mStringArray = null;
            }
            if ((mBuilderFieldsSet & 0x2) == 0) {
                mIntArray = null;
            }
            if ((mBuilderFieldsSet & 0x4) == 0) {
                mStringList = null;
            }
            if ((mBuilderFieldsSet & 0x8) == 0) {
                mMap = null;
            }
            if ((mBuilderFieldsSet & 0x10) == 0) {
                mStringMap = null;
            }
            if ((mBuilderFieldsSet & 0x20) == 0) {
                mSparseArray = null;
            }
            if ((mBuilderFieldsSet & 0x40) == 0) {
                mSparseIntArray = null;
            }
            if ((mBuilderFieldsSet & 0x80) == 0) {
                mNullableBoolean = null;
            }
            ParcelAllTheThingsDataClass o = new ParcelAllTheThingsDataClass(
                    mStringArray,
                    mIntArray,
                    mStringList,
                    mMap,
                    mStringMap,
                    mSparseArray,
                    mSparseIntArray,
                    mNullableBoolean);
            return o;
        }

        private void checkNotUsed() {
            if ((mBuilderFieldsSet & 0x100) != 0) {
                throw new IllegalStateException(
                        "This Builder should not be reused. Use a new Builder instance instead");
            }
        }
    }

    @DataClass.Generated(
            time = 1582685649678L,
            codegenVersion = "1.0.15",
            sourceFile = "frameworks/base/tests/Codegen/src/com/android/codegentest/ParcelAllTheThingsDataClass.java",
            inputSignatures = " @android.annotation.NonNull java.lang.String[] mStringArray\n @android.annotation.NonNull int[] mIntArray\n @android.annotation.NonNull java.util.List<java.lang.String> mStringList\n @android.annotation.NonNull java.util.Map<java.lang.String,com.android.codegentest.SampleWithCustomBuilder> mMap\n @android.annotation.NonNull java.util.Map<java.lang.String,java.lang.String> mStringMap\n @android.annotation.NonNull android.util.SparseArray<com.android.codegentest.SampleWithCustomBuilder> mSparseArray\n @android.annotation.NonNull android.util.SparseIntArray mSparseIntArray\n @java.lang.SuppressWarnings({\"WeakerAccess\"}) @android.annotation.Nullable java.lang.Boolean mNullableBoolean\nclass ParcelAllTheThingsDataClass extends java.lang.Object implements [android.os.Parcelable]\n@com.android.internal.util.DataClass(genBuilder=true, genAidl=false, genToString=true)")
    @Deprecated
    private void __metadata() {}


    //@formatter:on
    // End of generated code

}
