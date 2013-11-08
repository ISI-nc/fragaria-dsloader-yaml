package nc.isi.fragaria_dsloader_yaml;

import java.io.IOException;
import java.io.InputStream;

import org.yaml.snakeyaml.Yaml;


public class YamlSerializer {

	public <T> T serialize(String fileName, Class<T> clazz) throws IOException {
		InputStream input = null;
		try {
			ClassLoader classLoader = Thread.currentThread()
					.getContextClassLoader();
			input = classLoader.getResourceAsStream(fileName);
			Yaml yaml = new Yaml();
			return yaml.loadAs(input, clazz);
		} finally {
			if (input != null) {
				input.close();
			}
		}
	}
}
