LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)
LOCAL_MODULE := JniLib2
LOCAL_SRC_FILES := ndk_load.c calc.cpp
LOCAL_C_INCLUDES := calc.h

LOCAL_LDLIBS := -llog

include $(BUILD_SHARED_LIBRARY)