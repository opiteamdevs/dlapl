# R8 obfuscates and optimizes release builds. Keep only runtime metadata
# required by reflection-based libraries and Android framework APIs.

-keepattributes Signature,*Annotation*,InnerClasses,EnclosingMethod

# Gson uses generic type signatures and annotations when mapping JSON.
-keep class com.google.gson.reflect.TypeToken { *; }
-keep class * extends com.google.gson.reflect.TypeToken
-keepclassmembers,allowobfuscation class * {
    @com.google.gson.annotations.SerializedName <fields>;
}

# Android components are referenced by the manifest and retained by AGP/R8.
# Do not keep the entire app package: that would disable useful obfuscation.

# Preserve source file/line info for readable crash traces without retaining names.
-renamesourcefileattribute SourceFile
-keepattributes SourceFile,LineNumberTable
