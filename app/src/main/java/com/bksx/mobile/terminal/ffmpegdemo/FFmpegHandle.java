package com.bksx.mobile.terminal.ffmpegdemo;

/**
 * @author :qlf
 */
public class FFmpegHandle {
    public FFmpegHandle() {
    }

    private static class SingletonInstance{
        private static final FFmpegHandle INSTANCE = new FFmpegHandle();
    }

    public static FFmpegHandle getInstance(){
        return SingletonInstance.INSTANCE;
    }

    static {
        System.loadLibrary("ffmpegdemo");
        //用于各种类型声音/图像编解码
        System.loadLibrary("avcodec");
        //用做滤镜处理
        System.loadLibrary("avfilter");
        //用于各种音视频封装格式的生成和解析，包括获取解码所需信息以生成解码上下文结构和读取音视频帧等功能
        System.loadLibrary("avformat");
        //包含一些公共的工具函数
        System.loadLibrary("avutil");
        //用于重采样
        System.loadLibrary("swresample");
        //用于视频场景比例缩放、色彩映射转换
        System.loadLibrary("swscale");
    }

    public native int initVideo(String url);

    public native int onFrameCallback(byte[] buffer);

    public native int close();
}
