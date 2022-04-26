/*
 * Copyright (C) 2008 The Android Open Source Project
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

#define LOG_TAG "com_android_server_eink_EinkService"

#define LOG_NDEBUG 0
#define DEBUG_EINK 1

#include <stdlib.h>
#include <stdio.h>
#include <math.h>
#include <ctype.h>
#include <pthread.h>
#include <errno.h>
#include <sys/types.h>
#include <dirent.h>
#include <grp.h>
#include <inttypes.h>
#include <pwd.h>
#include <time.h>
#include <poll.h>
#include <fcntl.h>

#include <sys/stat.h>
#include <sys/syscall.h>

#include <string.h>
#include <unistd.h>
#include <assert.h>
#include <hardware/hardware.h>
#include <android_runtime/Log.h>
#include <nativehelper/JNIHelp.h>
#include "jni.h"
#include <sched.h>
#include <utils/Log.h>
#include <logwrap/logwrap.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <errno.h>
#include <unistd.h>
#include <signal.h>
#include <cutils/properties.h>
// ----------------------------------------------------------------------------

namespace android {

	const char *args[1];
	static pid_t pid;
/*
 * Field/method IDs and class object references.
 *
 * You should not need to store the JNIEnv pointer in here.  It is
 * thread-specific and will be passed back in on every call.
 */
static struct {
    jclass      platformLibraryClass;
} gCachedState;

// ----------------------------------------------------------------------------

/*
 * Helper function to throw an arbitrary exception.
 *
 * Takes the exception class name, a format string, and one optional integer
 * argument (useful for including an error code, perhaps from errno).
 */
static void throwException(JNIEnv* env, const char* ex, const char* fmt,
                           int data)
{

    if (jclass cls = env->FindClass(ex)) {
        if (fmt != NULL) {
            char msg[1000];
            // snprintf(msg, sizeof(msg), fmt, data);
            env->ThrowNew(cls, msg);
        } else {
            env->ThrowNew(cls, NULL);
        }

        /*
         * This is usually not necessary -- local references are released
         * automatically when the native code returns to the VM.  It's
         * required if the code doesn't actually return, e.g. it's sitting
         * in a native event loop.
         */
        env->DeleteLocalRef(cls);
    }
}

int system(const char * cmdstring)
{

    int status;

    if(cmdstring == NULL){      
         return (1);
    }

    if((pid = fork())<0){
            status = -1;
    }
    else if(pid == 0){
	        execl("/bin/sh", "sh", "-c", cmdstring, (char *)0);
	        exit(127);
        }
    else{
           while(waitpid(pid, &status, 0) < 0){
                if(errno != EINTR){
                    status = -1;
                    break;
                }
            }
        }
    return status;
}

jint com_android_server_eink_EinkService_init(JNIEnv *env, jclass clazz)
{
    int result=0;
    ALOGV("com_android_server_eink_EinkService_init");
	/*args[0] = "/system/bin/eink-drawpath";
	result = logwrap_fork_execvp(1, (char **)args, NULL, false,1, false, NULL);
	if (result) {
          errno = EIO;
          ALOGE("uibc sink start fail (unknown exit code %d)", result);
      }*/
      //system("/system/bin/eink-drawpath");
 
      property_set("ctl.start","einkdrawpath");
    return result;
}

jint com_android_server_eink_EinkService_kill(JNIEnv *env, jclass clazz)
{
    int result=0;
    ALOGV("com_android_server_eink_EinkService_kill");
    property_set("ctl.stop","einkdrawpath");
    //kill(pid, SIGKILL);
    return result;
}

// ----------------------------------------------------------------------------

/*
 * Array of methods.
 *
 * Each entry has three fields: the name of the method, the method
 * signature, and a pointer to the native implementation.
 */
