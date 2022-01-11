#include <jni.h>
#include <string>
extern "C"{
#include "libavcodec/avcodec.h"
}
extern "C" JNIEXPORT jstring JNICALL
Java_com_bksx_mobile_terminal_ffmpegdemo_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(avcodec_configuration());
}
