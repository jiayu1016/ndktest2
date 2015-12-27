//
// Created by Administrator on 2015/12/25.
//

/* Header for class com_example_administrator_ndktest_NdkJniUtil */

#ifndef _com_example_administrator_ndktest2_NdkJniUtil
#define _com_example_administrator_ndktest2_NdkJniUtil
#ifdef __cplusplus
extern "C" {
#endif

#define TAG "JNITEST2"
#define LOGV(...) __android_log_print(ANDROID_LOG_VERBOSE, TAG, __VA_ARGS__)
#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG , TAG, __VA_ARGS__)
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO , TAG, __VA_ARGS__)
#define LOGW(...) __android_log_print(ANDROID_LOG_WARN , TAG, __VA_ARGS__)
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR , TAG, __VA_ARGS__)

# define NELEM(x) ((int) (sizeof(x) / sizeof((x)[0])))

static const char *classPathName = "com/example/administrator/ndktest2/NdkJniUtil";

/*
 * Class:     com_example_administrator_ndktest_NdkJniUtil
 * Method:    getCLanguageString
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstringJNICALL
native_getCLanguageString
(JNIEnv
*env,
jobject obj
) {
return (*env)->
NewStringUTF(env,
"This just a test2 for Android Studio NDK JNI developer!");
}

JNIEXPORT jintJNICALL
native_calc
(JNIEnv
*env,
jobject obj, jint
a,
jint b
) {
LOGE("JNI executed \n");
return
calc_add(a, b
);
}

//Java和JNI函数的绑定表
static JNINativeMethod method_table[] = {
        {"getCLanguageString", "()Ljava/lang/String;", (void *) native_getCLanguageString},//绑定
        {"calc",               "(II)I",                (void *) native_calc},
};

static int registerNativeMethods(JNIEnv *env, const char *className,
                                 JNINativeMethod *gMethods, int numMethods) {
    jclass clazz;
    clazz = (*env)->FindClass(env, className);
    if (clazz == NULL) {
        return JNI_ERR;
    }
    if ((*env)->RegisterNatives(env, clazz, gMethods, numMethods) < 0) {
        return JNI_ERR;
    }

    return JNI_TRUE;
}

JNIEXPORT jint
JNI_OnLoad(JavaVM
*vm,
void *reserved
) {
JNIEnv *env = NULL;

if ((*vm)->
GetEnv(vm, (
void **) &env, JNI_VERSION_1_4) != JNI_OK) {
LOGE("ERROR: GetEnv failed\n");
return
JNI_ERR;
}

if (
registerNativeMethods(env, classPathName, method_table, NELEM(method_table)) < 0) {
LOGE("registerNativeMethods error");
return
JNI_ERR;
}

// 返回jni的版本
return
JNI_VERSION_1_4;
}

#ifdef __cplusplus
}
#endif
#endif
