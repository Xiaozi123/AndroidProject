package com.example.xiaozi.speechvoicetest;


import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import com.iflytek.cloud.ErrorCode;
import com.iflytek.cloud.InitListener;
import com.iflytek.cloud.SpeechSynthesizer;
import com.iflytek.cloud.*;
import android.widget.Toast;

public class KqSpeechCompound {
        // Log标签
        private static final String TAG = "KqSpeechCompound";
        // 上下文
        private Context mContext;
        // 语音合成对象
        private static SpeechSynthesizer mTts;

        /**
         * 发音人
         */
        public final static String[] COLOUD_VOICERS_ENTRIES = {"小燕", "小宇", "凯瑟琳", "亨利", "玛丽", "小研", "小琪", "小峰", "小梅", "小莉", "小蓉", "小芸", "小坤", "小强 ", "小莹",
                "小新", "楠楠", "老孙",};
        public final static String[] COLOUD_VOICERS_VALUE = {"xiaoyan", "xiaoyu", "catherine", "henry", "vimary", "vixy", "xiaoqi", "vixf", "xiaomei",
                "xiaolin", "xiaorong", "xiaoqian", "xiaokun", "xiaoqiang", "vixying", "xiaoxin", "nannan", "vils",};


        /**
         * 构造方法
         *
         * @param context
         */
        public KqSpeechCompound(Context context) {
            Log.d("tag54", "初始化失败,错ss 误码：" );
            // 上下文
            mContext = context;
            // 初始化合成对象
            mTts = SpeechSynthesizer.createSynthesizer(mContext, new InitListener() {
                @Override
                public void onInit(int code) {
                    if (code != ErrorCode.SUCCESS) {
                        Log.d("tag54", "初始化失败,错误码：" + code);
                    }
                    Log.d("tag54", "初始化失败,q错误码：" + code);
                }
            });
        }

        /**
         * 开始合成
         *
         * @param text
         */
        public void speaking(String text) {
            // 非空判断
            if (TextUtils.isEmpty(text)) {
                return;
            }
            Log.d("d","-------1------\n");
            int code =mTts.startSpeaking(text,mTtsListener);
            //int code = mTts.startSpeaking(text,mTtsListener);

            Log.d("d","-------2------\n");
            Log.d("tag54","-----"+code+"++++++++++");
            Log.d("d","-------3------\n");
            if (code != ErrorCode.SUCCESS) {
                Log.d("d","-------4------\n");
                if (code == ErrorCode.ERROR_COMPONENT_NOT_INSTALLED) {
                    Log.d("d","-------5------\n");
                    Toast.makeText(mContext, "没有安装语音+ code = " + code, Toast.LENGTH_SHORT).show();
                } else {
                    Log.d("d","-------6------\n");
                    Toast.makeText(mContext, "语音合成失败,错误码: " + code, Toast.LENGTH_SHORT).show();
                }
            }


        }

        /*
         * 停止语音播报
         */
        public static void stopSpeaking() {
            // 对象非空并且正在说话
            if (null != mTts && mTts.isSpeaking()) {
                // 停止说话
                mTts.stopSpeaking();
            }
        }

        /**
         * 判断当前有没有说话
         *
         * @return
         */
        public static boolean isSpeaking() {
            if (null != mTts) {
                return mTts.isSpeaking();
            } else {
                return false;
            }
        }

        /**
         * 合成回调监听。
         */
        private SynthesizerListener mTtsListener = new SynthesizerListener() {
            @Override
            public void onSpeakBegin() {
                Log.i(TAG, "开始播放");
            }

            @Override
            public void onSpeakPaused() {
                Log.i(TAG, "暂停播放");
            }

            @Override
            public void onSpeakResumed() {
                Log.i(TAG, "继续播放");
            }

            @Override
            public void onBufferProgress(int percent, int beginPos, int endPos, String info) {
                // TODO 缓冲的进度
                Log.i(TAG, "缓冲 : " + percent);
            }

            @Override
            public void onSpeakProgress(int percent, int beginPos, int endPos) {
                // TODO 说话的进度
                Log.i(TAG, "合成 : " + percent);
            }

            @Override
            public void onCompleted(SpeechError error) {
                if (error == null) {
                    Log.i(TAG, "播放完成");

                } else if (error != null) {
                    Log.i(TAG, error.getPlainDescription(true));
                }

            }

            @Override
            public void onEvent(int eventType, int arg1, int arg2, Bundle obj) {

            }
        };

        /**
         * 参数设置
         *
         * @return
         */
        private void setParam() {
            // 清空参数
            mTts.setParameter(SpeechConstant.PARAMS, null);
            // 引擎类型 网络
            mTts.setParameter(SpeechConstant.ENGINE_TYPE, SpeechConstant.TYPE_CLOUD);
            // 设置发音人
            mTts.setParameter(SpeechConstant.VOICE_NAME, COLOUD_VOICERS_VALUE[0]);
            // 设置语速
            mTts.setParameter(SpeechConstant.SPEED, "50");
            // 设置音调
            mTts.setParameter(SpeechConstant.PITCH, "50");
            // 设置音量
            mTts.setParameter(SpeechConstant.VOLUME, "100");
            // 设置播放器音频流类型
            mTts.setParameter(SpeechConstant.STREAM_TYPE, "3");

            // mTts.setParameter(SpeechConstant.TTS_AUDIO_PATH, Environment.getExternalStorageDirectory() + "/KRobot/wavaudio.pcm");
            // 背景音乐  1有 0 无
            // mTts.setParameter("bgs", "1");
        }

}
