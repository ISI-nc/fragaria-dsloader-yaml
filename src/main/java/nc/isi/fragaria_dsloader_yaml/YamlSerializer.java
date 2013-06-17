package nc.isi.fragaria_dsloader_yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.yaml.snakeyaml.Yaml;


public class YamlSerializer {

	public <T> T serialize(File file, Class<T> clazz) throws IOException {
		InputStream input = null;
		try {
			input = new FileInputStream(file);
			Yaml yaml = new Yaml();
			return yaml.loadAs(input, clazz);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} finally {
			if (input != null) {
				input.close();
			}
		}
	}
}
