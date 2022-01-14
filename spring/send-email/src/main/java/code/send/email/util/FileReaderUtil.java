package code.send.email.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReaderUtil {
	private static final ClassLoader src = Thread.currentThread().getContextClassLoader(); 
	
	private static Stream<String> stream(String filePath) throws IOException{
		return Files.lines(Paths.get(filePath));
	}
	
	public static List<String> getFileLines(String filePath) throws IOException{
		return stream(filePath).collect(Collectors.toList());
	}
	
	public static File getFile(Object ... composition) throws Exception {
		String path = concat("/", composition);
    	URL resource = src.getResource(path);
    	return new File(resource.toURI());
	}
	
	private static String concat(String delimiter, Object ... values) {
    	List strs = new ArrayList<>(Arrays.asList(values));
    	return concat(delimiter, strs);
    }
	
	private static String concat(String delimiter, List values) {
    	StringJoiner stringJoiner = new StringJoiner(delimiter, "", "");

    	for (Object value: values) {
    		stringJoiner.add(Objects.toString(value,""));
    	}

    	return stringJoiner.toString();
	}
}