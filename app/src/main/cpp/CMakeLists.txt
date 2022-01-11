# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.4.1)
#设置FFmpeg头文件的路径
include_directories(
        include#因为和CMakeLists.txt在同一级，所以直接写include
)
# Declares and names the project.

project("ffmpegdemo")
set(JNI_LIBS_DIR ${CMAKE_SOURCE_DIR}/src/main/jniLibs)

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.

add_library( # Sets the name of the library.
        ffmpegdemo

        # Sets the library as a shared library.
        SHARED

        # Provides a relative path to your source file(s).
        jni/ffmpeg_handler.cpp)

# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.

find_library( # Sets the name of the path variable.
        log-lib

        # Specifies the name of the NDK library that
        # you want CMake to locate.
        log)

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.



#1.定义一个变量avcodec
add_library(
        avcodec
        SHARED
        IMPORTED
)
#给avcodec这个变量赋值
set_target_properties(avcodec PROPERTIES IMPORTED_LOCATION ${CMAKE_SOURCE_DIR}/../../main/jniLibs/${ANDROID_ABI}/libavcodec.so)


#3.
add_library(
        avfilter
        SHARED
        IMPORTED
)
set_target_properties(avfilter PROPERTIES IMPORTED_LOCATION ${CMAKE_SOURCE_DIR}/../../main/jniLibs/${ANDROID_ABI}/libavfilter.so)

#4.
add_library(
        avformat
        SHARED
        IMPORTED
)
set_target_properties(avformat PROPERTIES IMPORTED_LOCATION ${CMAKE_SOURCE_DIR}/../../main/jniLibs/${ANDROID_ABI}/libavformat.so)

#5.
add_library(
        avutil
        SHARED
        IMPORTED
)
set_target_properties(avutil PROPERTIES IMPORTED_LOCATION ${CMAKE_SOURCE_DIR}/../../main/jniLibs/${ANDROID_ABI}/libavutil.so)

#7.
add_library(
        swresample
        SHARED
        IMPORTED
)
set_target_properties(swresample PROPERTIES IMPORTED_LOCATION ${CMAKE_SOURCE_DIR}/../../main/jniLibs/${ANDROID_ABI}/libswresample.so)

#8.
add_library(
        swscale
        SHARED
        IMPORTED
)
set_target_properties(swscale PROPERTIES IMPORTED_LOCATION ${CMAKE_SOURCE_DIR}/../../main/jniLibs/${ANDROID_ABI}/libswscale.so)
target_link_libraries( # Specifies the target library.
        ffmpegdemo
        avcodec#1
        avfilter#3
        avformat#4
        avutil#5
        swresample#7
        swscale#8
        # Links the target library to the log library
        # included in the NDK.
        ${log-lib})