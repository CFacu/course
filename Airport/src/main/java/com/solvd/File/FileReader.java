package com.solvd.file;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileReader {
	
	private final static Logger LOGGER = LogManager.getLogger(FileReader.class);

	private File file;
	private String text;

	public FileReader(String path) {
		file = new File(path);
		text = null;
		try {
			 text = FileUtils.readFileToString(file,StandardCharsets.UTF_8);
		} catch (IOException e) {
			LOGGER.error(e);
		}
		text = text.toLowerCase();
	}
	
	public void calculateOcurrences() {
		text = StringUtils.remove(text, '.');
		text = StringUtils.remove(text, ',');
		text = StringUtils.remove(text, ':');
		String[] words = StringUtils.split(text, " ");
		Integer count=1;
		HashMap<String, Integer> ocurrences = new HashMap<String, Integer>();
		for (String string : words) {
			count =  StringUtils.countMatches(text, string);
			ocurrences.put(string, count);
		}
		LOGGER.info(ocurrences);
	}
}