/****

Android JNI ʹ�õ����ݽṹJNINativeMethod���Java&Android 2009-09-06 20:42:56 �Ķ�234 ����0 �ֺţ�����С
Andoird ��ʹ����һ�ֲ�ͬ��ͳJava JNI�ķ�ʽ��������native�ĺ��������к���Ҫ��������Andoridʹ����һ��Java �� C ������ӳ������飬�������������˺����Ĳ����ͷ���ֵ����������������JNINativeMethod���������£�


typedef struct {
const char* name;
const char* signature;
void* fnPtr;
} JNINativeMethod;

��һ������name��Java�к��������֡�

�ڶ�������signature�����ַ����������˺����Ĳ����ͷ���ֵ

����������fnPtr�Ǻ���ָ�룬ָ��C������


���бȽ����������ǵڶ�������������

"()V"

"(II)V"

"(Ljava/lang/String;Ljava/lang/String;)V"


ʵ������Щ�ַ����뺯���Ĳ�������һһ��Ӧ�ġ�

"()" �е��ַ���ʾ������������������ֵ������"()V" �ͱ�ʾvoid Func();

"(II)V" ��ʾ void Func(int, int);


�����ÿһ���ַ��Ķ�Ӧ��ϵ����


�ַ� Java���� C����

V		void			void
Z		 jboolean	  boolean
I		  jint				int
J		 jlong			  long
D		jdouble 	  double
F		jfloat			  float
B		jbyte			 byte
C		jchar			char
S		jshort			short


��������"["��ʼ���������ַ���ʾ


[I 	  jintArray 	 int[]
[F 	jfloatArray    float[]
[B 	jbyteArray	  byte[]
[C    jcharArray	 char[]
[S    jshortArray	 short[]
[D    jdoubleArray double[]
[J 	jlongArray	   long[]
[Z    jbooleanArray boolean[]


����Ķ��ǻ������͡����Java�����Ĳ�����class������"L"��ͷ����";"��β�м�����"/" �����İ��������������Ӧ��C�������Ĳ�����Ϊjobject. һ��������String�࣬���Ӧ����Ϊjstring


Ljava/lang/String; String jstring
Ljava/net/Socket; Socket jobject


���JAVA����λ��һ��Ƕ���࣬����$��Ϊ������ķָ�����

���� "(Ljava/lang/String;Landroid/os/FileUtils$FileStatus;)Z"
****/

static const JNINativeMethod gMethods[] = {
    /* name,                        signature,      funcPtr */
    { "init_native","()I",(void *)com_android_server_eink_EinkService_init  },
    { "kill_native","()I",(void *)com_android_server_eink_EinkService_kill  },
};

/*
 * Do some (slow-ish) lookups now and save the results.
 *
 * Returns 0 on success.
 */
static int cacheIds(JNIEnv* env, jclass clazz)
{
    /*
     * Save the class in case we want to use it later.  Because this is a
     * reference to the Class object, we need to convert it to a JNI global
     * reference.
     */
    gCachedState.platformLibraryClass = (jclass) env->NewGlobalRef(clazz);      // .! : sample �е�ʵ��, �� HDMI ��ʵ��, ����Ҫ�ص� Java.
    if (clazz == NULL) {
        ALOGE("Can't create new global ref\n");
        return -1;
    }

    return 0;
}

/*
 * Explicitly register all methods for our class.
 *
 * While we're at it, cache some class references and method/field IDs.
 *
 * Returns 0 on success.
 */
int register_android_server_EinkService(JNIEnv* env)
{
    static const char* const kClassName = "com/android/server/eink/EinkService";
    jclass clazz;

    /* look up the class */
    clazz = env->FindClass(kClassName);
    if (clazz == NULL) {
        ALOGE("Can't find class %s\n", kClassName);
        return -1;
    }
    ALOGI("have find class %s\n", kClassName);

    /* register all the methods */
    if (env->RegisterNatives(clazz, gMethods,
                             sizeof(gMethods) / sizeof(gMethods[0])) != JNI_OK) {
        ALOGE("Failed registering methods for %s\n", kClassName);
        return -1;
    }
    ALOGI("registering methods for %s\n", kClassName);

    /* fill out the rest of the ID cache */ // .! : �� eink ʵ����, û�б�Ҫ cache Java �� or field �� ID.
    return cacheIds(env, clazz);
}
};
