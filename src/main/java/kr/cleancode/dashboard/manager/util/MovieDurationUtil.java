/**
 * Create Time: 2021-11-21
 * Made by: js
 */
package kr.cleancode.dashboard.manager.util;

import com.sun.jna.Native;
import com.sun.jna.Platform;
import uk.co.caprica.vlcjinfo.MediaInfoFile;
import uk.co.caprica.vlcjinfo.binding.LibMediaInfo;

import java.io.File;

public class MovieDurationUtil {

	private volatile static MovieDurationUtil object = null;
	
	public static final MovieDurationUtil getInstance(){
		if(object == null){
			synchronized (MovieDurationUtil.class) {
				if(object == null){
					object = new MovieDurationUtil();
				}
			}
		}
		
		return object;
	}
	
	private MovieDurationUtil() {
		Native.load(Platform.isWindows() ? "C:\\Program Files\\MediaInfo\\MediaInfo.dll" : "mediainfo", LibMediaInfo.class);
	}
	
	public final long getDuration(final File trgtFile) {
		final MediaInfoFile mediaInfoFile = new MediaInfoFile(trgtFile);
		if(mediaInfoFile.open()) {
			try {
		    	final long duration = Long.parseLong(mediaInfoFile.info("General;%Duration%"));
				mediaInfoFile.close();
				return 0L < duration ? duration : 0L;	
			} catch (NumberFormatException e) {
				final long duration = Long.parseLong(mediaInfoFile.info("Video;%Duration%"));
				mediaInfoFile.close();
				return 0L < duration ? duration : 0L;
			}
		}
		
		return 0L;
	}
}