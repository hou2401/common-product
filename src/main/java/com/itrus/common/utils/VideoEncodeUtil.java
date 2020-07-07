package com.itrus.common.utils;

import java.io.File;

import com.itrust.jave.AudioAttributes;
import com.itrust.jave.Encoder;
import com.itrust.jave.EncodingAttributes;
import com.itrust.jave.VideoAttributes;
/**   
* Copyright: Copyright (c) 2019 LanRu-Caifu
* 
* @ClassName: VideoEncodeUtil.java
* @Description: 视频编码
*
* @version: v1.0.0
* @author: wen_guoxing
* @date: 2019年3月11日 下午1:00:02 
*
*/
public class VideoEncodeUtil {
	
	private static AudioAttributes audio;
	private static VideoAttributes  video;
	private static EncodingAttributes  enciding;
	private static Encoder  encoder;
	
	static{
		audio = new AudioAttributes();
		video = new VideoAttributes();
		enciding = new EncodingAttributes();
		try {
			encoder = new Encoder();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void encode( File source, File target)throws Exception{
		audio.setCodec("libmp3lame");
		//设置新重新编码的音频流的比特率值
		//如果你想要128 kb / s比特率，你应该调用setBitRate（new Integer（128000））
		audio.setBitRate(new Integer(128000));
		//设置将在重新编码的音频流中使用的音频通道的数量（1 =单声道，2 =立体声）
		audio.setChannels(new Integer(2));
		//设置新重新编码的音频流的采样率。如果未设置采样率值，编码器将选择默认值。该值应以赫兹表示。例如，如果您想要类似CD的44100 Hz采样率，则应调用setSamplingRate（new Integer（44100））。
		audio.setSamplingRate(new Integer(44100));
		//可以调用此方法来改变音频流的音量。值256表示没有音量变化。因此，小于256的值是音量减小，而大于256的值将增加音频流的音量。
		audio.setVolume(256);
		
		//它设置将用于视频流转码的编解码器的名称。您必须从当前Encoder实例的getVideoEncoders（）方法返回的列表中选择一个值。否则，您可以传递VideoAttributes.DIRECT_STREAM_COPY特殊值，该值需要源文件中原始视频流的副本。
//		video.setCodec(VideoAttributes.DIRECT_STREAM_COPY);
		video.setCodec("mpeg4");
		//它设置新重新编码的视频流的比特率值。如果未设置比特率值，编码器将选择默认值。该值应以每秒位数表示。例如，如果你想要360 kb / s比特率，你应该调用setBitRate（new Integer（360000））。
		//800
		//360000
		video.setBitRate(new Integer(800));
		//它为新重新编码的音频流设置帧速率值。如果未设置比特率帧速率，则编码器将选择默认帧速率。该值应以每秒帧数表示。例如，如果你想要一个30 f / s的帧速率，你应该调用setFrameRate（new Integer（30））。
		video.setFrameRate(new Integer(15));
		
		enciding.setFormat("mp4");
		
		enciding.setAudioAttributes(audio);
		enciding.setVideoAttributes(video);
		
		//设置截取时间3s
		//enciding.setDuration(2F);
		
		encoder.encode(source, target, enciding);
	}
	
	        
	public static void main(String[] args) throws Exception {
		
		File source = new File("E:\\h5_q.mp4");
		File target = new File("E:\\h5_ys.mp4");
		VideoEncodeUtil.encode(source, target);
		System.out.println("---------压缩完成---------");
	}
	
}
